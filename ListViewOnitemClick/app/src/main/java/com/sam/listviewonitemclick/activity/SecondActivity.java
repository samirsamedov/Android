package com.sam.listviewonitemclick.activity;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;

import com.sam.listviewonitemclick.R;
import com.sam.listviewonitemclick.adapter.FollowersAdapter;
import com.sam.listviewonitemclick.model.Followers;

public class SecondActivity extends Activity {

    private class MyObject {
        private int number;
        private String name;

        MyObject(int num, String nam) {
            number = num;
            name = nam;
        }

        public int getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listview);

        //Init ArrayList of MyObject
        ArrayList<Followers> myArrayList = new ArrayList<Followers>();
        myArrayList.add(new Followers(0, "Sunday"));
        myArrayList.add(new Followers(1, "Monday"));
        myArrayList.add(new Followers(2, "Tuesday"));
        myArrayList.add(new Followers(3, "Wednesday"));
        myArrayList.add(new Followers(4, "Thursday"));
        myArrayList.add(new Followers(5, "Friday"));
        myArrayList.add(new Followers(6, "Saturday"));

        FollowersAdapter myAdapter = new FollowersAdapter(this, myArrayList);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                Followers clickedObj = (Followers) parent.getItemAtPosition(position);
                Toast.makeText(SecondActivity.this,
                        "Clicked item:\n" +
                                clickedObj.getNumber() + ": " +
                                clickedObj.getName(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    private class MyAdapter extends BaseAdapter {

        private ArrayList<Followers> myList;

        private Activity parentActivity;
        private LayoutInflater inflater;

        public MyAdapter(Activity parent, ArrayList<Followers> l) {
            parentActivity = parent;
            myList = l;
            inflater = (LayoutInflater) parentActivity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return myList.size();
        }

        @Override
        public Object getItem(int position) {
            return myList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView,
                            ViewGroup parent) {
            View view = convertView;
            if (convertView == null)
                view = inflater.inflate(R.layout.item, null);

            TextView text1 = (TextView) view.findViewById(R.id.text1);
            TextView text2 = (TextView) view.findViewById(R.id.text2);
            Followers myObj = myList.get(position);
            text1.setText(String.valueOf(myObj.getNumber()));
            text2.setText(myObj.getName());
            return view;
        }
    }
}