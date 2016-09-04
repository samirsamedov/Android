package com.sam.cloudinaryex.mCloud;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;

/**
 * Created by Samir on 4.9.2016.
 */
public class CloudinaryClient {

    public static String getRoundedCorners() {
        Cloudinary cloud = new Cloudinary(MyCOnfiguration.getMyConfigs());
        // Manupulation
        Transformation t = new Transformation();
        t.radius(60);
        return cloud.url().transformation(t).generate("sample.jpg");
    }

    public static String resize() {
        Cloudinary cloud = new Cloudinary(MyCOnfiguration.getMyConfigs());
        // Manupulation
        Transformation t = new Transformation();
        t.width(300);
        t.height(250);
        return cloud.url().transformation(t).generate("sample.jpg");
    }
}
