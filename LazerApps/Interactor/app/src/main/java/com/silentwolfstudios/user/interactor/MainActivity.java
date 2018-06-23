package com.silentwolfstudios.user.interactor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity { // ctrl  + click is f12 in visual studio

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // saveInstanceState , saved state of app
        setContentView(R.layout.activity_main);
    }
}