package com.mydomain.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FragmentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

    public void listFragment(View view) {
        Fragment fragment = ItemFragment.newInstance(1);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.layout, fragment);
        fragmentTransaction.commit();
    }

    public void blankFragment(View view) {
        Fragment fragment = BlankFragment.newInstance("Ardit", "Sarja");
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.layout, fragment);
        fragmentTransaction.commit();
    }

    public void myFragment(View view) {
        Fragment fragment = new MyFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.layout, fragment);
        fragmentTransaction.commit();
    }
}
