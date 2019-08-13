package com.example.ergedd_android2.presenter;

import com.example.ergedd_android2.Contract.HandPicAlbumContract;
import com.example.ergedd_android2.Contract.HandPicDetailContract;
import com.example.ergedd_android2.activitys.HandPicDetailActivity;
import com.example.ergedd_android2.base.BasePresenter;
import com.example.ergedd_android2.bean.HandPicAlbumBean;
import com.example.ergedd_android2.bean.HandPicBottomListBean;
import com.example.ergedd_android2.bean.HandPicDetailBean;
import com.example.ergedd_android2.model.HandPicDetailsModel;
import com.example.ergedd_android2.model.HandPicModel;

import java.util.List;

public class HandPickDetailPresenter<V extends HandPicDetailContract.HandPicDetailView>
        extends BasePresenter<V> implements HandPicDetailContract.HandPicDetailPresenter {

    private HandPicDetailsModel model=  new HandPicDetailsModel();

    @Override
    public void HandPicDetailHttp(int id) {
        model.getHandPicDetailData(id, new HandPicDetailContract.HandPicDetailModel.CallBack() {
            @Override
            public void onSuccess(List<HandPicDetailBean.RecordBean.AudiosBean> audios) {
                mView.onSuccess(audios);
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
