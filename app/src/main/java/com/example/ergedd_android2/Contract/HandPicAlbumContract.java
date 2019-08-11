package com.example.ergedd_android2.Contract;

import com.example.ergedd_android2.bean.BabyLookTabBean;
import com.example.ergedd_android2.bean.HandPicAlbumBean;
import com.example.ergedd_android2.bean.HandPicBottomListBean;

import java.util.List;


public interface HandPicAlbumContract {
    interface HandPicAlbumView {

        void onSuccess( List<HandPicAlbumBean.DataBean> data);
        void onBottomSuccess( List<HandPicBottomListBean.DataBean> data);

        void onFail(String msg);
    }


        interface HandPicAlbumPresenter{
            void HandPicAlbumHttp();
        }


        interface HandPicAlbumModel{
            interface CallBack{
                void onSuccess( List<HandPicAlbumBean.DataBean> data);
                void onBottomSuccess( List<HandPicBottomListBean.DataBean> data);



                void onFail(String msg);
            }


            void getHandPicAlbumData(CallBack callBack);
        }
}
