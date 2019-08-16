package com.example.ergedd_android2.activitys;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.ergedd_android2.Constant.Constants;
import com.example.ergedd_android2.R;
import com.example.ergedd_android2.adapters.VpAdapter;
import com.example.ergedd_android2.base.SimpleActivity;
import com.example.ergedd_android2.bean.PlayMusicBean;
import com.example.ergedd_android2.fragments.MusicFragment;
import com.example.ergedd_android2.fragments.MusicWordFragment;
import com.example.ergedd_android2.utils.TimerFormatter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlayMusicActivity extends SimpleActivity {

    @BindView(R.id.toolbar_Music)
    Toolbar toolbarMusic;
    @BindView(R.id.vp_music)
    ViewPager vpMusic;
    @BindView(R.id.current_music)
    TextView currentMusic;
    @BindView(R.id.seekBar_music)
    SeekBar seekBarMusic;
    @BindView(R.id.lenth_music)
    TextView lenthMusic;
    @BindView(R.id.mode_music)
    ImageView modeMusic;
    @BindView(R.id.play_music)
    ImageView playMusic;
    @BindView(R.id.up_music)
    ImageView upMusic;
    @BindView(R.id.next_music)
    ImageView nextMusic;
    @BindView(R.id.timer_music)
    ImageView timerMusic;
    @BindView(R.id.bg_music)
    LinearLayout bgMusic;
    private VpAdapter vpAdapter;
    private ArrayList<PlayMusicBean> play;
    private int index;

    @Override
    protected void initViewData() {

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("music");
        intentFilter.addAction("isPlay");
        intentFilter.addAction("up");
        intentFilter.addAction("next");
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver,intentFilter);

        Intent intent = getIntent();
        index = intent.getIntExtra("index", -1);
        play = intent.getParcelableArrayListExtra("play");
        String name = play.get(index).getName();


        toolbarMusic.setTitle(name);
        setSupportActionBar(toolbarMusic);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Drawable drawable = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        drawable.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(drawable);

        toolbarMusic.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        seekBarMusic.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Fragment> fragments = new ArrayList<>();
        MusicFragment musicFragment = new MusicFragment();
        MusicWordFragment musicWordFragment = new MusicWordFragment();
        fragments.add(musicFragment);
        fragments.add(musicWordFragment);

        vpAdapter = new VpAdapter(getSupportFragmentManager(), fragments, strings);

    }

    @Override
    protected int createLayout() {
        return R.layout.activity_play_music;
    }


    @OnClick({R.id.mode_music, R.id.play_music, R.id.up_music, R.id.next_music})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mode_music:
                break;
            case R.id.play_music:
                if (!Constants.ISPLAY){
                    Constants.ISPLAY=true;
                    playMusic.setImageResource(R.drawable.audio_player_pause);

                }else {
                    Constants.ISPLAY=false;
                    playMusic.setImageResource(R.drawable.audio_player_play);
                }
                Intent intentMusic = new Intent();
                intentMusic.setAction("isPlay1");
                LocalBroadcastManager.getInstance(this).sendBroadcast(intentMusic);

                break;
            case R.id.up_music:
                Constants.MUSICINDEX--;
                Intent intentMusic1 = new Intent();
                intentMusic1.setAction("up1");
                LocalBroadcastManager.getInstance(this).sendBroadcast(intentMusic1);
                break;
            case R.id.next_music:
                Constants.MUSICINDEX++;
                Intent intentMusic2 = new Intent();
                intentMusic2.setAction("next1");
                LocalBroadcastManager.getInstance(this).sendBroadcast(intentMusic2);
                break;
        }
    }

    BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("music".equals(action)){
                int duration = intent.getIntExtra("duration", -1);
                int currentPosition = intent.getIntExtra("currentPosition", -1);

                currentMusic.setText(TimerFormatter.formatterTime(currentPosition));
                lenthMusic.setText(TimerFormatter.formatterTime(duration));

                 seekBarMusic.setProgress(currentPosition);
                seekBarMusic.setMax(duration);

            }else if ("isPlay".equals(action)){

                if (!Constants.ISPLAY){
                    Constants.ISPLAY=true;
                    playMusic.setImageResource(R.drawable.audio_player_pause);

                }else {

                    Constants.ISPLAY=false;
                    playMusic.setImageResource(R.drawable.audio_player_play);
                }

            }else if ("up".equals(action)){
                toolbarMusic.setTitle(play.get(Constants.MUSICINDEX).getName());

            }else if ("next".equals(action)){
                toolbarMusic.setTitle(play.get(Constants.MUSICINDEX).getName());
            }

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }
}
