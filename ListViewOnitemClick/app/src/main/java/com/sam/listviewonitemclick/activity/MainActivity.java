package com.sam.listviewonitemclick.activity;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;

import com.sam.listviewonitemclick.R;
import com.sam.listviewonitemclick.adapter.FollowersAdapter;
import com.sam.listviewonitemclick.adapter.FollowersAdapter2;
import com.sam.listviewonitemclick.model.Followers;
import com.sam.listviewonitemclick.model.Followers2;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listview);

        //Init ArrayList of MyObject
       /*
       *  ArrayList<Followers> myArrayList = new ArrayList<Followers>();
        myArrayList = getAllList();

        FollowersAdapter followersAdapter = new FollowersAdapter(this, myArrayList);
        listView.setAdapter(followersAdapter);*/

        ArrayList<Followers2> followers2s = new ArrayList<>();
        followers2s = getAllFollowersList();
        FollowersAdapter2 followersAdapter2 = new FollowersAdapter2(this, followers2s);
        listView.setAdapter(followersAdapter2);

        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                Followers2 clickedObj = (Followers2) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,
                        "Clicked item:\n" +
                                clickedObj.getName() + ": " +
                                clickedObj.getScore(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    public ArrayList<Followers2> getAllFollowersList() {
        ArrayList<Followers2> followersList = new ArrayList<>();
        followersList.add(new Followers2("Samir", "125", true));
        followersList.add(new Followers2("Ayse", "23", false));
        followersList.add(new Followers2("Kaan", "550", true));
        followersList.add(new Followers2("Timuçin", "30", false));
        followersList.add(new Followers2("Ali", "603", true));
        followersList.add(new Followers2("Burcu", "1003", false));
        followersList.add(new Followers2("Efe", "203", false));
        followersList.add(new Followers2("Serdar", "103", false));
        followersList.add(new Followers2("Onur", "333", true));
        followersList.add(new Followers2("Mercan", "1003", false));

        return followersList;

    }

    public ArrayList<Followers> getAllList() {
        ArrayList<Followers> followersList = new ArrayList<>();
        followersList.add(new Followers(0, "Sunday"));
        followersList.add(new Followers(1, "Monday"));
        followersList.add(new Followers(2, "Tuesday"));
        followersList.add(new Followers(3, "Wednesday"));
        followersList.add(new Followers(4, "Thursday"));
        followersList.add(new Followers(5, "Friday"));
        followersList.add(new Followers(6, "Saturday"));
        followersList.add(new Followers(7, "Sunday"));
        followersList.add(new Followers(8, "Monday"));
        followersList.add(new Followers(9, "Tuesday"));
        return followersList;

    }

}