package com.sam.listviewonitemclick.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sam.listviewonitemclick.R;
import com.sam.listviewonitemclick.model.Followers;
import com.sam.listviewonitemclick.model.Followers2;

import java.util.ArrayList;

/**
 * Created by Samir on 20.7.2016.
 */
public class FollowersAdapter2 extends BaseAdapter {
    private ArrayList<Followers2> myList;

    private Activity parentActivity;
    private LayoutInflater inflater;

    public FollowersAdapter2(Activity parent, ArrayList<Followers2> l) {
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
    public View getView(final int position, View convertView,
                        ViewGroup parent) {
        View view = convertView;
        if (convertView == null)
            view = inflater.inflate(R.layout.item_follow, null);

        final Followers2 myObj = myList.get(position);

        TextView name = (TextView) view.findViewById(R.id.txt_item_followers_name);
        TextView mark = (TextView) view.findViewById(R.id.txt_item_followers_mark);
        final ImageView btn_follow = (ImageView) view.findViewById(R.id.btn_item_followers_2b_follow);
        name.setText(myObj.getName());
        mark.setText(myObj.getScore());
        if (myObj.isFollow() == true) {
            btn_follow.setImageResource(R.drawable.following_buton);
        } else {
            btn_follow.setImageResource(R.drawable.follow_buton);
        }

        btn_follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Followers2 myObj = myList.get(position);
                if (myObj.isFollow() == true) {
                    btn_follow.setImageResource(R.drawable.following_buton);
                } else {
                    btn_follow.setImageResource(R.drawable.follow_buton);
                }
            }
        });

        return view;
    }
}
