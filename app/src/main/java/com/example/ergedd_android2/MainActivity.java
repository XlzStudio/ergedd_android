package com.example.ergedd_android2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.ergedd_android2.Constant.Constants;
import com.example.ergedd_android2.base.BaseActivity;
import com.example.ergedd_android2.base.BasePresenter;
import com.example.ergedd_android2.fragments.BabyHearFragment;
import com.example.ergedd_android2.fragments.BabyLookFragment;
import com.example.ergedd_android2.fragments.CacheFragment;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

//Boss：李志凯
//项目副经理：马屹延
public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.bottom_navig)
    BottomNavigationView bottomNavig;
    private int mCurrentFgIndex = 0;
    private int mLastFgIndex = -1;
    private BabyLookFragment babyLookFragment;
    private BabyHearFragment babyHearFragment;
    private CacheFragment cacheFragment;


    @Override
    protected void initViewData() {
        initToobar();
        showFragment(mCurrentFgIndex);
        initBottomNavigationView();
    }

    private void initBottomNavigationView() {
        bottomNavig.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.btn_babylook:
                        showFragment(Constants.TYPE_BABYLOOK);
                        break;
                    case R.id.btn_babyhear:
                        showFragment(Constants.TYPE_BABYHEAR);
                        break;
                    case R.id.btn_cache:
                        showFragment(Constants.TYPE_CACHE);
                        break;

                }
                return true;
            }
        });

    }

    private void showFragment(int index) {
        mCurrentFgIndex = index;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);
        mLastFgIndex = index;
        switch (index) {
            case Constants
                    .TYPE_BABYLOOK:
                toolbar.setTitle(R.string.btn_babylook);
                if (babyLookFragment == null) {
                    babyLookFragment = BabyLookFragment.newInstance();
                    transaction.add(R.id.container, babyLookFragment);
                }
                transaction.show(babyLookFragment);
                break;
            case Constants.TYPE_BABYHEAR:
                toolbar.setTitle(R.string.btn_babyhear);
                if (babyHearFragment == null) {
                    babyHearFragment = BabyHearFragment.newInstance();
                    transaction.add(R.id.container, babyHearFragment);
                }
                transaction.show(babyHearFragment);
                break;
            case Constants.TYPE_CACHE:
                toolbar.setTitle(R.string.btn_cache);
                if (cacheFragment == null) {
                    cacheFragment = CacheFragment.newInstance();
                    transaction.add(R.id.container, cacheFragment);
                }
                transaction.show(cacheFragment);
                break;
            default:
                break;
        }
        transaction.commit();

    }
    private void hideFragment(FragmentTransaction transaction) {
        switch (mLastFgIndex) {
            case Constants.TYPE_BABYLOOK:
                if (babyLookFragment != null) {
                    transaction.hide(babyLookFragment);
                }
                break;
            case Constants.TYPE_BABYHEAR:
                if (babyHearFragment != null) {
                    transaction.hide(babyHearFragment);
                }
                break;
            case Constants.TYPE_CACHE:
                if (cacheFragment != null) {
                    transaction.hide(cacheFragment);
                }
                break;

            default:
                break;
        }
    }

    private void initToobar() {
        toolbar.setTitle("主页");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
    }

    @Override
    protected int createLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getData(String title) {

    }



}
