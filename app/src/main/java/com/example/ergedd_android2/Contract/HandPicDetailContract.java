package com.example.ergedd_android2.Contract;

import com.example.ergedd_android2.bean.HandPicAlbumBean;
import com.example.ergedd_android2.bean.HandPicBottomListBean;
import com.example.ergedd_android2.bean.HandPicDetailBean;

import java.util.List;


public interface HandPicDetailContract {
    interface HandPicDetailView {

        void onSuccess(List<HandPicDetailBean.RecordBean.AudiosBean> audios);

        void onFail(String msg);
    }


        interface HandPicDetailPresenter{
            void HandPicDetailHttp(int id);
        }


        interface HandPicDetailModel{
            interface CallBack{
                void onSuccess(List<HandPicDetailBean.RecordBean.AudiosBean> audios);



                void onFail(String msg);
            }


            void getHandPicDetailData(int id,CallBack callBack);
        }
}
