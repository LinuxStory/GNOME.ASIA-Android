package com.gnomeasia.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import butterknife.ButterKnife;

/**
 * ================================================
 * 作    者：FangYi
 * 邮    箱：87649669@qq.com
 * 版    本：1.0
 * 日    期：2017/8/21
 * 描    述：Fragment 基类
 * 修订历史：
 * ================================================
 */
public abstract class BaseFragment extends Fragment {

    public Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View mRootView = View.inflate(getActivity(), getLayoutId(), null);

        ButterKnife.bind(this, mRootView);

        mContext = getContext();
        init();
        return mRootView;
    }


    /**
     * @return 返回该Fragment的layout id
     */
    protected abstract int getLayoutId();

    /**
     * 说明：创建视图时的初始化操作均写在该方法
     */
    public abstract void init();


}
