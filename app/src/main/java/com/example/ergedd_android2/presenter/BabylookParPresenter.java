package com.example.ergedd_android2.presenter;

import com.example.ergedd_android2.Contract.BabylookParContract;
import com.example.ergedd_android2.base.BasePresenter;
import com.example.ergedd_android2.bean.BabylookParBean;
import com.example.ergedd_android2.model.BabylookParModel;

public class BabylookParPresenter<V extends BabylookParContract.BabylookParView> extends BasePresenter<V> implements BabylookParContract.BabylookParPresenter, BabylookParContract.BabylookParModel.CallBack {
    private BabylookParContract.BabylookParModel babylookParModel = new BabylookParModel();

    @Override
    public void http(int id) {
        babylookParModel.getData(id, this);
    }

    @Override
    public void showSuccess(BabylookParBean data) {
        mView.showSuccess(data);
    }

    @Override
    public void showError(String error) {
        mView.showError(error);
    }
}
