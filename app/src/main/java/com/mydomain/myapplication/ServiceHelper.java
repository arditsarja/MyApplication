package com.mydomain.myapplication;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class ServiceHelper {
    public static Timer timer = new Timer();
    public static int sekonda = 6;

    public static void activate(final Context context) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() { // Function runs every SimpleProducer.timeIntervalMin minutes.
                // Run the code you want here
                Log.d(context.getString(R.string.app_name),"Servisi filloi");
            }
        }, 0, 1000 * sekonda);
    }

    public static void cancel(final Context context) {
        timer.cancel();
        Log.d(context.getString(R.string.app_name),"Servisi perfundoi");
    }


}
