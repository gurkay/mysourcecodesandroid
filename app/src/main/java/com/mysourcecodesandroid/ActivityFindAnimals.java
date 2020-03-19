package com.mysourcecodesandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityFindAnimals extends AppCompatActivity {

    String questionFindAnimals[] = {
            "Find the bald eagle, bald eagle makes sound...!",
            "Find the bear, bear makes sound...!",
            "Find the beluga whale, beluga whale makes sound...!",
            "Find the cat, cat makes sound...!",
            "Find the jaguar, jaguar makes sound...!",
            "Find the killer whale, killer whale makes sound...!",
            "Find the lion, lion makes sound...!",
            "Find the penguin, penguin makes sound...!",
            "Find the sea lion, sea lion makes sound...!",
            "Find the pig, pig makes sound...!",
            "Find the gray wolf, gray wolf makes sound...!",
            "Find the leopard, leopard makes sound...!",
            "Find the frog, frog makes sound...!",
            "Find the hippo, hippo makes sound...!",
            "Find the chimps, chimps makes sound...!",
            "Find the elephant, elephant makes sound...!",
            "Find the bengal tiger, bengal tiger makes sound...!",
            "Find the dolphin, dolphin makes sound...!",
            "Find the dog, dog makes sound...!"
    };

    int picturesFindAnimals[] = {
            R.drawable.bald_eagle, R.drawable.bear, R.drawable.beluga_whale,
            R.drawable.cat, R.drawable.jaguar, R.drawable.killer_whale,
            R.drawable.lion, R.drawable.penguin, R.drawable.sea_lion,
            R.drawable.pig, R.drawable.gray_wolf, R.drawable.leopard,
            R.drawable.frog, R.drawable.hippo, R.drawable.chimps, R.drawable.elephant,
            R.drawable.bengal_tiger, R.drawable.dolphin, R.drawable.dog
    };

    TextView txtQuestionFindAnimals;
    ImageView imgPicturesOfQuestion0FindAnimals;
    LinearLayout tblRow3FindAnimals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_animals);
        init();

    }

    public void init() {
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        txtQuestionFindAnimals = findViewById(R.id.txtQuestionFindAnimals);
        imgPicturesOfQuestion0FindAnimals = findViewById(R.id.imgPicturesOfQuestion0FindAnimals);
        
        tblRow3FindAnimals.setVisibility(View.INVISIBLE);
        
        // take number of installment
        int level = 1;
        
        if(level == 1) {
            tblRow3FindAnimals.setVisibility(View.VISIBLE);
            
            // image view create
            for (int i = 0; i < installment; i++) {
                
                CheckBox checkBox = new CheckBox(context);
                checkBox.setText((i+1) + ". Taksit");

                pnlInstallmentsExample0.addView(checkBox);
            }
            
        }
        
        txtQuestionFindAnimals.setText(questionFindAnimals[0]);
        imgPicturesOfQuestion0FindAnimals.setImageResource(picturesFindAnimals[0]);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
