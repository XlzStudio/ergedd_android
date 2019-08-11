package com.example.ergedd_android2.bean;

import java.util.List;

public class HandPicAlbumBean {

    /**
     * success : true
     * data : [{"id":245,"name":"流行歌曲","count":15,"image":"http://img5g22.ergedd.com/album/97_20170414114434_zgfc.jpg","description":"激发宝宝兴趣爱好，让宝宝成为时尚流行儿歌达人，在音乐中快乐成长。","square_image_url":"http://img5g22.ergedd.com/audio_playlist/32676900831_1495419112739.png","erge_square_img_url":""},{"id":257,"name":"睡前故事大全","count":82,"image":"http://img5g22.ergedd.com/album/116_20170414114440_tpvt.jpg","description":"专为哄宝宝睡觉准备，优美的故事语言，把宝宝带进甜蜜的梦乡。","square_image_url":"http://img5g22.ergedd.com/audio_playlist/88872158933_1493809852104.jpg","erge_square_img_url":""},{"id":183,"name":"性格培养故事","count":20,"image":"http://img5g22.ergedd.com/audio_playlist/183_20170413112650_phik.png","description":"来听听小故事吧，让些简单有趣的故事帮助给孩子树立良好的人格。","square_image_url":"http://img5g22.ergedd.com/audio_playlist/16701174224_1493809754226.jpg","erge_square_img_url":""},{"id":276,"name":"巴塔木儿歌","count":30,"image":"http://img5g22.ergedd.com/audio_playlist/77294775510_1493795959461.jpg","description":"打造学习英语新途径，最萌动感儿歌，最完美英汉结合，宝宝轻松磨耳朵。","square_image_url":"http://img5g22.ergedd.com/audio_playlist/98792568364_1493809977390.jpg","erge_square_img_url":""},{"id":337,"name":"365夜故事","count":122,"image":"http://img5g22.ergedd.com/audio_playlist/94614924815_1547020471720.jpg","description":"故事岛上故事多，故事超人讲故事。","square_image_url":"http://img5g22.ergedd.com/audio_playlist/72595351091_1547020474719.jpg","erge_square_img_url":""},{"id":340,"name":"经典英文儿歌","count":119,"image":"http://img5g22.ergedd.com/audio_playlist/87767684431_1547542738458.jpg","description":"磨耳朵的经典英文儿歌，宝宝英文启蒙的好伙伴。","square_image_url":"http://img5g22.ergedd.com/audio_playlist/46435836743_1547542742955.jpg","erge_square_img_url":""},{"id":351,"name":"声律启蒙","count":18,"image":"http://img5g22.ergedd.com/audio_playlist/88675429760_1550912226049.jpg","description":"最具中国风的启蒙读物，让宝宝在诵读中掌握声韵格律！","square_image_url":"http://img5g22.ergedd.com/audio_playlist/18854667761_1550912229595.jpg","erge_square_img_url":""},{"id":353,"name":"百变马丁","count":26,"image":"http://img5g22.ergedd.com/audio_playlist/92677582105_1552974615290.jpg","description":"7岁的小男孩马丁，每天早上醒来后，都会化身一个新的角色，从而开展一段完全不同的奇幻冒险的故事。","square_image_url":"http://img5g22.ergedd.com/audio_playlist/5858489635_1552974618547.jpg","erge_square_img_url":""}]
     * message : Get excellent audio playlist successfully.
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
         * id : 245
         * name : 流行歌曲
         * count : 15
         * image : http://img5g22.ergedd.com/album/97_20170414114434_zgfc.jpg
         * description : 激发宝宝兴趣爱好，让宝宝成为时尚流行儿歌达人，在音乐中快乐成长。
         * square_image_url : http://img5g22.ergedd.com/audio_playlist/32676900831_1495419112739.png
         * erge_square_img_url :
         */

        private int id;
        private String name;
        private int count;
        private String image;
        private String description;
        private String square_image_url;
        private String erge_square_img_url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSquare_image_url() {
            return square_image_url;
        }

        public void setSquare_image_url(String square_image_url) {
            this.square_image_url = square_image_url;
        }

        public String getErge_square_img_url() {
            return erge_square_img_url;
        }

        public void setErge_square_img_url(String erge_square_img_url) {
            this.erge_square_img_url = erge_square_img_url;
        }
    }
}
