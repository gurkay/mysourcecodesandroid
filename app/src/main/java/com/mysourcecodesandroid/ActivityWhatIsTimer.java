package com.mysourcecodesandroid;

import android.content.Context;

public class ActivityWhatIsTimer extends ActivityFileTaskFindAnimals {


    private long gameTimer;

    public ActivityWhatIsTimer(Context context, int gameLevel) {
        super(context, gameLevel);
        onClickLevelButtonCheckGameTimer(gameLevel);
    }

    public ActivityWhatIsTimer(Context context, String fileName, int gameLevel, long gameTimer) {
        super(context, fileName, gameLevel);
        this.gameTimer = gameTimer;
    }

    public long getGameTimer() {
        return gameTimer;
    }

    public void setGameTimer(long gameTimer) {
        this.gameTimer = gameTimer;
    }

    public void onClickLevelButtonCheckGameTimer(int gameLevel) {
        String[] val = {"false", "false", "false", "false", "false"};

        for (int i = 0; i < 5; i++) {
            if (i <= (getGameLevel() - 1)) {
                val[i] = "true";
            } else {
                val[i] = "false";
            }
        }

        setGameLevelState(val);

        switch (gameLevel) {
            case 1:
                /**
                 * Level check state
                 */

                setGameLevel(gameLevel);
                setGameTimer(20000);

                break;
            case 2:

                setGameLevel(gameLevel);
                setGameTimer(17000);


                break;
            case 3:

                setGameLevel(gameLevel);
                setGameTimer(14000);

                break;
            case 4:

                setGameLevel(gameLevel);
                setGameTimer(11000);

                break;
            case 5:

                setGameLevel(gameLevel);
                setGameTimer(8000);

                break;
        }
    }

}
