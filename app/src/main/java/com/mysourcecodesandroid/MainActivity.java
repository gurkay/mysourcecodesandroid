package com.mysourcecodesandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView mainListView;
    Context context = this;

    String headList[] = {"Example 0", "Example 1", "Example 2", "Example 3", "Example 4", "Example 5",
            "Example 6", "Example 7", "Example 8", "Example 9", "Example 10"};
    String descriptionsList[] = {
            "RadioButton ve programatik olarak eklenen checkbox örneği",
            "Custom Toast Message Example",
            "Intent login screen",
            "Çalışma Zamanında(Programatik) Buton TextView Ekleme ve Buton Click Olayı",
            "Text to Speech Example",
            "Find Animals Game",
            "Countdown Time with Start, Pause and Reset",
            "Playing Sounds and Music application",
            "Read / Write Text File",
            "Tank Savaslari",
            "Test"
    };
    int pictures[] = {R.drawable.afghanistan, R.drawable.albania, R.drawable.algeria,
            R.drawable.argentina, R.drawable.macedonia, R.drawable.nigeria,
            R.drawable.romania, R.drawable.south_korea, R.drawable.turkey,
            R.drawable.vietnam, R.drawable.turkey};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init function call
        init();
    }

    public void init() {
        mainListView = findViewById(R.id.mainListView);
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
                        // custom toast message activity_example1.xml
                        // erişim icin LayoutInflater kullaıyoruz
                        LayoutInflater layoutInflater = LayoutInflater.from(context);
                        View viewLayout = layoutInflater.inflate(R.layout.activity_example1, null);

                        // Image nesnesini yukluyoruz
                        ImageView imageView = viewLayout.findViewById(R.id.imgExample1);
                        imageView.setImageResource(R.mipmap.ic_launcher_error);

                        // Text nesnesine ulaşıyoruz
                        TextView textView = viewLayout.findViewById(R.id.txtExample1);
                        textView.setText("Activity example1 custom toast message");

                        // Custom Toast message
                        Toast toast = new Toast(context);
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        toast.setDuration(Toast.LENGTH_LONG);
                        toast.setView(viewLayout);
                        toast.show();
                        break;
                    case 2:
                        Intent intentExample2 = new Intent(MainActivity.this, ActivityExample2.class);
                        startActivity(intentExample2);
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, Programmatically.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, ActivityTextToSpeech.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this, ActivityMainFindAnimals.class));
                        break;
                    case 6:
                        startActivity(new Intent(MainActivity.this, ActivityCountdownTimer.class));
                        break;
                    case 7:
                        startActivity(new Intent(MainActivity.this, ActivitySoundsAndMusic.class));
                        break;
                    case 8:
                        startActivity(new Intent(MainActivity.this, ActivityRWTextFile.class));
                        break;
                    case 9:
                        startActivity(new Intent(MainActivity.this, ActivityWarior.class));
                        break;
                    default:
                        break;
                }
            }
        });

    }
}
