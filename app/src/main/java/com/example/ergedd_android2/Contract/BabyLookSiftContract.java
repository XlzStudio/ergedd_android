package com.example.ergedd_android2.Contract;

import com.example.ergedd_android2.bean.BabyLookSiftItemBean;
import com.example.ergedd_android2.bean.BabyLookSiftGridBean;
import com.example.ergedd_android2.bean.BabyLookSiftThreeImgBean;
import com.example.ergedd_android2.bean.BabyLookTabBean;


public interface BabyLookSiftContract {
    interface BabyLookView {

        void onImgSuccess(BabyLookSiftThreeImgBean babyLookSiftThreeImgBean);
        void onGridSuccess(BabyLookSiftGridBean babyLookGridBean);
        void onItemSuccess(BabyLookSiftItemBean babyLookSiftItemBean);
        void onFail(String msg);
    }


        interface BabyLookPresenter{
            void BabyLookHttp();
        }


        interface BabyLookModel{
            interface CallBack{
                void onImgSuccess(BabyLookSiftThreeImgBean babyLookSiftThreeImgBean);
                void onGridSuccess(BabyLookSiftGridBean babyLookGridBean);
                void onItemSuccess(BabyLookSiftItemBean babyLookSiftItemBean);


                void onFail(String msg);
            }


            void getBabyLookData(CallBack callBack);
        }
}
