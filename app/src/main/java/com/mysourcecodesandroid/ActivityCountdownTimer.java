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

public class ActivityCountdownTimer extends AppCompatActivity {

    EditText edUserNameExample2, edPasswordExample2;
    Button btnSendExample2, btnClearExample2;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown_timer);
        init();
    }

    public void init() {
        // toolbar add
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edUserNameExample2 = findViewById(R.id.edUserNameExample2);
        edPasswordExample2 = findViewById(R.id.edPasswordExample2);
        btnSendExample2 = findViewById(R.id.btnSendExample2);
        btnClearExample2 = findViewById(R.id.btnClearExample2);

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
