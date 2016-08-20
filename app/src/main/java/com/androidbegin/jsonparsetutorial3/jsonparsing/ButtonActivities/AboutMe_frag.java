package com.androidbegin.jsonparsetutorial3.jsonparsing.ButtonActivities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidbegin.jsonparsetutorial3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutMe_frag extends Fragment {


    public AboutMe_frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_me_frag, container, false);
    }

}
