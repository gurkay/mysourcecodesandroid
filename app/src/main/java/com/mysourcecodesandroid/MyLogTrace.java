package com.mysourcecodesandroid;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyLogTrace implements ActivityInterfaceAll.MyLogTraceListener {
    /**
     * VARIABLES
     */
    Context context;
    private String tag = "TAG";
    String MESSAGE_HEADER_BEGIN = "============================== MY LOG BEGIN ========================================" + "\n";
    String MESSAGE_END = "============================== MY LOG END ==========================================";
    private String FILE_NAME = "logTrace.txt";
    private String message = MESSAGE_HEADER_BEGIN;


    private boolean fileState;

    public MyLogTrace(Context context) {
        this.context = context;

        saveLogTrace();

    }

    /**
     * CONSTRUCTOR
     *
     * @param context
     * @param fileName
     */
    public MyLogTrace(Context context, String fileName) {
        this.context = context;
        this.FILE_NAME = fileName;

        if (!isFileState()) {
            saveLogTrace();
        }
    }

    /**
     * GETTER AND SETTER METHODS
     *
     * @return
     */
    public boolean isFileState() {
        return fileState;
    }

    public void setFileState(boolean fileState) {
        this.fileState = fileState;
    }

    public String getTag() {
        return tag;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = getMessage() + message + "\n";
    }

    /**
     * OVERRIDE METHODS
     */
    @Override
    public void loadLogTrace() {
        FileInputStream fis = null;

        try {
            fis = context.openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text);
            }

            setMessage(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void checkFileState() {
        FileInputStream fis = null;

        try {
            fis = context.openFileInput(FILE_NAME);
            setFileState(true);
        } catch (FileNotFoundException e) {
            setFileState(false);
            e.printStackTrace();
        }
    }

    @Override
    public void saveLogTrace() {
        String text = getMessage() + MESSAGE_END;
        FileOutputStream fos = null;

        try {
            fos = context.openFileOutput(FILE_NAME, context.MODE_PRIVATE);
            fos.write(text.getBytes());
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
