package com.androidbegin.jsonparsetutorial3.jsonparsing.ButtonActivities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.androidbegin.jsonparsetutorial3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Aboutmenu_Frag extends Fragment {


    public Aboutmenu_Frag() {
        // Required empty public constructor
    }
    Fragment fragment;
    FragmentTransaction fragmentTransaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view1=inflater.inflate(R.layout.fragment_aboutmenu_, container, false);

       fragment=new AboutBook_frag();
        fragmentTransaction=getFragmentManager().beginTransaction().add(R.id.book_frag,fragment);
        fragmentTransaction.commit();




        Button aboutus_btn=(Button)view1.findViewById(R.id.aboutus_btn);

        Button equip_btn=(Button)view1.findViewById(R.id.equipment_btn);

        Button book_btn=(Button)view1.findViewById(R.id.book_btn);



        aboutus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragment=new AboutMe_frag();
                fragmentTransaction=getFragmentManager().beginTransaction().add(R.id.aboutus_frag,fragment);
                fragmentTransaction.commit();


            }
        });


        equip_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragment=new AboutEquip_frag();
                fragmentTransaction=getFragmentManager().beginTransaction().add(R.id.aboutus_frag,fragment);
                fragmentTransaction.commit();


            }
        });

        book_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragment=new AboutBook_frag();
                fragmentTransaction=getFragmentManager().beginTransaction().add(R.id.aboutus_frag,fragment);
                fragmentTransaction.commit();


            }
        });

        return view1;
    }

}
