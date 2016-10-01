package com.techpenta.parthaphotography.jsonparsing.ButtonActivities;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;

import com.techpenta.parthaphotography.R;
import com.techpenta.parthaphotography.jsonparsing.Imageloader.ImageLoader;

import org.json.JSONException;
import org.json.JSONObject;




public class About_Tab1 extends AppCompatActivity {
    private static String urlString;
    ImageLoader imageLoader = new ImageLoader(this);
    ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__tab1);

        urlString = "http://parthaphotography.com/wp-json/wp/v2/pages/8";
        new ProcessJSON().execute(urlString);

    }


    class ProcessJSON extends AsyncTask<String, Void, String> {

        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(About_Tab1.this);

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
                    JSONObject better_featured_image=reader.getJSONObject("better_featured_image");
                      //for fetching  image
                    String source_url=better_featured_image.getString("source_url");
                    ImageView img=(ImageView)findViewById(R.id.aboutme_img) ;
                    imageLoader.DisplayImage(source_url,img);

               //for fetching  webcontent

                    JSONObject content=reader.getJSONObject("acf");
                    String rendered=content.getString("tab_1_content_");

                  WebView webViewcontent=(WebView)findViewById(R.id.webView_about_me);
                    webViewcontent.loadData(rendered, "text/html", null);





                    Log.i("snigdhadeep5",source_url);








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
