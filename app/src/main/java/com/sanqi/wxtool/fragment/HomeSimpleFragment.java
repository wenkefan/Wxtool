package com.sanqi.wxtool.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.sanqi.wxtool.R;
import com.sanqi.wxtool.adapter.CommodityAdapter;
import com.sanqi.wxtool.base.CommodityBase;
import com.sanqi.wxtool.base.CommodityDao;
import com.sanqi.wxtool.util.ConstantUtil;

import java.util.List;

/**
 * Created by 范文轲 on 2017/9/19.
 */

public class HomeSimpleFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    public static final String EXTRA_TYPE = "extra_type";

    private StaggeredGridLayoutManager mLayoutManager;

    private CommodityAdapter mAdapter;

    private List<CommodityBase.NTbkItemBean> list;

    private String type;

    private boolean mIsRefreshing = false;

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
        type = getArguments().getString(EXTRA_TYPE);
        initView(view);
    }

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);

        showProgress();
    }

    private void initRecycleView() {
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addOnScrollListener(OnLoadMoreListener(mLayoutManager));
        mAdapter = new CommodityAdapter(mRecyclerView,list);
        mRecyclerView.setAdapter(mAdapter);
        setRecycleScrollBug();
    }

    private void showProgress(){
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mIsRefreshing = true;
                getCommodity();
            }
        });

        mSwipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
                mIsRefreshing = true;
                getCommodity();
            }
        }, 500);
    }

    private void getCommodity() {
        //请求数据库
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                CommodityDao dao = CommodityDao.getInstance(getContext());
                if (type.equals(ConstantUtil.HOME)) {
                    list = dao.query(0, 0);
                } else if (type.equals(ConstantUtil.SETTING)){
                    list = dao.query(0,1);
                }
                Log.d("fan",list.size()+"---------------size");
                mHandler.sendEmptyMessage(1);
            }
        });
        thread.start();
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    initRecycleView();
                    finishTask();
                    break;
            }
        }
    };

    private void finishTask() {
        mAdapter.notifyDataSetChanged();
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
        mIsRefreshing = false;
    }

    RecyclerView.OnScrollListener OnLoadMoreListener(StaggeredGridLayoutManager mLayoutManager){
        return new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        };
    }

    private void setRecycleScrollBug(){
        mRecyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mIsRefreshing;
            }
        });
    }
}
