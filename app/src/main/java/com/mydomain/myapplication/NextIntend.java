package com.mydomain.myapplication;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NextIntend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_intend);
        TextView label = (TextView) findViewById(R.id.show_data);
        Uri url = getIntent().getData();
        label.setText(url.toString());
    }
}
