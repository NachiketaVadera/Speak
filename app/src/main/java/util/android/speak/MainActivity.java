package util.android.speak;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.GestureDetector;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener  {
    public static final String TAG = "__Speak__";
    private static final String PREFERENCE_NAME = "preference_file";
    private EditText editText = null;
    private TextToSpeech textToSpeech = null;
    private BackButtonPressHandler backButtonPressHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backButtonPressHandler=new BackButtonPressHandler(this);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        SharedPreferences settings = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
        if (settings.getBoolean("firstRun", true)) {
            Log.i(TAG, "onCreate: First Run.");
            showWelcomeDialog();
        }

        findViewById(R.id.button_spk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.speak(editText.getText().toString(),
                        TextToSpeech.QUEUE_FLUSH, null, "onTouchTextToSpeech");
            }
        });
        findViewById(R.id.parentLayout).setOnTouchListener(new OnSwipeTouchListener(MainActivity.this){
            public void onSwipeTop() {
                Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeLeft() {
                Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeBottom() {
                Toast.makeText(MainActivity.this, "bottom and edit text clear", Toast.LENGTH_SHORT).show();
                editText.setText("");
            }

        });
        editText = findViewById(R.id.etText);
        textToSpeech = new TextToSpeech(this, this);
        textToSpeech.setLanguage(Locale.ENGLISH);
    }

    private void showWelcomeDialog() {
        // instruction dialog creation
    }
    @Override
    public void onInit(int status) {
        Log.i(TAG, "onInit: TextToSpeech Init with status " + status);
    }
    @Override
    public void onBackPressed(){
        backButtonPressHandler.onBackPressed();
    }

}
