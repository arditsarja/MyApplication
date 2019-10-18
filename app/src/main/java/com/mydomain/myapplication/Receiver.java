package com.mydomain.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Intendi u degjua.", Toast.LENGTH_LONG).show();
        Log.e("Intendi u degjua", "Intendi u degjua");
        if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
            kerkoKarikimi(context);
        } else if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            mosKerkoKArikim(context);
        }
    }


    private void kerkoKarikimi(Context context) {
        Toast.makeText(context, "Celulari u shkeput.", Toast.LENGTH_LONG).show();
    }

    private void mosKerkoKArikim(Context context) {
        Toast.makeText(context, "Po Karikohet.", Toast.LENGTH_LONG).show();
    }

}
