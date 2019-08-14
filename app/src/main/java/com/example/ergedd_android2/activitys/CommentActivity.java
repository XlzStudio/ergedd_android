package com.example.ergedd_android2.activitys;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ergedd_android2.Contract.CommentWriteContract;
import com.example.ergedd_android2.R;
import com.example.ergedd_android2.base.BaseActivity;
import com.example.ergedd_android2.bean.CommentWriteBean;
import com.example.ergedd_android2.presenter.CommentWritePresenter;

public class CommentActivity<V extends CommentWriteContract.CommentWriteView> extends BaseActivity<CommentWriteContract.CommentWriteView,CommentWritePresenter<CommentWriteContract.CommentWriteView>> implements CommentWriteContract.CommentWriteView,View.OnClickListener {

    private View status_bar_view;
    private TextView toolbar_title;
    private Toolbar toolbar;
    private RecyclerView comment_rv;
    private ImageView comment_write;


    @Override
    protected void initViewData() {
        status_bar_view = (View) findViewById(R.id.status_bar_view);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        comment_rv = (RecyclerView) findViewById(R.id.comment_rv);
        comment_write = (ImageView) findViewById(R.id.comment_write);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        toolbar_title.setText("评价");

        //设置是否显示左侧的按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //给左侧的按钮
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里处理返回按钮的逻辑
                finish();
            }
        });

        comment_write.setOnClickListener(this);
    }

    @Override
    protected int createLayout() {
        return R.layout.activity_comment;
    }

    @Override
    protected CommentWritePresenter createPresenter() {
        return new CommentWritePresenter();
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(CommentActivity.this,CommentWriteActivity.class));
    }

    @Override
    public void showSuccess(CommentWriteBean data) {

    }

    @Override
    public void showError(String error) {

    }
}
