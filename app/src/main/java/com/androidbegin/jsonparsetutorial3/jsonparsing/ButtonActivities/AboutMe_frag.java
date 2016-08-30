package com.androidbegin.jsonparsetutorial3.jsonparsing.ButtonActivities;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.androidbegin.jsonparsetutorial3.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutMe_frag extends Fragment {


    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    private static String urlString;
    static String rendered;
    // newInstance constructor for creating fragment with arguments
    public static AboutMe_frag newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        AboutMe_frag fragment = new AboutMe_frag();
        fragment.setArguments(args);
        return fragment;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE, 1);
    }

    // Inflate the fragment layout we defined above for this fragment
// Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_me_frag, container, false);

        urlString = "http://parthaphotography.com/wp-json/wp/v2/pages/8";

        new ProcessJSON().execute(urlString);



        return view;
    }

    public class ProcessJSON extends AsyncTask<String, Void, String> {
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
                    JSONObject acf=reader.getJSONObject("acf");
                    String rendered=acf.getString("tab_1_content_");

                    WebView webViewcontent=(WebView)getView().findViewById(R.id.webView_about_me);
                    webViewcontent.loadData(rendered, "text/html", null);


                    Log.i("kingsukmajumder",rendered);



                    // process other data as this way..............

                }catch(JSONException e){
                    e.printStackTrace();
                }

            }



            // if statement end
        }// onPostExecute() end




    }















    // ProcessJSON class end

    ;



}
