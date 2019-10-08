package util.android.speak;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    public static final String TAG = "__Speak__";

    private EditText editText = null;
    private TextToSpeech textToSpeech = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.llParent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.speak(editText.getText().toString(),
                        TextToSpeech.QUEUE_FLUSH, null, "onTouchTextToSpeech");
            }
        });
        editText = findViewById(R.id.etText);

        textToSpeech = new TextToSpeech(this, this);
        textToSpeech.setLanguage(Locale.ENGLISH);
    }

    @Override
    public void onInit(int status) {
        Log.i(TAG, "onInit: TextToSpeech Init with status " + status);
    }
}
