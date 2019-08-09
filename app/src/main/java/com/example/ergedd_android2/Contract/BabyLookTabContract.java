package com.example.ergedd_android2.Contract;

import com.example.ergedd_android2.bean.BabyLookTabBean;

import java.util.List;




public interface BabyLookTabContract {
    interface BabyLookView {

        void onTabSuccess(List<BabyLookTabBean> babyLookTabBeans);
       // void onSuccess(WxDataBean wxDataBean);

        void onFail(String msg);
    }


        interface BabyLookPresenter{
            void BabyLookHttp();
        }


        interface BabyLookModel{
            interface CallBack{
                void onTabSuccess(List<BabyLookTabBean> babyLookTabBeans);
                //void onSuccess(WxDataBean wxDataBean);



                void onFail(String msg);
            }


            void getBabyLookData(CallBack callBack);
        }
}
