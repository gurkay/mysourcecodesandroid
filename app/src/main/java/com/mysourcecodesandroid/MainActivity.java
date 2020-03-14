package com.mysourcecodesandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView mainListView;

    String headList[] = {"Example 0", "Example 1", "Example 2", "Example 3", "Example 4", "Example 5",
            "Example 6", "Example 7", "Example 8", "Example 9", "Example 10"};
    String descriptionsList[] = {"RadioButton ve programatik olarak eklenen checkbox örneği",
            "Example 1",
            "Example 2",
            "Çalışma Zamanında(Programatik) Buton TextView Ekleme ve Buton Click Olayı",
            "macedonia",
            "nigeria", "romania", "south_korea", "turkey", "vietnam", "Test"};
    int pictures[] = {R.drawable.afghanistan, R.drawable.albania, R.drawable.algeria,
            R.drawable.argentina, R.drawable.macedonia, R.drawable.nigeria,
            R.drawable.romania, R.drawable.south_korea, R.drawable.turkey,
            R.drawable.vietnam, R.drawable.turkey};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        mainListView = (ListView) findViewById(R.id.mainListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), headList, descriptionsList, pictures);
        mainListView.setAdapter(customAdapter);

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intentExample0 = new Intent(MainActivity.this, ActivityExample0.class);
                        startActivity(intentExample0);
                        break;
                    case 1:
                        Intent intentExample1 = new Intent(MainActivity.this, ActivityExample1.class);
                        startActivity(intentExample1);
                        break;
                    case 2:
                        Intent intentExample2 = new Intent(MainActivity.this, ActivityExample2.class);
                        startActivity(intentExample2);
                        break;
                    case 3:
                        Intent intentProgrammatically = new Intent(MainActivity.this, Programmatically.class);
                        startActivity(intentProgrammatically);
                        break;
                    default:
                        break;
                }
            }
        });

    }
}
