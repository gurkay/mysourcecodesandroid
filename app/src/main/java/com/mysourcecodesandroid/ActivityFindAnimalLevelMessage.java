package com.mysourcecodesandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityFindAnimalLevelMessage extends AppCompatActivity {

    TextView txtLevelFindAnimalsLevelMessage, txtTimerFindAnimalsLevelMessage;
    Button btnFindAnimalsLevelMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_animal_level_message);

        txtLevelFindAnimalsLevelMessage = findViewById(R.id.txtLevelFindAnimalsLevelMessage);
        txtTimerFindAnimalsLevelMessage = findViewById(R.id.txtTimerFindAnimalsLevelMessage);
        btnFindAnimalsLevelMessage = findViewById(R.id.btnFindAnimalsLevelMessage);

        txtLevelFindAnimalsLevelMessage.setText("LEVEL " + getIntent().getExtras().getString("level"));
        txtTimerFindAnimalsLevelMessage.setText("Start Time In Millis " + getIntent().getExtras().getString("timer"));

        btnFindAnimalsLevelMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ActivityFindAnimals.class));
            }
        });

    }
}
