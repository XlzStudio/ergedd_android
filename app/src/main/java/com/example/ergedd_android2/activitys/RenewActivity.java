package com.example.ergedd_android2.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.ergedd_android2.R;

public class RenewActivity extends AppCompatActivity {

    private TextView renew_toolbar_title;
    private Toolbar renew_Toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renew);
        initView();
    }

    private void initView() {
        renew_toolbar_title = (TextView) findViewById(R.id.renew_toolbar_title);
        renew_Toolbar = (Toolbar) findViewById(R.id.renew_Toolbar);

        renew_Toolbar.setTitle("");
        setSupportActionBar(renew_Toolbar);

        renew_toolbar_title.setText("自动续费");


        //设置是否显示左侧的按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //给左侧的按钮
        renew_Toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里处理返回按钮的逻辑
                finish();
            }
        });
    }
}
