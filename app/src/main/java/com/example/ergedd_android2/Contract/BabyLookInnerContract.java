package com.example.ergedd_android2.Contract;

import com.example.ergedd_android2.bean.BabyLookInnerBean;
import com.example.ergedd_android2.bean.BabyLookTabBean;


public interface BabyLookInnerContract {
    interface BabyLookView {

        void onInnerSuccess(BabyLookInnerBean babyLookInnerBean);
       // void onSuccess(WxDataBean wxDataBean);

        void onFail(String msg);
    }


        interface BabyLookPresenter{
            void BabyLookHttp();
        }


        interface BabyLookModel{
            interface CallBack{
                void onInnerSuccess(BabyLookInnerBean babyLookInnerBean);
                //void onSuccess(WxDataBean wxDataBean);



                void onFail(String msg);
            }


            void getBabyLookData(CallBack callBack);
        }
}
