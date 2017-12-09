package me.gavin.sensual.base;

import android.databinding.BindingAdapter;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import me.gavin.sensual.util.ImageLoader;

/**
 * 数据绑定适配器
 *
 * @author gavin.xiong 2017/8/15
 */
public class BindingAdapters {

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        ImageLoader.loadImage(imageView, url);
    }

    @BindingAdapter({"height"})
    public static void setLayoutHeight(View view, int height) {
        view.getLayoutParams().height = height;
    }

    @BindingAdapter({"msg"})
    public static void showMsg(View view, String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
        }
    }

}