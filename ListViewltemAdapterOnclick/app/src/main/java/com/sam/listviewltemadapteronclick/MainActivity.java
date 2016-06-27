package com.sam.listviewltemadapteronclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/*
* 1-) Prepare DataList SOurce (image - title - desription)

2-) Define apperiance onf single row in xml (İtem)

3-) Create a Custom Adapter that maps data from source to signle row (to item)

4-) Decide what happens when user CLICK on an Item */

public class MainActivity extends AppCompatActivity {
    ListView listview;
    ArrayList<DataList> dataLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataLists = new ArrayList<>();
        dataLists = getAllList();

        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(new MyBaseAdapter(MainActivity.this, dataLists));

    }

    public ArrayList<DataList> getAllList() {
        ArrayList<DataList> newList = new ArrayList<>();
        DataList data = new DataList("Hello", "From World", R.drawable.ic_alarm_add_black_24dp);
        DataList data2 = new DataList("Hello", "From Mars", R.drawable.ic_3d_rotation_black_24dp);
        DataList data3 = new DataList("Helle", "From Jupiter", R.drawable.ic_accessibility_black_24dp);
        DataList data4 = new DataList("Helle", "From Venus", R.drawable.ic_alarm_add_black_24dp);
        DataList data5 = new DataList("Helle", "From Moon", R.drawable.info);
        newList.add(data);
        newList.add(data2);
        newList.add(data3);
        newList.add(data4);
        newList.add(data5);
        return newList;
    }
}
