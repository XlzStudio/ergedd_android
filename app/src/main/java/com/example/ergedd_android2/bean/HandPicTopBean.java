package com.example.ergedd_android2.bean;

public class HandPicTopBean {

    /**
     * success : true
     * data : {"id":261,"name":"小猪佩奇","count":156,"image":"http://img5g22.ergedd.com/audio_playlist/34051731761_1493777604960.jpg","description":"风靡全球的可爱小猪，充满温情的家庭故事。保护宝宝视力，可以听的小猪佩奇哦~","square_image_url":"http://img5g22.ergedd.com/audio_playlist/66562931040_1493868622457.jpg","erge_square_img_url":""}
     * message : Get audio playlist successfully.
     */

    private boolean success;
    private DataBean data;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * id : 261
         * name : 小猪佩奇
         * count : 156
         * image : http://img5g22.ergedd.com/audio_playlist/34051731761_1493777604960.jpg
         * description : 风靡全球的可爱小猪，充满温情的家庭故事。保护宝宝视力，可以听的小猪佩奇哦~
         * square_image_url : http://img5g22.ergedd.com/audio_playlist/66562931040_1493868622457.jpg
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
