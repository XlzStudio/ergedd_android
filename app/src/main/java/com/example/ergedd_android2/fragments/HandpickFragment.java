package com.example.ergedd_android2.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.ergedd_android2.Contract.HandPicAlbumContract;
import com.example.ergedd_android2.R;
import com.example.ergedd_android2.activitys.HandPicDetailActivity;
import com.example.ergedd_android2.adapters.HandPicAlbumRecyclerAdapter;
import com.example.ergedd_android2.adapters.HandPicRecyclerAdapter;
import com.example.ergedd_android2.api.ApiServer;
import com.example.ergedd_android2.base.BaseFragment;
import com.example.ergedd_android2.base.BaseObsever;
import com.example.ergedd_android2.bean.BabyLookTabBean;
import com.example.ergedd_android2.bean.HandPicAlbumBean;
import com.example.ergedd_android2.bean.HandPicBottomListBean;
import com.example.ergedd_android2.bean.HandPicTopBean;
import com.example.ergedd_android2.presenter.HandPickPresenter;
import com.example.ergedd_android2.utils.HttpManager;
import com.example.ergedd_android2.utils.RxUtils;

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

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        recyclerBabyHear.setLayoutManager(mLinearLayoutManager);
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

    HandPicTopBean datas;
    @OnClick({R.id.baby_hear_hali, R.id.baby_hear_peiqi, R.id.baby_hear_song})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.baby_hear_hali:
                getTopData(258);
                startIntent();

                break;
            case R.id.baby_hear_peiqi:
                getTopData(194);
                startIntent();
                break;
            case R.id.baby_hear_song:
                getTopData(261);
                startIntent();
                break;
        }
    }

    private void startIntent() {
        if (datas!=null){
            HandPicTopBean.DataBean data = datas.getData();

            Intent intent = new Intent(getActivity(), HandPicDetailActivity.class);
            intent.putExtra("id", data.getId());
            intent.putExtra("name", data.getName());
            intent.putExtra("count", data.getCount() + "");
            intent.putExtra("content", data.getDescription());
            intent.putExtra("img", data.getSquare_image_url());
            intent.putExtra("bg", data.getImage());
            startActivity(intent);
        }
    }

    private static final String TAG = "HandpickFragment";
    private void getTopData(int id) {
        HttpManager.getInstance().getApiService(ApiServer.class)
                .getTopData("audio_playlists/"+id)
                .compose(RxUtils.<HandPicTopBean>rxScheduleThread())
                .subscribe(new BaseObsever<HandPicTopBean>() {
                    @Override
                    public void onSuccess(HandPicTopBean data) {
                        datas=data;
                    }

                    @Override
                    public void onFail(String error) {
                        Log.d(TAG, "onFail: ======="+error);
                    }
                });
    }

}
