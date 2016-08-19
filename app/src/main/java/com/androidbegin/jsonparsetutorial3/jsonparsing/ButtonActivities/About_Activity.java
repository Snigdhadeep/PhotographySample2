package com.androidbegin.jsonparsetutorial3.jsonparsing.ButtonActivities;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.webkit.WebView;
import android.webkit.WebViewClient;


import com.androidbegin.jsonparsetutorial3.R;


public class About_Activity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_);

        webView = (WebView) findViewById(R.id.webviewabout);
        webView.setWebViewClient(new MyWebViewClient());

        String url = "http://parthaphotography.com/wp-json/wp/v2/portfolio/";
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);



    }



    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }


}





















