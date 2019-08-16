package com.example.ergedd_android2.bean;

import java.util.List;

public class BabyFriendBean {

    /**
     * success : true
     * data : [{"id":436,"group":"brand_area","field":"20180207170111_nf0g","rank":"140","title":"宝狄与好友","url":"ergedd://album/398?type=brand","image_url":"http://img5g22.ergedd.com/admin/app_config/84672001395_1517995121121.png","image_url_width":"220","image_url_height":"220"},{"id":347,"group":"brand_area","field":"20170918135344_hj7v","rank":"120","title":"哈利","url":"ergedd://album/210?type=brand","image_url":"http://img5g22.ergedd.com/admin/app_config/88952043599_1505714054114.png","image_url_width":"220","image_url_height":"220"},{"id":346,"group":"brand_area","field":"20170918135247_ygyz","rank":"110","title":"网趣宝贝","url":"ergedd://album/211?type=brand","image_url":"http://img5g22.ergedd.com/admin/app_config/2934482350_1505714017624.png","image_url_width":"220","image_url_height":"220"},{"id":345,"group":"brand_area","field":"20170918135130_uynf","rank":"100","title":"Little Fox","url":"ergedd://album/3?type=brand","image_url":"http://img5g22.ergedd.com/admin/app_config/86967489642_1540370541858.png","image_url_width":"220","image_url_height":"220"},{"id":489,"group":"brand_area","field":"20190125113154_rlkl","rank":"95","title":"方块熊","url":"ergedd://album/537?type=brand","image_url":"http://img5g22.ergedd.com/admin/app_config/80378006177_1548387218676.png","image_url_width":"220","image_url_height":"220"},{"id":313,"group":"brand_area","field":"20170823152741_iejo","rank":"90","title":"熊孩子","url":"ergedd://album/225?type=brand","image_url":"http://img5g22.ergedd.com/admin/app_config/50820888419_1540369662188.png","image_url_width":"220","image_url_height":"220"},{"id":289,"group":"brand_area","field":"20170815143142_ysbm","rank":"85","title":"恰克大冒险","url":"ergedd://album/314?type=brand","image_url":"http://img5g22.ergedd.com/admin/app_config/95445574713_1502778735388.png","image_url_width":"220","image_url_height":"220"},{"id":487,"group":"brand_area","field":"20190125105905_rfk9","rank":"83","title":"千千简笔画","url":"ergedd://album/625?type=brand","image_url":"http://img5g22.ergedd.com/admin/app_config/95508318337_1564554758783.png","image_url_width":"220","image_url_height":"220"},{"id":312,"group":"brand_area","field":"20170823152649_zhiv","rank":"80","title":"蓝迪","url":"ergedd://album/231?type=brand","image_url":"http://img5g22.ergedd.com/admin/app_config/67125518145_1503473253827.png","image_url_width":"220","image_url_height":"220"},{"id":299,"group":"brand_area","field":"20170817211958_ab53","rank":"78","title":"变形金刚","url":"ergedd://album/232?type=brand","image_url":"http://img5g22.ergedd.com/admin/app_config/50966764995_1502976610653.png","image_url_width":"220","image_url_height":"220"},{"id":478,"group":"brand_area","field":"20181024145136_hhcn","rank":"75","title":"兔小贝","url":"ergedd://album/575?type=brand","image_url":"http://img5g22.ergedd.com/admin/app_config/88426948850_1540369462353.png","image_url_width":"220","image_url_height":"220"},{"id":301,"group":"brand_area","field":"20170817214453_kkik","rank":"60","title":"宝宝巴士","url":"ergedd://album/2?type=brand","image_url":"http://img5g22.ergedd.com/admin/app_config/30419069280_1502977546202.png","image_url_width":"220","image_url_height":"220"},{"id":485,"group":"brand_area","field":"20190125103256_bxwy","rank":"50","title":"海底小纵队","url":"ergedd://album/514?type=brand","image_url":"http://img5g22.ergedd.com/admin/app_config/30986457793_1548388595871.png","image_url_width":"220","image_url_height":"220"},{"id":512,"group":"brand_area","field":"20190419173600_avxp","rank":"40","title":"巴塔木儿歌","url":"ergedd://album/148?type=brand","image_url":"http://img5g22.ergedd.com/admin/app_config/81691087145_1555666648639.png","image_url_width":"200","image_url_height":"200"},{"id":288,"group":"brand_area","field":"20170815143052_tloe","rank":"30","title":"小马宝莉","url":"ergedd://album/233?type=brand","image_url":"http://img5g22.ergedd.com/admin/app_config/98742262619_1502778691414.png","image_url_width":"220","image_url_height":"220"},{"id":476,"group":"brand_area","field":"20181024142559_sqa8","rank":"24","title":"萌鸡小队","url":"ergedd://album/532?type=brand","image_url":"http://img5g22.ergedd.com/admin/app_config/54993895223_1540369434847.png","image_url_width":"220","image_url_height":"220"},{"id":474,"group":"brand_area","field":"20181024132109_fo9g","rank":"23","title":"超级飞侠","url":"ergedd://album/562?type=brand","image_url":"http://img5g22.ergedd.com/admin/app_config/74404405019_1540369407088.png","image_url_width":"220","image_url_height":"220"},{"id":287,"group":"brand_area","field":"20170815143018_z1wq","rank":"20","title":"汪汪队立大功","url":"ergedd://album/175?type=brand","image_url":"http://img5g22.ergedd.com/admin/app_config/12163168838_1540369757310.png","image_url_width":"220","image_url_height":"220"},{"id":286,"group":"brand_area","field":"20170815142336_npmp","rank":"10","title":"小猪佩奇","url":"ergedd://album/33?type=brand","image_url":"http://img5g22.ergedd.com/admin/app_config/68542299051_1502778612695.png","image_url_width":"220","image_url_height":"220"}]
     * message : Get app configs successfully
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
         * id : 436
         * group : brand_area
         * field : 20180207170111_nf0g
         * rank : 140
         * title : 宝狄与好友
         * url : ergedd://album/398?type=brand
         * image_url : http://img5g22.ergedd.com/admin/app_config/84672001395_1517995121121.png
         * image_url_width : 220
         * image_url_height : 220
         */

        private int id;
        private String group;
        private String field;
        private String rank;
        private String title;
        private String url;
        private String image_url;
        private String image_url_width;
        private String image_url_height;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getImage_url_width() {
            return image_url_width;
        }

        public void setImage_url_width(String image_url_width) {
            this.image_url_width = image_url_width;
        }

        public String getImage_url_height() {
            return image_url_height;
        }

        public void setImage_url_height(String image_url_height) {
            this.image_url_height = image_url_height;
        }
    }
}
