package com.mysourcecodesandroid;

import android.os.Handler;
import android.os.Looper;

public class ActivityFileTaskFindAnimals {
    
}

public class Waiter {
    WaitListener waitListener;
    int waitTime = 0;
    Handler handler;
    int waitStep = 1000;
    int maxWaitTime = 5000;
    boolean condition = false;

    public Waiter(Looper looper, final int waitStep, final int maxWaitTime){

        handler = new Handler(looper);
        this.waitStep = waitStep;
        this.maxWaitTime = maxWaitTime;

    }

    public void start(){

        handler.post(new Runnable() {
            @Override
            public void run() {

                waitListener.checkCondition();

                if (condition) {

                    waitListener.onConditionSuccess();

                } else {
                    if (waitTime <= maxWaitTime) {

                        waitTime += waitStep;
                        handler.postDelayed(this, waitStep);

                    } else {

                        waitListener.onWaitEnd();
                    }
                }
            }
        });

    }

    public void setConditionState(boolean condition){
        this.condition = condition;
    }

    public void setWaitListener(WaitListener waitListener){
        this.waitListener = waitListener;
    }
}
