package com.mysourcecodesandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

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

    String[] useImage = {
            "false", "false", "false", "false", "false", "false", "false", "false", "false",
            "false", "false", "false", "false", "false", "false", "false", "false", "false",
            "false"
    };

    TextView txtQuestionFindAnimals;
    TableRow tblRow3FirstRowFindAnimals, tblRow3SecondRowFindAnimals, tblRow3ThreeRowFindAnimals, tblRow3FourRowFindAnimals;
    TableLayout tblRow3FindAnimals;
    Context context = this;
    int level = 4;
    int randomIntFindAnimal, randomPlaceFindAnimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_animals);
        init();

    }

    public void init() {
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        txtQuestionFindAnimals = findViewById(R.id.txtQuestionFindAnimals);
        tblRow3FirstRowFindAnimals = findViewById(R.id.tblRow3FirstRowFindAnimals);
        tblRow3SecondRowFindAnimals = findViewById(R.id.tblRow3SecondRowFindAnimals);
        tblRow3ThreeRowFindAnimals = findViewById(R.id.tblRow3ThreeRowFindAnimals);
        tblRow3FourRowFindAnimals = findViewById(R.id.tblRow3FourRowFindAnimals);



        /**
         * LEVEL 1
         */


        txtQuestionFindAnimals.setText(questionFindAnimals[0]);

        // take number of installment
        // level = 1;

        if (level == 1) {

            // image view create
            for (int i = 0; i < 2; i++) {
                final ImageView imageView = new ImageView(context);
                imageView.setId(i);
                imageView.setImageResource(picturesFindAnimals[i]);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Message : " + imageView.getId(), Toast.LENGTH_SHORT).show();
                    }
                });

                tblRow3FirstRowFindAnimals.addView(imageView);
            }

        }

        /**
         * LEVEL 4
         */
        // take number of installment
        level = 4;

        if (level == 4) {

            randomIntFindAnimal = randomNumberCreate(0, 18);
            txtQuestionFindAnimals.setText(questionFindAnimals[randomIntFindAnimal]);
            randomPlaceFindAnimal = randomNumberCreate(0, 5);

            int count = 0;
            // image view create
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {

                    int randomNumber = randomNumberCreate(0, 18);

                    // Use to image
                    while (useToImage(randomNumber) == true) {
                        randomNumber = randomNumberCreate(0, 18);
                    }

                    final ImageView imageView = new ImageView(context);

                    switch (i) {
                        case 0:

                            if (count == randomPlaceFindAnimal) {
                                imageView.setId(randomIntFindAnimal);
                                imageView.setImageResource(picturesFindAnimals[randomIntFindAnimal]);
                                imageView.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(context, "Message : " + imageView.getId(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                                //TableRow tableRow = new TableRow(context);
                                tblRow3FirstRowFindAnimals.addView(imageView);
                                count++;
                            } else {
                                imageView.setId(randomNumber);
                                imageView.setImageResource(picturesFindAnimals[randomNumber]);
                                imageView.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(context, "Message : " + imageView.getId(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                                //TableRow tableRow = new TableRow(context);
                                tblRow3FirstRowFindAnimals.addView(imageView);
                                count++;
                            }

                            break;
                        case 1:
                            if (count == randomPlaceFindAnimal) {
                                imageView.setId(randomIntFindAnimal);
                                imageView.setImageResource(picturesFindAnimals[randomIntFindAnimal]);
                                imageView.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(context, "Message : " + imageView.getId(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                                //TableRow tableRow = new TableRow(context);
                                tblRow3SecondRowFindAnimals.addView(imageView);
                                count++;
                            } else {
                                imageView.setId(randomNumber);
                                imageView.setImageResource(picturesFindAnimals[randomNumber]);

                                imageView.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(context, "Message : " + imageView.getId(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                                //TableRow tableRow = new TableRow(context);
                                tblRow3SecondRowFindAnimals.addView(imageView);
                                count++;
                            }
                            break;
                        case 2:
                            if (count == randomPlaceFindAnimal) {
                                imageView.setId(randomIntFindAnimal);
                                imageView.setImageResource(picturesFindAnimals[randomIntFindAnimal]);
                                imageView.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(context, "Message : " + imageView.getId(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                                //TableRow tableRow = new TableRow(context);
                                tblRow3ThreeRowFindAnimals.addView(imageView);
                                count++;
                            } else {
                                imageView.setId(randomNumber);
                                imageView.setImageResource(picturesFindAnimals[randomNumber]);

                                imageView.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(context, "Message : " + imageView.getId(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                                //TableRow tableRow = new TableRow(context);
                                tblRow3ThreeRowFindAnimals.addView(imageView);
                                count++;
                            }
                            break;
                    }

                    Log.d("CONSOLE LOG TAG", "Right now here...! Gürkay BAŞYİĞİT continues find error :) Image get ID : " + imageView.getId());

                }
                Log.d("Gürkay CONSOLE LOG TAG", "count : " + count);
            }

        }

    }

    public boolean useToImage(int imageId) {
        boolean conclution = false;

        if(useImage[imageId].equals("false")) {
            useImage[imageId] = "true";
            conclution = false;
        } else {
            conclution = true;
        }

        return conclution;
    }

    public int randomNumberCreate(int minimum, int maximum) {
        int min = minimum;
        int max = maximum;
        int randomNumber = new Random().nextInt((max - min) + 1) + min;
        return randomNumber;
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
