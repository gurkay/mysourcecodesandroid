package com.mysourcecodesandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Locale;

public class ActivityTextToSpeech extends AppCompatActivity {
    private TextToSpeech mTTS;
    private EditText edTextToSpeech;
    private SeekBar seekBarPitchTextToSpeech, seekBarSpeedTextToSpeech;
    private Button btnSpeakTextToSpeech;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);
        init();
    }



    public void init() {
        // add toolbar back button arrow
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnSpeakTextToSpeech = findViewById(R.id.btnSpeakTextToSpeech);

        mTTS = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(Locale.ENGLISH);

                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        btnSpeakTextToSpeech.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        edTextToSpeech = findViewById(R.id.edTextToSpeech);
        seekBarPitchTextToSpeech = findViewById(R.id.seekBarPitchTextToSpeech);
        seekBarSpeedTextToSpeech = findViewById(R.id.seekBarSpeedTextToSpeech);

        btnSpeakTextToSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Test", Toast.LENGTH_SHORT).show();
                speak();
            }
        });
    }

    private void speak() {
        String text = edTextToSpeech.getText().toString();
        float pitch = (float) seekBarPitchTextToSpeech.getProgress() / 50;
        if(pitch < 0.1) pitch = 0.1f;
        float speed = (float) seekBarSpeedTextToSpeech.getProgress() / 50;
        if(speed < 0.1) speed = 0.1f;

        mTTS.setPitch(pitch);
        mTTS.setSpeechRate(speed);

        // Controller SDK versions
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mTTS.speak(text, TextToSpeech.QUEUE_FLUSH,null,null);
            Toast.makeText(context, "great Lolipop", Toast.LENGTH_SHORT).show();
        } else {
            mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            Toast.makeText(context, "not Lolipop", Toast.LENGTH_SHORT).show();
        }
    }

    // CTRL + O methods
    @Override
    protected void onDestroy() {
        if(mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if(itemId == R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
