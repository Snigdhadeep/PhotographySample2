package com.androidbegin.jsonparsetutorial3.jsonparsing.ButtonActivities;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.androidbegin.jsonparsetutorial3.R;

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

public class Gallery_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener  {
    // Declare Variables


    JSONObject jsonobject;
    JSONArray jsonarray;
    ListView listview;
    ListViewAdapter_Gallery adapter;
    ProgressDialog mProgressDialog;
    ArrayList<HashMap<String, String>> arraylist;
    static String RANK = "rank";
    static String COUNTRY = "country";
    static String POPULATION = "population";
    static String FLAG = "flag";

    static String TITLE = "title";
    static String DATE = "date";
    static String MULTITEXT= "multitext2";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_);


        //for toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        new DownloadJSON().execute();


    }//oncreate




    // DownloadJSON AsyncTask
    private class DownloadJSON extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(Gallery_Activity.this);

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



                URL url=new URL("http://parthaphotography.com/wp-json/wp/v2/portfolio/?per_page=100");
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
                    JSONObject imagejson=jsonObject.getJSONObject("acf");
                    String pic=imagejson.getString("display_pic");



                    Log.i("snigdhadeep",pic);



                  /*  JSONObject imagejson=jsonObject.getJSONObject("better_featured_image");
                    String pic=imagejson.getString("source_url");
                    Log.i("kingsukmajumder",title);
                    //String image= jsonObject.getJSONObject("acf").getString("display_pic");
                    String date= jsonObject.getString("date");*/



                   map.put("flag", pic);
                   // map.put("country", contentsingleitem);







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
            listview = (ListView) findViewById(R.id.gallerylistview);
            // Pass the results into ListViewAdapter.java
            adapter = new ListViewAdapter_Gallery(Gallery_Activity.this, arraylist);
            // Set the adapter to the ListView
            listview.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
        }
    }

















            @Override
            public void onBackPressed() {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    super.onBackPressed();
                }
            }//on back pressed

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.about_, menu);
        return true;
    }//optionsmenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }//optionsitemSelected

            public boolean onNavigationItemSelected(MenuItem item) {
                // Handle navigation view item clicks here.
                int id = item.getItemId();

                if (id == R.id.nav_camera) {
                    // Handle the camera action
                } else if (id == R.id.nav_gallery) {

                } else if (id == R.id.nav_slideshow) {

                } else if (id == R.id.nav_manage) {

                } else if (id == R.id.nav_share) {

                } else if (id == R.id.nav_send) {

                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }//nevigationitemselected


}
