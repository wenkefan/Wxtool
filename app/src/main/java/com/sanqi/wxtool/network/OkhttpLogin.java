package com.sanqi.wxtool.network;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by 范文轲 on 2017/9/21.
 */

public class OkhttpLogin extends Okhttp {
    @Override
    public void onError(Call call, IOException e) {

    }

    @Override
    public <T> void onSucceed(Call call, Response response, String json, int flag, Class<T> clas) {

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
}
