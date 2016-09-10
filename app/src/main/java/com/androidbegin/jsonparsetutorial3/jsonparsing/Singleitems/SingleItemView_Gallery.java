package com.androidbegin.jsonparsetutorial3.jsonparsing.Singleitems;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TabHost;

import com.androidbegin.jsonparsetutorial3.R;
import com.androidbegin.jsonparsetutorial3.jsonparsing.ButtonActivities.About_Tab1;
import com.androidbegin.jsonparsetutorial3.jsonparsing.ButtonActivities.About_Tab2;
import com.androidbegin.jsonparsetutorial3.jsonparsing.ButtonActivities.About_Tab3;
import com.androidbegin.jsonparsetutorial3.jsonparsing.ButtonActivities.Gallery_Tab1;
import com.androidbegin.jsonparsetutorial3.jsonparsing.ButtonActivities.Gallery_Tab2;
import com.androidbegin.jsonparsetutorial3.jsonparsing.ButtonActivities.Gallery_Tab3;
import com.androidbegin.jsonparsetutorial3.jsonparsing.Imageloader.ImageLoader;

public class SingleItemView_Gallery extends TabActivity {
	// Declare Variables
	String lifestory;
	String funfacts;
	String habitat;
	String flagnew;
	String content;
	String position;
	ImageLoader imageLoader = new ImageLoader(this);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from singleitemview_blog.xmlg.xml
		setContentView(R.layout.singleitemview_gallery);

		// create the TabHost that will contain the Tabs
		TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);


		TabHost.TabSpec tab1 = tabHost.newTabSpec("First Tab");
		TabHost.TabSpec tab2 = tabHost.newTabSpec("Second Tab");
		TabHost.TabSpec tab3 = tabHost.newTabSpec("Third Tab");


		Intent i = getIntent();


		tab1.setIndicator("Tab1");
		Intent intent=new Intent(this,Gallery_Tab1.class);
		lifestory=i.getStringExtra("lifestory");
		intent.putExtra("lifestory_tab1",lifestory);
		tab1.setContent(intent);


		tab2.setIndicator("Tab2");
		Intent intent1=new Intent(this,Gallery_Tab2.class);
		habitat=i.getStringExtra("habitat");
		intent1.putExtra("habitat_tab2",habitat);
		tab2.setContent(intent1);



		tab3.setIndicator("Tab3");
		Intent intent2=new Intent(this,Gallery_Tab3.class);
		funfacts=i.getStringExtra("funfacts");
		intent2.putExtra("funfacts_tab3",funfacts);
		tab3.setContent(intent2);

		/** Add the tabs  to the TabHost to display. */
		tabHost.addTab(tab1);
		tabHost.addTab(tab2);
		tabHost.addTab(tab3);




	/*	Intent i = getIntent();


		flagnew=i.getStringExtra("flag");
		ImageView img=(ImageView)findViewById(R.id.flag_gallery) ;

		Log.i("snigdhadeep2",flagnew);

		imageLoader.DisplayImage(flagnew,img);


		funfacts=i.getStringExtra("funfacts");
		WebView webViewcontent=(WebView)findViewById(R.id.webView_singlegallerycontent);
		webViewcontent.loadData(funfacts, "text/html", null);


		Log.i("hmm",funfacts);*/
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


		Log.i("snigdhadeep2",flag); */


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