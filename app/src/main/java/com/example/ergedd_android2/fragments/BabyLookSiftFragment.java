package com.example.ergedd_android2.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.ergedd_android2.Contract.BabyLookSiftContract;
import com.example.ergedd_android2.R;
import com.example.ergedd_android2.adapters.BabyLookSiftGridAdapter;
import com.example.ergedd_android2.adapters.BabyLookSiftItemAdapter;
import com.example.ergedd_android2.base.BaseFragment;
import com.example.ergedd_android2.bean.BabyLookSiftGridBean;
import com.example.ergedd_android2.bean.BabyLookSiftItemBean;
import com.example.ergedd_android2.bean.BabyLookSiftThreeImgBean;
import com.example.ergedd_android2.bean.BabyLookTabBean;
import com.example.ergedd_android2.presenter.BabyLookSiftPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BabyLookSiftFragment extends BaseFragment<BabyLookSiftFragment, BabyLookSiftPresenter> implements BabyLookSiftContract.BabyLookView {


    @BindView(R.id.scrofa)
    ImageView scrofa;
    @BindView(R.id.chook)
    ImageView chook;
    @BindView(R.id.dog)
    ImageView dog;
    @BindView(R.id.gridview)
    GridView gridview;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    Unbinder unbinder;

    private List<List<BabyLookSiftThreeImgBean.DataBean>> imgList=new ArrayList<>();
    private BabyLookSiftGridAdapter babyLookSiftGridAdapter;
    private BabyLookSiftItemAdapter babyLookSiftItemAdapter;

    @Override
    protected BabyLookSiftPresenter createPresenter() {
        return new BabyLookSiftPresenter();
    }

    @Override
    protected int createLayout() {
        return R.layout.fragment_baby_look_sift;
    }

    @Override
    protected void initViewAndData() {

        mPresenter.BabyLookImgSiftHttp(33);
        mPresenter.BabyLookImgSiftHttp(532);
        mPresenter.BabyLookImgSiftHttp(175);

        mPresenter.BabyLookGridSiftHttp();

        mPresenter.BabyLookSiftItemHttp(0);


        mPresenter.BabyLookSiftItemHttp(20);

        babyLookSiftGridAdapter = new BabyLookSiftGridAdapter(this);
        gridview.setAdapter(babyLookSiftGridAdapter);

        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        babyLookSiftItemAdapter = new BabyLookSiftItemAdapter(this);
        recyclerview.setAdapter(babyLookSiftItemAdapter);

    }


    @OnClick({R.id.scrofa, R.id.chook, R.id.dog})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.scrofa:
                break;
            case R.id.chook:
                break;
            case R.id.dog:
                break;
        }
    }


    @Override
    public void onImgSuccess(BabyLookSiftThreeImgBean babyLookSiftThreeImgBean) {
        List<BabyLookSiftThreeImgBean.DataBean> data = babyLookSiftThreeImgBean.getData();
        imgList.add(data);
    }

    @Override
    public void onGridSuccess(BabyLookSiftGridBean babyLookGridBean) {
        List<BabyLookSiftGridBean.DataBean> data = babyLookGridBean.getData();
        babyLookSiftGridAdapter.initData(data);
    }

    @Override
    public void onItemSuccess(BabyLookSiftItemBean babyLookSiftItemBean) {
        List<BabyLookSiftItemBean.DataBean> data = babyLookSiftItemBean.getData();
        babyLookSiftItemAdapter.initData(data);
    }

    @Override
    public void onFail(String msg) {

    }
}
