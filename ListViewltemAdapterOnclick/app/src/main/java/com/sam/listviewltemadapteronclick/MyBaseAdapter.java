package com.sam.listviewltemadapteronclick;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Samir on 27.6.2016.
 * TWO
 */
public class MyBaseAdapter extends BaseAdapter {

    ArrayList<DataList> dataArrayList = new ArrayList<>();
    LayoutInflater inflater;
    Context context;

    public MyBaseAdapter(Context context, ArrayList<DataList> dataList) {
        this.dataArrayList = dataList;
        this.context = context;
        inflater = LayoutInflater.from(this.context); // only context can only be used
    }


    
    @Override
    public int getCount() {
        return dataArrayList.size();
    }

    @Override
    public DataList getItem(int position) { // Object changed with DataList
        return dataArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder;
        DataList currenttdata= dataArrayList.get(position); // here is current data

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_listview, null);
            myViewHolder = new MyViewHolder();
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        myViewHolder.title = (TextView)convertView.findViewById(R.id.txt_title);
        myViewHolder.title.setText(currenttdata.getTitle());
        myViewHolder.desc = (TextView)convertView.findViewById(R.id.txt_des);
        myViewHolder.desc.setText(currenttdata.getDesc());

        myViewHolder.ivgIcon=(ImageView)convertView.findViewById(R.id.img);
        myViewHolder.ivgIcon.setImageResource(currenttdata.getImgResId());

        return convertView;
    }

    public class MyViewHolder {
        TextView title,desc;
        ImageView ivgIcon;

    }
}
