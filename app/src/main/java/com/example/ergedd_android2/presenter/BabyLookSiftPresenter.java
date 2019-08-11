package com.example.ergedd_android2.presenter;

import com.example.ergedd_android2.Contract.BabyLookSiftContract;
import com.example.ergedd_android2.base.BasePresenter;
import com.example.ergedd_android2.bean.BabyLookSiftGridBean;
import com.example.ergedd_android2.bean.BabyLookSiftItemBean;
import com.example.ergedd_android2.bean.BabyLookSiftThreeImgBean;
import com.example.ergedd_android2.fragments.BabyLookSiftFragment;
import com.example.ergedd_android2.model.BabyLookSiftModel;

public class BabyLookSiftPresenter extends BasePresenter<BabyLookSiftFragment> implements BabyLookSiftContract.BabyLookPresenter {

    private final BabyLookSiftModel babyLookSiftModel;

    public BabyLookSiftPresenter() {
        babyLookSiftModel = new BabyLookSiftModel();
    }

    @Override
    public void BabyLookHttp() {

    }

    public void BabyLookImgSiftHttp(int id){
        babyLookSiftModel.httpItem(new BabyLookSiftContract.BabyLookModel.CallBack() {
            @Override
            public void onImgSuccess(BabyLookSiftThreeImgBean babyLookSiftThreeImgBean) {
                mView.onImgSuccess(babyLookSiftThreeImgBean);
            }

            @Override
            public void onGridSuccess(BabyLookSiftGridBean babyLookGridBean) {

            }

            @Override
            public void onItemSuccess(BabyLookSiftItemBean babyLookSiftItemBean) {

            }

            @Override
            public void onFail(String msg) {

            }
        },id);
    }

    public void BabyLookGridSiftHttp(){
        babyLookSiftModel.httpGridView(new BabyLookSiftContract.BabyLookModel.CallBack() {
            @Override
            public void onImgSuccess(BabyLookSiftThreeImgBean babyLookSiftThreeImgBean) {

            }

            @Override
            public void onGridSuccess(BabyLookSiftGridBean babyLookGridBean) {
                mView.onGridSuccess(babyLookGridBean);
            }

            @Override
            public void onItemSuccess(BabyLookSiftItemBean babyLookSiftItemBean) {

            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

    public void BabyLookSiftItemHttp(int offset){
        babyLookSiftModel.httpItem(new BabyLookSiftContract.BabyLookModel.CallBack() {
            @Override
            public void onImgSuccess(BabyLookSiftThreeImgBean babyLookSiftThreeImgBean) {

            }

            @Override
            public void onGridSuccess(BabyLookSiftGridBean babyLookGridBean) {

            }

            @Override
            public void onItemSuccess(BabyLookSiftItemBean babyLookSiftItemBean) {
                mView.onItemSuccess(babyLookSiftItemBean);
            }

            @Override
            public void onFail(String msg) {

            }
        },offset);
    }
}
