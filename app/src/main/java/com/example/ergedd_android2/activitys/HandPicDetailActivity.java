package com.example.ergedd_android2.activitys;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ergedd_android2.Contract.HandPicDetailContract;
import com.example.ergedd_android2.R;
import com.example.ergedd_android2.adapters.HandPickDetailAdapter;
import com.example.ergedd_android2.base.BaseActivity;
import com.example.ergedd_android2.bean.HandPicDetailBean;
import com.example.ergedd_android2.presenter.HandPickDetailPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HandPicDetailActivity extends BaseActivity<HandPicDetailActivity, HandPickDetailPresenter<HandPicDetailActivity>> implements HandPicDetailContract.HandPicDetailView {

    @BindView(R.id.toolbar_babyhear_detail)
    Toolbar toolbarBabyhearDetail;
    @BindView(R.id.img_babyhear_detail)
    ImageView imgBabyhearDetail;
    @BindView(R.id.count_babyher_detail)
    TextView countBabyherDetail;
    @BindView(R.id.name_babyhear_detail)
    TextView nameBabyhearDetail;
    @BindView(R.id.content_babyhear_detail)
    TextView contentBabyhearDetail;
    @BindView(R.id.play_babyhear_detail)
    ImageView playBabyhearDetail;
    @BindView(R.id.recycler_baby_hear_detail)
    RecyclerView recyclerBabyHearDetail;
    @BindView(R.id.bg_baby_detaill)
    ImageView bgBabyDetaill;
    @BindView(R.id.playAll_babyhear_detail)
    TextView playAllBabyhearDetail;
    @BindView(R.id.title_babyhear_toolbar)
    TextView title_babyhear_toolbar;
    private HandPickDetailAdapter handPickDetailAdapter;

    @Override
    public void onSuccess(List<HandPicDetailBean.RecordBean.AudiosBean> audios) {
        handPickDetailAdapter.initData(audios);
    }

    @Override
    public void onFail(String msg) {

    }


    @Override
    protected void initViewData() {


        Intent intent = getIntent();
        int id = intent.getIntExtra("id", -1);
        String name = intent.getStringExtra("name");
        String count = intent.getStringExtra("count");
        String img = intent.getStringExtra("img");
        String bg = intent.getStringExtra("bg");
        String content = intent.getStringExtra("content");

        title_babyhear_toolbar.setText(name);
        setSupportActionBar(toolbarBabyhearDetail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        toolbarBabyhearDetail.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        nameBabyhearDetail.setText(name);
        countBabyherDetail.setText(count + "");
        contentBabyhearDetail.setText(content);
        Glide.with(this).load(img).into(imgBabyhearDetail);
        Glide.with(this).load(bg).into(bgBabyDetaill);

        mPresenter.attach(this);
        mPresenter.HandPicDetailHttp(id);

        recyclerBabyHearDetail.setLayoutManager(new LinearLayoutManager(this));
        handPickDetailAdapter = new HandPickDetailAdapter(this);
        recyclerBabyHearDetail.setAdapter(handPickDetailAdapter);

        recyclerBabyHearDetail.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }


    @Override
    protected int createLayout() {
        return R.layout.activity_hand_pic_detail;
    }

    @Override
    protected HandPickDetailPresenter<HandPicDetailActivity> createPresenter() {
        return new HandPickDetailPresenter<>();
    }
}
