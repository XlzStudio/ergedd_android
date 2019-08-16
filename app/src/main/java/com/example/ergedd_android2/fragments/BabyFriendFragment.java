package com.example.ergedd_android2.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ergedd_android2.Contract.BabyFriendContract;
import com.example.ergedd_android2.R;
import com.example.ergedd_android2.adapters.BabyFriendAdapter;
import com.example.ergedd_android2.base.BaseFragment;
import com.example.ergedd_android2.bean.BabyFriendBean;
import com.example.ergedd_android2.presenter.BabyFriendPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BabyFriendFragment<V extends BabyFriendContract.BabyFriendView> extends BaseFragment<BabyFriendContract.BabyFriendView, BabyFriendPresenter<BabyFriendContract.BabyFriendView>>
        implements BabyFriendContract.BabyFriendView {


    @BindView(R.id.recycler_baby_friend)
    RecyclerView recyclerBabyFriend;
    Unbinder unbinder;
    private BabyFriendAdapter babyFriendAdapter;

    @Override
    public void showSuccess(final BabyFriendBean data) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                List<BabyFriendBean.DataBean> data1 = data.getData();
                babyFriendAdapter.initData(data1);
            }
        });

    }

    @Override
    public void showError(String error) {

    }

    @Override
    protected BabyFriendPresenter<BabyFriendContract.BabyFriendView> createPresenter() {
        return new BabyFriendPresenter<>();
    }

    @Override
    protected int createLayout() {
        return R.layout.fragment_baby_friend;
    }

    @Override
    protected void initViewAndData() {
        recyclerBabyFriend.setLayoutManager(new GridLayoutManager(getActivity(),3,GridLayoutManager.VERTICAL,false));
        babyFriendAdapter = new BabyFriendAdapter(getActivity());
        recyclerBabyFriend.setAdapter(babyFriendAdapter);

        mPresenter.http();
        mPresenter.attach(this);
    }
}
