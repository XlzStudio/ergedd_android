package com.example.ergedd_android2.activitys;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.ergedd_android2.Contract.BabylookParContract;
import com.example.ergedd_android2.R;
import com.example.ergedd_android2.adapters.BabylookParRvAdapter;
import com.example.ergedd_android2.base.BaseActivity;
import com.example.ergedd_android2.bean.BabylookParBean;
import com.example.ergedd_android2.presenter.BabylookParPresenter;

import java.util.ArrayList;

public class ParticularsActivity<V extends BabylookParContract.BabylookParView> extends BaseActivity<BabylookParContract.BabylookParView, BabylookParPresenter<BabylookParContract.BabylookParView>> implements BabylookParContract.BabylookParView {

    private Toolbar particulars_toolbar;
    private RecyclerView particulars_rv;
    private ArrayList<BabylookParBean.DataBean> list;
    private BabylookParRvAdapter babylookParRvAdapter;
    private static final String TAG = "ParticularsActivity";

    @Override
    protected void initViewData() {
        particulars_toolbar = (Toolbar) findViewById(R.id.particulars_toolbar);
        particulars_rv = (RecyclerView) findViewById(R.id.particulars_rv);

        particulars_rv.setLayoutManager(new LinearLayoutManager(this));
        particulars_toolbar.setTitle("");
        setSupportActionBar(particulars_toolbar);

        //设置是否显示左侧的按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //给左侧的按钮
        particulars_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里处理返回按钮的逻辑
                finish();
            }
        });

        list = new ArrayList<>();
        babylookParRvAdapter = new BabylookParRvAdapter(list, this);
        particulars_rv.setAdapter(babylookParRvAdapter);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        mPresenter.http(id);
    }

    @Override
    protected int createLayout() {
        return R.layout.activity_particulars;
    }

    @Override
    protected BabylookParPresenter createPresenter() {
        return new BabylookParPresenter();
    }

    @Override
    public void showSuccess(BabylookParBean data) {
        list.addAll(data.getData());
        babylookParRvAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String error) {
        Log.e(TAG, "showError: "+error);
    }
}
