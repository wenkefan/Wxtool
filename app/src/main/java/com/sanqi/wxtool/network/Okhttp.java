package com.sanqi.wxtool.network;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 范文轲 on 2017/9/21.
 */

public abstract class Okhttp {

    public OnSucceedListener listener;
    public OkHttpClient client;


    public void setListener(OnSucceedListener listener) {
        this.listener = listener;
        client = new OkHttpClient();
    }

    public <T> void getAsynHttp(final int flag, String URL, final Class<T> clas) {
        Request request = new Request.Builder().url(URL).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                listener.Error();
                onError(call, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                response.body().close();
                Log.d("fwk",json);
                onSucceed(call,response,json, flag, clas);
            }
        });
    }


    public <T> void postAsynHttp(final int flag, String url, RequestBody formBody, final Class<T> clas){
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.Error();
                onError(call,e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Log.d("fwk",json);
                response.body().close();
                onSucceed(call,response,json,flag,clas);
            }

        });
    }


    public abstract void onError(Call call, IOException e);
    public abstract <T> void onSucceed(Call call, Response response, String json, int flag, Class<T> clas);
}
