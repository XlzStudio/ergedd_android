package com.example.ergedd_android2.presenter;

import com.example.ergedd_android2.Contract.HandPicAlbumContract;
import com.example.ergedd_android2.base.BasePresenter;
import com.example.ergedd_android2.bean.BabyLookTabBean;
import com.example.ergedd_android2.bean.HandPicAlbumBean;
import com.example.ergedd_android2.bean.HandPicBottomListBean;
import com.example.ergedd_android2.model.BabyLookModel;
import com.example.ergedd_android2.model.HandPicModel;

import java.util.List;

public class HandPickPresenter<V extends HandPicAlbumContract.HandPicAlbumView>
        extends BasePresenter<V> implements HandPicAlbumContract.HandPicAlbumPresenter{
  private   HandPicModel handPicModel = new HandPicModel();
    @Override
    public void HandPicAlbumHttp() {

        handPicModel.getHandPicAlbumData(new HandPicAlbumContract.HandPicAlbumModel.CallBack() {
            @Override
            public void onSuccess(List<HandPicAlbumBean.DataBean> data) {
                mView.onSuccess(data);
            }

            @Override
            public void onBottomSuccess(List<HandPicBottomListBean.DataBean> data) {
                mView.onBottomSuccess(data);
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
