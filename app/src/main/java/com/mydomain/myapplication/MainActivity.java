package com.mydomain.myapplication;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mydomain.myapplication.LayoutsActivities.LayoutActivity;
import com.mydomain.myapplication.UiControl.UiActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    private String msg = "Aplikacioni : therritet funksioni ";

    public void fr(View view) {
        startActivity(new Intent(getBaseContext(), FrActivity.class));
    }

    public void lay(View view) {
        startActivity(new Intent(getBaseContext(), LayoutActivity.class));
    }

    public void ui(View view) {
        startActivity(new Intent(getBaseContext(), UiActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Thirrja e pare kur aktiviteti krujohet
        Log.d(msg, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();
        editText = findViewById(R.id.editText);
    }

    public void lexoPasswordin(View view) {
        String vlera = editText.getText().toString();
        Toast.makeText(this, vlera, Toast.LENGTH_LONG).show();
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

    public void broadcastIntent(View view) {
        Intent intent = new Intent();
        intent.setAction("com.mydomain.CUSTOM_INTENT");
        sendBroadcast(intent);
    }


    public void ndiz(View view) {
        startService(new Intent(getBaseContext(), Sherbimi.class));
    }

    public void callFragmentActivity(View view) {
        startActivity(new Intent(getBaseContext(), FragmentActivity.class));
    }

    public void callIntendActivity(View view) {
        startActivity(new Intent(getBaseContext(), IntendActivity.class));
    }
    public void dragActivity(View view) {
        startActivity(new Intent(getBaseContext(), DragAndDropActivity.class));
    }


    public void fik(View view) {
        stopService(new Intent(getBaseContext(), Sherbimi.class));
    }

    public void callActivity(View view) {
        startActivity(new Intent(getBaseContext(), ScrollingActivity.class));
    }
    public void callAct(View view) {
        startActivity(new Intent(getBaseContext(), CallActivity.class));
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
