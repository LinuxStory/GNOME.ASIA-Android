package com.gnomeasia.ui.system;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.gnomeasia.R;
import com.gnomeasia.base.BaseActivity;
import com.gnomeasia.ui.system.main.EventFragment;
import com.gnomeasia.ui.system.main.GnomeFragment;
import com.gnomeasia.ui.system.main.MoreFragment;
import com.gnomeasia.ui.system.main.NewsFragment;

import butterknife.BindView;


public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar mBottomNavigationBar;

    int lastSelectedPosition = 0;
    private NewsFragment mNewsFragment;
    private EventFragment mEventFragment;
    private GnomeFragment mGnomeFragment;
    private MoreFragment mMoreFragment;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {


        mNewsFragment = new NewsFragment();
        mEventFragment = new EventFragment();
        mGnomeFragment = new GnomeFragment();
        mMoreFragment = new MoreFragment();

        initBnv();
    }

    private void initBnv() {

        setSelectedFragment(lastSelectedPosition);

        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT);

        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_main_news_red_24dp, R.string.main_news).setActiveColorResource(R.color.red))
                .addItem(new BottomNavigationItem(R.drawable.ic_main_event_red_24dp, R.string.main_envent).setActiveColorResource(R.color.red))
                .addItem(new BottomNavigationItem(R.drawable.ic_main_gnome_red_24dp, R.string.main_gnome).setActiveColorResource(R.color.red))
                .addItem(new BottomNavigationItem(R.drawable.ic_main_more_red_24dp, R.string.main_more).setActiveColorResource(R.color.red))
                .setFirstSelectedPosition(lastSelectedPosition > 3 ? 3 : lastSelectedPosition)
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                lastSelectedPosition = position;
                setSelectedFragment(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    private void setSelectedFragment(int position) {
        switch (position) {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.home_activity_frag_container, mNewsFragment).commitAllowingStateLoss();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.home_activity_frag_container, mEventFragment).commitAllowingStateLoss();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.home_activity_frag_container, mGnomeFragment).commitAllowingStateLoss();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.home_activity_frag_container, mMoreFragment).commitAllowingStateLoss();
                break;
            default:

                break;
        }
    }

}
