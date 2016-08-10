package com.androidbegin.jsonparsetutorial3;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity {
	// Declare Variables
	JSONObject jsonobject;
	JSONArray jsonarray;
	ListView listview;
	ListViewAdapter adapter;
	ProgressDialog mProgressDialog;
	ArrayList<HashMap<String, String>> arraylist;
	static String RANK = "rank";
	static String COUNTRY = "country";
	static String POPULATION = "population";
	static String FLAG = "flag";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from listview_main.xml
		setContentView(R.layout.listview_main);
		// Execute DownloadJSON AsyncTask
		new DownloadJSON().execute();

		getIntent();
	}

	// DownloadJSON AsyncTask
		private class DownloadJSON extends AsyncTask<Void, Void, Void> {

			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				// Create a progressdialog
				mProgressDialog = new ProgressDialog(MainActivity.this);
				// Set progressdialog title
				mProgressDialog.setTitle("Android JSON Parse Tutorial");
				// Set progressdialog message
				mProgressDialog.setMessage("Loading...");
				mProgressDialog.setIndeterminate(false);
				// Show progressdialog
				mProgressDialog.show();
			}

		@Override
		protected Void doInBackground(Void... params) {
			// Create an array
			arraylist = new ArrayList<HashMap<String, String>>();
			// Retrieve JSON Objects from the given URL address


			HttpURLConnection connection = null;
			BufferedReader reader = null;
			String t1="";

			try {



				URL url=new URL("http://parthaphotography.com/wp-json/wp/v2/posts/?per_page=100");
				connection=(HttpURLConnection)url.openConnection();
				connection.connect();

				InputStream stream=connection.getInputStream();
				reader=new BufferedReader(new InputStreamReader(stream));
				StringBuffer buffer=new StringBuffer();
				String line="";
				while((line=reader.readLine())!=null){
					buffer.append(line);
				}
				String finaljson=buffer.toString();
				Log.d("msg",finaljson);

				JSONArray jsonArray = new JSONArray(finaljson);
				int count = jsonArray.length();

				for(int i=0 ; i< count; i++){   // iterate through jsonArray
					HashMap<String, String> map = new HashMap<String, String>();

					JSONObject jsonObject = jsonArray.getJSONObject(i);  // get jsonObject @ i position
					//System.out.println("jsonObject " + i + ": " + jsonObject);
					JSONObject type=jsonObject.getJSONObject("better_featured_image");
					String pic=type.getString("source_url");
					Log.i("kingsukmajumder",pic);
					//String image= jsonObject.getJSONObject("acf").getString("display_pic");
					String date= jsonObject.getString("date");

					map.put("rank", date);
					map.put("country", date);
					map.put("population", date);
					map.put("flag", pic);



					// System.out.println(image);
					//Log.d("Response: ", "> " + image);
					arraylist.add(map);
				}





			} catch (MalformedURLException e) {
				//e.printStackTrace();
			} catch (IOException e) {
				// e.printStackTrace();
			} catch (JSONException e) {
				//e.printStackTrace();
			} finally {
				if(connection!=null) {
					connection.disconnect();
				}
				try {if(reader!=null) {
					reader.close();
				}
				} catch (IOException e) {
					//e.printStackTrace();
				}
			}






			return null;
		}

		@Override
		protected void onPostExecute(Void args) {
			// Locate the listview in listview_main.xml
			listview = (ListView) findViewById(R.id.listview);
			// Pass the results into ListViewAdapter.java
			adapter = new ListViewAdapter(MainActivity.this, arraylist);
			// Set the adapter to the ListView
			listview.setAdapter(adapter);
			// Close the progressdialog
			mProgressDialog.dismiss();
		}
	}
}