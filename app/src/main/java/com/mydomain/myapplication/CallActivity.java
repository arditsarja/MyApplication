package com.mydomain.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CallActivity extends AppCompatActivity {
    EditText number;
    EditText msg;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        number = findViewById(R.id.telNo);
        msg = findViewById(R.id.message);
        email = findViewById(R.id.emailAdr);
        checkPermission();
    }


    public void makeCall(View view) {
        if (number == null)
            return;
        String telNum = number.getText().toString();
        if (telNum.equals(""))
            return;
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + telNum));
        if (ActivityCompat.checkSelfPermission(CallActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent);
    }


    public void sendMessage(View v) {
        if (number == null || msg == null)
            return;
        String telNum = number.getText().toString();
        String messageText = msg.getText().toString();
        if (messageText.equals("") || telNum.equals(""))
            return;
        SmsManager smsManager = SmsManager.getDefault();
        try {
            smsManager.sendTextMessage(telNum, null, messageText, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendEmail(View view) {
        if (email == null || msg == null)
            return;
        String emailText = email.getText().toString();
        String messageText = msg.getText().toString();
        if (messageText.equals("") || emailText.equals(""))
            return;
        String[] TO = {emailText};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subjekti");
        emailIntent.putExtra(Intent.EXTRA_TEXT, messageText);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(CallActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private void checkPermission() {
        int requestCode = 100;
        List<String> permissionsToRequest = new ArrayList<>();
        List<String> permissions = new ArrayList<>();
        permissions.add(Manifest.permission.CALL_PHONE);
        permissions.add(Manifest.permission.READ_CONTACTS);
        permissions.add(Manifest.permission.WRITE_CONTACTS);

        for (String permission : permissions) {
            int permissionCheck = ContextCompat.checkSelfPermission(this, permission);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                permissionsToRequest.add(permission);
            }

        }
        if (!permissionsToRequest.isEmpty()) {
            ActivityCompat.requestPermissions(this,
                    permissionsToRequest.toArray(new String[permissionsToRequest.size()]), requestCode);
        }

    }
}
