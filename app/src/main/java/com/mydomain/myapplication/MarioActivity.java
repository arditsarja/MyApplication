package com.mydomain.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MarioActivity extends AppCompatActivity {

    EditText passwordi;
    Button butoni;
    TextView lexo;
    EditText nrTeli;
    Button telefono;
    Button teldirekt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mario);
        kerkoLeje();
        passwordi = findViewById(R.id.editText4);
        butoni = findViewById(R.id.btnLexo);
        lexo = findViewById(R.id.florian);
        butoni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lexo.setText(passwordi.getText().toString());
            }
        });

        nrTeli = findViewById(R.id.editText5);
        telefono = findViewById(R.id.button21);
        telefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + nrTeli.getText().toString())));
            }
        });
        teldirekt = findViewById(R.id.button22);
        teldirekt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent flori = new Intent(Intent.ACTION_CALL);
                flori.setData(Uri.parse("tel:" + nrTeli.getText().toString()));
                if (ActivityCompat.checkSelfPermission(MarioActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED) {
                    return;
                }
                startActivity(flori);

            }
        });


    }

    private void kerkoLeje() {
        int kodi = 100;
        String[] permissions = {Manifest.permission.CALL_PHONE};
        int rezultat = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (rezultat != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, permissions, kodi);
        }
    }
}
