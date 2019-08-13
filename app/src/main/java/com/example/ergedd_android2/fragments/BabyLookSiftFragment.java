package com.example.ergedd_android2.fragments;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.ergedd_android2.Contract.BabyLookSiftContract;
import com.example.ergedd_android2.R;
import com.example.ergedd_android2.activitys.ParticularsActivity;
import com.example.ergedd_android2.adapters.BabyLookSiftGridAdapter;
import com.example.ergedd_android2.adapters.BabyLookSiftItemAdapter;
import com.example.ergedd_android2.base.BaseFragment;
import com.example.ergedd_android2.bean.BabyLookSiftGridBean;
import com.example.ergedd_android2.bean.BabyLookSiftItemBean;
import com.example.ergedd_android2.bean.BabyLookSiftThreeImgBean;
import com.example.ergedd_android2.presenter.BabyLookSiftPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BabyLookSiftFragment extends BaseFragment<BabyLookSiftFragment, BabyLookSiftPresenter> implements BabyLookSiftContract.BabyLookView, BabyLookSiftGridAdapter.OnClickListener {


    @BindView(R.id.scrofa)
    ImageView scrofa;
    @BindView(R.id.chook)
    ImageView chook;
    @BindView(R.id.dog)
    ImageView dog;
    @BindView(R.id.gridview)
    RecyclerView gridview;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    Unbinder unbinder;
    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout smart_refresh_layout;

    private List<List<BabyLookSiftThreeImgBean.DataBean>> imgList = new ArrayList<>();
    private BabyLookSiftGridAdapter babyLookSiftGridAdapter;
    private BabyLookSiftItemAdapter babyLookSiftItemAdapter;
    private List<BabyLookSiftGridBean.DataBean> data;
    private View view;

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

        initItemData();

        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        babyLookSiftItemAdapter = new BabyLookSiftItemAdapter(this);
        recyclerview.setAdapter(babyLookSiftItemAdapter);

        gridview.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        data = new ArrayList<>();
        babyLookSiftGridAdapter = new BabyLookSiftGridAdapter(data, getActivity());
        gridview.setAdapter(babyLookSiftGridAdapter);
        babyLookSiftGridAdapter.setOnClickListener(this);

        smart_refresh_layout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
//                page++;
//                initItemData();
                smart_refresh_layout.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
//                data.clear();
//                initItemData();
                babyLookSiftItemAdapter.notifyDataSetChanged();
                babyLookSiftGridAdapter.notifyDataSetChanged();
                smart_refresh_layout.finishRefresh();
            }
        });
    }

    private void initItemData() {
        mPresenter.BabyLookImgSiftHttp(33);
        mPresenter.BabyLookImgSiftHttp(532);
        mPresenter.BabyLookImgSiftHttp(175);

        mPresenter.BabyLookGridSiftHttp();

        mPresenter.BabyLookSiftItemHttp(0);

        mPresenter.BabyLookSiftItemHttp(20);
    }


    @OnClick({R.id.scrofa, R.id.chook, R.id.dog, R.id.smart_refresh_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.scrofa:
                Intent intent = new Intent(getActivity(), ParticularsActivity.class);
                intent.putExtra("id", 33);
                intent.putExtra("title", "小猪佩奇");
                startActivity(intent);
                break;
            case R.id.chook:
                Intent intent2 = new Intent(getActivity(), ParticularsActivity.class);
                intent2.putExtra("id", 532);
                intent2.putExtra("title", "萌鸡小队");
                startActivity(intent2);
                break;
            case R.id.dog:
                Intent intent3 = new Intent(getActivity(), ParticularsActivity.class);
                intent3.putExtra("id", 175);
                intent3.putExtra("title", "汪汪队立大功");
                startActivity(intent3);
                break;
            case R.id.smart_refresh_layout:
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
        data.addAll(babyLookGridBean.getData());
        babyLookSiftGridAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemSuccess(BabyLookSiftItemBean babyLookSiftItemBean) {
        List<BabyLookSiftItemBean.DataBean> data = babyLookSiftItemBean.getData();
        babyLookSiftItemAdapter.initData(data);
    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    public void OnItemClick(int p, BabyLookSiftGridBean.DataBean dataBean) {
        Intent intent4 = new Intent(getActivity(), ParticularsActivity.class);
        intent4.putExtra("id", dataBean.getId());
        intent4.putExtra("title", dataBean.getName());
        startActivity(intent4);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
