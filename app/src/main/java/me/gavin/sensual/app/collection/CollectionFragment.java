package me.gavin.sensual.app.collection;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.gavin.sensual.R;
import me.gavin.sensual.base.BindingFragment;
import me.gavin.sensual.databinding.LayoutPagingToolbarBinding;

/**
 * 收藏
 *
 * @author gavin.xiong 2017/8/16
 */
public class CollectionFragment extends BindingFragment<LayoutPagingToolbarBinding, CollectionViewModel> {

    public static CollectionFragment newInstance() {
        return new CollectionFragment();
    }

    @Override
    protected void bindViewModel(@Nullable Bundle savedInstanceState) {
        mViewModel = new CollectionViewModel(getContext(), this, mBinding);
        mViewModel.afterCreate();
        mBinding.setVm(mViewModel);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_paging_toolbar;
    }

    @Override
    protected void afterCreate(@Nullable Bundle savedInstanceState) {
        mBinding.includeToolbar.toolbar.setTitle("收藏");
        mBinding.includeToolbar.toolbar.setNavigationIcon(R.drawable.vt_arrow_back_24dp);
        mBinding.includeToolbar.toolbar.setNavigationOnClickListener(v -> pop());
    }
}
