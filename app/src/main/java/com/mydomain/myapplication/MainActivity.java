package com.mydomain.myapplication;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;
import com.mydomain.myapplication.LayoutsActivities.LayoutActivity;
import com.mydomain.myapplication.UiControl.UiActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText tittull;
    EditText tekst;
    TextView bigTxt;

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
        tittull = findViewById(R.id.tiltull);
        tekst = findViewById(R.id.tekst);
        bigTxt = findViewById(R.id.bigTxt);
        Bundle bundle = getIntent().getExtras();
        FirebaseMessaging.getInstance().subscribeToTopic("topiku");
        if (bundle != null) {
            String titulli = bundle.getString("titull");
            String teksti = bundle.getString("tekst");
            String bigtex = bundle.getString("bigtex");
            tittull.setText(titulli);
            tekst.setText(teksti);
            bigTxt.setText(bigtex);
        }
    }

    public void openDialog(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Deshironi te kryeni veprimin ?");
        alertDialogBuilder.setPositiveButton("Po", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(MainActivity.this, "Ju klikuat butonin Po", Toast.LENGTH_LONG).show();
            }
        });

        alertDialogBuilder.setNegativeButton("Jo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Ju klikuat butonin Jo", Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
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

    public void callMarioActivity(View view) {
        startActivity(new Intent(getBaseContext(), MarioActivity.class));
    }
    public void animateAct(View view) {
        startActivity(new Intent(getBaseContext(), AnimationActivity.class));
    }
    public void recordAct(View view) {
        startActivity(new Intent(getBaseContext(), RecorderActivity.class));
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

    public void showNotification(View view) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        String message = "Mesazh";
        String title = "Titull";


        // Create an Intent for the activity you want to start
        Intent resultIntent = new Intent(this, MainActivity.class);
        // Create the TaskStackBuilder and add the intent, which inflates the back stack
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        // Get the PendingIntent containing the entire back stack
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        String notification_channel_id = "Kujtese";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(notification_channel_id, "Leksion", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setDescription("TestNotification");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.BLUE);
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);

        }

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, notification_channel_id);
        notificationBuilder.setDefaults(Notification.DEFAULT_ALL);
        notificationBuilder.setContentTitle(title);
        notificationBuilder.setContentText(message);
        notificationBuilder.setContentInfo("Info");
        notificationBuilder.setWhen(System.currentTimeMillis());
        notificationBuilder.setSmallIcon(R.drawable.image);
        notificationBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.image));
        notificationBuilder.setBadgeIconType(R.drawable.image);
        notificationBuilder.setContentIntent(resultPendingIntent);
        notificationManager.notify(new Random().nextInt(), notificationBuilder.build());

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
