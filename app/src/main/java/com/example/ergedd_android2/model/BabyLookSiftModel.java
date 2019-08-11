package com.example.ergedd_android2.model;

import com.example.ergedd_android2.Contract.BabyLookSiftContract;
import com.example.ergedd_android2.api.ApiServer;
import com.example.ergedd_android2.bean.BabyLookSiftItemBean;
import com.example.ergedd_android2.bean.BabyLookSiftGridBean;
import com.example.ergedd_android2.bean.BabyLookSiftThreeImgBean;
import com.example.ergedd_android2.utils.HttpManager;
import com.example.ergedd_android2.utils.RxUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class BabyLookSiftModel implements BabyLookSiftContract.BabyLookModel{
    public void httpThreeImg(final CallBack callBack, int id){
        HttpManager.getInstance().getApiService(ApiServer.class)
                .getLookSift("albums/"+id+"/videos","new",0,20,8)
                .compose(RxUtils.<BabyLookSiftThreeImgBean>rxScheduleThread())
                .subscribe(new Observer<BabyLookSiftThreeImgBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BabyLookSiftThreeImgBean babyLookSiftThreeImgBean) {
                        callBack.onImgSuccess(babyLookSiftThreeImgBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void httpGridView(final CallBack callBack){
        HttpManager.getInstance().getApiService(ApiServer.class)
                .getLookGrid("albums/home_recommended","new",0,16)
                .compose(RxUtils.<BabyLookSiftGridBean>rxScheduleThread())
                .subscribe(new Observer<BabyLookSiftGridBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BabyLookSiftGridBean babyLookGridBean) {
                        callBack.onGridSuccess(babyLookGridBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void httpItem(final CallBack callBack, int offset){
        HttpManager.getInstance().getApiService(ApiServer.class)
                .getLookItemUp("home_items",1,"new",offset,20,8)
                .compose(RxUtils.<BabyLookSiftItemBean>rxScheduleThread())
                .subscribe(new Observer<BabyLookSiftItemBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BabyLookSiftItemBean babyLookItemBean) {
                        callBack.onItemSuccess(babyLookItemBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getBabyLookData(CallBack callBack) {

    }
}
