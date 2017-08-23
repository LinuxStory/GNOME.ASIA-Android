package com.gnomeasia.ui.system.main;

import com.gnomeasia.R;
import com.gnomeasia.base.LazyLoadingFragment;
import com.socks.library.KLog;

/**
 * Created by FANGYI on 2017/8/21.
 */

public class EventFragment extends LazyLoadingFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_event;
    }

    @Override
    public void init() {

        KLog.e("==init====EventFragment===");

    }

    @Override
    public void lazyLoad() {
        KLog.e("==lazyLoad====EventFragment===");
    }


}
