package me.gavin.sensual.util;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;

import me.gavin.sensual.R;
import me.gavin.sensual.util.glide.BlurTransformation;
import me.gavin.sensual.util.glide.GlideCircleTransformation;

/**
 * 图片加载器
 *
 * @author gavin.xiong 2017/3/15
 */
public class ImageLoader {

    /**
     * 图片占位色
     */
    private static final int[] COLORS = new int[]{
            R.color.colorHolder00,
            R.color.colorHolder01,
            R.color.colorHolder02,
            R.color.colorHolder03,
            R.color.colorHolder04,
            R.color.colorHolder05,
            R.color.colorHolder06,
    };

    /**
     * 正常加载图片
     */
    public static void loadImage(ImageView imageView, String url) {
        int colorRes = getPlaceholderColor();
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(colorRes)
                .error(colorRes)
                .into(imageView);
    }

    /**
     * 正常加载图片
     */
    public static void loadImage(Fragment fragment, ImageView imageView, String url, int width, int height) {
//        if (!BuildConfig.DEBUG) {
        int colorRes = getPlaceholderColor();
        Glide.with(fragment)
                .load(url)
//                    .asBitmap()
                .placeholder(colorRes)
                .error(colorRes)
                .override(width, height)
                .into(imageView);
//        }
    }

    /**
     * 加载头像
     */
    public static void loadHead(Fragment fragment, ImageView imageView, String url) {
        Glide.with(fragment)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .override(200, 200)
                .transform(new GlideCircleTransformation(imageView.getContext()))
                .into(imageView);
    }

    /**
     * 加载高斯模糊图片
     */
    public static void loadBlurImage(Fragment fragment, ImageView imageView, String url, int width, int height) {
        int colorRes = getPlaceholderColor();
        Glide.with(fragment)
                .load(url)
                .placeholder(colorRes)
                .error(colorRes)
                .bitmapTransform(new BlurTransformation(imageView.getContext(), width / 5))
                .override(width, height)
                .into(imageView);
    }

    /**
     * 获取 bitmap 对象 可用来获取尺寸等
     */
    public static Bitmap getBitmap(Fragment fragment, String url) throws Exception {
        return Glide.with(fragment)
                .load(url)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .get();
    }

    /**
     * 获取随机占位色
     */
    private static int getPlaceholderColor() {
        return COLORS[(int) (Math.random() * COLORS.length)];
    }

}
