package com.silentwolfstudios.user.interactor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity { // ctrl  + click is f12 in visual studio

    private EditText etName;
    private Button btStartAdventure;
    private ImageView ivMainTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // saveInstanceState , saved state of app
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        btStartAdventure = findViewById(R.id.btStartAdventure);

        btStartAdventure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
}