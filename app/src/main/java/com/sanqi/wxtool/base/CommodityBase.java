package com.sanqi.wxtool.base;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wenke on 2017/9/18.
 * 商品实例
 */

public class CommodityBase implements Serializable {

    private List<NTbkItemBean> n_tbk_item;

    public List<NTbkItemBean> getN_tbk_item() {
        return n_tbk_item;
    }

    public void setN_tbk_item(List<NTbkItemBean> n_tbk_item) {
        this.n_tbk_item = n_tbk_item;
    }

    public static class NTbkItemBean implements Serializable {
        /**
         * item_url : http://item.taobao.com/item.htm?id=557411863076
         * num_iid : 557411863076
         * pict_url : http://img4.tbcdn.cn/tfscom/i2/2149637483/TB1fuzkeYsTMeJjSszdXXcEupXa_!!0-item_pic.jpg
         * provcity : 上海
         * reserve_price : 99.00
         * title : 添星中秋月饼礼盒装 蛋黄莲蓉广式月饼中秋节礼品散装多口味团购
         * user_type : 1
         * zk_final_price : 38.80
         */

        private String item_url;
        private long num_iid;
        private String pict_url;
        private String provcity;
        private String reserve_price;
        private String title;
        private int user_type;
        private String zk_final_price;
        private int not_uploaded;
        private int uploaded;

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

        public String getPict_url() {
            return pict_url;
        }

        public void setPict_url(String pict_url) {
            this.pict_url = pict_url;
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
    }
}
