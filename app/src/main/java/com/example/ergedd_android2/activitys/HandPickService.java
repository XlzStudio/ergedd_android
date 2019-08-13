package com.example.ergedd_android2.activitys;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.example.ergedd_android2.bean.PlayMusicBean;

import java.io.IOException;
import java.util.ArrayList;

public class HandPickService extends Service {

    //private MediaPlayer mediaPlayer = new MediaPlayer();
    private MediaPlayer mediaPlayer;
    private final IBinder iBinder = new MusicBinder();
    private int musicIndex = 1;

    public HandPickService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

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

        public MediaPlayer getPlayer(){
            return mediaPlayer;
        }

    }

    /**
     * 播放音乐的方法
     * @param currentPath  音乐文件路径
     */
    public void playMusic(String currentPath){
        mediaPlayer = new MediaPlayer();
        try {
            if(mediaPlayer.isPlaying()){//如果当前正在播放音乐，则先停止
                mediaPlayer.stop();
            }
            mediaPlayer.reset();//重置播放器z状态
            mediaPlayer.setDataSource(currentPath);
            mediaPlayer.prepare();

            mediaPlayer.start();

            // updateSeekBar();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //设计一些歌曲播放、暂停、停止、退出相应的逻辑，此外还设计了上一首和下一首的逻辑

    public void playOrPause() {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        } else {
            mediaPlayer.start();
        }
    }

    public void nextMusic(ArrayList<PlayMusicBean> musics) {

        if(mediaPlayer != null && musicIndex < musics.size()) {
            mediaPlayer.stop();
            try {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(musics.get(musicIndex+1).getResource());
                musicIndex++;
                mediaPlayer.prepare();
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
            } catch (Exception e) {
                Log.d("hint", "can't jump next music");
                e.printStackTrace();
            }
        }
    }

    public void upMusic(ArrayList<PlayMusicBean> musics) {
        if(mediaPlayer != null && musicIndex > 0) {
            mediaPlayer.stop();
            try {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(musics.get(musicIndex+1).getResource());
                musicIndex--;
                mediaPlayer.prepare();
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
            } catch (Exception e) {
                Log.d("hint", "can't jump pre music");
                e.printStackTrace();
            }
        }
    }
}
