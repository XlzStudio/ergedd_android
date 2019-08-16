package com.example.ergedd_android2.presenter;

import com.example.ergedd_android2.Contract.BabyFriendContract;
import com.example.ergedd_android2.Contract.HandPicAlbumContract;
import com.example.ergedd_android2.base.BasePresenter;
import com.example.ergedd_android2.bean.BabyFriendBean;
import com.example.ergedd_android2.bean.HandPicAlbumBean;
import com.example.ergedd_android2.bean.HandPicBottomListBean;
import com.example.ergedd_android2.model.BabyFriendModel;
import com.example.ergedd_android2.model.HandPicModel;

import java.util.List;

public class BabyFriendPresenter<V extends BabyFriendContract.BabyFriendView>
        extends BasePresenter<V> implements BabyFriendContract.BabyFriendPresenter {

    @Override
    public void http() {
        BabyFriendModel babyFriendModel = new BabyFriendModel();
        babyFriendModel.getData(new BabyFriendContract.BabyFriendModel.CallBack() {
            @Override
            public void showSuccess(BabyFriendBean data) {
                mView.showSuccess(data);
            }

            @Override
            public void showError(String error) {

            }
        });
    }
}
