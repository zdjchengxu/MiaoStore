package com.zdj.miaostore.bean;

import java.util.List;

public class CategoryDataBean {

    @Override
    public String toString() {
        return "CategoryDataBean{" +
                "code=" + code +
                ", msg=" + msg +
                ", data=" + data +
                '}';
    }

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
                        "shopId=" + shopId +
                        ", shopName='" + shopName + '\'' +
                        ", shopThumbnail='" + shopThumbnail + '\'' +
                        ", shopPrice=" + shopPrice +
                        ", categoryId=" + categoryId +
                        ", shopType=" + shopType +
                        ", shopDesc='" + shopDesc + '\'' +
                        ", shopAddress='" + shopAddress + '\'' +
                        ", categoryName='" + categoryName + '\'' +
                        '}';
            }

            /**
             * shopId : 14
             * shopName : 二厂汽水含气碳酸饮料饮用水果味汽水6种口味混搭
             * shopThumbnail : /picture/gwyl.jpg
             * shopPrice : 46
             * categoryId : 2
             * shopType : 1
             * shopDesc : 二厂汽水含气碳酸饮料饮用水果味汽水6种口味混搭 275ml*6瓶
             * shopAddress : 海南
             * categoryName : 饮料
             */

            private int shopId;
            private String shopName;
            private String shopThumbnail;
            private double shopPrice;
            private int categoryId;
            private int shopType;
            private String shopDesc;
            private String shopAddress;
            private String categoryName;

            public int getShopId() {
                return shopId;
            }

            public void setShopId(int shopId) {
                this.shopId = shopId;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public String getShopThumbnail() {
                return shopThumbnail;
            }

            public void setShopThumbnail(String shopThumbnail) {
                this.shopThumbnail = shopThumbnail;
            }

            public double getShopPrice() {
                return shopPrice;
            }

            public void setShopPrice(double shopPrice) {
                this.shopPrice = shopPrice;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public int getShopType() {
                return shopType;
            }

            public void setShopType(int shopType) {
                this.shopType = shopType;
            }

            public String getShopDesc() {
                return shopDesc;
            }

            public void setShopDesc(String shopDesc) {
                this.shopDesc = shopDesc;
            }

            public String getShopAddress() {
                return shopAddress;
            }

            public void setShopAddress(String shopAddress) {
                this.shopAddress = shopAddress;
            }

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
            }
        }
    }
}
