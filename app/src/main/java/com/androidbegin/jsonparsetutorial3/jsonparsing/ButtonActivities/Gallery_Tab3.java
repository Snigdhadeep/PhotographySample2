package com.androidbegin.jsonparsetutorial3.jsonparsing.ButtonActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.androidbegin.jsonparsetutorial3.R;

public class Gallery_Tab3 extends AppCompatActivity {

    String funfacts_tab3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery__tab3);

        Intent i = getIntent();

        funfacts_tab3=i.getStringExtra("funfacts_tab3");
        WebView webViewcontent=(WebView)findViewById(R.id.webView_funfacts);
        webViewcontent.loadData(funfacts_tab3, "text/html", null);
    }
}
