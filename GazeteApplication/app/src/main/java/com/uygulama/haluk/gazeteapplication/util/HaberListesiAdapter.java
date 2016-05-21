package com.uygulama.haluk.gazeteapplication.util;

import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.uygulama.haluk.gazeteapplication.R;
import com.uygulama.haluk.gazeteapplication.model.Haber;

import java.util.List;

/**
 * Created by Haluk on 30.04.2016.
 */
public class HaberListesiAdapter extends BaseAdapter
{
    private final List<Haber> haberler;
    private final ListFragment listFragment;

    public HaberListesiAdapter(List<Haber> haberler, ListFragment listFragment)
    {
        this.haberler = haberler;
        this.listFragment = listFragment;
    }

    @Override
    public int getCount() {
        return haberler.size();
    }

    @Override
    public Object getItem(int position) {
        return haberler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Haber suAnkiHaber = haberler.get(position);

        if(convertView == null)
        {
           convertView = listFragment.getActivity().getLayoutInflater().inflate(R.layout.list_view_haber, parent, false);
        }

        TextView txtTitle = (TextView)convertView.findViewById(R.id.liste_view_haber_etiket);
        txtTitle.setText(suAnkiHaber.getEtiket());

        return convertView;
    }
}
