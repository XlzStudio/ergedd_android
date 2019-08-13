package com.example.ergedd_android2.activitys;

import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.ergedd_android2.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private RelativeLayout mSoundUnfold;
    private Switch mSoundSw;
    private boolean aBoolean;
    private RelativeLayout mRestMorning;
    private RelativeLayout mRestNigh;
    private PopupWindow window;
    private PopupWindow popupWindow;
    /**
     * 06:00
     */
    private TextView mTimeMorning;
    /**
     * 21:00
     */
    private TextView mTimeNight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
    }
//rest_morning  rest_nigh

    private void initView() {
        mTimeMorning = (TextView) findViewById(R.id.time_morning);
        mTimeNight = (TextView) findViewById(R.id.time_night);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mSoundUnfold = (RelativeLayout) findViewById(R.id.rest_unfold);
        mSoundSw = (Switch) findViewById(R.id.rest_sw);
        mRestMorning = (RelativeLayout) findViewById(R.id.rest_morning);
        mRestMorning.setOnClickListener(this);
        mRestNigh = (RelativeLayout) findViewById(R.id.rest_nigh);
        mRestNigh.setOnClickListener(this);

        mToolbar.setTitle("设置");
        mToolbar.setTitleTextColor(Color.GREEN);
        setSupportActionBar(mToolbar);

        mSoundSw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aBoolean) {
                    mSoundUnfold.setVisibility(View.GONE);
                    aBoolean = false;
                } else {
                    mSoundUnfold.setVisibility(View.VISIBLE);
                    aBoolean = true;
                }
            }
        });
        createPop();
    }

    private void createPop() {
        View inflate = View.inflate(this, R.layout.setting_popupwindow_morning, null);
        window = new PopupWindow(inflate);
        window.setAnimationStyle(R.style.take_photo_anim);
        //设置SelectPicPopupWindow弹出窗体的宽
        window.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置SelectPicPopupWindow弹出窗体的高
        window.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置SelectPicPopupWindow弹出窗体可点击
        window.setFocusable(true);

        window.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });

        TextView time_6 = inflate.findViewById(R.id.time_6);
        TextView time_6_3 = inflate.findViewById(R.id.time_6_3);
        TextView time_7 = inflate.findViewById(R.id.time_7);
        TextView time_7_3 = inflate.findViewById(R.id.time_7_3);
        TextView time_8 = inflate.findViewById(R.id.time_8);
        TextView time_8_3 = inflate.findViewById(R.id.time_8_3);
        TextView time_9 = inflate.findViewById(R.id.time_9);
        time_6.setOnClickListener(this);
        time_6_3.setOnClickListener(this);
        time_7.setOnClickListener(this);
        time_7_3.setOnClickListener(this);
        time_8.setOnClickListener(this);
        time_8_3.setOnClickListener(this);
        time_9.setOnClickListener(this);

        View inflate1 = View.inflate(this, R.layout.setting_popupwindow_night, null);
        popupWindow = new PopupWindow(inflate1);
        popupWindow.setAnimationStyle(R.style.take_photo_anim);
        //设置SelectPicPopupWindow弹出窗体的宽
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置SelectPicPopupWindow弹出窗体的高
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置SelectPicPopupWindow弹出窗体可点击
        popupWindow.setFocusable(true);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });

        TextView time_20 = inflate1.findViewById(R.id.time_20);
        TextView time_20_3 = inflate1.findViewById(R.id.time_20_3);
        TextView time_21 = inflate1.findViewById(R.id.time_21);
        TextView time_21_3 = inflate1.findViewById(R.id.time_21_3);
        TextView time_22 = inflate1.findViewById(R.id.time_22);
        TextView time_22_3 = inflate1.findViewById(R.id.time_22_3);
        TextView time_23 = inflate1.findViewById(R.id.time_23);
        TextView time_23_3 = inflate1.findViewById(R.id.time_23_3);
        TextView time_24 = inflate1.findViewById(R.id.time_24);
        time_20.setOnClickListener(this);
        time_20_3.setOnClickListener(this);
        time_21.setOnClickListener(this);
        time_21_3.setOnClickListener(this);
        time_22.setOnClickListener(this);
        time_22_3.setOnClickListener(this);
        time_23.setOnClickListener(this);
        time_23_3.setOnClickListener(this);
        time_24.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rest_morning:
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 0.7f;
                getWindow().setAttributes(lp);


                Rect rect = new Rect();
                getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int winHeight = getWindow().getDecorView().getHeight();
                window.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM, 0, winHeight - rect.bottom);
                break;
            case R.id.rest_nigh:
                WindowManager.LayoutParams lp1 = getWindow().getAttributes();
                lp1.alpha = 0.7f;
                getWindow().setAttributes(lp1);


                Rect rec1t = new Rect();
                getWindow().getDecorView().getWindowVisibleDisplayFrame(rec1t);
                int winHeight1 = getWindow().getDecorView().getHeight();
                popupWindow.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM, 0, winHeight1 - rec1t.bottom);
                break;

            case R.id.time_6:
                mTimeMorning.setText("06:00");
                window.dismiss();
                break;
            case R.id.time_6_3:
                mTimeMorning.setText("06:30");
                window.dismiss();
                break;
            case R.id.time_7:
                mTimeMorning.setText("07:00");
                window.dismiss();
                break;
            case R.id.time_7_3:
                mTimeMorning.setText("07:30");
                window.dismiss();
                break;
            case R.id.time_8:
                mTimeMorning.setText("08:00");
                window.dismiss();
                break;
            case R.id.time_8_3:
                mTimeMorning.setText("08:30");
                window.dismiss();
                break;
            case R.id.time_9:
                mTimeMorning.setText("09:00");
                window.dismiss();
                break;
            case R.id.time_20:
                mTimeNight.setText("20:00");
                popupWindow.dismiss();
                break;
            case R.id.time_20_3:
                mTimeNight.setText("20:30");
                popupWindow.dismiss();
                break;
            case R.id.time_21:
                mTimeNight.setText("21:00");
                popupWindow.dismiss();
                break;
            case R.id.time_21_3:
                mTimeNight.setText("21:30");
                popupWindow.dismiss();
                break;
            case R.id.time_22:
                mTimeNight.setText("22:00");
                popupWindow.dismiss();
                break;
            case R.id.time_22_3:
                mTimeNight.setText("22:30");
                popupWindow.dismiss();
                break;
            case R.id.time_23:
                mTimeNight.setText("23:00");
                popupWindow.dismiss();
                break;
            case R.id.time_23_3:
                mTimeNight.setText("23:30");
                popupWindow.dismiss();
                break;
            case R.id.time_24:
                mTimeNight.setText("24:00");
                popupWindow.dismiss();
                break;
        }
    }
}
