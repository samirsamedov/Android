package com.dailyworship.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dailyworship.R;
import com.dailyworship.fragment.PageFragment;

/**
 * Created by Samir on 4.5.2016.
 * FragmentStatePagerAdapter Sayısı belli olmayan sayfalarda kullanılması önerilir
 * bu şekilde en minimal şekilde bellek tüketimi olur
 */
public class SwipeYasiniSerifAdapter extends PagerAdapter {


    private int[] image_resource = {R.drawable.sayfa1, R.drawable.sayfa2, R.drawable.sayfa3, R.drawable.sayfa4, R.drawable.sayfa5, R.drawable.sayfa6};
    private Context context;
    private LayoutInflater layoutInflater;

    public SwipeYasiniSerifAdapter(Context context) {

        this.context = context;
    }


    @Override
    public int getCount() {
        return image_resource.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.fragment_page, container, false);
        ImageView imageview = (ImageView) item_view.findViewById(R.id.img_view_sayfalar);
        TextView textView = (TextView) item_view.findViewById(R.id.txt_fragment_page_count);

        imageview.setImageResource(image_resource[position]);
        textView.setText("Image: " + (position+1));
        container.addView(item_view);
        return item_view;
    }

    // sayfa degişiminde eski bilgileri silme işlemi
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object); // validation ekledik ki sayfa xml de ki Linerlayout mu
    }

     /*
    *  Fragment fragment = new PageFragment();
        // ve oluşturulan fragmente arguman ekliyoruz
        Bundle bundle = new Bundle();
        bundle.putInt("count", position + 1); // position 0 dan başlar
        fragment.setArguments(bundle);
        return fragment;*/

    // kaç sayfamız varsa onun sayısını döner Yasini Şerif 6 sayfa
}
