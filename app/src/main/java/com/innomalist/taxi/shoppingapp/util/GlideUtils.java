package com.innomalist.taxi.shoppingapp.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.innomalist.taxi.shoppingapp.base.AppConstants;
import com.kiandashopping.kiandashopping.base.GlideApp;
import java.io.File;

public class GlideUtils {
    public static void showImage(Context context, ImageView imageView, int i, String str) {
        if (context != null) {
            try {
                GlideApp.with(context).load(str).transition((TransitionOptions) DrawableTransitionOptions.withCrossFade()).placeholder(i).into(imageView);
            } catch (Exception e) {
                Log.e(AppConstants.EXCEPTION, e.toString());
            }
        }
    }

    public static void showImage(Context context, ImageView imageView, Drawable drawable, String str) {
        if (context != null) {
            try {
                GlideApp.with(context).load(str).transition((TransitionOptions) DrawableTransitionOptions.withCrossFade()).placeholder(drawable).into(imageView);
            } catch (Exception e) {
                Log.e(AppConstants.EXCEPTION, e.toString());
            }
        }
    }

    public static void showImagePNG(Context context, ImageView imageView, int i, String str) {
        try {
            DrawableTransitionOptions with = DrawableTransitionOptions.with(new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build());
            if (context != null) {
                GlideApp.with(context).load(str).transition((TransitionOptions) with).placeholder(i).into(imageView);
            }
        } catch (Exception e) {
            Log.e(AppConstants.EXCEPTION, e.toString());
        }
    }

    public static void showRoundImage(Context context, ImageView imageView, int i, String str) {
        if (context != null) {
            try {
                GlideApp.with(context).load(str).thumbnail((RequestBuilder) Glide.with(context).load(Integer.valueOf(i)).circleCrop()).transition((TransitionOptions) DrawableTransitionOptions.withCrossFade()).transform((Transformation) new CircleCrop()).into(imageView);
            } catch (Exception e) {
                Log.e(AppConstants.EXCEPTION, e.toString());
            }
        }
    }

    public static void showBlurImage(Context context, ImageView imageView, int i, String str) {
        if (context != null) {
            try {
                GlideApp.with(context).load(str).transition((TransitionOptions) DrawableTransitionOptions.withCrossFade()).transform((Transformation) new BlurTransformation(70)).placeholder(i).into(imageView);
            } catch (Exception e) {
                Log.e(AppConstants.EXCEPTION, e.toString());
            }
        }
    }

    public static void showCrossFadeImage(Context context, ImageView imageView, String str) {
        if (context != null) {
            try {
                GlideApp.with(context).load(str).transition((TransitionOptions) DrawableTransitionOptions.withCrossFade()).into(imageView);
            } catch (Exception e) {
                Log.e(AppConstants.EXCEPTION, e.toString());
            }
        }
    }

    public static void showDefaultBlurImage(Context context, ImageView imageView, int i) {
        if (context != null) {
            try {
                GlideApp.with(context).load(Integer.valueOf(i)).transition((TransitionOptions) DrawableTransitionOptions.withCrossFade()).transform((Transformation) new BlurTransformation(70)).placeholder(i).into(imageView);
            } catch (Exception e) {
                Log.e(AppConstants.EXCEPTION, e.toString());
            }
        }
    }

    public static void showRoundImage(Context context, ImageView imageView, String str) {
        if (context != null) {
            try {
                GlideApp.with(context).load(str).transform((Transformation) new CircleCrop()).transition((TransitionOptions) DrawableTransitionOptions.withCrossFade()).into(imageView);
            } catch (Exception e) {
                Log.e(AppConstants.EXCEPTION, e.toString());
            }
        }
    }

    public static void showRoundImage(Context context, ImageView imageView, File file) {
        if (context != null) {
            try {
                GlideApp.with(context).load(file).transform((Transformation) new CircleCrop()).transition((TransitionOptions) DrawableTransitionOptions.withCrossFade()).into(imageView);
            } catch (Exception e) {
                Log.e(AppConstants.EXCEPTION, e.toString());
            }
        }
    }
}
