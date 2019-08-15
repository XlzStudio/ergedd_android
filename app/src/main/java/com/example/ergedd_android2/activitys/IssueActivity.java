package com.example.ergedd_android2.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.ergedd_android2.R;

import java.util.ArrayList;

public class IssueActivity extends AppCompatActivity {

    private TextView issue_toolbar_title;
    private Toolbar issue_Toolbar;
    private ExpandableListView issue_elv;
    //group数据
    private ArrayList<String> mGroupList;
    //item数据
    private ArrayList<ArrayList<String>> mItemList;
    private WebView issue_web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue);
        initView();
    }

    private void initView() {
        issue_toolbar_title = (TextView) findViewById(R.id.issue_toolbar_title);
        issue_Toolbar = (Toolbar) findViewById(R.id.issue_Toolbar);
        issue_web = (WebView) findViewById(R.id.issue_web);

        issue_Toolbar.setTitle("");
        setSupportActionBar(issue_Toolbar);

        issue_toolbar_title.setText("常见问题");

        //设置是否显示左侧的按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //给左侧的按钮
        issue_Toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里处理返回按钮的逻辑
                finish();
            }
        });


        issue_web.getSettings().setJavaScriptEnabled(true);
        issue_web.setWebViewClient(new WebViewClient());
        issue_web.loadUrl("http://api.ergedd.com/h5static/android.html?app=%E5%84%BF%E6%AD%8C%E7%82%B9%E7%82%B9");
    }
}
