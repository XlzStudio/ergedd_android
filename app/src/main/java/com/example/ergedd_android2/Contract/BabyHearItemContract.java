package com.example.ergedd_android2.Contract;

import com.example.ergedd_android2.bean.BabyHearItemBean;

public interface BabyHearItemContract {
    interface BabyHearItemView{
        void showSuccess(BabyHearItemBean data);
        void showError(String error);
    }
    interface BabyHearItemPresenter{
        void http(int id);
    }
    interface BabyHearItemModel{
        interface CallBack{
            void showSuccess(BabyHearItemBean data);
            void showError(String error);
        }
        void getData(int id,CallBack callBack);
    }
}
