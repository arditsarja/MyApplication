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
        Log.e("Intendi u degjua","Intendi u degjua");
    }
}
