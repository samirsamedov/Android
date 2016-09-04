package com.sam.cloudinaryex.mPicasso;

import android.content.Context;
import android.widget.ImageView;

import com.sam.cloudinaryex.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Samir on 4.9.2016.
 */
public class PicassoClient {

    public static void downloadImage(Context c, String url, ImageView img) {
        if (url != null && url.length() > 0) {
            Picasso.with(c).load(url).placeholder(R.drawable.ic_timelapse_deep_purple_300_24dp).into(img);
        } else {
            Picasso.with(c).load(R.drawable.ic_warning_red_600_24dp).into(img);
        }

    }
}
