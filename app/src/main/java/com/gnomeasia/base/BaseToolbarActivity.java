package com.gnomeasia.base;

import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.gnomeasia.R;

/**
 * Created by FANGYI on 2017/8/21.
 */

public abstract class BaseToolbarActivity extends BaseActivity {

    /**
     * 初始化ToolBar
     * @param title
     */
    public void initToolbar(String title) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(v -> finish());
    }

    /**
     * 初始化 带title的ToolBar
     * @param title
     */
    public void initTitle(String title) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(v -> finish());

        TextView titleTableName = (TextView) findViewById(R.id.toolbar_title);
        titleTableName.setText(title);
    }

}
