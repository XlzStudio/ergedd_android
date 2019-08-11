package com.example.ergedd_android2.presenter;

import com.example.ergedd_android2.Contract.BabyHearContract;
import com.example.ergedd_android2.base.BasePresenter;
import com.example.ergedd_android2.bean.BabyHearBean;
import com.example.ergedd_android2.model.BabyHearModel;

public class BabyHearPresenter<V extends BabyHearContract.BabyHearView> extends BasePresenter<V> implements BabyHearContract.BabyHearPresenter, BabyHearContract.BabyHearModel.CallBack {
    private BabyHearContract.BabyHearModel babyHearModel = new BabyHearModel();

    @Override
    public void http() {
        if (mView != null) {
            babyHearModel.getData(this);
        }
    }

    @Override
    public void showSuccess(BabyHearBean data) {
        mView.showSuccess(data);
    }

    @Override
    public void showError(String error) {
        mView.showError(error);
    }
}
