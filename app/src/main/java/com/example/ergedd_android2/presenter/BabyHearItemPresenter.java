package com.example.ergedd_android2.presenter;

import com.example.ergedd_android2.Contract.BabyHearItemContract;
import com.example.ergedd_android2.base.BasePresenter;
import com.example.ergedd_android2.bean.BabyHearItemBean;
import com.example.ergedd_android2.model.BabyHearItemModel;

public class BabyHearItemPresenter<V extends BabyHearItemContract.BabyHearItemView> extends BasePresenter<V> implements BabyHearItemContract.BabyHearItemPresenter, BabyHearItemContract.BabyHearItemModel.CallBack {
    private BabyHearItemContract.BabyHearItemModel babyHearItemModel = new BabyHearItemModel();

    @Override
    public void http(int id) {
        if (mView != null) {
            babyHearItemModel.getData(id,this);
        }
    }

    @Override
    public void showSuccess(BabyHearItemBean data) {
        mView.showSuccess(data);
    }

    @Override
    public void showError(String error) {
        mView.showError(error);
    }
}
