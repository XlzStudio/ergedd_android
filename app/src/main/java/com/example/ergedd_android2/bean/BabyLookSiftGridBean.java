package com.example.ergedd_android2.bean;

import java.util.List;

public class BabyLookSiftGridBean {

    /**
     * success : true
     * data : [{"id":514,"copyright_sensitive":0,"sensitive":0,"description":"海底世界大冒险","name":"海底小纵队","icon_url":"http://img5g22.ergedd.com/album/514_1548125393319.png","image_url":"http://img5g22.ergedd.com/album/514_1531906089603.jpg","erge_img_url":"","is_vip":2,"play_count":0,"status":1,"type":1,"video_count":26,"icon_b":"","publisher_name":"万达儿童-海底小纵队"},{"id":659,"copyright_sensitive":0,"sensitive":0,"description":"风靡全球的英语教学片","name":"爱探险的朵拉","icon_url":"http://img5g22.ergedd.com/album/659_1554979285069.png","image_url":"http://img5g22.ergedd.com/album/36118302384_1553502781888.jpg","erge_img_url":"","is_vip":2,"play_count":0,"status":1,"type":1,"video_count":40,"icon_b":"","publisher_name":"戎音广告"},{"id":562,"copyright_sensitive":0,"sensitive":0,"description":"跟着乐迪环游世界","name":"超级飞侠","icon_url":"http://img5g22.ergedd.com/album/562_1537873619600.png","image_url":"http://img5g22.ergedd.com/album/562_1545043168054.jpg","erge_img_url":"http://img5g22.ergedd.com/album/562_1544176901596.png","is_vip":2,"play_count":0,"status":1,"type":1,"video_count":26,"icon_b":"","publisher_name":"奥飞文化-奥飞"},{"id":28,"copyright_sensitive":0,"sensitive":0,"description":"中外经典绘本故事","name":"哈利讲故事","icon_url":"http://img5g22.ergedd.com/album/28_1492578758731.png","image_url":"http://img5g22.ergedd.com/album/28_1545204938210.jpg","erge_img_url":"","is_vip":2,"play_count":27951527,"status":1,"type":1,"video_count":60,"icon_b":"","publisher_name":"上海臻材-哈利儿歌"},{"id":601,"copyright_sensitive":0,"sensitive":0,"description":"玩玩具 学英语","name":"大眼兔玩具","icon_url":"http://img5g22.ergedd.com/album/601_1549004468535.png","image_url":"http://img5g22.ergedd.com/album/601_1548964153256.jpg","erge_img_url":"","is_vip":2,"play_count":0,"status":1,"type":1,"video_count":62,"icon_b":"","publisher_name":"萌宝教育"},{"id":677,"copyright_sensitive":0,"sensitive":0,"description":"家喻户晓的明星娃娃","name":"天线宝宝","icon_url":"http://img5g22.ergedd.com/album/677_1554979709643.png","image_url":"http://img5g22.ergedd.com/album/677_1554865452832.jpg","erge_img_url":"","is_vip":2,"play_count":0,"status":1,"type":1,"video_count":120,"icon_b":"","publisher_name":"DHX"},{"id":233,"copyright_sensitive":0,"sensitive":0,"description":"友谊的魔法","name":"小马宝莉","icon_url":"http://img5g22.ergedd.com/album/233_1547201586206.png","image_url":"http://img5g22.ergedd.com/album/233_1496835226736.jpg","erge_img_url":"","is_vip":2,"play_count":0,"status":1,"type":1,"video_count":65,"icon_b":"","publisher_name":"孩之宝"},{"id":663,"copyright_sensitive":0,"sensitive":0,"description":"关于成长和友谊的故事","name":"嗨！道奇","icon_url":"http://img5g22.ergedd.com/album/663_1554369595851.png","image_url":"http://img5g22.ergedd.com/album/663_1555483225051.jpg","erge_img_url":"","is_vip":2,"play_count":0,"status":1,"type":1,"video_count":51,"icon_b":"","publisher_name":"BBC"},{"id":33,"copyright_sensitive":0,"sensitive":0,"description":"粉红猪小妹的情商课","name":"小猪佩奇","icon_url":"http://img5g22.ergedd.com/album/33_1493977102106.png","image_url":"http://img5g22.ergedd.com/album/33_1500456911360.png","erge_img_url":"http://img5g22.ergedd.com/album/33_1544176577740.png","is_vip":2,"play_count":166123434,"status":1,"type":1,"video_count":156,"icon_b":null,"publisher_name":"山成十趣-小猪佩奇"},{"id":10,"copyright_sensitive":0,"sensitive":0,"description":"来学习纯正的英语吧","name":"巴塔木英文歌","icon_url":"http://img5g22.ergedd.com/album/10_1492578783440.png","image_url":"http://img5g22.ergedd.com/album/10_20170414114412_vatw.jpg","erge_img_url":"","is_vip":2,"play_count":18123096,"status":1,"type":1,"video_count":56,"icon_b":null,"publisher_name":"捷成华视-巴塔木"}]
     * message : Get albums for index recommendation successfully
     */

    private boolean success;
    private String message;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 514
         * copyright_sensitive : 0
         * sensitive : 0
         * description : 海底世界大冒险
         * name : 海底小纵队
         * icon_url : http://img5g22.ergedd.com/album/514_1548125393319.png
         * image_url : http://img5g22.ergedd.com/album/514_1531906089603.jpg
         * erge_img_url :
         * is_vip : 2
         * play_count : 0
         * status : 1
         * type : 1
         * video_count : 26
         * icon_b :
         * publisher_name : 万达儿童-海底小纵队
         */

        private int id;
        private int copyright_sensitive;
        private int sensitive;
        private String description;
        private String name;
        private String icon_url;
        private String image_url;
        private String erge_img_url;
        private int is_vip;
        private int play_count;
        private int status;
        private int type;
        private int video_count;
        private String icon_b;
        private String publisher_name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCopyright_sensitive() {
            return copyright_sensitive;
        }

        public void setCopyright_sensitive(int copyright_sensitive) {
            this.copyright_sensitive = copyright_sensitive;
        }

        public int getSensitive() {
            return sensitive;
        }

        public void setSensitive(int sensitive) {
            this.sensitive = sensitive;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon_url() {
            return icon_url;
        }

        public void setIcon_url(String icon_url) {
            this.icon_url = icon_url;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getErge_img_url() {
            return erge_img_url;
        }

        public void setErge_img_url(String erge_img_url) {
            this.erge_img_url = erge_img_url;
        }

        public int getIs_vip() {
            return is_vip;
        }

        public void setIs_vip(int is_vip) {
            this.is_vip = is_vip;
        }

        public int getPlay_count() {
            return play_count;
        }

        public void setPlay_count(int play_count) {
            this.play_count = play_count;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getVideo_count() {
            return video_count;
        }

        public void setVideo_count(int video_count) {
            this.video_count = video_count;
        }

        public String getIcon_b() {
            return icon_b;
        }

        public void setIcon_b(String icon_b) {
            this.icon_b = icon_b;
        }

        public String getPublisher_name() {
            return publisher_name;
        }

        public void setPublisher_name(String publisher_name) {
            this.publisher_name = publisher_name;
        }
    }
}
