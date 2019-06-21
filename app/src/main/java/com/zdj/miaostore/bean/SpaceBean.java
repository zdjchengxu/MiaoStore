package com.zdj.miaostore.bean;

import java.util.List;

public class SpaceBean {


    /**
     * code : 200
     * msg : null
     * data : {"list":[{"spaceId":"90389d42c3464adc9120f4f7f12d9aa2","spaceTile":"电脑数码","spaceContent":"只能说","spaceTime":1560912789,"spaceType":1,"sapceSecondUser":0,"sapceThreeUser":0,"userId":7,"spaceRepleId":null,"userBase":{"userId":7,"userPhone":"12345678901","userPassword":"123456","userImg":"/picture/1560326276128.jpg","username":"国产007","userAge":"22","userSex":"男","userDesc":"22","userToken":"1d21f6aedd097dd97cd35604e8455428"},"list_img":[{"spaceImgId":25,"spaceImgPath":"/picture/1560912789853.jpg","spaceId":"90389d42c3464adc9120f4f7f12d9aa2"}],"list_reply":[{"spaceId":"d79f9ddad00c45c2b5e13b02425d2b49","spaceTile":null,"spaceContent":"室内设计","spaceTime":1560909246,"spaceType":2,"sapceSecondUser":7,"sapceThreeUser":0,"userId":0,"spaceRepleId":"21608983505d462c846e7a6ee2950e9b","userBase":null,"list_img":null,"list_reply":null,"userBaseSecoundUser":{"userId":7,"userPhone":"12345678901","userPassword":"123456","userImg":"/picture/1560326276128.jpg","username":"国产007","userAge":"22","userSex":"男","userDesc":"22","userToken":"1d21f6aedd097dd97cd35604e8455428"},"userBaseThreeUser":{"userId":62,"userPhone":"18507514908","userPassword":"00000000","userImg":"/picture/1560782465355.png","username":"Phoenix","userAge":"12","userSex":"男","userDesc":"PHL","userToken":"b8a82605dbe6d7929d6a1169f02ac377"}}],"userBaseSecoundUser":{"userId":7,"userPhone":"12345678901","userPassword":"123456","userImg":"/picture/1560326276128.jpg","username":"国产007","userAge":"22","userSex":"男","userDesc":"22","userToken":"1d21f6aedd097dd97cd35604e8455428"},"userBaseThreeUser":{"userId":62,"userPhone":"18507514908","userPassword":"00000000","userImg":"/picture/1560782465355.png","username":"Phoenix","userAge":"12","userSex":"男","userDesc":"PHL","userToken":"b8a82605dbe6d7929d6a1169f02ac377"}}]}
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
             * spaceId : 90389d42c3464adc9120f4f7f12d9aa2
             * spaceTile : 电脑数码
             * spaceContent : 只能说
             * spaceTime : 1560912789
             * spaceType : 1
             * sapceSecondUser : 0
             * sapceThreeUser : 0
             * userId : 7
             * spaceRepleId : null
             * userBase : {"userId":7,"userPhone":"12345678901","userPassword":"123456","userImg":"/picture/1560326276128.jpg","username":"国产007","userAge":"22","userSex":"男","userDesc":"22","userToken":"1d21f6aedd097dd97cd35604e8455428"}
             * list_img : [{"spaceImgId":25,"spaceImgPath":"/picture/1560912789853.jpg","spaceId":"90389d42c3464adc9120f4f7f12d9aa2"}]
             * list_reply : [{"spaceId":"d79f9ddad00c45c2b5e13b02425d2b49","spaceTile":null,"spaceContent":"室内设计","spaceTime":1560909246,"spaceType":2,"sapceSecondUser":7,"sapceThreeUser":0,"userId":0,"spaceRepleId":"21608983505d462c846e7a6ee2950e9b","userBase":null,"list_img":null,"list_reply":null,"userBaseSecoundUser":{"userId":7,"userPhone":"12345678901","userPassword":"123456","userImg":"/picture/1560326276128.jpg","username":"国产007","userAge":"22","userSex":"男","userDesc":"22","userToken":"1d21f6aedd097dd97cd35604e8455428"},"userBaseThreeUser":{"userId":62,"userPhone":"18507514908","userPassword":"00000000","userImg":"/picture/1560782465355.png","username":"Phoenix","userAge":"12","userSex":"男","userDesc":"PHL","userToken":"b8a82605dbe6d7929d6a1169f02ac377"}}]
             * userBaseSecoundUser : {"userId":7,"userPhone":"12345678901","userPassword":"123456","userImg":"/picture/1560326276128.jpg","username":"国产007","userAge":"22","userSex":"男","userDesc":"22","userToken":"1d21f6aedd097dd97cd35604e8455428"}
             * userBaseThreeUser : {"userId":62,"userPhone":"18507514908","userPassword":"00000000","userImg":"/picture/1560782465355.png","username":"Phoenix","userAge":"12","userSex":"男","userDesc":"PHL","userToken":"b8a82605dbe6d7929d6a1169f02ac377"}
             */

            private String spaceId;
            private String spaceTile;
            private String spaceContent;
            private int spaceTime;
            private int spaceType;
            private int sapceSecondUser;
            private int sapceThreeUser;
            private int userId;
            private Object spaceRepleId;
            private UserBaseBean userBase;
            private UserBaseSecoundUserBean userBaseSecoundUser;
            private UserBaseThreeUserBean userBaseThreeUser;
            private List<ListImgBean> list_img;
            private List<ListReplyBean> list_reply;

            public String getSpaceId() {
                return spaceId;
            }

            public void setSpaceId(String spaceId) {
                this.spaceId = spaceId;
            }

            public String getSpaceTile() {
                return spaceTile;
            }

            public void setSpaceTile(String spaceTile) {
                this.spaceTile = spaceTile;
            }

            public String getSpaceContent() {
                return spaceContent;
            }

            public void setSpaceContent(String spaceContent) {
                this.spaceContent = spaceContent;
            }

            public int getSpaceTime() {
                return spaceTime;
            }

            public void setSpaceTime(int spaceTime) {
                this.spaceTime = spaceTime;
            }

            public int getSpaceType() {
                return spaceType;
            }

            public void setSpaceType(int spaceType) {
                this.spaceType = spaceType;
            }

            public int getSapceSecondUser() {
                return sapceSecondUser;
            }

            public void setSapceSecondUser(int sapceSecondUser) {
                this.sapceSecondUser = sapceSecondUser;
            }

            public int getSapceThreeUser() {
                return sapceThreeUser;
            }

            public void setSapceThreeUser(int sapceThreeUser) {
                this.sapceThreeUser = sapceThreeUser;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public Object getSpaceRepleId() {
                return spaceRepleId;
            }

            public void setSpaceRepleId(Object spaceRepleId) {
                this.spaceRepleId = spaceRepleId;
            }

            public UserBaseBean getUserBase() {
                return userBase;
            }

            public void setUserBase(UserBaseBean userBase) {
                this.userBase = userBase;
            }

            public UserBaseSecoundUserBean getUserBaseSecoundUser() {
                return userBaseSecoundUser;
            }

            public void setUserBaseSecoundUser(UserBaseSecoundUserBean userBaseSecoundUser) {
                this.userBaseSecoundUser = userBaseSecoundUser;
            }

            public UserBaseThreeUserBean getUserBaseThreeUser() {
                return userBaseThreeUser;
            }

            public void setUserBaseThreeUser(UserBaseThreeUserBean userBaseThreeUser) {
                this.userBaseThreeUser = userBaseThreeUser;
            }

            public List<ListImgBean> getList_img() {
                return list_img;
            }

            public void setList_img(List<ListImgBean> list_img) {
                this.list_img = list_img;
            }

            public List<ListReplyBean> getList_reply() {
                return list_reply;
            }

            public void setList_reply(List<ListReplyBean> list_reply) {
                this.list_reply = list_reply;
            }

            public static class UserBaseBean {
                /**
                 * userId : 7
                 * userPhone : 12345678901
                 * userPassword : 123456
                 * userImg : /picture/1560326276128.jpg
                 * username : 国产007
                 * userAge : 22
                 * userSex : 男
                 * userDesc : 22
                 * userToken : 1d21f6aedd097dd97cd35604e8455428
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

            public static class UserBaseSecoundUserBean {
                /**
                 * userId : 7
                 * userPhone : 12345678901
                 * userPassword : 123456
                 * userImg : /picture/1560326276128.jpg
                 * username : 国产007
                 * userAge : 22
                 * userSex : 男
                 * userDesc : 22
                 * userToken : 1d21f6aedd097dd97cd35604e8455428
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

            public static class UserBaseThreeUserBean {
                /**
                 * userId : 62
                 * userPhone : 18507514908
                 * userPassword : 00000000
                 * userImg : /picture/1560782465355.png
                 * username : Phoenix
                 * userAge : 12
                 * userSex : 男
                 * userDesc : PHL
                 * userToken : b8a82605dbe6d7929d6a1169f02ac377
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

            public static class ListImgBean {
                /**
                 * spaceImgId : 25
                 * spaceImgPath : /picture/1560912789853.jpg
                 * spaceId : 90389d42c3464adc9120f4f7f12d9aa2
                 */

                private int spaceImgId;
                private String spaceImgPath;
                private String spaceId;

                public int getSpaceImgId() {
                    return spaceImgId;
                }

                public void setSpaceImgId(int spaceImgId) {
                    this.spaceImgId = spaceImgId;
                }

                public String getSpaceImgPath() {
                    return spaceImgPath;
                }

                public void setSpaceImgPath(String spaceImgPath) {
                    this.spaceImgPath = spaceImgPath;
                }

                public String getSpaceId() {
                    return spaceId;
                }

                public void setSpaceId(String spaceId) {
                    this.spaceId = spaceId;
                }
            }

            public static class ListReplyBean {
                /**
                 * spaceId : d79f9ddad00c45c2b5e13b02425d2b49
                 * spaceTile : null
                 * spaceContent : 室内设计
                 * spaceTime : 1560909246
                 * spaceType : 2
                 * sapceSecondUser : 7
                 * sapceThreeUser : 0
                 * userId : 0
                 * spaceRepleId : 21608983505d462c846e7a6ee2950e9b
                 * userBase : null
                 * list_img : null
                 * list_reply : null
                 * userBaseSecoundUser : {"userId":7,"userPhone":"12345678901","userPassword":"123456","userImg":"/picture/1560326276128.jpg","username":"国产007","userAge":"22","userSex":"男","userDesc":"22","userToken":"1d21f6aedd097dd97cd35604e8455428"}
                 * userBaseThreeUser : {"userId":62,"userPhone":"18507514908","userPassword":"00000000","userImg":"/picture/1560782465355.png","username":"Phoenix","userAge":"12","userSex":"男","userDesc":"PHL","userToken":"b8a82605dbe6d7929d6a1169f02ac377"}
                 */

                private String spaceId;
                private Object spaceTile;
                private String spaceContent;
                private int spaceTime;
                private int spaceType;
                private int sapceSecondUser;
                private int sapceThreeUser;
                private int userId;
                private String spaceRepleId;
                private Object userBase;
                private Object list_img;
                private Object list_reply;
                private UserBaseSecoundUserBeanX userBaseSecoundUser;
                private UserBaseThreeUserBeanX userBaseThreeUser;

                public String getSpaceId() {
                    return spaceId;
                }

                public void setSpaceId(String spaceId) {
                    this.spaceId = spaceId;
                }

                public Object getSpaceTile() {
                    return spaceTile;
                }

                public void setSpaceTile(Object spaceTile) {
                    this.spaceTile = spaceTile;
                }

                public String getSpaceContent() {
                    return spaceContent;
                }

                public void setSpaceContent(String spaceContent) {
                    this.spaceContent = spaceContent;
                }

                public int getSpaceTime() {
                    return spaceTime;
                }

                public void setSpaceTime(int spaceTime) {
                    this.spaceTime = spaceTime;
                }

                public int getSpaceType() {
                    return spaceType;
                }

                public void setSpaceType(int spaceType) {
                    this.spaceType = spaceType;
                }

                public int getSapceSecondUser() {
                    return sapceSecondUser;
                }

                public void setSapceSecondUser(int sapceSecondUser) {
                    this.sapceSecondUser = sapceSecondUser;
                }

                public int getSapceThreeUser() {
                    return sapceThreeUser;
                }

                public void setSapceThreeUser(int sapceThreeUser) {
                    this.sapceThreeUser = sapceThreeUser;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public String getSpaceRepleId() {
                    return spaceRepleId;
                }

                public void setSpaceRepleId(String spaceRepleId) {
                    this.spaceRepleId = spaceRepleId;
                }

                public Object getUserBase() {
                    return userBase;
                }

                public void setUserBase(Object userBase) {
                    this.userBase = userBase;
                }

                public Object getList_img() {
                    return list_img;
                }

                public void setList_img(Object list_img) {
                    this.list_img = list_img;
                }

                public Object getList_reply() {
                    return list_reply;
                }

                public void setList_reply(Object list_reply) {
                    this.list_reply = list_reply;
                }

                public UserBaseSecoundUserBeanX getUserBaseSecoundUser() {
                    return userBaseSecoundUser;
                }

                public void setUserBaseSecoundUser(UserBaseSecoundUserBeanX userBaseSecoundUser) {
                    this.userBaseSecoundUser = userBaseSecoundUser;
                }

                public UserBaseThreeUserBeanX getUserBaseThreeUser() {
                    return userBaseThreeUser;
                }

                public void setUserBaseThreeUser(UserBaseThreeUserBeanX userBaseThreeUser) {
                    this.userBaseThreeUser = userBaseThreeUser;
                }

                public static class UserBaseSecoundUserBeanX {
                    /**
                     * userId : 7
                     * userPhone : 12345678901
                     * userPassword : 123456
                     * userImg : /picture/1560326276128.jpg
                     * username : 国产007
                     * userAge : 22
                     * userSex : 男
                     * userDesc : 22
                     * userToken : 1d21f6aedd097dd97cd35604e8455428
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

                public static class UserBaseThreeUserBeanX {
                    /**
                     * userId : 62
                     * userPhone : 18507514908
                     * userPassword : 00000000
                     * userImg : /picture/1560782465355.png
                     * username : Phoenix
                     * userAge : 12
                     * userSex : 男
                     * userDesc : PHL
                     * userToken : b8a82605dbe6d7929d6a1169f02ac377
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
        }
    }
}
