package com.androidbegin.jsonparsetutorial3.jsonparsing.ButtonActivities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;



import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;

import android.webkit.WebView;


import com.androidbegin.jsonparsetutorial3.R;

/**
 * Created by Snikdha on 8/18/2016.
 */
public class News_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private static String urlString;
    String rendered;


    ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_);



      //  WebView webViewcontent=(WebView)findViewById(R.id.webView_news);
     //   webViewcontent.loadData(rendered, "text/html", null);


                urlString = "http://parthaphotography.com/wp-json/wp/v2/pages/1075";
                new ProcessJSON().execute(urlString);


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





    }//oncreate




             class ProcessJSON extends AsyncTask<String, Void, String>{



                 protected void onPreExecute() {
                     super.onPreExecute();
                     // Create a progressdialog
                     mProgressDialog = new ProgressDialog(News_Activity.this);

                     // Set progressdialog message
                     mProgressDialog.setMessage("Please wait...");
                     mProgressDialog.setIndeterminate(false);
                     mProgressDialog.setCancelable(false);
                     mProgressDialog.setCanceledOnTouchOutside(false);
                     // Show progressdialog
                     mProgressDialog.show();
                 }



                protected String doInBackground(String... strings){
                    String stream = null;
                    String urlString = strings[0];

                    HTTPDataHandler hh = new HTTPDataHandler();
                    stream = hh.GetHTTPData(urlString);

                    // Return the data from specified url
                    return stream;
                }

                protected void onPostExecute(String stream){
                   // TextView tv = (TextView) findViewById(R.id.tv);
                    //tv.setText(stream);

            /*
                Important in JSON DATA
                -------------------------
                * Square bracket ([) represents a JSON array
                * Curly bracket ({) represents a JSON object
                * JSON object contains key/value pairs
                * Each key is a String and value may be different data types
             */

                    //..........Process JSON DATA................
                    if(stream !=null){
                        try{
                            // Get the full HTTP Data as JSONObject

                            JSONObject reader= new JSONObject(stream);
                            JSONObject content=reader.getJSONObject("content");
                            String rendered=content.getString("rendered");

                            WebView webViewcontent=(WebView)findViewById(R.id.webView_news);
                            webViewcontent.loadData(rendered, "text/html", null);





                            // process other data as this way..............

                        }catch(JSONException e){
                            e.printStackTrace();
                        }

                    } // if statement end
                    // Close the progressdialog
                    mProgressDialog.dismiss();
                } // onPostExecute() end
            } // ProcessJSON class end













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

        if (id == R.id.nav_about) {
            Intent i=new Intent(this,About_Activity.class);
            startActivity(i);

        }  else if (id == R.id.nav_gallery) {
            Intent i=new Intent(this,Gallery_Activity.class);
            startActivity(i);

        } else if (id == R.id.nav_blog) {
            Intent i=new Intent(this,Blog_Activity.class);
            startActivity(i);

        } else if (id == R.id.nav_contact) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }//nevigationitemselected



}


