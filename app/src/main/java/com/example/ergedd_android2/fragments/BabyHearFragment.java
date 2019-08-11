package com.example.ergedd_android2.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.example.ergedd_android2.Contract.BabyHearContract;
import com.example.ergedd_android2.R;
import com.example.ergedd_android2.adapters.VpAdapter;
import com.example.ergedd_android2.base.BaseFragment;
import com.example.ergedd_android2.bean.BabyHearBean;
import com.example.ergedd_android2.presenter.BabyHearPresenter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BabyHearFragment<V extends BabyHearContract.BabyHearView> extends BaseFragment<BabyHearContract.BabyHearView, BabyHearPresenter<BabyHearContract.BabyHearView>> implements BabyHearContract.BabyHearView {


    @BindView(R.id.babyhear_tab)
    TabLayout babyhear_tab;
    @BindView(R.id.babyhear_vp)
    ViewPager babyhear_vp;
    private View view;
    private ArrayList<Fragment> fs;
    private ArrayList<String> title;
    private Unbinder unbinder;
    private static final String TAG = "BabyHearFragment";


    public BabyHearFragment() {
        // Required empty public constructor
    }


    public static BabyHearFragment newInstance() {

        return new BabyHearFragment();
    }

    @Override
    protected int createLayout() {
        return R.layout.fragment_baby_hear;
    }

    @Override
    protected void initViewAndData() {
        fs = new ArrayList<>();
        title = new ArrayList<>();
        mPresenter.http();
    }

    @Override
    protected BabyHearPresenter createPresenter() {
        return new BabyHearPresenter();
    }

    @Override
    public void showSuccess(BabyHearBean data) {
        fs.add(new HandpickFragment());
        title.add("精选");
        List<BabyHearBean.DataBean> data1 = data.getData();
        for (int i = 0; i <data1 .size(); i++) {
            BabyItemFragment babyItemFragment = new BabyItemFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id",data1.get(i).getId());
            babyItemFragment.setArguments(bundle);
            fs.add(babyItemFragment);
            title.add(data1.get(i).getName());
        }
        VpAdapter vpAdapter = new VpAdapter(getChildFragmentManager(), fs, this.title);
        babyhear_vp.setAdapter(vpAdapter);
        babyhear_tab.setupWithViewPager(babyhear_vp);
    }

    @Override
    public void showError(String error) {
        Log.e(TAG, "showError: "+error);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getData(String title) {

    }
}
