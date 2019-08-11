package com.example.ergedd_android2.model;


import com.example.ergedd_android2.Contract.BabyLookTabContract;
import com.example.ergedd_android2.api.ApiServer;
import com.example.ergedd_android2.base.BaseObsever;
import com.example.ergedd_android2.bean.BabyLookTabBean;
import com.example.ergedd_android2.utils.HttpManager;
import com.example.ergedd_android2.utils.RxUtils;


public class BabyLookModel implements BabyLookTabContract.BabyLookModel {

    @Override
    public void getBabyLookData(final BabyLookTabContract.BabyLookModel.CallBack callBack) {
        //audio_categories
        HttpManager.getInstance().getApiService(ApiServer.class).getlookTab("album_categories","new", 0, 100, 20)
                .compose(RxUtils.<BabyLookTabBean>rxScheduleThread())
               .subscribe(new BaseObsever<BabyLookTabBean>() {
                   @Override
                   public void onSuccess(BabyLookTabBean data) {
                       callBack.onTabSuccess(data);
                   }

                   @Override
                   public void onFail(String error) {
                        callBack.onFail(error);
                   }
               });
       /* HttpManager.getInstance().getApiService(ApiServer.class).getWxData(1)
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
                });*/
    }
}
