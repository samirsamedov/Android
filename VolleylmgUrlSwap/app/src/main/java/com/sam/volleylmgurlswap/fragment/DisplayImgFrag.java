package com.sam.volleylmgurlswap.fragment;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.sam.volleylmgurlswap.R;
import com.sam.volleylmgurlswap.util.Singleton;

public class DisplayImgFrag extends Fragment {


    ImageView img_frag_display;
    LinearLayout linearLayout;
    int count;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display_img, container, false);

        final String[] IMG_URL = new String[3];
        IMG_URL[0] = "http://www.intrawallpaper.com/static/images/Hawaii-Beach-Wallpaper-HD_H47ejc9.jpg";
        IMG_URL[1] = "http://www.intrawallpaper.com/static/images/Nature-HD-1080P.jpg";
        IMG_URL[2] = "http://www.intrawallpaper.com/static/images/6937164-beautiful-summer-wallpaper-hd.jpg";
        count = 0;

        img_frag_display = (ImageView) view.findViewById(R.id.img_frag_display);
        linearLayout = (LinearLayout) view.findViewById(R.id.layout_frag_display);


        //Start

        ImageRequest imageRequest = new ImageRequest(IMG_URL[count], new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {

                img_frag_display.setImageBitmap(response);
                setImageView(img_frag_display, response);
                count++;
            }
        }, 0, 0, ImageView.ScaleType.CENTER_CROP, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getActivity(), "Something Wrong", Toast.LENGTH_LONG).show();
                error.printStackTrace();
            }
        });

        Singleton.getInstance(getContext()).addToRequestQueue(imageRequest);

        // End



        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageRequest imageRequest = new ImageRequest(IMG_URL[count], new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {

                        img_frag_display.setImageBitmap(response);
                        setImageView(img_frag_display, response);
                        count++;
                        if (count == 3)
                            count = 0;
                    }
                }, 0, 0, ImageView.ScaleType.CENTER_CROP, null, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getActivity(), "Something Wrong", Toast.LENGTH_LONG).show();
                        error.printStackTrace();
                    }
                });

                Singleton.getInstance(getContext()).addToRequestQueue(imageRequest);
            }
        });


        return view;
    }

    public boolean setImageView(ImageView img_view, Bitmap response) {
        try {
            img_view.setImageBitmap(response);
            return true;
        } catch (Exception e) {
            return true;
        }
    }


}
