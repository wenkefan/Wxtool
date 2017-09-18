package com.sanqi.wxtool.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 范文轲 on 2017/9/18.
 */

public abstract class BaseFragment extends Fragment {
    private View rootView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(getLayoutId(), container, false);

        return rootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }


    @Override
    public void onDetach() {

        super.onDetach();
    }


    public abstract int getLayoutId();

    public abstract void initViews(View view);
}
