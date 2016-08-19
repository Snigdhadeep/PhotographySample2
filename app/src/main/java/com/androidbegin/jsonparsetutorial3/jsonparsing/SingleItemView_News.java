package com.androidbegin.jsonparsetutorial3.jsonparsing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.androidbegin.jsonparsetutorial3.R;
import com.androidbegin.jsonparsetutorial3.jsonparsing.ButtonActivities.Blog_Activity;

public class SingleItemView_News extends Activity {
	// Declare Variables
	String rank;
	String country;
	String population;
	String flag;
	String content;
	String position;
	ImageLoader imageLoader = new ImageLoader(this);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from singleitemview.xml
		setContentView(R.layout.singleitemview);

		Intent i = getIntent();
		// Get the result of rank
		//rank = i.getStringExtra("rank1");
		// Get the result of country

		// Get the result of population
	//	population = i.getStringExtra("population1");
		// Get the result of flag
	//	flag = i.getStringExtra("flag");





		WebView webViewcontent=(WebView)findViewById(R.id.webView_blogcontent);
		webViewcontent.loadData(country, "text/html", null);



		// Locate the TextViews in singleitemview.xml
	//	TextView txtrank = (TextView) findViewById(R.id.title);
		//TextView txtcountry = (TextView) findViewById(R.id.multitext);

		//webViewcontent.getSettings().setJavaScriptEnabled(true);



		//	webViewcontent.loadData(content, "text/html", "UTF-8");

		// Locate the ImageView in singleitemview.xml
		//ImageView imgflag = (ImageView) findViewById(R.id.flag);


//webViewcontent.loadUrl("http://parthaphotography.com/a-few-bird-photography-mistakes-and-their-solutions/");
		// Set results to the TextViews
	//txtrank.setText(rank);
		//txtcountry.setText(country);


		// Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
	//	imageLoader.DisplayImage(flag, imgflag);
	}
}