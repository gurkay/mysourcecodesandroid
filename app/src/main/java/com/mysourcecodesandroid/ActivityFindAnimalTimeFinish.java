package com.mysourcecodesandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityFindAnimalTimeFinish extends AppCompatActivity {

    Button btnFindAnimalTimeFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_animal_time_finish);

        btnFindAnimalTimeFinish = findViewById(R.id.btnFindAnimalTimeFinish);

        btnFindAnimalTimeFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityMainFindAnimals.class);
                intent.putExtra("gameLevel", getIntent().getExtras().getString("gameLevel"));
                startActivity(intent);
            }
        });

    }
}
