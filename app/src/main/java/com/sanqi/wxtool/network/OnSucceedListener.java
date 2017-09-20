package com.sanqi.wxtool.network;

/**
 * Created by 范文轲 on 2017/9/20.
 */

public interface OnSucceedListener {

    public <T> void OnSucceed(int flag, T cla, String message);

    public void Error();
}
