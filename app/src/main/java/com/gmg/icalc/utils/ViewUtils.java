package com.gmg.icalc.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.gmg.icalc.MediaUtils;
import com.gmg.icalc.SharedPreferenceUtilities;

/**
 * Created by KM on 10/24/2017. IC
 */

public class ViewUtils {
    public static void setImageToView (Context context, String url, ImageView imageView){
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .skipMemoryCache(true)
                .placeholder(MediaUtils.image_placeholder_black)
                .error(MediaUtils.image_error_black)
                .into(imageView);
    }

    public static void setAvatarToView (Context context, ImageView imageView){
        String avatarPath = SharedPreferenceUtilities.getFromSessionSP(context, SharedPreferenceUtilities.USER_PHOTO);
        Glide.with(context)
                .load(avatarPath)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .skipMemoryCache(true)
                .placeholder(MediaUtils.image_placeholder_black)
                .error(MediaUtils.image_error_black)
                .into(imageView);
    }
}
