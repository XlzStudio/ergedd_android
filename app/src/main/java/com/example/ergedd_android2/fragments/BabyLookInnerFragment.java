package com.example.ergedd_android2.fragments;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.ergedd_android2.Contract.BabyLookInnerContract;
import com.example.ergedd_android2.R;
import com.example.ergedd_android2.activitys.ParticularsActivity;
import com.example.ergedd_android2.adapters.BabyLookInnerAdapter;
import com.example.ergedd_android2.base.BaseFragment;
import com.example.ergedd_android2.bean.BabyLookInnerBean;
import com.example.ergedd_android2.presenter.BabyLookInnerPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BabyLookInnerFragment extends BaseFragment<BabyLookInnerFragment, BabyLookInnerPresenter> implements BabyLookInnerContract.BabyLookView, BabyLookInnerAdapter.OnClickListener {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    Unbinder unbinder;
    private int cid;
    private BabyLookInnerAdapter babyLookInnerAdapter;

    public void bundle(int id) {
        cid=id;
    }


    @Override
    public void onInnerSuccess(BabyLookInnerBean babyLookInnerBean) {
        List<BabyLookInnerBean.DataBean> data = babyLookInnerBean.getData();
        babyLookInnerAdapter.initData(data);
    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    protected BabyLookInnerPresenter createPresenter() {
        return new BabyLookInnerPresenter();
    }

    private static final String TAG = "BabyLookInnerFragment";
    @Override
    protected int createLayout() {
        Log.d(TAG, "createLayout: "+cid);
        return R.layout.fragment_baby_look_inner;
    }

    @Override
    protected void initViewAndData() {
        recyclerview.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        babyLookInnerAdapter = new BabyLookInnerAdapter(this);
        recyclerview.setAdapter(babyLookInnerAdapter);

        mPresenter.BabyLookHttp(cid);

        babyLookInnerAdapter.setOnClickListener(this);
    }


    @Override
    public void OnItemClick(int p, BabyLookInnerBean.DataBean dataBean) {
        Intent intent = new Intent(getActivity(),ParticularsActivity.class);
        intent.putExtra("id",dataBean.getId());
        startActivity(intent);
    }
}
