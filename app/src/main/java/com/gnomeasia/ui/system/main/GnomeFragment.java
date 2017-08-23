package com.gnomeasia.ui.system.main;

import com.gnomeasia.R;
import com.gnomeasia.base.LazyLoadingFragment;
import com.socks.library.KLog;

/**
 * Created by FANGYI on 2017/8/21.
 */

public class GnomeFragment extends LazyLoadingFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_gnome;
    }

    @Override
    public void init() {

        KLog.e("==init====GnomeFragment===");

    }

    @Override
    public void lazyLoad() {
        KLog.e("==lazyLoad====GnomeFragment===");
    }



}
