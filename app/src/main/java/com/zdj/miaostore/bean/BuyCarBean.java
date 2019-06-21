package com.zdj.miaostore.bean;

import java.util.List;

public class BuyCarBean {

    @Override
    public String toString() {
        return "BuyCarBean{" +
                "code=" + code +
                ", msg=" + msg +
                ", data=" + data +
                '}';
    }

    /**
     * code : 200
     * msg : null
     * data : {"list":[{"shoppcardbaseId":"5b0aea40eb03463e98fe7c852cd853bf","shoppcardbaseSum":1,"shoppcardbaseTime":1560773091,"shopId":14,"userId":66}]}
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
                    "list=" + list +
                    '}';
        }

        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {

            @Override
            public String toString() {
                return "ListBean{" +
                        "shoppcardbaseId='" + shoppcardbaseId + '\'' +
                        ", shoppcardbaseSum=" + shoppcardbaseSum +
                        ", shoppcardbaseTime=" + shoppcardbaseTime +
                        ", shopId=" + shopId +
                        ", userId=" + userId +
                        '}';
            }

            /**
             * shoppcardbaseId : 5b0aea40eb03463e98fe7c852cd853bf
             * shoppcardbaseSum : 1
             * shoppcardbaseTime : 1560773091
             * shopId : 14
             * userId : 66
             */

            private String shoppcardbaseId;
            private int shoppcardbaseSum;
            private int shoppcardbaseTime;
            private int shopId;
            private int userId;

            public String getShoppcardbaseId() {
                return shoppcardbaseId;
            }

            public void setShoppcardbaseId(String shoppcardbaseId) {
                this.shoppcardbaseId = shoppcardbaseId;
            }

            public int getShoppcardbaseSum() {
                return shoppcardbaseSum;
            }

            public void setShoppcardbaseSum(int shoppcardbaseSum) {
                this.shoppcardbaseSum = shoppcardbaseSum;
            }

            public int getShoppcardbaseTime() {
                return shoppcardbaseTime;
            }

            public void setShoppcardbaseTime(int shoppcardbaseTime) {
                this.shoppcardbaseTime = shoppcardbaseTime;
            }

            public int getShopId() {
                return shopId;
            }

            public void setShopId(int shopId) {
                this.shopId = shopId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }
        }
    }
}
