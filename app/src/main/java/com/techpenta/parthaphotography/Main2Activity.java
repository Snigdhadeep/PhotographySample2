package com.techpenta.parthaphotography;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class Main2Activity extends AppCompatActivity {
    EditText txt;
    Button buttonsavedata;
    Firebase mrootfirebase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt = (EditText) findViewById(R.id.txtsavedata);
        buttonsavedata = (Button) findViewById(R.id.buttonsave1);
        mrootfirebase = new Firebase("https://parthaphotography-4cb28.firebaseio.com/Blog");


        buttonsavedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value=txt.getText().toString();
                Firebase childroot=mrootfirebase.child("good2");
                childroot.setValue(value);
            }
        });

    }
}
