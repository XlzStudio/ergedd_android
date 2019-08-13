package com.example.ergedd_android2.activitys;

import android.Manifest;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ergedd_android2.Contract.BabylookParContract;
import com.example.ergedd_android2.R;
import com.example.ergedd_android2.adapters.BabylookParRvAdapter;
import com.example.ergedd_android2.base.BaseActivity;
import com.example.ergedd_android2.bean.BabylookParBean;
import com.example.ergedd_android2.presenter.BabylookParPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.ArrayList;

public class ParticularsActivity<V extends BabylookParContract.BabylookParView> extends BaseActivity<BabylookParContract.BabylookParView, BabylookParPresenter<BabylookParContract.BabylookParView>> implements BabylookParContract.BabylookParView {
    //appkey:5d520f720cafb2aebc0007a5

    private RecyclerView particulars_rv;
    private ArrayList<BabylookParBean.DataBean> list;
    private BabylookParRvAdapter babylookParRvAdapter;
    private static final String TAG = "ParticularsActivity";
    private View status_bar_view;
    private TextView toolbar_title;
    private Toolbar toolbar;
    private String title;
    private SmartRefreshLayout smart_refresh_layout;
    private int id;


    @Override
    protected void initViewData() {
        status_bar_view = (View) findViewById(R.id.status_bar_view);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        particulars_rv = (RecyclerView) findViewById(R.id.particulars_rv);
        smart_refresh_layout = (SmartRefreshLayout) findViewById(R.id.smart_refresh_layout);

        particulars_rv.setLayoutManager(new LinearLayoutManager(this));
        toolbar.setTitle("");
        setSupportActionBar(toolbar);


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

        list = new ArrayList<>();
        babylookParRvAdapter = new BabylookParRvAdapter(list, this);
        particulars_rv.setAdapter(babylookParRvAdapter);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        title = intent.getStringExtra("title");
        toolbar_title.setText(title);

        initItemData();
        initPre();
        smart_refresh_layout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
//                page++;
//                initItemData();
                smart_refresh_layout.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                list.clear();
                initItemData();
                babylookParRvAdapter.notifyDataSetChanged();
                smart_refresh_layout.finishRefresh();
            }
        });
    }

    private void initItemData() {
        mPresenter.http(id);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.particulars_toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.comment:
                Toast.makeText(this, "暂无评论", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                share();
                break;
            default:
                break;
        }
        return true;
    }

    private void share() {
        UMImage image = new UMImage(ParticularsActivity.this, "http://ww1.sinaimg.cn/large/0065oQSqly1frrifts8l5j30j60ojq6u.jpg");//网络图片
//        UMImage thumb = new UMImage(this, R.drawable.umeng_socialize_wechat);
//        image.setThumb(thumb);
        image.compressStyle = UMImage.CompressStyle.QUALITY;//质量压缩，适合长图的分享
        new ShareAction(ParticularsActivity.this)
                .withText(title)
                .withMedia(image)
                .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN)
                .setCallback(umShareListener)
                .open();
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
        Log.e(TAG, "showError: " + error);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (grantResults.length > 0 && requestCode == 123) {

        }
    }

    private void initPre() {
        String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
        ActivityCompat.requestPermissions(this, mPermissionList, 123);
    }

    private UMShareListener umShareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(ParticularsActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(ParticularsActivity.this, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(ParticularsActivity.this, "取消了", Toast.LENGTH_LONG).show();

        }
    };

}
