package com.ys.mosbydemo;

import android.os.AsyncTask;
import android.os.SystemClock;

/**
 * Created by 10370 on 2016/5/25.
 * "Business Logic" component
 */
public class GreetingGeneratorTask extends AsyncTask<Void, Void, Integer> {

    //Callback - Listener.
    public interface GreetingTaskListener{
        void onGreetingGenerated(String greetingText);
    }

    private String baseText;
    private GreetingTaskListener listener;
    public GreetingGeneratorTask(String baseText, GreetingTaskListener listener){
        this.baseText = baseText;
        this.listener = listener;
    }

    @Override
    protected Integer doInBackground(Void... params) {
        SystemClock.sleep(3 * 1000);
        return (int)(Math.random() * 100);
    }

    @Override
    protected void onPostExecute(Integer integer) {
        listener.onGreetingGenerated(baseText + " " + integer);
    }
}
