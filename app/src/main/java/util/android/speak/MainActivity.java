package util.android.speak;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements
        View.OnTouchListener, TextToSpeech.OnInitListener {

    EditText editText = null;
    LinearLayout linearLayout = null;
    TextToSpeech textToSpeech = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout) findViewById(R.id.llParent);
        editText = (EditText) findViewById(R.id.etText);

        textToSpeech = new TextToSpeech(this,this);
        textToSpeech.setLanguage(Locale.ENGLISH);

        linearLayout.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        textToSpeech.speak(editText.getText().toString(),TextToSpeech.QUEUE_FLUSH,null,"onTouchTextToSpeech");
        return false;
    }

    @Override
    public void onInit(int status) {
        // unused method
    }
}
