package com.gnomeasia.base;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.gnomeasia.R;

import butterknife.BindView;

/**
 * ================================================
 * 作    者：FangYi
 * 邮    箱：87649669@qq.com
 * 版    本：1.0
 * 日    期：2017/8/21
 * 描    述：懒加载Fragment
 * 修订历史：
 * ================================================
 */
public abstract class LazyLoadingFragment extends BaseFragment {
    // 标志位，标志已经初始化完成，因为setUserVisibleHint是在onCreateView之前调用的，
    // 在视图未初始化的时候，在lazyLoad当中就使用的话，就会有空指针的异常
    private boolean isPrepared;
    //标志当前页面是否可见
    private boolean isVisible;

    private boolean isLoadData = false;

    protected Activity mActivity;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isPrepared = true;
        lazyLoad();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //懒加载
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            if (isLoadData) {
                onInvisible();
            }
        }
    }

    protected void onVisible() {
        if (!isVisible || !isPrepared) {
            return;
        }
        lazyLoad();
        isLoadData = true;

    }

    /**
     * 当视图初始化并且对可见时加载数据
     */
    public abstract void lazyLoad();

    /**
     * 当该视图对用户不可见并且已经加载过数据的时候，如果需要在切换到其他页面时停止加载数据，通过覆写此方法实现
     */
    protected void onInvisible() {}

}
