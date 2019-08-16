package com.example.ergedd_android2.Contract;

import com.example.ergedd_android2.bean.BabyFriendBean;
import com.example.ergedd_android2.bean.BabyHearBean;

public interface BabyFriendContract {
    interface BabyFriendView{
        void showSuccess(BabyFriendBean data);
        void showError(String error);
    }
    interface BabyFriendPresenter{
        void http();
    }
    interface BabyFriendModel{
        interface CallBack{
            void showSuccess(BabyFriendBean data);
            void showError(String error);
        }
        void getData(CallBack callBack);
    }
}
