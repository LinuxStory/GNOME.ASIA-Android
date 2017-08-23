package com.gnomeasia.ui.fragment.news.child;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gnomeasia.MyApplication;
import com.gnomeasia.R;
import com.gnomeasia.adapter.NewAdapter;
import com.gnomeasia.base.BaseHomeFragment;
import com.gnomeasia.view.DefineLoadMoreView;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;

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
public class NewsHomeFragment extends BaseHomeFragment {


    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.recycler_view)
    SwipeMenuRecyclerView mRecyclerView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;
    private ArrayList<String> mList;
    private NewAdapter mAdapter;


    public static NewsHomeFragment newInstance() {
        Bundle args = new Bundle();
        NewsHomeFragment fragment = new NewsHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_more_home;
    }

    @Override
    protected void initView(View view) {
        mToolbarTitle.setText(getString(R.string.toolbar_news));

        mRefreshLayout.setRefreshing(true);
        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mRefreshLayout.setOnRefreshListener(() -> loadData());


        //初始化RecyclerView
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        DefineLoadMoreView loadMoreView = new DefineLoadMoreView(mContext);
        mRecyclerView.addFooterView(loadMoreView); // 添加为Footer。
        mRecyclerView.setLoadMoreView(loadMoreView); // 设置LoadMoreView更新监听。
        // 加载更多的监听。
        mRecyclerView.setLoadMoreListener(() -> loadMore());

        mList = new ArrayList<>();
        MyApplication.getHandler().postDelayed(() -> {
            for (int i = 0; i < 30; i++) {
                mList.add("来打我啊啊啊啊 " + i);
            }

            mAdapter = new NewAdapter(R.layout.item_news, mList);
            mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
            mAdapter.setNotDoAnimationCount(3);
            mRecyclerView.setAdapter(mAdapter);
            mRefreshLayout.setRefreshing(false);
        }, 2000);




    }

    /**
     * 加载更多
     */
    private void loadMore() {

        MyApplication.getHandler().postDelayed(() -> {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add("我是加载出来的" + i);
            }
            mList.addAll(list);

            mAdapter.notifyItemRangeInserted(mList.size() - list.size(), list.size());
            mRecyclerView.loadMoreFinish(false, true);
        }, 2000);


    }

    /**
     * 下拉刷新
     */
    private void loadData() {

        MyApplication.getHandler().postDelayed(() -> {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add("刚更新的" + i);
            }

            mList.addAll(0, list);
            mAdapter.notifyDataSetChanged();

            mRefreshLayout.setRefreshing(false);
            mRecyclerView.loadMoreFinish(false, true);
        }, 2000);


    }
}