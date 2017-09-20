package com.sanqi.wxtool.base;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 范文轲 on 2017/9/20.
 */

public class LoginBase implements Serializable {

    /**
     {"status":0,"msg":"登录成功!","data":{"id":3,"username":"123","password":"","phone":"123","wxid":null,"qqid":null,"alisession":null,"alikey":null,"alivalue":null,"token":"8b081f1d-8132-401b-8485-c0c0b1805617","phonenum":50,"role":1,"createTime":null,"updateTime":null}}
     */

    private int status;
    private String msg;
    private data data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LoginBase.data getData() {
        return data;
    }

    public void setData(LoginBase.data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LoginBase{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    class data implements Serializable{
        private int id;
        private String username;
        private String password;
        private String phone;
        private Object wxid;
        private Object qqid;
        private Object alisession;
        private Object alikey;
        private String token;
        private int phonenum;
        private int role;
        private Object createTime;
        private Object updateTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Object getWxid() {
            return wxid;
        }

        public void setWxid(Object wxid) {
            this.wxid = wxid;
        }

        public Object getQqid() {
            return qqid;
        }

        public void setQqid(Object qqid) {
            this.qqid = qqid;
        }

        public Object getAlisession() {
            return alisession;
        }

        public void setAlisession(Object alisession) {
            this.alisession = alisession;
        }

        public Object getAlikey() {
            return alikey;
        }

        public void setAlikey(Object alikey) {
            this.alikey = alikey;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getPhonenum() {
            return phonenum;
        }

        public void setPhonenum(int phonenum) {
            this.phonenum = phonenum;
        }

        public int getRole() {
            return role;
        }

        public void setRole(int role) {
            this.role = role;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        @Override
        public String toString() {
            return "data{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", phone='" + phone + '\'' +
                    ", wxid=" + wxid +
                    ", qqid=" + qqid +
                    ", alisession=" + alisession +
                    ", alikey=" + alikey +
                    ", token='" + token + '\'' +
                    ", phonenum=" + phonenum +
                    ", role=" + role +
                    ", createTime=" + createTime +
                    ", updateTime=" + updateTime +
                    '}';
        }
    }

}
