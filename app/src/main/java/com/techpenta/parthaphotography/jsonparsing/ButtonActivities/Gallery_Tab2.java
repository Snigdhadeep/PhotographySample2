package com.techpenta.parthaphotography.jsonparsing.ButtonActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.techpenta.parthaphotography.R;

public class Gallery_Tab2 extends AppCompatActivity {


    String habitat_tab2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery__tab2);


        Intent i = getIntent();

        habitat_tab2=i.getStringExtra("habitat_tab2");
        WebView webViewcontent=(WebView)findViewById(R.id.webView_habitat);
        webViewcontent.loadData(habitat_tab2, "text/html", null);
    }
}
