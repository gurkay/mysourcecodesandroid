package com.mysourcecodesandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Random;

public class ActivityFindAnimals extends AppCompatActivity {

    String questionFindAnimals[] = {
            "Find the bear, bear makes sound growlll",
            "Find the cat, cat makes sound meowww",
            "Find the chick, chick makes sound cikcik",
            "Find the cow, cow makes sound mowwww",
            "Find the crocodile, crocodile makes sound...!",
            "Find the dog, dog makes sound havhav",
            "Find the donkey, donkey makes sound aiiiaiii",
            "Find the duck, duck makes sound virak virak",
            "Find the elephant, elephant makes sound...!",
            "Find the frog, frog makes sound...!",
            "Find the giraffe, giraffe makes sound...!",
            "Find the goat, goat makes sound meaameeaa",
            "Find the hippo, hippo makes sound...!",
            "Find the koala, koala makes sound...!",
            "Find the lemurs, lemurs makes sound...!",
            "Find the lion, lion makes sound roarrrr",
            "Find the monkey, monkey makes sound...!",
            "Find the mouse, mouse makes sound...!",
            "Find the panda, panda makes sound...!",
            "Find the penguin, penguin makes sound...!",
            "Find the pig, pig makes sound...!",
            "Find the polar bear, polar bear makes sound...!",
            "Find the porky, porky makes sound...!",
            "Find the rabbit, rabbit makes sound...!",
            "Find the raccoon, raccoon makes sound...!",
            "Find the sheep, sheep makes sound meeemeeee"
    };

    int picturesFindAnimals[] = {
            R.drawable.bear, R.drawable.cat, R.drawable.chick, R.drawable.cow, R.drawable.crocodile,
            R.drawable.dog, R.drawable.donkey, R.drawable.duck, R.drawable.elephant, R.drawable.frog,
            R.drawable.giraffe, R.drawable.goat, R.drawable.hippo, R.drawable.koala, R.drawable.lemurs,
            R.drawable.lion, R.drawable.monkey, R.drawable.mouse, R.drawable.panda, R.drawable.penguin,
            R.drawable.pig, R.drawable.polar_bear, R.drawable.porky, R.drawable.rabbit,
            R.drawable.raccoon, R.drawable.sheep
    };

    int soundFindAnimals[] = {
            R.raw.bear, R.raw.cat, R.raw.chick, R.raw.cow, R.raw.crocodile,
            R.raw.dog, R.raw.donkey, R.raw.duck, R.raw.elephant, R.raw.frog,
            R.raw.giraffe, R.raw.goat, R.raw.hippo, R.raw.koala, R.raw.lemurs,
            R.raw.lion, R.raw.monkey, R.raw.mouse, R.raw.panda, R.raw.penguin,
            R.raw.pig, R.raw.polar_bear, R.raw.porky, R.raw.rabbit,
            R.raw.raccoon, R.raw.sheep
    };

    String[] useImage = {
            "false", "false", "false", "false", "false", "false", "false", "false", "false", "false",
            "false", "false", "false", "false", "false", "false", "false", "false", "false", "false",
            "false", "false", "false", "false", "false", "false"
    };

    private static final String FILE_NAME = "level.txt";

    MediaPlayer player;
    LinearLayout linearLayoutVerticalFindAnimals;
    TextView txtQuestionFindAnimals, txtNumberOfLevelFindAnimals, txtNumberOfTimerFindAnimals;
    ImageView imgViewCheck0FindAnimals, imgViewCheck1FindAnimals, imgViewCheck2FindAnimals;
    TableLayout tblLayoutFindAnimals;
    Context context = this;
    int randomIntFindAnimal, randomPlaceFindAnimal;
    private TextToSpeech mTTS;
    private int imageViewHeight = 550;
    private int numberOfRandomPlaceFindAnimal;
    private int numberOfCheckAnswer = 0;
    private int gameLevel;

    private long mTimeLeftInMillis;
    private CountDownTimer mCountDownTimer;
    ActivityWhatIsTimer activityWhatIsTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_animals);
        init();
    }

    public void init() {
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        txtQuestionFindAnimals = findViewById(R.id.txtQuestionFindAnimals);
        txtNumberOfLevelFindAnimals = findViewById(R.id.txtNumberOfLevelFindAnimals);
        imgViewCheck0FindAnimals = findViewById(R.id.imgViewCheck0FindAnimals);
        imgViewCheck1FindAnimals = findViewById(R.id.imgViewCheck1FindAnimals);
        imgViewCheck2FindAnimals = findViewById(R.id.imgViewCheck2FindAnimals);
        txtNumberOfTimerFindAnimals = findViewById(R.id.txtNumberOfTimerFindAnimals);
        tblLayoutFindAnimals = findViewById(R.id.tblLayoutFindAnimals);


        this.gameLevel = Integer.parseInt(getIntent().getExtras().getString("gameLevel"));
        this.mTimeLeftInMillis = Long.parseLong(getIntent().getExtras().getString("gameTimer"));
        this.numberOfRandomPlaceFindAnimal = Integer.parseInt(getIntent().getExtras().getString("numberOfRandomPlaceFindAnimal"));
        this.randomPlaceFindAnimal = Integer.parseInt(getIntent().getExtras().getString("randomPlaceFindAnimal"));

        txtNumberOfLevelFindAnimals.setText(Integer.toString(this.gameLevel));

        mTTS = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(Locale.getDefault());

                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        Log.e("TTS", "Speak");
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        gameStart();
    }

    public long getmTimeLeftInMillis() {
        return mTimeLeftInMillis;
    }

    public int getNumberOfCheckAnswer() {
        return this.numberOfCheckAnswer;
    }

    public void setNumberOfCheckAnswer(int numberOfCheckAnswer) {
        this.numberOfCheckAnswer = numberOfCheckAnswer;
    }

    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText(context, "MediaPlayer release", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        stopPlayer();
    }

    private void playerStart(int soundFindAnimals) {
        if (player == null) {
            player = MediaPlayer.create(context, soundFindAnimals);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }

    private void speak() {
        String text = txtQuestionFindAnimals.getText().toString();
        float pitch = (float) 75 / 50;
        if (pitch < 0.1) pitch = 0.1f;
        float speed = (float) 75 / 50;
        if (speed < 0.1) speed = 0.1f;

        mTTS.setPitch(pitch);
        mTTS.setSpeechRate(speed);

        // Controller SDK versions
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        } else {
            mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    /**
     * Game Start
     */
    public void gameStart() {
        int count = 0;
        int columsTblRow = 2;
        int rndPlaceFindAnimal = randomNumberCreate(0, numberOfRandomPlaceFindAnimal);
        randomIntFindAnimal = randomNumberCreate(0, 25);
        txtQuestionFindAnimals.setText(questionFindAnimals[randomIntFindAnimal]);
        if (this.gameLevel == 4) {
            this.imageViewHeight = 350;
        } else if (this.gameLevel == 5) {
            this.imageViewHeight = 300;
        }

        /**
         * WAIT SPEAK AND SOUND
         */

        speak();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // Actions to do after 10 seconds
                playerStart(soundFindAnimals[randomIntFindAnimal]);
                /**
                 *  time counter
                 */

            }
        }, 5000);

        // image view create
        for (int i = 0; i < numberOfRandomPlaceFindAnimal; i++) {
            TableRow tableRow = new TableRow(context);

            for (int j = 0; j < columsTblRow; j++) {
                int randomNumber = randomNumberCreate(0, 25);
                // Use to image
                while (useToImage(randomNumber) == true) {
                    randomNumber = randomNumberCreate(0, 25);
                }

                final ImageView imageView = new ImageView(context);
                if (this.gameLevel == 2) {
                    if (count < 3) {
                        if (count == rndPlaceFindAnimal) {
                            imageView.setId(randomIntFindAnimal);
                            imageView.setImageResource(picturesFindAnimals[randomIntFindAnimal]);

                            imageView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(context, "Answer : Correct" + imageView.getId(), Toast.LENGTH_SHORT).show();
                                    setNumberOfCheckAnswer(getNumberOfCheckAnswer() + 1);
                                    correctAnswer(getNumberOfCheckAnswer());
                                }
                            });

                            useToImage(randomIntFindAnimal);

                            imageView.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, imageViewHeight));
                            tableRow.addView(imageView);
                            stopPlayer();

                        } else {
                            imageView.setId(randomNumber);
                            imageView.setImageResource(picturesFindAnimals[randomNumber]);

                            imageView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(context, "Message : Fail answer" + imageView.getId(), Toast.LENGTH_SHORT).show();
                                    gameRestart();

                                    Intent intent = new Intent(getApplicationContext(), ActivityFindAnimalTimeFinish.class);
                                    intent.putExtra("gameLevel", Integer.toString(gameLevel));
                                    startActivity(intent);
                                    finish();

                                }
                            });
                            useToImage(randomIntFindAnimal);

                            imageView.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, imageViewHeight));
                            tableRow.addView(imageView);
                            stopPlayer();
                        }
                        count++;
                    }
                } else {
                    if (count == rndPlaceFindAnimal) {
                        imageView.setId(randomIntFindAnimal);
                        imageView.setImageResource(picturesFindAnimals[randomIntFindAnimal]);

                        imageView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(context, "Answer : Correct" + imageView.getId(), Toast.LENGTH_SHORT).show();
                                setNumberOfCheckAnswer(getNumberOfCheckAnswer() + 1);
                                correctAnswer(getNumberOfCheckAnswer());
                            }
                        });

                        useToImage(randomIntFindAnimal);

                        imageView.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, imageViewHeight));
                        tableRow.addView(imageView);
                        stopPlayer();
                    } else {
                        imageView.setId(randomNumber);
                        imageView.setImageResource(picturesFindAnimals[randomNumber]);

                        imageView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(context, "Message : Fail answer" + imageView.getId(), Toast.LENGTH_SHORT).show();
                                gameRestart();

                                Intent intent = new Intent(getApplicationContext(), ActivityFindAnimalTimeFinish.class);
                                intent.putExtra("gameLevel", Integer.toString(gameLevel));
                                startActivity(intent);
                                finish();

                            }
                        });
                        useToImage(randomIntFindAnimal);

                        imageView.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, imageViewHeight));
                        tableRow.addView(imageView);
                        stopPlayer();
                    }
                    count++;
                }
            }

            tblLayoutFindAnimals.addView(tableRow);
        }
        startTime();
    }

    public void gameRestart() {
        setNumberOfCheckAnswer(0);
        imgViewCheck0FindAnimals.setImageResource(R.mipmap.ic_launcher_incheck_trans);
        imgViewCheck1FindAnimals.setImageResource(R.mipmap.ic_launcher_incheck_trans);
        imgViewCheck2FindAnimals.setImageResource(R.mipmap.ic_launcher_incheck_trans);
        tblLayoutFindAnimals.removeAllViews();
        for (int i = 0; i < this.useImage.length; i++) {
            this.useImage[i] = "false";
        }
        stopPlayer();
        resetTimer();
    }

    /**
     * if correct answer
     */
    public void correctAnswer(int corAnswer) {
        //setGameLevel(1);
        if (corAnswer == 1) {
            imgViewCheck0FindAnimals.setImageResource(R.mipmap.ic_launcher_check_trans);
            tblLayoutFindAnimals.removeAllViews();
            stopPlayer();
        }
        if (corAnswer == 2) {
            imgViewCheck1FindAnimals.setImageResource(R.mipmap.ic_launcher_check_trans);
            tblLayoutFindAnimals.removeAllViews();
            stopPlayer();
        }

        if (corAnswer == 3) {
            final Waiter waiter = new Waiter(getMainLooper(), 1000, 1000);
            waiter.setWaitListener(new WaitListener() {

                @Override
                public void checkCondition() {
                    imgViewCheck2FindAnimals.setImageResource(R.mipmap.ic_launcher_check_trans);
                }

                @Override
                public void onWaitEnd() {
                    //DO
                    setNumberOfCheckAnswer(0);

                    gameRestart();

                    if (gameLevel == 1) {
                        gameLevel++;
                    } else if (gameLevel == 2) {
                        gameLevel++;
                    } else if (gameLevel == 3) {
                        gameLevel++;
                    } else if (gameLevel == 4) {
                        gameLevel++;
                    }

                    activityWhatIsTimer = new ActivityWhatIsTimer(getApplicationContext(), gameLevel);



                    Intent intent = new Intent(getApplicationContext(), ActivityFindAnimalLevelMessage.class);
                    intent.putExtra("gameLevel", Integer.toString(gameLevel));
                    intent.putExtra("mTimeLeftInMillis", Long.toString(mTimeLeftInMillis));
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onConditionSuccess() {
                    //DO

                    tblLayoutFindAnimals.removeAllViews();
                }

            });

            waiter.start();
        }

        if (corAnswer < 3 || corAnswer < 0) {
            gameStart();
        }

    }

    /**
     * Time counter
     */
    public void startTime() {

        mCountDownTimer = new CountDownTimer(getmTimeLeftInMillis(), 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {

            }
        }.start();

    }

    /**
     * Reset timer
     */
    public void resetTimer() {
        updateCountDownText();
    }

    /**
     * Reset timer
     */
    public void pauseTimer() {
        mCountDownTimer.cancel();
    }

    /**
     * Time counter text update
     */
    public void updateCountDownText() {
        // int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (getmTimeLeftInMillis() / 1000) % 60;

        // String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d", seconds);
        txtNumberOfTimerFindAnimals.setText(timeLeftFormatted);
    }

    /**
     * USE TO IMAGE RANDOM
     *
     * @param imageId
     * @return
     */
    public boolean useToImage(int imageId) {
        boolean conclution = false;

        if (useImage[imageId].equals("false")) {
            useImage[imageId] = "true";
            conclution = false;
        } else {
            conclution = true;
        }

        return conclution;
    }

    /**
     * TANDOM NAMBER GENERATE
     *
     * @param minimum
     * @param maximum
     * @return
     */
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
