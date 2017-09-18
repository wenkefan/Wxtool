package com.sanqi.wxtool.base;

import java.io.Serializable;

/**
 * Created by wenke on 2017/9/18.
 * 商品实例
 */

public class CommodityBase implements Serializable {
    /**
     *
     {"item_url": "http://item.taobao.com/item.htm?id=532654547293",
     "num_iid": 532654547293,
     "pict_url": "http://img2.tbcdn.cn/tfscom/i1/2069639905/TB1Ji28aOFTMKJjSZFAXXckJpXa_!!0-item_pic.jpg",
     "provcity": "浙江 绍兴",
     "reserve_price": "68.00",
     "title": "儿童袜子宝宝婴儿袜纯棉春秋薄款童袜秋冬厚款男女童袜地板袜中筒",
     "user_type": 1,
     "zk_final_price": "16.80"
     }
     */

    private String item_url;
    private long num_iid;
    private String picr_ur;
    private String provcity;
    private String reserve_price;
    private String title;
    private int user_type;
    private String zk_final_price;
    //额外添加的两个字段
    private int not_uploaded;//未上传  0/1
    private int uploaded;//已上传

    public String getItem_url() {
        return item_url;
    }

    public void setItem_url(String item_url) {
        this.item_url = item_url;
    }

    public long getNum_iid() {
        return num_iid;
    }

    public void setNum_iid(long num_iid) {
        this.num_iid = num_iid;
    }

    public String getPicr_ur() {
        return picr_ur;
    }

    public void setPicr_ur(String picr_ur) {
        this.picr_ur = picr_ur;
    }

    public String getProvcity() {
        return provcity;
    }

    public void setProvcity(String provcity) {
        this.provcity = provcity;
    }

    public String getReserve_price() {
        return reserve_price;
    }

    public void setReserve_price(String reserve_price) {
        this.reserve_price = reserve_price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }

    public String getZk_final_price() {
        return zk_final_price;
    }

    public void setZk_final_price(String zk_final_price) {
        this.zk_final_price = zk_final_price;
    }

    public int getNot_uploaded() {
        return not_uploaded;
    }

    public void setNot_uploaded(int not_uploaded) {
        this.not_uploaded = not_uploaded;
    }

    public int getUploaded() {
        return uploaded;
    }

    public void setUploaded(int uploaded) {
        this.uploaded = uploaded;
    }
}
