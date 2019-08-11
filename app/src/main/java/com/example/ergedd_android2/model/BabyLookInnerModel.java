package com.example.ergedd_android2.model;

import com.example.ergedd_android2.Contract.BabyLookInnerContract;
import com.example.ergedd_android2.api.ApiServer;
import com.example.ergedd_android2.bean.BabyLookInnerBean;
import com.example.ergedd_android2.utils.HttpManager;
import com.example.ergedd_android2.utils.RxUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class BabyLookInnerModel implements BabyLookInnerContract.BabyLookModel {
    @Override
    public void getBabyLookData(CallBack callBack) {

    }

    public void getBabyLookData(final CallBack callBack, int id){
        HttpManager.getInstance().getApiService(ApiServer.class)
                .getLookInner("album_categories/"+id+"/albums","new",0,20,8)
                .compose(RxUtils.<BabyLookInnerBean>rxScheduleThread())
                .subscribe(new Observer<BabyLookInnerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BabyLookInnerBean babyLookInnerBean) {
                        callBack.onInnerSuccess(babyLookInnerBean);
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
}

