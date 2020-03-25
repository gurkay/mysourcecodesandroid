package com.mysourcecodesandroid;

class ActivityInterfaceAll {

    interface FileTaskListener {
        public void loadFileLevelOfFindAnimals(); // checkCondition();
        public void checkFileStateFindAnimals();
        public void saveFileLevelOfFindAnimals(); // onWaitEnd();
        // public void onConditionSuccess();
    }

    interface MyLogTraceListener {
        public void loadLogTrace();
        public void saveLogTrace();
        public void checkFileState();
    }
}
