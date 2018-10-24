package com.demo.landlordpractise.async;

import android.os.AsyncTask;

public class AsyncRunner {
    public static void runInBackGround(Runnable action){
        new AsyncTask<Boolean, Void, Void>(){

            @Override
            protected Void doInBackground(Boolean... booleans) {
                action.run();
                return null;
            }
        }.execute(true);
    }
}
