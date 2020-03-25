package com.mysourcecodesandroid;

import android.app.Activity;
import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ActivityFileTaskFindAnimals implements ActivityInterfaceAll.FileTaskListener {

    ActivityInterfaceAll.FileTaskListener fileTaskListener;
    Context context;
    private String FILE_NAME_LEVEL = "level.txt";
    private boolean fileStateFindAnimals = false;
    private int gameLevel = 1;

    public ActivityFileTaskFindAnimals(Context context) {
        this.context = context;
        this.FILE_NAME_LEVEL = "level.txt";
        this.fileStateFindAnimals = true;
        saveFileLevelOfFindAnimals();
    }

    public ActivityFileTaskFindAnimals(Context context, int gameLevel) {
        this.context = context;
        this.fileStateFindAnimals = true;
        this.gameLevel = gameLevel;
        saveFileLevelOfFindAnimals();
    }

    public ActivityFileTaskFindAnimals(Context context, String fileNameLevel, int gameLevel) {
        this.context = context;
        this.fileStateFindAnimals = true;
        this.FILE_NAME_LEVEL = fileNameLevel;
        this.gameLevel = gameLevel;
        saveFileLevelOfFindAnimals();
    }

    public boolean isFileStateFindAnimals() {
        return fileStateFindAnimals;
    }

    public void setFileStateFindAnimals(boolean fileStateFindAnimals) {
        this.fileStateFindAnimals = fileStateFindAnimals;
    }

    public int getGameLevel() {
        return gameLevel;
    }

    public void setGameLevel(int gameLevel) {
        this.gameLevel = gameLevel;
    }

    public void seFileTaskListener(ActivityInterfaceAll.FileTaskListener fileTaskListener) {
        this.fileTaskListener = fileTaskListener;
    }

    @Override
    public void loadFileLevelOfFindAnimals() {
        FileInputStream fis = null;

        try {
            fis = context.openFileInput(FILE_NAME_LEVEL);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while((text = br.readLine()) != null) {
                sb.append(text);
            }
            setGameLevel(Integer.parseInt(sb.toString()));
            this.fileStateFindAnimals = true;
        } catch (FileNotFoundException e) {
            this.fileStateFindAnimals = false;
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void checkFileStateFindAnimals() {

        FileInputStream fis = null;

        try {
            fis = context.openFileInput(FILE_NAME_LEVEL);
            setFileStateFindAnimals(true);
        } catch (FileNotFoundException e) {
            setFileStateFindAnimals(false);
            e.printStackTrace();
        }
    }

    @Override
    public void saveFileLevelOfFindAnimals() {
    
        FileOutputStream fos = null;

        try {
            fos = context.openFileOutput(FILE_NAME_LEVEL, context.MODE_PRIVATE);
            fos.write(Integer.toString(getGameLevel()).getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }    
    }
}
