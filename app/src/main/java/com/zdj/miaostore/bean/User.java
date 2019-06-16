package com.zdj.miaostore.bean;

import java.io.Serializable;

public class User implements Serializable {

    @Override
    public String toString() {
        return "User{" +
                "code=" + code +
                ", msg=" + msg +
                ", data=" + data +
                '}';
    }

    /**
     * code : 200
     * msg : null
     * data : {"userId":65,"userPhone":"15607535217","userPassword":"zdj123","userImg":"/picture/head.png","username":"国产007","userAge":"100","userSex":"男","userDesc":"这个人很懒，什么都没有留下","userToken":"ae77451019c3554d2aed0d21872aac05"}
     */

    private int code;
    private Object msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "userId=" + userId +
                    ", userPhone='" + userPhone + '\'' +
                    ", userPassword='" + userPassword + '\'' +
                    ", userImg='" + userImg + '\'' +
                    ", username='" + username + '\'' +
                    ", userAge='" + userAge + '\'' +
                    ", userSex='" + userSex + '\'' +
                    ", userDesc='" + userDesc + '\'' +
                    ", userToken='" + userToken + '\'' +
                    '}';
        }

        /**
         * userId : 65
         * userPhone : 15607535217
         * userPassword : zdj123
         * userImg : /picture/head.png
         * username : 国产007
         * userAge : 100
         * userSex : 男
         * userDesc : 这个人很懒，什么都没有留下
         * userToken : ae77451019c3554d2aed0d21872aac05
         */


        private int userId;
        private String userPhone;
        private String userPassword;
        private String userImg;
        private String username;
        private String userAge;
        private String userSex;
        private String userDesc;
        private String userToken;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserPhone() {
            return userPhone;
        }

        public void setUserPhone(String userPhone) {
            this.userPhone = userPhone;
        }

        public String getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }

        public String getUserImg() {
            return userImg;
        }

        public void setUserImg(String userImg) {
            this.userImg = userImg;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUserAge() {
            return userAge;
        }

        public void setUserAge(String userAge) {
            this.userAge = userAge;
        }

        public String getUserSex() {
            return userSex;
        }

        public void setUserSex(String userSex) {
            this.userSex = userSex;
        }

        public String getUserDesc() {
            return userDesc;
        }

        public void setUserDesc(String userDesc) {
            this.userDesc = userDesc;
        }

        public String getUserToken() {
            return userToken;
        }

        public void setUserToken(String userToken) {
            this.userToken = userToken;
        }
    }
}
