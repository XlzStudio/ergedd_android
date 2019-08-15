package com.example.ergedd_android2.presenter;

import com.example.ergedd_android2.Contract.CommentWriteContract;
import com.example.ergedd_android2.base.BasePresenter;
import com.example.ergedd_android2.bean.CommentWriteBean;
import com.example.ergedd_android2.model.CommentWriteModel;

public class CommentWritePresenter<V extends CommentWriteContract.CommentWriteView> extends BasePresenter<V> implements CommentWriteContract.CommentWritePresenter, CommentWriteContract.CommentWriteModel.CallBack {
    private CommentWriteContract.CommentWriteModel commentWriteModel = new CommentWriteModel();

    @Override
    public void http(int id) {
        if (mView != null) {
            commentWriteModel.getData(id,this);
        }
    }

    @Override
    public void showSuccess(CommentWriteBean data) {
        mView.showSuccess(data);
    }

    @Override
    public void showError(String error) {
        mView.showError(error);
    }
}
