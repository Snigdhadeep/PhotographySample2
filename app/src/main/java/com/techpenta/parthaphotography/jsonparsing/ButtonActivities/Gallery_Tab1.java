package com.techpenta.parthaphotography.jsonparsing.ButtonActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.techpenta.parthaphotography.R;
import com.techpenta.parthaphotography.jsonparsing.Imageloader.ImageLoader;

public class Gallery_Tab1 extends AppCompatActivity {


    String lifestory_tab1;
    ImageLoader imageLoader = new ImageLoader(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery__tab1);

        Intent i = getIntent();

        lifestory_tab1=i.getStringExtra("lifestory_tab1");
        WebView webViewcontent=(WebView)findViewById(R.id.webView_lifestory);
        webViewcontent.loadData(lifestory_tab1, "text/html", null);
    }
}
