package com.mydomain.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntendActivity extends AppCompatActivity {
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intend);
        b1=(Button)findViewById(R.id.button8);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://www.example.com"));
                startActivity(i);
            }
        });

        b2=(Button)findViewById(R.id.button9);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("tel:9510300000"));
                startActivity(i);
            }
        });
    }

    public void read(View view){
        Intent read1=new Intent();
        read1.setAction(android.content.Intent.ACTION_VIEW);
        read1.setData(ContactsContract.Contacts.CONTENT_URI);
        startActivity(read1);
    }
}
