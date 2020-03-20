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

public class ActivityRWTextFile extends AppCompatActivity {

    
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;
    
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rw_textfile);
        init();
    }

    public void init() {
        // toolbar add
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        
        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);
            

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
