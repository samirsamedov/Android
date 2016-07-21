package com.sam.listviewonitemclick.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sam.listviewonitemclick.model.Followers;
import com.sam.listviewonitemclick.R;

import java.util.ArrayList;

/**
 * Created by Samir on 20.7.2016.
 */
public class FollowersAdapter extends BaseAdapter {
    private ArrayList<Followers> myList;

    private Activity parentActivity;
    private LayoutInflater inflater;

    public FollowersAdapter(Activity parent, ArrayList<Followers> l) {
        parentActivity = parent;
        myList=l;
        inflater = (LayoutInflater)parentActivity
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
    public View getView (int position, View convertView,
                         ViewGroup parent) {
        View view = convertView;
        if(convertView==null)
            view = inflater.inflate(R.layout.item, null);

        TextView text1 = (TextView)view.findViewById(R.id.text1);
        TextView text2 = (TextView)view.findViewById(R.id.text2);
         //



        //
        Followers myObj = myList.get(position);
        text1.setText(String.valueOf(myObj.getNumber()));
        text2.setText(myObj.getName());
        return view;
    }
}
