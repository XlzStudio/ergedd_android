package com.example.ergedd_android2.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.ergedd_android2.Contract.BabyHearItemContract;
import com.example.ergedd_android2.R;
import com.example.ergedd_android2.adapters.BabyItemRvAdapter;
import com.example.ergedd_android2.base.BaseFragment;
import com.example.ergedd_android2.bean.BabyHearItemBean;
import com.example.ergedd_android2.presenter.BabyHearItemPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class BabyItemFragment<V extends BabyHearItemContract.BabyHearItemView> extends BaseFragment<BabyHearItemContract.BabyHearItemView, BabyHearItemPresenter<BabyHearItemContract.BabyHearItemView>> implements BabyHearItemContract.BabyHearItemView {


    @BindView(R.id.babyitem_rv)
    RecyclerView babyitem_rv;
    private View view;
    private ArrayList<BabyHearItemBean.DataBean> list;
    private BabyItemRvAdapter babyItemRvAdapter;
    private static final String TAG = "BabyItemFragment";

    public BabyItemFragment() {
        // Required empty public constructor
    }

    @Override
    protected int createLayout() {
        return R.layout.fragment_baby_item;
    }

    @Override
    protected void initViewAndData() {
        babyitem_rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        Bundle arguments = getArguments();
        int id = arguments.getInt("id");
        mPresenter.http(id);
        list = new ArrayList<>();
        babyItemRvAdapter = new BabyItemRvAdapter(list, getActivity());
        babyitem_rv.setAdapter(babyItemRvAdapter);
    }

    @Override
    protected BabyHearItemPresenter createPresenter() {
        return new BabyHearItemPresenter();
    }

    @Override
    public void showSuccess(BabyHearItemBean data) {
        list.addAll(data.getData());
        babyItemRvAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String error) {
        Log.e(TAG, "showError: "+error);
    }

    @OnClick(R.id.babyitem_rv)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.babyitem_rv:
                break;
        }
    }

}
