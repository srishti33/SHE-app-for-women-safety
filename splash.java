package com.example.shiva.she;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;

public class splash extends AppCompatActivity {

    private static int SPLASH_TIME_OUT=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent homeIntent=new Intent(splash.this,main.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }

}

