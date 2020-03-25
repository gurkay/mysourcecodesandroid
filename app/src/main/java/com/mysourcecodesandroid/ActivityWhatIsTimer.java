package com.mysourcecodesandroid;

import android.content.Context;

public class ActivityWhatIsTimer extends ActivityFileTaskFindAnimals {



    private long gameTimer;
    private int numberOfRandomPlaceFindAnimal;

    public ActivityWhatIsTimer(Context context, String FILE_NAME, int gameLevel, final long gameTimer) {
        super(context, FILE_NAME, gameLevel);
        this.gameTimer = gameTimer;
        saveGameTimer();
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

    public void saveGameTimer() {
        if (getGameLevel() == 1) {
            setGameTimer(20000);
            setNumberOfRandomPlaceFindAnimal(1);
        } else if (getGameLevel() == 2) {
            setGameTimer(17000);
            setNumberOfRandomPlaceFindAnimal(2);
        } else if (getGameLevel() == 3) {
            setGameTimer(14000);
            setNumberOfRandomPlaceFindAnimal(2);
        } else if (getGameLevel() == 4) {
            setGameTimer(11000);
            setNumberOfRandomPlaceFindAnimal(3);
        } else if (getGameLevel() == 5) {
            setGameTimer(8000);
            setNumberOfRandomPlaceFindAnimal(4);
        }

    }


}
