package com.techpenta.parthaphotography.jsonparsing.Singleitems;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.techpenta.parthaphotography.R;

public class SingleItemView extends Activity {
	// Declare Variables


	String content;



	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from singleitemview_blog_blog.xml
		setContentView(R.layout.singleitemview_blog);

		Intent i = getIntent();

		content = i.getStringExtra("content");

		WebView webViewcontent=(WebView)findViewById(R.id.webView_blogcontent);
		webViewcontent.loadData(content, "text/html", null);



		// Locate the TextViews in singleitemview_blog.xmlg.xml
	//	TextView txtrank = (TextView) findViewById(R.id.title);
		//TextView txtcountry = (TextView) findViewById(R.id.multitext);

		//webViewcontent.getSettings().setJavaScriptEnabled(true);



		//	webViewcontent.loadData(content, "text/html", "UTF-8");

		// Locate the ImageView in singleitemview_blog.xmlg.xml
		//ImageView imgflag = (ImageView) findViewById(R.id.flag);


//webViewcontent.loadUrl("http://parthaphotography.com/a-few-bird-photography-mistakes-and-their-solutions/");
		// Set results to the TextViews
	//txtrank.setText(rank);
		//txtcountry.setText(country);


		// Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
		//imageLoader.DisplayImage(flag, imgflag);
	}
}