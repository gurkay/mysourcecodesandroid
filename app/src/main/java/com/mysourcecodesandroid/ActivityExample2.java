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

public class ActivityExample2 extends AppCompatActivity implements View.OnClickListener {

    EditText edUserNameExample2, edPasswordExample2;
    Button btnSendExample2, btnClearExample2;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);
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
        btnSendExample2.setOnClickListener(this);
        btnClearExample2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) { // v tiklanan buton
        switch (v.getId()) {
            case R.id.btnSendExample2:
                if(edUserNameExample2.getText().toString().equalsIgnoreCase("gurkay")
                && edPasswordExample2.getText().toString().equals("1")) {
                    Toast.makeText(context, "Giris basarili", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(context, ActivityExample21.class));
                } else {
                    Toast.makeText(context, "Hatali kullanici adi veya sifre", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnClearExample2:
                    edUserNameExample2.setText("");
                    edPasswordExample2.setText("");
                    edUserNameExample2.requestFocus();
                break;

        }
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
