package com.techpenta.parthaphotography;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.techpenta.parthaphotography.jsonparsing.ButtonActivities.About_Activity;
import com.techpenta.parthaphotography.jsonparsing.ButtonActivities.Blog_Activity;
import com.techpenta.parthaphotography.jsonparsing.ButtonActivities.Gallery_Activity;
import com.techpenta.parthaphotography.jsonparsing.ButtonActivities.News_Activity;

public class Homepage_titlimobile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_titlimobile);


     /*  ImageView rotateImage;
        rotateImage = (ImageView) findViewById(R.id.cameraicon);
        Animation startRotateAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        rotateImage.startAnimation(startRotateAnimation);*/

        getIntent();

        Button blog_btn=(Button)findViewById(R.id.blogbtn);
        blog_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Blog_Activity.class);
                startActivity(intent);
            }
        });

        Button gallery_btn=(Button)findViewById(R.id.gallerybtn);
        gallery_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Gallery_Activity.class);
                startActivity(intent);
            }
        });

        Button news_btn=(Button)findViewById(R.id.newsbtn);
        news_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),News_Activity.class);
                startActivity(intent);
            }
        });

        Button about_btn=(Button)findViewById(R.id.aboutbtn);
        about_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),About_Activity.class);
                startActivity(intent);
            }
        });
    }
}
