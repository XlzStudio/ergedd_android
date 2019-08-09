package com.example.ergedd_android2.presenter;

import com.example.ergedd_android2.Contract.BabyLookTabContract;
import com.example.ergedd_android2.base.BasePresenter;
import com.example.ergedd_android2.bean.BabyLookTabBean;
import com.example.ergedd_android2.model.BabyLookModel;

import java.util.List;

public class BabyLookPresenter <V extends BabyLookTabContract.BabyLookView>
        extends BasePresenter<V> implements BabyLookTabContract.BabyLookPresenter,BabyLookTabContract.BabyLookModel.CallBack {
    private  BabyLookTabContract.BabyLookModel babyLookModel=new BabyLookModel();
    @Override
    public void BabyLookHttp() {
        if (mView != null) {
            babyLookModel.getBabyLookData(this);
        }
    }

    @Override
    public void onTabSuccess(BabyLookTabBean babyLookTabBeans) {
        mView.onTabSuccess(babyLookTabBeans);
    }

    @Override
    public void onFail(String msg) {

    }
}
