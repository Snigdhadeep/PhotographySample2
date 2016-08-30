package com.androidbegin.jsonparsetutorial3.jsonparsing.ButtonActivities;


import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;

import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Surface;
import android.webkit.WebView;


import com.androidbegin.jsonparsetutorial3.R;
import com.astuetz.PagerSlidingTabStrip;

import org.json.JSONException;
import org.json.JSONObject;


public class About_Activity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener{

    private static String urlString;
    String rendered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_);









        //for toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);






        Display display = getWindowManager().getDefaultDisplay();
        int rotation = display.getRotation();

        Point size = new Point();
        display.getSize(size);


        int lock = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

        if (rotation == Surface.ROTATION_0
                || rotation == Surface.ROTATION_180) {
            // if rotation is 0 or 180 and width is greater than height, we have
            // a tablet
            if (size.x > size.y) {
                if (rotation == Surface.ROTATION_0) {
                    lock = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
                } else {
                    lock = ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
                }
            } else {
                // we have a phone
                if (rotation == Surface.ROTATION_0) {
                    lock = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

                    // Get the ViewPager and set it's PagerAdapter so that it can display items
                    ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
                    viewPager.setAdapter(new AboutSampleFragmentPagerAdapter(getSupportFragmentManager()));

                    // Give the PagerSlidingTabStrip the ViewPager
                    PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
                    // Attach the view pager to the tab strip
                    tabsStrip.setViewPager(viewPager);

                } else {
                    lock = ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                }
            }
        }


        else {
            // if rotation is 90 or 270 and width is greater than height, we
            // have a phone
            if (size.x > size.y) {
                if (rotation == Surface.ROTATION_90) {
                    lock = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;

                    // Get the ViewPager and set it's PagerAdapter so that it can display items
                    ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
                    viewPager.setAdapter(new AboutSampleFragmentPagerAdapter(getSupportFragmentManager()));

                    // Give the PagerSlidingTabStrip the ViewPager
                    PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
                    // Attach the view pager to the tab strip
                    tabsStrip.setViewPager(viewPager);

                } else {
                    lock = ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
                }
            } else {
                // we have a tablet
                if (rotation == Surface.ROTATION_90) {
                    lock = ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                } else {
                    lock = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
                }
            }
        }





    }//oncreate







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



























