package com.silentwolfstudios.user.interactor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;


public class MainActivity extends AppCompatActivity { // ctrl  + click is f12 in visual studio


    private EditText etName;
    private Button btStartAdventure;
    private ImageView ivMainTitle;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // saveInstanceState , saved state of app
        setContentView(R.layout.activity_main);

        //Ads Initialization
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        showInterstitialAd();
        //Ads Initialization end

        etName = findViewById(R.id.etName);
        btStartAdventure = findViewById(R.id.btStartAdventure);

        btStartAdventure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInterstitialAd();

                String name = etName.getText().toString();
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, StoryActivity.class);  //start new Activity via Intent
                i.putExtra(getResources().getString(R.string.key) , name);  // store data in intent with string "name" gotten from key // data passed in Intent //bundle means multiple data bundled to send
                startActivity(i);
            }
        });


        ivMainTitle = findViewById(R.id.ivMainTitle);
        ivMainTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(view);
            }
        });


    }

    private  void hideKeyboard(View view){
        view = getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }



    public void showInterstitialAd(){
        if (mInterstitialAd.isLoaded()) { // you must load ad before showing it!!!
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
            Toast.makeText(this, "The interstitial wasn't loaded yet.", Toast.LENGTH_SHORT).show();
        }
    }
}