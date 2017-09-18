package com.sanqi.wxtool.fragment;

import android.view.View;

import com.sanqi.wxtool.R;

/**
 * Created by 范文轲 on 2017/9/18.
 */

public class SettingFragment extends BaseFragment {

    public static SettingFragment newInstance(){
        return new SettingFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.setting_fragment;
    }

    @Override
    public void initViews(View view) {

    }
}
