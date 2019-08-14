package com.example.ergedd_android2.model;

import com.example.ergedd_android2.Contract.CommentWriteContract;
import com.example.ergedd_android2.api.ApiServer;
import com.example.ergedd_android2.base.BaseObsever;
import com.example.ergedd_android2.bean.CommentWriteBean;
import com.example.ergedd_android2.utils.HttpManager;
import com.example.ergedd_android2.utils.RxUtils;

public class CommentWriteModel implements CommentWriteContract.CommentWriteModel {

    @Override
    public void getData(int id,final CallBack callBack) {
        HttpManager.getInstance().getApiService(ApiServer.class)
                .getCommentWriteData(id)
                .compose(RxUtils.<CommentWriteBean>rxScheduleThread())
                .subscribe(new BaseObsever<CommentWriteBean>() {
                    @Override
                    public void onSuccess(CommentWriteBean data) {
                        callBack.showSuccess(data);
                    }

                    @Override
                    public void onFail(String error) {
                        callBack.showError(error);
                    }
                });
    }
}
