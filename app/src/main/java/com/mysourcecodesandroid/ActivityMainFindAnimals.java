package com.mysourcecodesandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ActivityMainFindAnimals extends AppCompatActivity {

    Button btnLevel1MainFindAnimals, btnLevel2MainFindAnimals, btnLevel3MainFindAnimals, btnLevel4MainFindAnimals, btnLevel5MainFindAnimals;
    MyLogTrace myLogTrace;
    ActivityWhatIsTimer activityWhatIsTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_find_animals);

        init();

        /**
         * MY LOG APP
         * by Gürkay BAŞYİĞİT
         */
        myLogTrace.saveLogTrace();
        Log.i(myLogTrace.getTag(), myLogTrace.getMessage() + myLogTrace.MESSAGE_END);

    }

    public boolean chkLogFileStateFindAnimals(String fileName) {

        FileInputStream fis = null;

        try {
            fis = openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text);
            }

            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void chkFileStateFindAnimals(String fileName) {

        FileInputStream fis = null;

        try {
            fis = openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text);
            }

            myLogTrace.setMessage("chkFileStateFindAnimals(); " + fileName);
            activityWhatIsTimer = new ActivityWhatIsTimer(getApplicationContext(), Integer.parseInt(sb.toString()));

        } catch (FileNotFoundException e) {
            myLogTrace.setMessage("chkFileStateFindAnimals() fail : there are not level.txt ");
            activityWhatIsTimer = new ActivityWhatIsTimer(getApplicationContext(), "level.txt", 1, 20000);
            e.printStackTrace();


        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void init() {
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btnLevel1MainFindAnimals = findViewById(R.id.btnLevel1MainFindAnimals);
        btnLevel2MainFindAnimals = findViewById(R.id.btnLevel2MainFindAnimals);
        btnLevel3MainFindAnimals = findViewById(R.id.btnLevel3MainFindAnimals);
        btnLevel4MainFindAnimals = findViewById(R.id.btnLevel4MainFindAnimals);
        btnLevel5MainFindAnimals = findViewById(R.id.btnLevel5MainFindAnimals);

        if (chkLogFileStateFindAnimals("logTraceFindAnimals.txt")) {
            myLogTrace.setMessage("chkLogFileStateFindAnimals(); " + chkLogFileStateFindAnimals("logTraceFindAnimals.txt"));
            myLogTrace = new MyLogTrace(getApplicationContext(), "logTraceFindAnimals.txt");
        } else {
            myLogTrace = new MyLogTrace(getApplicationContext());
        }

        /**
         * Check level.txt file
         */
        chkFileStateFindAnimals("level.txt");

        /**
         * Button Enable setting
         */
        if (activityWhatIsTimer.getGameLevelState()[0].equals("true")) {
            btnLevel1MainFindAnimals.setBackground(getDrawable(R.drawable.level1open));
        } else {
            btnLevel1MainFindAnimals.setBackground(getDrawable(R.drawable.level1close));
        }

        if (activityWhatIsTimer.getGameLevelState()[1].equals("true")) {
            btnLevel2MainFindAnimals.setBackground(getDrawable(R.drawable.level2open));
        } else {
            btnLevel2MainFindAnimals.setBackground(getDrawable(R.drawable.level2close));
        }

        if (activityWhatIsTimer.getGameLevelState()[2].equals("true")) {
            btnLevel3MainFindAnimals.setBackground(getDrawable(R.drawable.level3open));
        } else {
            btnLevel3MainFindAnimals.setBackground(getDrawable(R.drawable.level3close));
        }

        if (activityWhatIsTimer.getGameLevelState()[3].equals("true")) {
            btnLevel4MainFindAnimals.setBackground(getDrawable(R.drawable.level4open));
        } else {
            btnLevel4MainFindAnimals.setBackground(getDrawable(R.drawable.level4close));
        }

        if (activityWhatIsTimer.getGameLevelState()[4].equals("true")) {
            btnLevel5MainFindAnimals.setBackground(getDrawable(R.drawable.level5open));
        } else {
            btnLevel5MainFindAnimals.setBackground(getDrawable(R.drawable.level5close));
        }

        btnLevel1MainFindAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityWhatIsTimer.onClickLevelButtonCheckGameTimer(1);

                Intent intent = new Intent(getApplicationContext(), ActivityFindAnimals.class);
                intent.putExtra("gameLevel", Integer.toString(activityWhatIsTimer.getGameLevel()));
                intent.putExtra("gameTimer", Long.toString(activityWhatIsTimer.getGameTimer()));
                intent.putExtra("numberOfRandomPlaceFindAnimal", Integer.toString(1));
                intent.putExtra("randomPlaceFindAnimal", Integer.toString(1));
                startActivity(intent);
                finish();
            }
        });

        btnLevel2MainFindAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityWhatIsTimer.onClickLevelButtonCheckGameTimer(2);
                Intent intent = new Intent(getApplicationContext(), ActivityFindAnimals.class);
                intent.putExtra("gameLevel", Integer.toString(activityWhatIsTimer.getGameLevel()));
                intent.putExtra("gameTimer", Long.toString(activityWhatIsTimer.getGameTimer()));
                intent.putExtra("numberOfRandomPlaceFindAnimal", Integer.toString(2));
                intent.putExtra("randomPlaceFindAnimal", Integer.toString(2));
                startActivity(intent);
                finish();
            }
        });

        btnLevel3MainFindAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityWhatIsTimer.onClickLevelButtonCheckGameTimer(3);

                Intent intent = new Intent(getApplicationContext(), ActivityFindAnimals.class);
                intent.putExtra("gameLevel", Integer.toString(activityWhatIsTimer.getGameLevel()));
                intent.putExtra("gameTimer", Long.toString(activityWhatIsTimer.getGameTimer()));
                intent.putExtra("numberOfRandomPlaceFindAnimal", Integer.toString(2));
                intent.putExtra("randomPlaceFindAnimal", Integer.toString(3));
                startActivity(intent);
                finish();
            }
        });

        btnLevel4MainFindAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityWhatIsTimer.onClickLevelButtonCheckGameTimer(4);
                Intent intent = new Intent(getApplicationContext(), ActivityFindAnimals.class);
                intent.putExtra("gameLevel", Integer.toString(activityWhatIsTimer.getGameLevel()));
                intent.putExtra("gameTimer", Long.toString(activityWhatIsTimer.getGameTimer()));
                intent.putExtra("numberOfRandomPlaceFindAnimal", Integer.toString(3));
                intent.putExtra("randomPlaceFindAnimal", Integer.toString(5));
                startActivity(intent);
                finish();
            }
        });

        btnLevel5MainFindAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityWhatIsTimer.onClickLevelButtonCheckGameTimer(5);
                Intent intent = new Intent(getApplicationContext(), ActivityFindAnimals.class);
                intent.putExtra("gameLevel", Integer.toString(activityWhatIsTimer.getGameLevel()));
                intent.putExtra("gameTimer", Long.toString(activityWhatIsTimer.getGameTimer()));
                intent.putExtra("numberOfRandomPlaceFindAnimal", Integer.toString(4));
                intent.putExtra("randomPlaceFindAnimal", Integer.toString(7));
                startActivity(intent);
                finish();
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
