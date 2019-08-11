package com.example.ergedd_android2.model;

import com.example.ergedd_android2.Contract.BabyHearItemContract;
import com.example.ergedd_android2.api.ApiServer;
import com.example.ergedd_android2.base.BaseObsever;
import com.example.ergedd_android2.bean.BabyHearItemBean;
import com.example.ergedd_android2.utils.HttpManager;
import com.example.ergedd_android2.utils.RxUtils;

public class BabyHearItemModel implements BabyHearItemContract.BabyHearItemModel {

    @Override
    public void getData(int id,final CallBack callBack) {
        HttpManager.getInstance().getApiService(ApiServer.class)
                .getBabyHearItem(id)
                .compose(RxUtils.<BabyHearItemBean>rxScheduleThread())
                .subscribe(new BaseObsever<BabyHearItemBean>() {
                    @Override
                    public void onSuccess(BabyHearItemBean data) {
                        callBack.showSuccess(data);
                    }

                    @Override
                    public void onFail(String error) {
                        callBack.showError(error);
                    }
                });
    }
}
