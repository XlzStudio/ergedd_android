package com.example.ergedd_android2.Contract;

import com.example.ergedd_android2.bean.CommentWriteBean;

public interface CommentWriteContract {
    interface CommentWriteView{
        void showSuccess(CommentWriteBean data);
        void showError(String error);
    }
    interface CommentWritePresenter{
        void http(int id);
    }
    interface CommentWriteModel{
        interface CallBack{
            void showSuccess(CommentWriteBean data);
            void showError(String error);
        }
        void getData(int id,CallBack callBack);
    }
}
