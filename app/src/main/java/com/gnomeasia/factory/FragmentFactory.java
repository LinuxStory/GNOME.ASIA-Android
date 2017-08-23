package com.gnomeasia.factory;

import android.support.v4.app.Fragment;

import com.gnomeasia.ui.system.main.EventFragment;
import com.gnomeasia.ui.system.main.GnomeFragment;
import com.gnomeasia.ui.system.main.MoreFragment;
import com.gnomeasia.ui.system.main.NewsFragment;



/**
 * ================================================
 * 作    者：FangYi
 * 邮    箱：87649669@qq.com
 * 版    本：1.0
 * 日    期：2017/8/21
 * 描    述：FragmentFactory 工厂
 * 修订历史：
 * ================================================
 */
public class FragmentFactory {

    /**
     * main
     *
     * @param position
     * @return
     */
    public static Fragment createForMain(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:// 资讯
                fragment = new NewsFragment();
                break;
            case 1:// 活动
                fragment = new EventFragment();
                break;
            case 2:// GNOME
                fragment = new GnomeFragment();
                break;
            case 3:// 我的
                fragment = new MoreFragment();
                break;
        }
        return fragment;
    }
}
