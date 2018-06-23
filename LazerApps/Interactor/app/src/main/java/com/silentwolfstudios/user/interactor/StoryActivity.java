package com.silentwolfstudios.user.interactor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class StoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

    Intent i = getIntent();
    String name = i.getStringExtra(getResources().getString(R.string.key)); //get string from key
    Toast.makeText(this, name , Toast.LENGTH_SHORT).show();

    loadPage();
    }

    private void loadPage(int p ageNumber){

    }
    //mvp model view presenter //3 models // each rows eg. button tv and iv used for navigation // entire layout is third model
}