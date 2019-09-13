package com.mydomain.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private String msg = "Aplikacioni : therritet funksioni ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Thirrja e pare kur aktiviteti krujohet
        Log.d(msg, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.image);
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
}
