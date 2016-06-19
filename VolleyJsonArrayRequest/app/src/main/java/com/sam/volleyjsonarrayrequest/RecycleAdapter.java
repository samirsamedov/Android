package com.sam.volleyjsonarrayrequest;

import android.content.ContentValues;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Samir on 19.6.2016.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {

    ArrayList<Contact> arraylist = new ArrayList<>();

    public RecycleAdapter(ArrayList<Contact> arraylist) {
        this.arraylist = arraylist;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txtname.setText(arraylist.get(position).getName());
        holder.txtcity.setText(arraylist.get(position).getCity());
        holder.txtcountry.setText(arraylist.get(position).getCountry());

    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtname;
        TextView txtcity;
        TextView txtcountry;

        public MyViewHolder(View itemView) {
            super(itemView);

            txtname = (TextView) itemView.findViewById(R.id.txtname);
            txtcity = (TextView) itemView.findViewById(R.id.txtcity);
            txtcountry = (TextView) itemView.findViewById(R.id.txtcountry);
        }
    }
}
