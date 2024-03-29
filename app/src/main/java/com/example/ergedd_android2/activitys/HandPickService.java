package com.example.ergedd_android2.activitys;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ergedd_android2.Constant.Constants;
import com.example.ergedd_android2.bean.PlayMusicBean;
import com.example.ergedd_android2.utils.TimerFormatter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HandPickService extends Service {

    //private MediaPlayer mediaPlayer = new MediaPlayer();
    private MediaPlayer mediaPlayer;
    private final IBinder iBinder = new MusicBinder();
    private Timer timer;


    public HandPickService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return iBinder;
    }



    /**
     * MusicBinder 提供了getService方法来获得当前MusicService的实例
     */
    public class  MusicBinder extends Binder{
        public HandPickService getService(){
            return HandPickService.this;
        }
    }

    /**
     * 播放音乐的方法
     * @param currentPath  音乐文件路径
     */
    public synchronized void playMusic(final String currentPath){
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    if(mediaPlayer.isPlaying()){//如果当前正在播放音乐，则先停止
                        mediaPlayer.stop();
                    }
                    mediaPlayer.reset();//重置播放器状态
                    mediaPlayer.setDataSource(currentPath);
                    mediaPlayer.prepare();

                    mediaPlayer.start();

                    // updateSeekBar();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();

    }

    //设计一些歌曲播放、暂停、停止、退出相应的逻辑，此外还设计了上一首和下一首的逻辑

    public synchronized void playOrPause() {

        new Thread(){
            @Override
            public void run() {
                super.run();
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                } else {
                    mediaPlayer.start();
                }
            }
        }.start();

    }

    private int musicIndex = 0;//记录点击下标

    public synchronized void nextMusic(final ArrayList<PlayMusicBean> musics) {
//        musicIndex=index;

        new Thread(){
            @Override
            public void run() {
                super.run();
                if(mediaPlayer != null && Constants.MUSICINDEX < musics.size()) {//////////
                    mediaPlayer.stop();
                    try {
                        mediaPlayer.reset();
                        mediaPlayer.setDataSource(musics.get(Constants.MUSICINDEX+1).getResource());/////////
                        Constants.MUSICINDEX++;/////////
                        mediaPlayer.prepare();
                        mediaPlayer.seekTo(0);
                        mediaPlayer.start();
                    } catch (Exception e) {
                        Log.d("hint", "can't jump next music");
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }

    public synchronized void upMusic(final ArrayList<PlayMusicBean> musics) {
//        musicIndex=index;

        new Thread(){
            @Override
            public void run() {
                super.run();
                if(mediaPlayer != null && Constants.MUSICINDEX > 0) {
                    mediaPlayer.stop();
                    try {
                        mediaPlayer.reset();
                        mediaPlayer.setDataSource(musics.get(Constants.MUSICINDEX+1).getResource());
                        Constants.MUSICINDEX--;
                        mediaPlayer.prepare();
                        mediaPlayer.seekTo(0);
                        mediaPlayer.start();
                    } catch (Exception e) {
                        Log.d("hint", "can't jump pre music");
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }

    //音乐播放进度条
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //mp.getCurrentPosition() 得到mp的播放进度，把他设置给sb当做进度，两者保持一致
            final int duration = mediaPlayer.getDuration();
            int currentPosition = mediaPlayer.getCurrentPosition();


            progressBar.setMax(duration);
            progressBar.setProgress(currentPosition);


            //设置播放进度时间
            progressPlayBabyhear.setText(TimerFormatter.
                    formatterTime(mediaPlayer.getCurrentPosition())+"/"+
                    TimerFormatter.formatterTime(mediaPlayer.getDuration()));

            Intent intent = new Intent();
            intent.setAction("music");
            intent.putExtra("duration",duration);
            intent.putExtra("currentPosition",currentPosition);
            LocalBroadcastManager.getInstance(HandPickService.this).sendBroadcast(intent);

            if(mediaPlayer.getCurrentPosition() == mediaPlayer.getDuration()){
                timer.cancel();
            }
        }
    };

    public void playProgress(final ArrayList<PlayMusicBean> musics, final int index) {

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                handler.sendEmptyMessage(1);
            }
        },0,50);

    }

    ProgressBar progressBar;
    TextView progressPlayBabyhear;
    TextView lenthPlayBabyhear;
    public void getProgress(ProgressBar progressBar, TextView progressPlayBabyhear,TextView lenthPlayBabyhear) {
        this.progressBar=progressBar;
        this.progressPlayBabyhear=progressPlayBabyhear;
        this.lenthPlayBabyhear=lenthPlayBabyhear;
    }

}
