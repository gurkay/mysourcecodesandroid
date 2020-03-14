package com.mysourcecodesandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView mainListView;
    String descriptionsList[] = {"afghanistan", "albania", "algeria", "turkey"};
    int pictures[] = {R.drawable.afghanistan, R.drawable.albania, R.drawable.algeria, R.drawable.turkey};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        mainListView = (ListView) findViewById(R.id.mainListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), descriptionsList, pictures);
        mainListView.setAdapter(customAdapter);
    }
}
