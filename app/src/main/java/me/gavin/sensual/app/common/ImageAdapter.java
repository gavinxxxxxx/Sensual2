package me.gavin.sensual.app.common;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.ViewConfiguration;

import com.bumptech.glide.Glide;

import java.util.List;

import me.gavin.sensual.BuildConfig;
import me.gavin.sensual.R;
import me.gavin.sensual.base.function.IntConsumer;
import me.gavin.sensual.base.recycler.RecyclerHeaderFooterAdapter;
import me.gavin.sensual.base.recycler.RecyclerHolder;
import me.gavin.sensual.databinding.ItemImageBinding;
import me.gavin.sensual.util.DisplayUtil;
import me.gavin.sensual.util.ImageLoader;

/**
 * 图片列表适配器
 *
 * @author gavin.xiong 2016/12/28
 */
public class ImageAdapter extends RecyclerHeaderFooterAdapter<Image, ItemImageBinding> {
    private Fragment mFragment;
    private int mWidth;

    private IntConsumer mListener;

    ImageAdapter(Context context, Fragment fragment, List<Image> mData) {
        super(context, mData, R.layout.item_image);
        mFragment = fragment;
        mWidth = DisplayUtil.getScreenWidth() / 2 - DisplayUtil.dp2px(12);
    }

    public void setListener(IntConsumer listener) {
        this.mListener = listener;
    }

    @Override
    protected void onBind(RecyclerHolder<ItemImageBinding> holder, int position, Image t) {
        int tempHeight = (int) (t.getHeight() / (t.getWidth() + 0f) * mWidth);
        holder.binding.imageView.getLayoutParams().height = tempHeight;
        if (BuildConfig.DEBUG) {
            ImageLoader.loadBlurImage(mFragment, holder.binding.imageView, t.getUrl(), mWidth, tempHeight);
        } else {
            ImageLoader.loadImage(mFragment, holder.binding.imageView, t.getUrl(), mWidth, tempHeight);
        }

        holder.binding.item.setOnClickListener((v) -> {
            if (mListener != null) {
                mListener.accept(position);
            }
        });
    }

    @Override
    public void onViewRecycled(RecyclerHolder holder) {
        super.onViewRecycled(holder);
        if (holder.binding instanceof ItemImageBinding) {
            Glide.clear(((ItemImageBinding) holder.binding).imageView);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(onScrollListener);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        recyclerView.removeOnScrollListener(onScrollListener);
    }

    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {

        int mQuickScrollFlag = ViewConfiguration.get(mContext).getScaledMinimumFlingVelocity() / 2;

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            if (Glide.with(mFragment).isPaused() && newState == RecyclerView.SCROLL_STATE_IDLE) {
                Glide.with(mFragment).resumeRequests();
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            if (!Glide.with(mFragment).isPaused() && Math.max(Math.abs(dx), Math.abs(dy)) > mQuickScrollFlag) {
                Glide.with(mFragment).pauseRequests();
            } else if (Glide.with(mFragment).isPaused() && Math.max(Math.abs(dx), Math.abs(dy)) < mQuickScrollFlag) {
                Glide.with(mFragment).resumeRequests();
            }
        }

    };

}
