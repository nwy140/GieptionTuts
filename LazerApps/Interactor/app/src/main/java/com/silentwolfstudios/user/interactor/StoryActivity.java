package com.silentwolfstudios.user.interactor;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class StoryActivity extends AppCompatActivity {

    private Mars mars;
    private String name;

    private ImageView ivStoryScene;
    private TextView tvStoryText;
    private Button btStoryChoice1;
    private Button btStoryChoice2;

    private Stack<Integer> pageStack = new Stack<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        ivStoryScene = findViewById(R.id.ivStoryScene);
        tvStoryText = findViewById(R.id.tvStoryText);
        btStoryChoice1 = findViewById(R.id.btStoryChoice1);
        btStoryChoice2 = findViewById(R.id.btStoryChoice2);

    Intent i = getIntent();
    name = i.getStringExtra(getResources().getString(R.string.key)); //get string from key

        if (name==null|| name.isEmpty()){
            name="friend";
        }
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        mars = new Mars();
        loadPage(0);

    }

    private void loadPage(int pageNumber){

        pageStack.push(pageNumber);

        final Page page = mars.getPage(pageNumber);
        Drawable drawable = getResources().getDrawable(page.getImageId()); // get a drawable image from res
        ivStoryScene.setImageDrawable(drawable);
        tvStoryText.setText(String.format(getString(page.getTextId()), name));//passed user's name

        if(page.isFinalPage()){
            btStoryChoice2.setText("Play Again");
            btStoryChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadPage(0);
                }
            });
            btStoryChoice1.setVisibility(View.INVISIBLE);
        } else{
            btStoryChoice1.setVisibility(View.VISIBLE);
            btStoryChoice2.setText(page.getChoice2().getButtonId());
            btStoryChoice1.setText(page.getChoice1().getButtonId());

            btStoryChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadPage(page.getChoice1().getPageNumber());

                }
            });

            btStoryChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        loadPage(page.getChoice2().getPageNumber());

                }
            });
        }

    }

    @Override
    public void onBackPressed(){
        // {0 1 2 3 4} // this is what in memory
        pageStack.pop(); // remove latest number which is 4 and returns
        // {0 1 2 3}

        if(pageStack.isEmpty()){
            super.onBackPressed();
        } else{
            // [0 1 2]
            loadPage(pageStack.pop()); // pop returns what is removed // pop returns what is just removed from page// remove page 1 and leave it as 0
        }\

    }
    //mvp model view presenter //3 models // each rows eg. button tv and iv used for navigation // entire layout is third model
}