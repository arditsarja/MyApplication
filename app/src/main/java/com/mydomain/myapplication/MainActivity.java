package com.mydomain.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    private String msg = "Aplikacioni : therritet funksioni ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Thirrja e pare kur aktiviteti krujohet
        Log.d(msg, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();
        editText = findViewById(R.id.editText);
    }

    public void lexoPasswordin(View view){
       String vlera =  editText.getText().toString();
        Toast.makeText(this,vlera,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        //Thirrja kur aktiviteti behet i shikueshem nga perdoruesi
        super.onStart();
        Log.d(msg, "onStart()");
    }

    @Override
    protected void onResume() {
        //Thirrja kur përdoruesi fillon bashkëveprimin me aplikacionin.
        super.onResume();
        Log.d(msg, "onResume()");
    }

    @Override
    protected void onStop() {
        //Kur aktiviteti nuk merr asnje te dhene dhe nuk egezkuton asnje kod dhe nje aktivitet tjeter po rifillon
        super.onStop();
        Log.d(msg, "onStop()");
    }

    @Override
    protected void onPause() {
        //Thirrja kur aktiviteti nuk eshte i shikueshem nga perdoruesi
        super.onPause();
        Log.d(msg, "onPause()");
    }

    @Override
    protected void onDestroy() {
        //Thirrja kur aktiviteti shkaterrohet nga sistemi
        super.onDestroy();
        Log.d(msg, "onDestroy()");
    }

    @Override
    protected void onRestart() {
        //Thirrja kur aktiviteti ristarton pasi ka ndaluar
        super.onRestart();
        Log.d(msg, "onRestart()");
    }

    public void startService(View view) {
        startService(new Intent(getBaseContext(), MyService.class));
    }

    // Method to stop the service
    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), MyService.class));
    }

    // broadcast a custom intent.

    public void broadcastIntent(View view){
        Intent intent = new Intent();
        intent.setAction("com.mydomain.CUSTOM_INTENT"); sendBroadcast(intent);
    }

    private void checkPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            Log.e(msg, "This Android version does not support fingerprint authentication");
            return;
        }

        List<IntentFilter> intentFilters = new ArrayList<>();
        intentFilters.add(new IntentFilter(Intent.ACTION_POWER_CONNECTED));
        intentFilters.add(new IntentFilter(Intent.ACTION_POWER_DISCONNECTED));
        intentFilters.add(new IntentFilter(Intent.ACTION_BATTERY_LOW));
        intentFilters.add(new IntentFilter(Intent.ACTION_BATTERY_OKAY));
        intentFilters.add(new IntentFilter("com.mydomain.CUSTOM_INTENT"));
        for (IntentFilter intentFilter : intentFilters) {
            registerReceiver(new Receiver(), intentFilter);
        }

    }
}
