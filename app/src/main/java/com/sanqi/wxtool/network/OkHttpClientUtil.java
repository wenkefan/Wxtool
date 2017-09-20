package com.sanqi.wxtool.network;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 范文轲 on 2017/9/20.
 */

public class OkHttpClientUtil {

    OnSucceedListener listener;
    private OkHttpClient client;
    private static final OkHttpClientUtil OK_HTTP = new OkHttpClientUtil();

    public static OkHttpClientUtil getInstance() {
        return OK_HTTP;
    }

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
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                response.body().close();
                Log.d("fwk",json);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(json);
                    if (jsonObject.getInt("status") == 10000) {
                        Gson gson = new Gson();
                        listener.OnSucceed(flag, gson.fromJson(json, clas), null);
                    } else {
                        String message = (String) jsonObject.get("msg");
                        listener.OnSucceed(flag, null, message);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public <T> void postAsynHttp(final int flag,String url,RequestBody formBody,final Class<T> clas){
//        RequestBody formBody = new FormBody.Builder()
//                .add("size", "10")
//                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.Error();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Log.d("fwk",json);
                response.body().close();
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(json);
                    if (jsonObject.getInt("status") == 0) {
                        Gson gson = new Gson();
                        listener.OnSucceed(flag, gson.fromJson(json, clas), null);
                    } else {
                        String message = (String) jsonObject.get("msg");
                        listener.OnSucceed(flag, null, message);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }
}
