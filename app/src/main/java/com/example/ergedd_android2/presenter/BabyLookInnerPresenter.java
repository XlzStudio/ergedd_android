package com.example.ergedd_android2.presenter;

import com.example.ergedd_android2.Contract.BabyLookInnerContract;
import com.example.ergedd_android2.base.BasePresenter;
import com.example.ergedd_android2.bean.BabyLookInnerBean;
import com.example.ergedd_android2.fragments.BabyLookInnerFragment;
import com.example.ergedd_android2.model.BabyLookInnerModel;

public class BabyLookInnerPresenter extends BasePresenter<BabyLookInnerFragment> implements BabyLookInnerContract.BabyLookPresenter{

    private final BabyLookInnerModel babyLookInnerModel;

    @Override
    public void BabyLookHttp() {

    }

    public BabyLookInnerPresenter() {
        babyLookInnerModel = new BabyLookInnerModel();
    }

    public void BabyLookHttp(int id) {
        babyLookInnerModel.getBabyLookData(new BabyLookInnerContract.BabyLookModel.CallBack() {
            @Override
            public void onInnerSuccess(BabyLookInnerBean babyLookInnerBean) {
                mView.onInnerSuccess(babyLookInnerBean);
            }

            @Override
            public void onFail(String msg) {
                mView.onFail(msg);
            }
        },id);
    }
}
