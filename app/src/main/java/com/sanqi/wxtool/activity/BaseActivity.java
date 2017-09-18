package com.sanqi.wxtool.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by wenke on 2017/9/18.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        init();
        initView();
    }

    protected abstract int getLayoutId();

    protected abstract void init();

    protected abstract void initView();

    private ProgressDialog mypDialog;  // 进度提示，请稍候

    public void showProgress(Activity activity, String str) {
        //实例化
        mypDialog = new ProgressDialog(activity);
        //设置进度条风格，风格为圆形，旋转的
        mypDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        //设置ProgressDialog 标题
//		mypDialog.setTitle("请稍候");
        //设置ProgressDialog 提示信息
        mypDialog.setMessage(str);
        //设置ProgressDialog 标题图标
//		mypDialog.setIcon(R.drawable.logo);

        //设置ProgressDialog 的进度条是否不明确
        mypDialog.setIndeterminate(false);
        //设置ProgressDialog 是否可以按退回按键取消
        mypDialog.setCancelable(true);

        //让ProgressDialog显示
        mypDialog.show();
    }

    public void DismissDialog(){
        if (mypDialog != null){
            mypDialog.dismiss();
        }
    }
}
