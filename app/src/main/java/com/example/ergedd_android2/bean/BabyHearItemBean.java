package com.example.ergedd_android2.bean;

import java.util.List;

public class BabyHearItemBean {

    /**
     * success : true
     * data : [{"id":339,"name":"跟着胖河马唱儿歌","count":30,"image":"http://img5g22.ergedd.com/audio_playlist/98335096936_1547541448246.jpg","description":"超好听的经典英文儿歌全在这儿","square_image_url":"http://img5g22.ergedd.com/audio_playlist/64426795367_1550764431554.jpg","erge_square_img_url":""},{"id":282,"name":"奇妙英文歌","count":98,"image":"http://img5g22.ergedd.com/audio_playlist/64534903031_1493809918521.jpg","description":"宝宝巴士发车喽，海量英文儿歌，快来跟着奇奇妙妙一起唱吧！","square_image_url":"http://img5g22.ergedd.com/audio_playlist/65686393900_1550765110944.jpg","erge_square_img_url":""},{"id":281,"name":"巴塔木英文歌","count":36,"image":"http://img5g22.ergedd.com/audio_playlist/28740805516_1493809758681.jpg","description":"简单易学的巴塔木儿歌，英汉结合让宝宝轻松磨耳朵，快乐学英语~","square_image_url":"http://img5g22.ergedd.com/audio_playlist/11128563776_1550764601170.jpg","erge_square_img_url":""},{"id":284,"name":"睡前英文儿歌","count":19,"image":"http://img5g22.ergedd.com/audio_playlist/19509790348_1493810319879.jpg","description":"精选动听英文歌，悠扬舒缓旋律，陪伴宝宝甜蜜入睡。","square_image_url":"http://img5g22.ergedd.com/audio_playlist/46908212471_1493811123948.jpg","erge_square_img_url":""},{"id":340,"name":"经典英文儿歌","count":119,"image":"http://img5g22.ergedd.com/audio_playlist/87767684431_1547542738458.jpg","description":"磨耳朵的经典英文儿歌，宝宝英文启蒙的好伙伴。","square_image_url":"http://img5g22.ergedd.com/audio_playlist/46435836743_1547542742955.jpg","erge_square_img_url":""},{"id":103,"name":"英文儿歌","count":91,"image":"http://img5g22.ergedd.com/audio_playlist/103_20170413112648_g9du.jpg","description":"学英语，从儿歌开始。精选不同风格英文儿歌，让宝宝新鲜不断，轻松学英语！","square_image_url":"http://img5g22.ergedd.com/audio_playlist/97863393958_1493881689801.jpg","erge_square_img_url":""},{"id":338,"name":"手指家族","count":31,"image":"http://img5g22.ergedd.com/audio_playlist/57346360551_1547461400473.jpg","description":"动动手指学英文，经典英文童谣Finger Family","square_image_url":"http://img5g22.ergedd.com/audio_playlist/17413388600_1547461404162.jpg","erge_square_img_url":""},{"id":283,"name":"哈利学字母","count":26,"image":"http://img5g22.ergedd.com/audio_playlist/42571665009_1493810124425.jpg","description":"哈利学前班开课了！快来跟着哈利一起，成为英语小达人吧","square_image_url":"http://img5g22.ergedd.com/audio_playlist/50085708987_1493811104598.jpg","erge_square_img_url":""},{"id":280,"name":"日常用语歌","count":13,"image":"http://img5g22.ergedd.com/audio_playlist/25677143473_1493809554944.jpg","description":"贴近生活场景，激发宝宝兴趣，让宝宝轻松学会基本英语会话。","square_image_url":"http://img5g22.ergedd.com/audio_playlist/43771440384_1493811175225.jpg","erge_square_img_url":""},{"id":334,"name":"鹅妈妈传统童谣","count":70,"image":"http://img5g22.ergedd.com/audio_playlist/71374144974_1545123705227.jpg","description":"赶快和孩子一起唱起来，走进古老童谣的世界吧~","square_image_url":"http://img5g22.ergedd.com/audio_playlist/78180601592_1545123709751.jpg","erge_square_img_url":""},{"id":333,"name":"一起来唱歌","count":60,"image":"http://img5g22.ergedd.com/audio_playlist/60276682610_1545120408203.jpg","description":"让孩子从小就有和声体验，享受唱歌的乐趣！","square_image_url":"http://img5g22.ergedd.com/audio_playlist/2958537315_1545120412637.jpg","erge_square_img_url":""},{"id":332,"name":"经典英文童谣","count":46,"image":"http://img5g22.ergedd.com/audio_playlist/35535175210_1545118210273.jpg","description":"在学习歌曲的潜移默化中，不知不觉学会了英文句子，真正做到寓教于乐！","square_image_url":"http://img5g22.ergedd.com/audio_playlist/87863468679_1545118214315.jpg","erge_square_img_url":""},{"id":324,"name":"圣诞欢乐颂","count":55,"image":"http://img5g22.ergedd.com/audio_playlist/80328192494_1542710323024.jpg","description":"充满节日气氛的圣诞，怎么能少得了圣诞歌曲呢，快来一起学唱圣诞歌谣吧！","square_image_url":"http://img5g22.ergedd.com/audio_playlist/9994789995_1542710327402.jpg","erge_square_img_url":""},{"id":256,"name":"欧美经典儿歌","count":52,"image":"http://img5g22.ergedd.com/album/4_20170414114410_0q23.jpg","description":"传唱不息的欧美经典旋律，宝宝最好的英语儿歌，让宝宝快乐学英语！","square_image_url":"http://img5g22.ergedd.com/audio_playlist/42043038704_1493811052625.jpg","erge_square_img_url":""}]
     * message : Get audio playlist of category successfully.
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
         * id : 339
         * name : 跟着胖河马唱儿歌
         * count : 30
         * image : http://img5g22.ergedd.com/audio_playlist/98335096936_1547541448246.jpg
         * description : 超好听的经典英文儿歌全在这儿
         * square_image_url : http://img5g22.ergedd.com/audio_playlist/64426795367_1550764431554.jpg
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
