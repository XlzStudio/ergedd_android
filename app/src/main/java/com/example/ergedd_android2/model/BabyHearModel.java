package com.example.ergedd_android2.model;

import com.example.ergedd_android2.Contract.BabyHearContract;
import com.example.ergedd_android2.api.ApiServer;
import com.example.ergedd_android2.base.BaseObsever;
import com.example.ergedd_android2.bean.BabyHearBean;
import com.example.ergedd_android2.utils.HttpManager;
import com.example.ergedd_android2.utils.RxUtils;

public class BabyHearModel implements BabyHearContract.BabyHearModel {

    @Override
    public void getData(final CallBack callBack) {
        HttpManager.getInstance().getApiService(ApiServer.class)
                .getBabyHearTab()
                .compose(RxUtils.<BabyHearBean>rxScheduleThread())
                .subscribe(new BaseObsever<BabyHearBean>() {
                    @Override
                    public void onSuccess(BabyHearBean data) {
                        callBack.showSuccess(data);
                    }

                    @Override
                    public void onFail(String error) {
                        callBack.showError(error);
                    }
                });
    }
}
