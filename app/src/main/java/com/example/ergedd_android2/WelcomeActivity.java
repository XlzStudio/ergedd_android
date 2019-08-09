package com.example.ergedd_android2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {

    private int page=3;

    @SuppressLint("HandlerLeak")
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            page--;
            if (page<0){
                timerTask.cancel();
                mediaPlayer.release();

                Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);

                finish();
            }
        }
    };
    private TimerTask timerTask;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initview();
    }

    private void initview() {
        mediaPlayer = MediaPlayer.create(this, R.raw.ergedd_introduce);

        mediaPlayer.start();

        Timer timer = new Timer();

        timerTask = new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                handler.handleMessage(message);
            }
        };

        timer.schedule(timerTask,2000,1000);
    }
}
