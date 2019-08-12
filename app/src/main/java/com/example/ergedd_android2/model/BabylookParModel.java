package com.example.ergedd_android2.model;

import android.util.Log;

import com.example.ergedd_android2.Contract.BabylookParContract;
import com.example.ergedd_android2.api.ApiServer;
import com.example.ergedd_android2.base.BaseObsever;
import com.example.ergedd_android2.bean.BabylookParBean;
import com.example.ergedd_android2.utils.HttpManager;
import com.example.ergedd_android2.utils.RxUtils;

import java.util.List;

public class BabylookParModel implements BabylookParContract.BabylookParModel {

    @Override
    public void getData(int id,final CallBack callBack) {
        HttpManager.getInstance().getApiService2(ApiServer.class)
                .getBabylookParData(id)
                .compose(RxUtils.<BabylookParBean>rxScheduleThread())
                .subscribe(new BaseObsever<BabylookParBean>() {
                    @Override
                    public void onSuccess(BabylookParBean data) {
                        callBack.showSuccess(data);
                        List<BabylookParBean.DataBean> data1 = data.getData();
                        int size = data1.size();
                        Log.e("解析成功", "onSuccess: "+data.toString());
                    }

                    @Override
                    public void onFail(String error) {
                        callBack.showError(error);
                        Log.e("解析失败", "onSuccess: "+error);
                    }
                });
    }
}
