package com.example.ergedd_android2.utils;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.ergedd_android2.R;
import com.example.ergedd_android2.app.MyApp;

import java.util.Random;

public class PopUtils implements View.OnClickListener {

    private TextView input;
    private char aChar;
    private char aChar1;
    private boolean aBoolean;
    private String s2;
    private String s1;
    private TextView question;
    private String s4;
    private PopupWindow popupWindow;
    private View view;
    private Class<?> aClass;
    private Context context;

    public void statrPop(View view1, Context context, Class<?> c) {
        view = View.inflate(MyApp.getInstance(), R.layout.view_unlock_dialog, null);
        popupWindow = new PopupWindow(view, 360, 60);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(true);
        question = view.findViewById(R.id.unlock_question);
        input = view.findViewById(R.id.unlock_input);
        TextView btn_1 = view.findViewById(R.id.btn_1);
        TextView btn_2 = view.findViewById(R.id.btn_2);
        TextView btn_3 = view.findViewById(R.id.btn_3);
        TextView btn_4 = view.findViewById(R.id.btn_4);
        TextView btn_5 = view.findViewById(R.id.btn_5);
        TextView btn_6 = view.findViewById(R.id.btn_6);
        TextView btn_7 = view.findViewById(R.id.btn_7);
        TextView btn_8 = view.findViewById(R.id.btn_8);
        TextView btn_9 = view.findViewById(R.id.btn_9);
        TextView btn_0 = view.findViewById(R.id.btn_0);
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);

        random();

        ImageView viewById = view.findViewById(R.id.close);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popupWindow.showAtLocation(view1, Gravity.CENTER, 0, 0);
        aClass=c;
        this.context=context;

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_0:
                setText("0");
                break;
            case R.id.btn_1:
                setText("1");
                break;
            case R.id.btn_2:
                setText("2");
                break;
            case R.id.btn_3:
                setText("3");
                break;
            case R.id.btn_4:
                setText("4");
                break;
            case R.id.btn_5:
                setText("5");
                break;
            case R.id.btn_6:
                setText("6");
                break;
            case R.id.btn_7:
                setText("7");
                break;
            case R.id.btn_8:
                setText("8");
                break;
            case R.id.btn_9:
                setText("9");
                break;
        }
    }

    private void setText(String c) {
        if (aBoolean) {
            aBoolean = false;
            if (c.equals(s2)) {
                input.setText(s4 + c);
                Intent intent = new Intent(context, aClass);
                context.startActivity(intent);
                popupWindow.dismiss();
            } else {
                input.setText("");
                random();
                Animation shake = AnimationUtils.loadAnimation(MyApp.getInstance(), R.anim.shake);//加载动画资源文件
                view.startAnimation(shake); //给组件播放动画效果
            }
        } else {
            aBoolean = true;
            if (c.equals(s1)) {
                s4 = c;
                input.setText(c);
            } else {
                random();
                Animation shake = AnimationUtils.loadAnimation(MyApp.getInstance(), R.anim.shake);//加载动画资源文件
                view.startAnimation(shake); //给组件播放动画效果
            }
        }
    }

    private void random() {
        Random random = new Random();
        int i = random.nextInt(5) + 2;
        int i1 = random.nextInt(4) + 5;

        question.setText(i + " * " + i1 + "=");

        int i3 = i * i1;
        String s = String.valueOf(i3);
        char[] chars = s.toCharArray();

        s1 = String.valueOf(chars[0]);
        s2 = String.valueOf(chars[1]);
    }
}
