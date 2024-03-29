package com.example.ergedd_android2.Contract;

import com.example.ergedd_android2.bean.BabyLookTabBean;


public interface BabyLookTabContract {
    interface BabyLookView {

        void onTabSuccess(BabyLookTabBean babyLookTabBeans);
       // void onSuccess(WxDataBean wxDataBean);

        void onFail(String msg);
    }


        interface BabyLookPresenter{
            void BabyLookHttp();
        }


        interface BabyLookModel{
            interface CallBack{
                void onTabSuccess(BabyLookTabBean babyLookTabBeans);
                //void onSuccess(WxDataBean wxDataBean);



                void onFail(String msg);
            }


            void getBabyLookData(CallBack callBack);
        }
}
