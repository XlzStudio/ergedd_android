package com.example.ergedd_android2.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class SimpleActivity extends AppCompatActivity {

    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //布局
        setContentView(createLayout());

        //绑定id  监听
        bind = ButterKnife.bind(this);

        //eventbus传值
       // EventBus.getDefault().register(this);

        //布局 和  逻辑
       initViewData();
    }

    protected abstract void initViewData();



    protected abstract int createLayout();

    //销毁
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
        }
        //Eventbus注销
        //EventBus.getDefault().unregister(this);
    }
}
