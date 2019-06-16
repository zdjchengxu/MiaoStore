package com.zdj.miaostore.bean;

import java.util.List;

public class HomePageBean {


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
        private List<ListAdvBean> list_adv;
        private List<ListShopHotBean> list_shop_hot;
        private List<ListShopRecommendBean> list_shop_recommend;
        private List<ListShopBean> list_shop;

        public List<ListAdvBean> getList_adv() {
            return list_adv;
        }

        public void setList_adv(List<ListAdvBean> list_adv) {
            this.list_adv = list_adv;
        }

        public List<ListShopHotBean> getList_shop_hot() {
            return list_shop_hot;
        }

        public void setList_shop_hot(List<ListShopHotBean> list_shop_hot) {
            this.list_shop_hot = list_shop_hot;
        }

        public List<ListShopRecommendBean> getList_shop_recommend() {
            return list_shop_recommend;
        }

        public void setList_shop_recommend(List<ListShopRecommendBean> list_shop_recommend) {
            this.list_shop_recommend = list_shop_recommend;
        }

        public List<ListShopBean> getList_shop() {
            return list_shop;
        }

        public void setList_shop(List<ListShopBean> list_shop) {
            this.list_shop = list_shop;
        }

        public static class ListAdvBean {
            /**
             * advertisingId : 1
             * advertisingImg : /picture/a.jpg
             * advertisingType : 1
             */

            private int advertisingId;
            private String advertisingImg;
            private int advertisingType;

            public int getAdvertisingId() {
                return advertisingId;
            }

            public void setAdvertisingId(int advertisingId) {
                this.advertisingId = advertisingId;
            }

            public String getAdvertisingImg() {
                return advertisingImg;
            }

            public void setAdvertisingImg(String advertisingImg) {
                this.advertisingImg = advertisingImg;
            }

            public int getAdvertisingType() {
                return advertisingType;
            }

            public void setAdvertisingType(int advertisingType) {
                this.advertisingType = advertisingType;
            }
        }

        public static class ListShopHotBean {
            /**
             * shopId : 1
             * shopName : 懒人电竞椅
             * shopThumbnail : /picture/diy.jpg
             * shopPrice : 145
             * categoryId : 3
             * shopType : 2
             * shopDesc : 电竞椅游戏椅家用网吧电竞懒人椅主播吃鸡电脑椅人体工学椅子按摩
             * shopAddress : 海南
             * categoryName : 电脑椅
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

        public static class ListShopRecommendBean {
            /**
             * shopId : 7
             * shopName : 可叠落会议室椅培训椅简约现代会客椅办公接待洽谈凳子职员椅白色
             * shopThumbnail : /picture/cy.jpg
             * shopPrice : 110
             * categoryId : 3
             * shopType : 3
             * shopDesc : 可叠落会议室椅培训椅简约现代会客椅办公接待洽谈凳子职员椅白色
             * shopAddress : 海南
             * categoryName : 电脑椅
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

        public static class ListShopBean {
            /**
             * shopId : 1
             * shopName : 懒人电竞椅
             * shopThumbnail : /picture/diy.jpg
             * shopPrice : 145
             * categoryId : 3
             * shopType : 2
             * shopDesc : 电竞椅游戏椅家用网吧电竞懒人椅主播吃鸡电脑椅人体工学椅子按摩
             * shopAddress : 海南
             * categoryName : 电脑椅
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
