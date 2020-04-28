package com.mysourcecodesandroid;

import org.junit.jupiter.api.Test;

public class ActivityFindAnimalsTest {

    ActivityFindAnimals activityFindAnimals = new ActivityFindAnimals();

    @Test
    public void init() {
    }

    @Test
    public void getNumberOfRandomPlaceFindAnimal() {
    }

    @Test
    public void setNumberOfRandomPlaceFindAnimal() {
    }

    @Test
    public void getNumberOfCheckAnswer() {
    }

    @Test
    public void setNumberOfCheckAnswer() {
    }

    @Test
    public void setGameLevel() {
        try {
            int input = 1;
            int output;
            int expected = 1;
            double delta = .1;

            activityFindAnimals.setGameLevel(input);
            assertEquals("Adding 1 more fruit to list", expected, activityFindAnimals.getGameLevel(), delta);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.jupiter.api.Test
    public void getGameLevel() {
        try {
            int output;
            int expected = 1;
            double delta = .1;


            //assertEquals(expected, output, delta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void gameRestart() {
    }

    @Test
    public void correctAnswer() {
    }

    @Test
    public void startTime() {
    }

    @Test
    public void resetTimer() {
    }

    @Test
    public void updateCountDownText() {
    }

    @Test
    public void getLevelState() {
    }

    @Test
    public void gameStart() {
    }

    @Test
    public void useToImage() {
    }

    @Test
    public void randomNumberCreate() {
    }
}