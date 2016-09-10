package com.androidbegin.jsonparsetutorial3.jsonparsing.ButtonActivities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidbegin.jsonparsetutorial3.R;
import com.androidbegin.jsonparsetutorial3.jsonparsing.Imageloader.ImageLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class About_Tab2 extends Activity {

    private static String urlString;
    ImageLoader imageLoader = new ImageLoader(this);
    ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__tab2);

        urlString = "http://parthaphotography.com/wp-json/wp/v2/pages/8";
        new ProcessJSON().execute(urlString);

    }


    class ProcessJSON extends AsyncTask<String, Void, String> {


        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(About_Tab2.this);

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



                    //for fetching  webcontent

                    JSONObject content=reader.getJSONObject("acf");
                    String rendered=content.getString("tab_2_content");
                    WebView webViewcontent=(WebView)findViewById(R.id.webView_about_equipment);
                    webViewcontent.loadData(rendered, "text/html", null);


                    JSONArray equipment_image=content.getJSONArray("equipment_image");
                    JSONObject zero=equipment_image.getJSONObject(0);
                    String images=zero.getString("images");

                    ImageView img=(ImageView)findViewById(R.id.equipment_img);
                    imageLoader.DisplayImage(images,img);

                    Log.i("snigdhadeep5",images);








                    // process other data as this way..............

                }catch(JSONException e){
                    e.printStackTrace();
                }

            } // if statement end
            // Close the progressdialog
            mProgressDialog.dismiss();
        } // onPostExecute() end
    } // ProcessJSON class end




}

