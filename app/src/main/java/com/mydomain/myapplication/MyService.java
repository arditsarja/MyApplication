package com.mydomain.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        /*** Sistemi e therret këtë metodë kur një komponent tjetër dëshiron të
         lidhet me shërbimin duke thirrur bindService (). Nëse zbatoni këtë
         metodë, duhet të siguroni një ndërfaqe që klientët përdorin për të
         komunikuar me shërbimin, duke kthyer një objekt IBinder. Gjithmonë
         duhet ta zbatoni këtë metodë, por nëse nuk doni të lejoni detyrimin,
         atëherë duhet të ktheheni pavlefshëm.*/
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Servisi Filloi", Toast.LENGTH_LONG).show();
        ServiceHelper.activate(this);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ServiceHelper.cancel(this);
        Toast.makeText(this, "Servisi Ndaloi", Toast.LENGTH_LONG).show();
    }
}
