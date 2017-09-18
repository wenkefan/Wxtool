package com.sanqi.wxtool.fragment;

import android.os.Bundle;
import android.view.View;

import com.sanqi.wxtool.R;

/**
 * Created by 范文轲 on 2017/9/19.
 */

public class HomeSimpleFragment extends BaseFragment {


    public static final String EXTRA_TYPE = "extra_type";

    public static HomeSimpleFragment newInstance(String type){
        HomeSimpleFragment mFragment = new HomeSimpleFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_TYPE, type);
        mFragment.setArguments(bundle);
       return mFragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_simple_home;
    }

    @Override
    public void initViews(View view) {

    }
}
