package com.mysourcecodesandroid;

import android.content.Context;

public class ActivityWhatIsTimer extends ActivityFileTaskFindAnimals {



    private long gameTimer;
    private int numberOfRandomPlaceFindAnimal;

    public ActivityWhatIsTimer(Context context) {
        super(context);
        this.gameTimer = 20000;
    }

    public ActivityWhatIsTimer(Context context, int gameLevel) {
        super(context, gameLevel);
    }

    public ActivityWhatIsTimer(Context context, String FILE_NAME, int gameLevel, final long gameTimer) {
        super(context, FILE_NAME, gameLevel);
        this.gameTimer = gameTimer;
    }

    public long getGameTimer() {
        return gameTimer;
    }

    public void setGameTimer(long gameTimer) {
        this.gameTimer = gameTimer;
    }

    public int getNumberOfRandomPlaceFindAnimal() {
        return numberOfRandomPlaceFindAnimal;
    }

    public void setNumberOfRandomPlaceFindAnimal(int numberOfRandomPlaceFindAnimal) {
        this.numberOfRandomPlaceFindAnimal = numberOfRandomPlaceFindAnimal;
    }




}
