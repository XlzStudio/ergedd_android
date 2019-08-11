package com.example.ergedd_android2.Contract;

import com.example.ergedd_android2.bean.BabyHearBean;

public interface BabyHearContract {
    interface BabyHearView{
        void showSuccess(BabyHearBean data);
        void showError(String error);
    }
    interface BabyHearPresenter{
        void http();
    }
    interface BabyHearModel{
        interface CallBack{
            void showSuccess(BabyHearBean data);
            void showError(String error);
        }
        void getData(CallBack callBack);
    }
}
