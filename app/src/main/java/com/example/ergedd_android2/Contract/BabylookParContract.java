package com.example.ergedd_android2.Contract;

import com.example.ergedd_android2.bean.BabylookParBean;

public interface BabylookParContract {
    interface BabylookParView{
        void showSuccess(BabylookParBean data);
        void showError(String error);
    }
    interface BabylookParPresenter{
        void http(int id);
    }
    interface BabylookParModel{
        interface CallBack{
            void showSuccess(BabylookParBean data);
            void showError(String error);
        }
        void getData(int id,CallBack callBack);
    }
}
