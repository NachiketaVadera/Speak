package util.android.speak;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    String receivedText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();

        linearLayout = (LinearLayout) findViewById(R.id.llParent);
        editText = (EditText) findViewById(R.id.etText);
        textToSpeech = new TextToSpeech(this,this);
        textToSpeech.setLanguage(Locale.ENGLISH);

        linearLayout.setOnTouchListener(this);

        if(bundle != null){
            receivedText = bundle.getString(Intent.EXTRA_PROCESS_TEXT);
            editText.setText(receivedText);
        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        textToSpeech.speak(editText.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
        return false;
    }

    @Override
    public void onInit(int status) {
        textToSpeech.speak(receivedText,TextToSpeech.QUEUE_FLUSH,null);
    }
}
