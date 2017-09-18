package com.sanqi.wxtool.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.sanqi.wxtool.R;
import com.sanqi.wxtool.util.ConstantUtil;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 范文轲 on 2017/9/18.
 */

public class HomeFragemnt extends BaseFragment {

    private SlidingTabLayout mSlidingTabLayout;

    private ViewPager mViewPager;

    public static HomeFragemnt newInstance(){
        return new HomeFragemnt();
    }

    private List<String> titles = Arrays.asList("未发送", "已完成");
    private List<String> types = Arrays.asList(
            ConstantUtil.HOME,
            ConstantUtil.SETTING);
    @Override
    public int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    public void initViews(View view) {
        init(view);
        initFragments();
    }

    private void init(View view) {
        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
    }

    private void initFragments() {
        mViewPager.setAdapter(new HomeAdapter(getChildFragmentManager()));
        mViewPager.setOffscreenPageLimit(1);
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    private class HomeAdapter extends FragmentStatePagerAdapter{

        public HomeAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return HomeSimpleFragment.newInstance(types.get(position));
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

        @Override
        public int getCount() {
            return titles.size();
        }
    }
}
