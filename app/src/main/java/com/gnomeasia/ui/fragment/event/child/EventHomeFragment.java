package com.gnomeasia.ui.fragment.event.child;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.gnomeasia.R;
import com.gnomeasia.base.BaseHomeFragment;

import butterknife.BindView;

/**
 * ================================================
 * 作    者：FangYi
 * 邮    箱：87649669@qq.com
 * 版    本：1.0
 * 日    期：2017/8/23
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class EventHomeFragment extends BaseHomeFragment {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;

    public static EventHomeFragment newInstance() {
        Bundle args = new Bundle();
        EventHomeFragment fragment = new EventHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_more_home;
    }

    @Override
    protected void initView(View view) {

        mToolbarTitle.setText(getString(R.string.toolbar_event));
    }
}