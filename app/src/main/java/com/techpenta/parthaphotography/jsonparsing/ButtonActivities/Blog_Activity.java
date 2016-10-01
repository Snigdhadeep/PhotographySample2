package com.techpenta.parthaphotography.jsonparsing.ButtonActivities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.firebase.client.ValueEventListener;
import com.techpenta.parthaphotography.R;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

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

public class Blog_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    // Declare Variables



    ListView listview;
    ListViewAdapter adapter;
    ProgressDialog mProgressDialog;
    ArrayList<HashMap<String, String>> arraylist;
    Firebase mfirebase;

    Firebase title;
    long titlecountlong;
    int titlecountint;



    static String FLAG = "flag";
    static String TITLE = "title";
    static String MULTITEXT= "multitext";
    static String CONTENT="content";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_);


        // Execute DownloadJSON AsyncTask

              new DownloadJSON().execute();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //for drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);







    }//oncreate


    @Override
    protected void onStart() {
        super.onStart();
        final HashMap<String, String> map = new HashMap<String, String>();
        //firebase

        mfirebase=new Firebase("https://parthaphotography-4cb28.firebaseio.com/Blog");
        final Firebase titlecountfire=mfirebase.child("Title");
        titlecountfire.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("Size "+dataSnapshot.getChildrenCount());
                titlecountlong=dataSnapshot.getChildrenCount();
                titlecountint=(int) (long)titlecountlong;;


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        titlecountfire.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                String titlelist=dataSnapshot.getValue(String.class);
               map.put("title",titlelist);
                arraylist.add(map);

                System.out.println("titlelist= " + titlelist );
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }//on start

    // DownloadJSON AsyncTask
    private class DownloadJSON extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(Blog_Activity.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Android JSON Parse Tutorial");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setCanceledOnTouchOutside(false);
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
                System.out.println("Size2 "+count);







            /*       for (int i = 0; i < count; i++) {   // iterate through jsonArray
                        final HashMap<String, String> map = new HashMap<String, String>();

                        JSONObject jsonObject = jsonArray.getJSONObject(i);  // get jsonObject @ i position
                        //System.out.println("jsonObject " + i + ": " + jsonObject);


                        //fetch tittle
                        JSONObject titlejson = jsonObject.getJSONObject("title");
                        String title = titlejson.getString("rendered");
                        //fetch content in blog  page
                        JSONObject contentjson = jsonObject.getJSONObject("excerpt");
                        String content = contentjson.getString("rendered");
                        String contenthtml = Html.fromHtml(content).toString();

                        //fetch image in  blog page

                        JSONObject imagejson = jsonObject.getJSONObject("better_featured_image");
                        String pic = imagejson.getString("source_url");

                        //fetch content page in single itemview
                        JSONObject contentsingleitemjson = jsonObject.getJSONObject("content");
                        String contentsingleitem = contentsingleitemjson.getString("rendered");

                        //  Log.i("kingsukmajumder",contentsingleitem);

                        map.put("flag", pic);

                        //   map.put("title", title);

                        map.put("multitext", contenthtml);

                        map.put("content", contentsingleitem);

                        //map.put("content",contentsingleitem);


                        Firebase title_fire = mfirebase.child("Title");
                        Firebase titleno = title_fire.child(Integer.toString(i));

                        Firebase pic_fire = mfirebase.child("Pic");
                        Firebase pic_fireno = pic_fire.child(Integer.toString(i));

                        Firebase multitext_fire = mfirebase.child("Multitext");
                        Firebase multitext_fireno = multitext_fire.child(Integer.toString(i));

                        Firebase contentsingle_fire = mfirebase.child("Contentsingle");
                        Firebase contentsingle_fireno = contentsingle_fire.child(Integer.toString(i));


                        titleno.setValue(title);
                        pic_fireno.setValue(pic);
                        multitext_fireno.setValue(contenthtml);
                        contentsingle_fireno.setValue(contentsingleitem);


                        arraylist.add(map);
                    }

*/



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
            adapter = new ListViewAdapter(Blog_Activity.this,arraylist);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about) {

            Intent i=new Intent(this,About_Activity.class);
            startActivity(i);

        } else if (id == R.id.nav_news) {
            Intent i=new Intent(this,News_Activity.class);
            startActivity(i);

        } else if (id == R.id.nav_gallery) {

            Intent i=new Intent(this,Gallery_Activity.class);
            startActivity(i);

        } else if (id == R.id.nav_contact) {



        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }//nevigationitemselected
}
