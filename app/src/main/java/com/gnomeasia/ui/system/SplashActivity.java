package com.gnomeasia.ui.system;

import com.gnomeasia.MyApplication;
import com.gnomeasia.R;
import com.gnomeasia.base.BaseActivity;

import butterknife.BindView;
import me.wangyuwei.particleview.ParticleView;

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
public class SplashActivity extends BaseActivity {
    @BindView(R.id.pv_splash_welcome)
    ParticleView mPvSplashWelcome;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void init() {
        mPvSplashWelcome.startAnim();

        mPvSplashWelcome.setOnParticleAnimListener(() -> MyApplication.getHandler().postDelayed(() -> {
            newInstance(MainActivity.class);
            finish();
        },1000));
    }
}
