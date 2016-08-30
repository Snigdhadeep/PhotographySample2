package com.androidbegin.jsonparsetutorial3.jsonparsing.Singleitems;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.androidbegin.jsonparsetutorial3.R;
import com.androidbegin.jsonparsetutorial3.jsonparsing.Imageloader.ImageLoader;

public class SingleItemView_Gallery extends Activity {
	// Declare Variables
	String rank;
	String country;
	String population;
	String flagnew;
	String content;
	String position;
	ImageLoader imageLoader = new ImageLoader(this);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from singleitemview_blog.xmlg.xml
		setContentView(R.layout.singleitemview_gallery);

		Intent i = getIntent();


		flagnew=i.getStringExtra("flag");
		ImageView img=(ImageView)findViewById(R.id.flag_gallery) ;

		Log.i("snigdhadeep2",flagnew);

		imageLoader.DisplayImage(flagnew,img);
		// Get the result of rank
		//rank = i.getStringExtra("rank1");
		// Get the result of country

		// Get the result of population
	//	population = i.getStringExtra("population1");
		// Get the result of flag
	//	flag = i.getStringExtra("flag");


/*
		flag = i.getStringExtra("flag");
		ImageView singleimagegallery=(ImageView)findViewById(R.id.singleimageViewgallery);
		// Passes flag images URL into ImageLoader.class
			imageLoader.DisplayImage(flag, singleimagegallery);


		Log.i("snigdhadeep2",flag);*/


		// Locate the TextViews in singleitemview_blog.xmlg.xml
	//	TextView txtrank = (TextView) findViewById(R.id.title);
		//TextView txtcountry = (TextView) findViewById(R.id.multitext);

		//webViewcontent.getSettings().setJavaScriptEnabled(true);



		//	webViewcontent.loadData(content, "text/html", "UTF-8");

		// Locate the ImageView in singleitemview_blog_blog.xml
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