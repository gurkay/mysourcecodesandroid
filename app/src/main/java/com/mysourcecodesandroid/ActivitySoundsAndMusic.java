package com.mysourcecodesandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivitySoundsAndMusic extends AppCompatActivity {
    
    MediaPlayer player;
    private Button btnPlayActivitySoundsAndMusic;
    private Button btnPauseActivitySoundsAndMusic;
    private Button btnStopActivitySoundsAndMusic;
       
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounds_and_music);
        init();
    }

    public void init() {
        // toolbar add
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        
        btnPlayActivitySoundsAndMusic = findViewById(R.id.btnPlayActivitySoundsAndMusic);
        btnPauseActivitySoundsAndMusic = findViewById(R.id.btnPauseActivitySoundsAndMusic);
        btnStopActivitySoundsAndMusic = findViewById(R.id.btnStopActivitySoundsAndMusic);
            
        btnPlayActivitySoundsAndMusic.setOnClickListener(new View.onClickListener() {
          @Override
          public void onClick(View v) {
            if(player == null) {
                player = MediaPlayer.create(contex, R.raw.lion);
                player.setOnCompletionListener(new MediaPlayer.onCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        stopPlayer();
                    }
                });
            }
              
            player.start();
          }
        });
        btnPauseActivitySoundsAndMusic.setOnClickListener(new View.onClickListener() {
          @Override
          public void onClick(View v) {
            if(player != null) {
                player.pause();
            }
          }
        });
        btnStopActivitySoundsAndMusic.setOnClickListener(new View.onClickListener() {
          @Override
          public void onClick(View v) {
            stopPlayer();
          }
        });        
    }
    
    private void stopPlayer() {
        if(player != null) {
            player.release();
            player = null;
            Toast.makeText(contex, "MediaPlayer release", Toast.LENGTH_SHORT).show();
        }    
    }
    
    @Override
    public void onStop() {
        super.onStop();
        stopPlayer();
    }    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();

        if(itemId == R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
