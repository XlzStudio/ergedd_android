package com.example.ergedd_android2.model;

import android.util.Log;

import com.example.ergedd_android2.Contract.HandPicAlbumContract;
import com.example.ergedd_android2.api.ApiServer;
import com.example.ergedd_android2.base.BaseObsever;
import com.example.ergedd_android2.bean.BabyLookTabBean;
import com.example.ergedd_android2.bean.HandPicAlbumBean;
import com.example.ergedd_android2.bean.HandPicBottomListBean;
import com.example.ergedd_android2.utils.HttpManager;
import com.example.ergedd_android2.utils.RxUtils;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


public class HandPicModel implements HandPicAlbumContract.HandPicAlbumModel {

    private static final String TAG = "tag";
    @Override
    public void getHandPicAlbumData(final CallBack callBack) {
        //audio_playlists/excellent
        HttpManager.getInstance().getApiService(ApiServer.class).getAlbum("audio_playlists/excellent","new")
                .compose(RxUtils.<HandPicAlbumBean>rxScheduleThread())
                .subscribe(new Observer<HandPicAlbumBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HandPicAlbumBean handPicAlbumBean) {
                        List<HandPicAlbumBean.DataBean> data = handPicAlbumBean.getData();
                        callBack.onSuccess(data);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ====="+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        HttpManager.getInstance().getApiService(ApiServer.class).getBottomData("audio_categories?channel=original","original")
                .compose(RxUtils.<HandPicBottomListBean>rxScheduleThread())
                .subscribe(new Observer<HandPicBottomListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HandPicBottomListBean handPicBottomListBean) {
                        List<HandPicBottomListBean.DataBean> data = handPicBottomListBean.getData();
                        callBack.onBottomSuccess(data);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ====="+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
