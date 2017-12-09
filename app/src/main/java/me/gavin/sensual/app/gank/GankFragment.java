package me.gavin.sensual.app.gank;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.databinding.library.baseAdapters.BR;

import me.gavin.sensual.R;
import me.gavin.sensual.base.BindingFragment;
import me.gavin.sensual.databinding.LayoutPagingToolbarBinding;

/**
 * 干货集中营 - 福利
 *
 * @author gavin.xiong 2017/8/14
 */
public class GankFragment extends BindingFragment<LayoutPagingToolbarBinding, GankViewModel> {

    public static GankFragment newInstance() {
        return new GankFragment();
    }

    @Override
    protected void bindViewModel(@Nullable Bundle savedInstanceState) {
        mViewModel = new GankViewModel(getContext(), this, mBinding);
        mViewModel.afterCreate();
        mBinding.setVariable(BR.vm, mViewModel);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_paging_toolbar;
    }

    @Override
    protected void afterCreate(@Nullable Bundle savedInstanceState) {
        mBinding.includeToolbar.toolbar.setNavigationIcon(R.drawable.vt_arrow_back_24dp);
        mBinding.includeToolbar.toolbar.setNavigationOnClickListener(v -> pop());
        mBinding.includeToolbar.toolbar.setTitle("干货集中营");
    }

}
