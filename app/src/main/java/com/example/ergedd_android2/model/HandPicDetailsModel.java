package com.example.ergedd_android2.model;

import android.util.Log;

import com.example.ergedd_android2.Contract.BabyHearContract;
import com.example.ergedd_android2.Contract.HandPicDetailContract;
import com.example.ergedd_android2.api.ApiServer;
import com.example.ergedd_android2.base.BaseObsever;
import com.example.ergedd_android2.bean.BabyHearBean;
import com.example.ergedd_android2.bean.HandPicDetailBean;
import com.example.ergedd_android2.utils.HttpManager;
import com.example.ergedd_android2.utils.RxUtils;

import java.util.List;

public class HandPicDetailsModel implements HandPicDetailContract.HandPicDetailModel {

//apid=258&offset=0&limit=20&os=3&code=20618&uuid=88f90448-1cac-4f10-8e80-34cafd428ce8&channel=qihu
private static final String TAG = "HandPicDetailsModel";
    @Override
    public void getHandPicDetailData(int id,final CallBack callBack) {
        HttpManager.getInstance().getDetailService(ApiServer.class)
                .getDetailData(id,0,20,3,"20618","88f90448-1cac-4f10-8e80-34cafd428ce8","qihu")
                .compose(RxUtils.<HandPicDetailBean>rxScheduleThread())
                .subscribe(new BaseObsever<HandPicDetailBean>() {
                    @Override
                    public void onSuccess(HandPicDetailBean data) {
                        List<HandPicDetailBean.RecordBean.AudiosBean> audios = data.getRecord().getAudios();
                        callBack.onSuccess(audios);
                    }

                    @Override
                    public void onFail(String error) {
                        Log.d(TAG, "onFail: ========"+error);
                    }
                });
    }
}
