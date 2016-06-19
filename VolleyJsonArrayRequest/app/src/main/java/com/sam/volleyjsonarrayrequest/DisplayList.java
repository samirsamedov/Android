package com.sam.volleyjsonarrayrequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class DisplayList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Contact> arraylist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true); // for performance inrease

        BackGroundTast backGroundTast = new BackGroundTast(DisplayList.this);
        arraylist = new ArrayList<>();
        arraylist = backGroundTast.getArrayList();
        adapter = new RecycleAdapter(arraylist);
        recyclerView.setAdapter(adapter);


    }
}
