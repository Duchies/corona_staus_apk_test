package com.example.myapplication_helloworld_test;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import gr.net.maroulis.library.EasySplashScreen;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        EasySplashScreen cofig = new EasySplashScreen( Main3Activity.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(1000)
                .withBackgroundColor(Color.parseColor("#FFFFFF"))

                .withFooterText("DEVELOPED BY AMAN :)")

                .withLogo(R.mipmap.splash_icon);



        cofig.getFooterTextView().setTextColor(Color.BLACK);


        View easysplash = cofig.create();
        setContentView(easysplash);




    }
}
