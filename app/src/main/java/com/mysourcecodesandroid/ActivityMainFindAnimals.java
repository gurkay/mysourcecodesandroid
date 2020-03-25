package com.mysourcecodesandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ActivityMainFindAnimals extends AppCompatActivity {

    Button btnLevel1MainFindAnimals, btnLevel2MainFindAnimals, btnLevel3MainFindAnimals, btnLevel4MainFindAnimals, btnLevel5MainFindAnimals;
    MyLogTrace myLogTrace;
    ActivityWhatIsTimer activityWhatIsTimer;
    ActivityFileTaskFindAnimals activityFileTaskFindAnimals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_find_animals);

        try {
            activityWhatIsTimer = new ActivityWhatIsTimer(getApplicationContext(), Integer.parseInt(getIntent().getExtras().getString("gameLevel")));
        } catch (Exception e) {
            activityWhatIsTimer = new ActivityWhatIsTimer(getApplicationContext(), "level.txt", 1, 20000);
        }

        init();

        /**
         * MY LOG APP
         * by Gürkay BAŞYİĞİT
         */
        myLogTrace.saveLogTrace();
        Log.i(myLogTrace.getTag(), myLogTrace.getMessage() + myLogTrace.MESSAGE_END);

    }

    public void init() {
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btnLevel1MainFindAnimals = findViewById(R.id.btnLevel1MainFindAnimals);
        btnLevel2MainFindAnimals = findViewById(R.id.btnLevel2MainFindAnimals);
        btnLevel3MainFindAnimals = findViewById(R.id.btnLevel3MainFindAnimals);
        btnLevel4MainFindAnimals = findViewById(R.id.btnLevel4MainFindAnimals);
        btnLevel5MainFindAnimals = findViewById(R.id.btnLevel5MainFindAnimals);

        /**
         * LEVEL LOAD
         */
        myLogTrace = new MyLogTrace(getApplicationContext(), "logTraceFindAnimals.txt");
        myLogTrace.setMessage("create file and game level : " + activityWhatIsTimer.getGameLevel());
        myLogTrace.setMessage("Game Timer : " + activityWhatIsTimer.getGameTimer());
        myLogTrace.setMessage("Game Number of Random Find Animal : " + activityWhatIsTimer.getNumberOfRandomPlaceFindAnimal());

        if(!activityWhatIsTimer.isFileStateFindAnimals()) {
            activityWhatIsTimer.saveFileLevelOfFindAnimals();
            myLogTrace.setMessage("create file and game level : " + activityWhatIsTimer.getGameLevel());
        }

        activityWhatIsTimer.loadFileLevelOfFindAnimals();

        /**
         * Button Enable setting
         */
        switch (activityWhatIsTimer.getGameLevel()) {
            case 1:
                btnLevel1MainFindAnimals.setEnabled(true);
                btnLevel2MainFindAnimals.setEnabled(false);
                btnLevel3MainFindAnimals.setEnabled(false);
                btnLevel4MainFindAnimals.setEnabled(false);
                btnLevel5MainFindAnimals.setEnabled(false);

                myLogTrace.setMessage("btnLevel1MainFindAnimals getId() : " + btnLevel1MainFindAnimals.getId());

                break;
            case 2:
                btnLevel1MainFindAnimals.setEnabled(true);
                btnLevel2MainFindAnimals.setEnabled(true);
                btnLevel3MainFindAnimals.setEnabled(false);
                btnLevel4MainFindAnimals.setEnabled(false);
                btnLevel5MainFindAnimals.setEnabled(false);

                myLogTrace.setMessage("btnLevel2MainFindAnimals visible : " + btnLevel1MainFindAnimals.getVisibility());

                break;
            case 3:
                btnLevel1MainFindAnimals.setEnabled(true);
                btnLevel2MainFindAnimals.setEnabled(true);
                btnLevel3MainFindAnimals.setEnabled(true);
                btnLevel4MainFindAnimals.setEnabled(false);
                btnLevel5MainFindAnimals.setEnabled(false);
                break;
            case 4:
                btnLevel1MainFindAnimals.setEnabled(true);
                btnLevel2MainFindAnimals.setEnabled(true);
                btnLevel3MainFindAnimals.setEnabled(true);
                btnLevel4MainFindAnimals.setEnabled(true);
                btnLevel5MainFindAnimals.setEnabled(false);
                break;
            case 5:
                btnLevel1MainFindAnimals.setEnabled(true);
                btnLevel2MainFindAnimals.setEnabled(true);
                btnLevel3MainFindAnimals.setEnabled(true);
                btnLevel4MainFindAnimals.setEnabled(true);
                btnLevel5MainFindAnimals.setEnabled(true);
                break;
        }

        btnLevel1MainFindAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityFindAnimals.class);
                intent.putExtra("gameLevel", Integer.toString(activityWhatIsTimer.getGameLevel()));
                intent.putExtra("gameTimer", Long.toString(activityWhatIsTimer.getGameTimer()));
                intent.putExtra("numberOfRandomPlaceFindAnimal", Integer.toString(activityWhatIsTimer.getNumberOfRandomPlaceFindAnimal()));
                startActivity(intent);
            }
        });

        btnLevel2MainFindAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityFindAnimals.class);
                intent.putExtra("gameLevel", Integer.toString(activityWhatIsTimer.getGameLevel()));
                intent.putExtra("gameTimer", Long.toString(activityWhatIsTimer.getGameTimer()));
                intent.putExtra("numberOfRandomPlaceFindAnimal", Integer.toString(activityWhatIsTimer.getNumberOfRandomPlaceFindAnimal()));
                startActivity(intent);
            }
        });

        btnLevel3MainFindAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityFindAnimals.class);
                intent.putExtra("gameLevel", Integer.toString(activityWhatIsTimer.getGameLevel()));
                intent.putExtra("gameTimer", Long.toString(activityWhatIsTimer.getGameTimer()));
                intent.putExtra("numberOfRandomPlaceFindAnimal", Integer.toString(activityWhatIsTimer.getNumberOfRandomPlaceFindAnimal()));
                startActivity(intent);
            }
        });

        btnLevel4MainFindAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityFindAnimals.class);
                intent.putExtra("gameLevel", Integer.toString(activityWhatIsTimer.getGameLevel()));
                intent.putExtra("gameTimer", Long.toString(activityWhatIsTimer.getGameTimer()));
                intent.putExtra("numberOfRandomPlaceFindAnimal", Integer.toString(activityWhatIsTimer.getNumberOfRandomPlaceFindAnimal()));
                startActivity(intent);
            }
        });

        btnLevel5MainFindAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityFindAnimals.class);
                intent.putExtra("gameLevel", Integer.toString(activityWhatIsTimer.getGameLevel()));
                intent.putExtra("gameTimer", Long.toString(activityWhatIsTimer.getGameTimer()));
                intent.putExtra("numberOfRandomPlaceFindAnimal", Integer.toString(activityWhatIsTimer.getNumberOfRandomPlaceFindAnimal()));
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
