package com.example.ergedd_android2.model;

import com.example.ergedd_android2.Contract.BabyLookTabContract;
import com.example.ergedd_android2.api.ApiServer;
import com.example.ergedd_android2.utils.HttpManager;
import com.example.ergedd_android2.utils.RxUtils;

import java.util.List;



public class BabyLookModel implements WxArticleandTabContract.WxArticleModel {

    @Override
    public void getWxArticleData(final BabyLookTabContract.BabyLookModel.CallBack callBack) {
        HttpManager.getInstance().getApiService(ApiServer.class).getWxTab("wxarticle/chapters/json")
                .compose(RxUtils.<BaseResponse<List<WxTabBean>>>rxScheduleThread())
                .compose(RxUtils.<List<WxTabBean>>changeResult())
                .subscribe(new BaseObsever<List<WxTabBean>>() {
                    @Override
                    public void onSuccess(List<WxTabBean> data) {
                        if (data != null) {
                            callBack.onTabSuccess(data);
                        }
                    }

                    @Override
                    public void onFail(String error) {
                        callBack.onFail(error);
                    }
                });
        HttpManager.getInstance().getApiService(ApiServer.class).getWxData(1)
                .compose(RxUtils.<BaseResponse<WxDataBean>>rxScheduleThread())
                .compose(RxUtils.<WxDataBean>changeResult())
                .subscribe(new BaseObsever<WxDataBean>() {
                    @Override
                    public void onSuccess(WxDataBean data) {
                        callBack.onSuccess(data);
                    }

                    @Override
                    public void onFail(String error) {
                        callBack.onFail(error);
                    }
                });
    }
}
