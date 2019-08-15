package com.example.ergedd_android2;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ergedd_android2.activitys.SettingActivity;
import com.example.ergedd_android2.base.BaseActivity;
import com.example.ergedd_android2.base.BasePresenter;
import com.example.ergedd_android2.constant.Constants;
import com.example.ergedd_android2.fragments.BabyHearFragment;
import com.example.ergedd_android2.fragments.BabyLookFragment;
import com.example.ergedd_android2.fragments.CacheFragment;
import com.example.ergedd_android2.utils.AppCleanMgr;
import com.example.ergedd_android2.utils.PopUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

//项目总经理：马屹延
//项目总监：杨明
//项目负责人：张九红
//后勤：李志凯

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.bottom_navig)
    BottomNavigationView bottomNavig;
    @BindView(R.id.background)
    ImageView background;
    @BindView(R.id.test)
    TextView test;
    @BindView(R.id.setting)
    ImageView setting;
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
                        toolbar.setBackgroundResource(R.mipmap.icon_theme_header);
                        background.setVisibility(View.INVISIBLE);
                        test.setVisibility(View.INVISIBLE);
                        setting.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.btn_babyhear:
                        showFragment(Constants.TYPE_BABYHEAR);
                        toolbar.setBackgroundResource(R.mipmap.icon_theme_header);
                        background.setVisibility(View.INVISIBLE);
                        background.setVisibility(View.INVISIBLE);
                        test.setVisibility(View.INVISIBLE);
                        setting.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.btn_cache:
                        showFragment(Constants.TYPE_CACHE);
                        background.setVisibility(View.VISIBLE);
                        test.setVisibility(View.VISIBLE);
                        setting.setVisibility(View.VISIBLE);
                        toolbar.setBackgroundResource(R.color.white);
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
                if (babyLookFragment == null) {
                    babyLookFragment = BabyLookFragment.newInstance();
                    transaction.add(R.id.container, babyLookFragment);
                }
                transaction.show(babyLookFragment);
                break;
            case Constants.TYPE_BABYHEAR:
                if (babyHearFragment == null) {
                    babyHearFragment = BabyHearFragment.newInstance();
                    transaction.add(R.id.container, babyHearFragment);
                }
                transaction.show(babyHearFragment);
                break;
            case Constants.TYPE_CACHE:
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
        toolbar.setTitle("");
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


    @OnClick({R.id.test, R.id.setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.test:
                Toast.makeText(this, "已清理" + AppCleanMgr.getAppClearSize(this), Toast.LENGTH_SHORT).show();
                AppCleanMgr.cleanApplicationData(this);
                break;
            case R.id.setting:
                PopUtils popUtils = new PopUtils();
                popUtils.statrPop(setting, this, SettingActivity.class);
                break;
        }
    }
}
