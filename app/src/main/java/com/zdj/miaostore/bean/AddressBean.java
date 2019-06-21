package com.zdj.miaostore.bean;

import java.util.List;

public class AddressBean {


    /**
     * code : 200
     * msg : null
     * data : {"list":[{"addressId":78,"addressName":"海南省琼海市嘉积镇富海路158号","addressDesc":"zdj添加的地址测试","addressPhone":"15607535217","addressUserName":"赵","addressType":1,"userId":67}]}
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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * addressId : 78
             * addressName : 海南省琼海市嘉积镇富海路158号
             * addressDesc : zdj添加的地址测试
             * addressPhone : 15607535217
             * addressUserName : 赵
             * addressType : 1
             * userId : 67
             */

            private int addressId;
            private String addressName;
            private String addressDesc;
            private String addressPhone;
            private String addressUserName;
            private int addressType;
            private int userId;

            public int getAddressId() {
                return addressId;
            }

            public void setAddressId(int addressId) {
                this.addressId = addressId;
            }

            public String getAddressName() {
                return addressName;
            }

            public void setAddressName(String addressName) {
                this.addressName = addressName;
            }

            public String getAddressDesc() {
                return addressDesc;
            }

            public void setAddressDesc(String addressDesc) {
                this.addressDesc = addressDesc;
            }

            public String getAddressPhone() {
                return addressPhone;
            }

            public void setAddressPhone(String addressPhone) {
                this.addressPhone = addressPhone;
            }

            public String getAddressUserName() {
                return addressUserName;
            }

            public void setAddressUserName(String addressUserName) {
                this.addressUserName = addressUserName;
            }

            public int getAddressType() {
                return addressType;
            }

            public void setAddressType(int addressType) {
                this.addressType = addressType;
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
