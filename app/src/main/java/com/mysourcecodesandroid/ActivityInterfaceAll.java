package com.mysourcecodesandroid;

public interface FileTaskListener {
    public void checkCondition();
    public void onWaitEnd();
    public void onConditionSuccess();
}
