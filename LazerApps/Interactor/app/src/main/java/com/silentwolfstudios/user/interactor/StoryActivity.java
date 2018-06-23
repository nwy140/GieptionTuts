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

public class StoryActivity extends AppCompatActivity {

    private Mars mars;
    private ImageView ivStoryScene;
    private TextView tvStoryText;
    private Button btStoryChoice1;
    private Button btStoryChoice2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        ivStoryScene = findViewById(R.id.ivStoryScene);
        tvStoryText = findViewById(R.id.tvStoryText);
        btStoryChoice1 = findViewById(R.id.btStoryChoice1);
        btStoryChoice2 = findViewById(R.id.btStoryChoice2);

    Intent i = getIntent();
    String name = i.getStringExtra(getResources().getString(R.string.key)); //get string from key

        if (name==null|| name.isEmpty()){
            name="friend";
        }
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        mars = new Mars();
        loadPage(0);

    }

    private void loadPage(int pageNumber){
        final Page page = mars.getPage(pageNumber);
        Drawable drawable = getResources().getDrawable(page.getImageId()); // get a drawable image from res
        ivStoryScene.setImageDrawable(drawable);
        tvStoryText.setText(page.getTextId());

        if(page.isFinalPage()){
            btStoryChoice2.setText("Play Again");
            btStoryChoice1.setVisibility(View.INVISIBLE);
        } else{
            btStoryChoice2.setText(page.getChoice1().getButtonId());
            btStoryChoice1.setText(page.getChoice2().getButtonId());
            btStoryChoice1.setVisibility(View.VISIBLE);

            btStoryChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadPage(page.getChoice1().getPageNumber());
                }
            });

            btStoryChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(page.isFinalPage()){
                        loadPage(0);
                    }else {
                        loadPage(page.getChoice2().getPageNumber());
                    }
                }
            });
        }

    }

    //mvp model view presenter //3 models // each rows eg. button tv and iv used for navigation // entire layout is third model
}