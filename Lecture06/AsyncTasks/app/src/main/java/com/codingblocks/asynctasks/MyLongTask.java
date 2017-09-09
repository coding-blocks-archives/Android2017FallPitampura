package com.codingblocks.asynctasks;

import android.os.AsyncTask;

/**
 * Created by arnav on 9/9/2017.
 */
class MyLongTask extends AsyncTask<Integer, Float, Void> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        for (int i = 0; i < integers[0]; i++) {
            waitForASec();
            publishProgress((float) i / (float) integers[0]);
        }
        return null;
    }

    void waitForASec() {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() < startTime + 1000) ;
    }


}
