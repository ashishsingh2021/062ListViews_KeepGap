package com.example.a062listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.util.Log;  //FOR  CONSOLE  LOG
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;  // Added
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ArrayList<String> myFamily=new ArrayList<String>();  // DECLARED FINAL                                                   //Step1  Array List
        myFamily.add("Ashish");
        myFamily.add("Abhishek");
        myFamily.add("Sushil");

        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myFamily);  //Step2 ArrayAdaptor

        final ListView myListView =(ListView)findViewById(R.id.myListView);      //DECLARED FINAL                                      //Step3 ListView
        myListView.setAdapter(arrayAdapter);                                                                                           //Step4 Set adaptor to listview

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){                                                       //Step5  Listener for the tapped item

            public void onItemClick(AdapterView<?>parent,View view,int position,long id)
            {
                Log.i("Person tapped:",myFamily.get(position));
                Toast.makeText(getApplicationContext()," Delete "+myFamily.get(position),Toast.LENGTH_LONG).show();
                myFamily.remove(position);
                myListView.setAdapter(arrayAdapter);
                  //
            }

        });




    }
}
