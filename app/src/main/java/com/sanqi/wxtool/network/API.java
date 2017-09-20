package com.sanqi.wxtool.network;

/**
 * Created by 范文轲 on 2017/9/20.
 */

public class API {

    private static final String Api = "http://118.31.71.66:8080";

    /** 登陆接口 */
    public static final String LoginUrl = Api + "/api/user/gologin";

    public static final String LoginUrl1 = LoginUrl + "?phone=%1$s&password=%2$s";

}
