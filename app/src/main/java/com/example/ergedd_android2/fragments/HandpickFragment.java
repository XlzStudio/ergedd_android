package com.example.ergedd_android2.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.ergedd_android2.Contract.HandPicAlbumContract;
import com.example.ergedd_android2.R;
import com.example.ergedd_android2.adapters.HandPicAlbumRecyclerAdapter;
import com.example.ergedd_android2.adapters.HandPicRecyclerAdapter;
import com.example.ergedd_android2.base.BaseFragment;
import com.example.ergedd_android2.bean.BabyLookTabBean;
import com.example.ergedd_android2.bean.HandPicAlbumBean;
import com.example.ergedd_android2.bean.HandPicBottomListBean;
import com.example.ergedd_android2.contract.BabyLookTabContract;
import com.example.ergedd_android2.presenter.HandPickPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HandpickFragment extends BaseFragment<HandpickFragment, HandPickPresenter<HandpickFragment>> implements HandPicAlbumContract.HandPicAlbumView {

    @BindView(R.id.baby_hear_hali)
    ImageView babyHearHali;
    @BindView(R.id.baby_hear_peiqi)
    ImageView babyHearPeiqi;
    @BindView(R.id.baby_hear_song)
    ImageView babyHearSong;
    @BindView(R.id.baby_hear_album)
    RecyclerView babyHearAlbum;
    @BindView(R.id.recycler_baby_hear)
    RecyclerView recyclerBabyHear;
    Unbinder unbinder;
    private HandPicAlbumRecyclerAdapter handPicAlbumRecyclerAdapter;
    private HandPicRecyclerAdapter handPicRecyclerAdapter;

    @Override
    protected HandPickPresenter<HandpickFragment> createPresenter() {
        return new HandPickPresenter<>();
    }

    @Override
    protected int createLayout() {
        return R.layout.fragment_handpick;
    }

    @Override
    protected void initViewAndData() {
        babyHearAlbum.setLayoutManager(new GridLayoutManager(getActivity(),3));
        handPicAlbumRecyclerAdapter = new HandPicAlbumRecyclerAdapter(getActivity());
        babyHearAlbum.setAdapter(handPicAlbumRecyclerAdapter);

        recyclerBabyHear.setLayoutManager(new LinearLayoutManager(getActivity()));
        handPicRecyclerAdapter = new HandPicRecyclerAdapter(getActivity());
        recyclerBabyHear.setAdapter(handPicRecyclerAdapter);


        recyclerBabyHear.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        mPresenter.attach(this);
        mPresenter.HandPicAlbumHttp();
    }


    @Override
    public void onSuccess(List<HandPicAlbumBean.DataBean> data) {
        handPicAlbumRecyclerAdapter.getAlbum(data);
    }


    @Override
    public void onFail(String msg) {

    }

    public void onBottomSuccess(List<HandPicBottomListBean.DataBean> data) {
        handPicRecyclerAdapter.getBottom(data);
    }


    @OnClick({R.id.baby_hear_hali, R.id.baby_hear_peiqi, R.id.baby_hear_song})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.baby_hear_hali:
                break;
            case R.id.baby_hear_peiqi:
                break;
            case R.id.baby_hear_song:
                break;
        }
    }
}
