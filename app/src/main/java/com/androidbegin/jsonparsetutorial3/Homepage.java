package com.androidbegin.jsonparsetutorial3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.androidbegin.jsonparsetutorial3.jsonparsing.ButtonActivities.Blog_Activity;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);


       ImageView rotateImage;
        rotateImage = (ImageView) findViewById(R.id.cameraicon);
        Animation startRotateAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotation);
        rotateImage.startAnimation(startRotateAnimation);

        getIntent();

        Button about_btn=(Button)findViewById(R.id.aboutbtn);
        about_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Blog_Activity.class);
                startActivity(intent);
            }
        });
    }
}
