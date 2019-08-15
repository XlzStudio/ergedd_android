package com.example.ergedd_android2.fragments;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.ergedd_android2.Contract.BabyLookTabContract;
import com.example.ergedd_android2.R;
import com.example.ergedd_android2.adapters.BabyLookVpadapter;
import com.example.ergedd_android2.base.BaseFragment;
import com.example.ergedd_android2.bean.BabyLookTabBean;
import com.example.ergedd_android2.presenter.BabyLookPresenter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BabyLookFragment extends BaseFragment<BabyLookTabContract.BabyLookView, BabyLookPresenter<BabyLookTabContract.BabyLookView>>
        implements BabyLookTabContract.BabyLookView {


    @BindView(R.id.babyLook_tab)
    TabLayout babyLookTab;
    @BindView(R.id.babyLook_vp)
    ViewPager babyLookVp;
    Unbinder unbinder;
    private ArrayList<Fragment> fragments;
    private ArrayList<BabyLookTabBean.DataBean> babyLookTabBeans1;
    private ArrayList<String> strings;


    public BabyLookFragment() {
        // Required empty public constructor
    }

    public static BabyLookFragment newInstance() {
        return new BabyLookFragment();
    }


    @Override
    public void onTabSuccess(BabyLookTabBean babyLookTabBeans) {

        for (int i = 0; i < babyLookTabBeans.getData().size(); i++) {
            BabyLookInnerFragment babyLookInnerFragment = new BabyLookInnerFragment();
            babyLookInnerFragment.bundle(babyLookTabBeans.getData().get(i).getId());
            fragments.add(babyLookInnerFragment);
            strings.add(babyLookTabBeans.getData().get(i).getName());
        }

        BabyFriendFragment babyFriendFragment = new BabyFriendFragment();
        fragments.add(babyFriendFragment);
        strings.add("伙伴");

        BabyLookVpadapter babyLookVpadapter = new BabyLookVpadapter(getChildFragmentManager(), fragments,strings);
        babyLookVp.setAdapter(babyLookVpadapter);
        babyLookTab.setupWithViewPager(babyLookVp);
    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    protected BabyLookPresenter<BabyLookTabContract.BabyLookView> createPresenter() {
        return new BabyLookPresenter<>();
    }

    @Override
    protected int createLayout() {
        return R.layout.fragment_baby_look;
    }

    @Override
    protected void initViewAndData() {
        mPresenter.BabyLookHttp();

        fragments = new ArrayList<>();
        BabyLookSiftFragment babyLookSiftFragment = new BabyLookSiftFragment();
        fragments.add(babyLookSiftFragment);

        strings = new ArrayList<>();
        strings.add("精选");

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getData(String title) {

    }
}
