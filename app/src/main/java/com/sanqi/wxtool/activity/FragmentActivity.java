package com.sanqi.wxtool.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.sanqi.wxtool.R;
import com.sanqi.wxtool.fragment.HomeFragemnt;
import com.sanqi.wxtool.fragment.SettingFragment;
import com.sanqi.wxtool.weight.CircleImageView;

/**
 * Created by 范文轲 on 2017/9/18.
 */

public class FragmentActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView mNavigationView;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;

    private int index;

    private int currentTabIndex;

    private Fragment[] fragments;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_activity;
    }

    @Override
    protected void init() {

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    private void initFragment() {
        HomeFragemnt homeFragemnt = HomeFragemnt.newInstance();
        SettingFragment settingFragment = SettingFragment.newInstance();

        fragments = new Fragment[]{
                homeFragemnt,
                settingFragment
        };

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, homeFragemnt)
                .commit();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setNavigationView();
        initFragment();
        initToolBar();
    }

    private void initToolBar() {
        mToolbar.setTitle(R.string.home);
        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }
    //设置侧滑
    private void setNavigationView() {

        mNavigationView.setNavigationItemSelectedListener(this);
        View headerView = mNavigationView.inflateHeaderView(R.layout.nav_header_main);
        CircleImageView mCircleImageView = (CircleImageView) headerView.findViewById(
                R.id.nav_head_avatar);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                changIndex(0, getResources().getString(R.string.home), item);
                return true;

            case R.id.nav_setting:
                changIndex(1, getResources().getString(R.string.setting), item);
                return true;
        }
        return true;
    }

    public void changIndex(int changNum, String title, MenuItem item) {

        index = changNum;
        switchFragment(fragments[changNum]);
        item.setChecked(true);
        mToolbar.setTitle(title);
        mDrawerLayout.closeDrawers();
    }

    public void switchFragment(Fragment fragment) {

        FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
        trx.hide(fragments[currentTabIndex]);
        if (!fragments[index].isAdded()) {
            trx.add(R.id.content, fragments[index]);
        }
        trx.show(fragments[index]).commit();
        currentTabIndex = index;
    }
}
