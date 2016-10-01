package com.techpenta.parthaphotography;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseApp;

/**
 * Created by Snikdha on 9/14/2016.
 */
public class CrowdWeather extends android.app.Application {




    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);


    }



}
