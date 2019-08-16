package com.example.ergedd_android2.fragments;


import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ergedd_android2.Constant.Constants;
import com.example.ergedd_android2.Contract.BabyHearContract;
import com.example.ergedd_android2.R;
import com.example.ergedd_android2.activitys.HandPickService;
import com.example.ergedd_android2.activitys.PlayMusicActivity;
import com.example.ergedd_android2.adapters.VpAdapter;
import com.example.ergedd_android2.base.BaseFragment;
import com.example.ergedd_android2.bean.BabyHearBean;
import com.example.ergedd_android2.bean.PlayMusicBean;
import com.example.ergedd_android2.presenter.BabyHearPresenter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BabyHearFragment<V extends BabyHearContract.BabyHearView> extends BaseFragment<BabyHearContract.BabyHearView, BabyHearPresenter<BabyHearContract.BabyHearView>> implements BabyHearContract.BabyHearView {


    @BindView(R.id.babyhear_tab)
    TabLayout babyhear_tab;
    @BindView(R.id.babyhear_vp)
    ViewPager babyhear_vp;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.play_babyhear)
    ImageView playBabyhear;
    @BindView(R.id.name_play_babyhear)
    TextView namePlayBabyhear;
    @BindView(R.id.progress_play_babyhear)
    TextView progressPlayBabyhear;
    TextView lenthPlayBabyhear;
    @BindView(R.id.play_up_babyhear)
    ImageView playUpBabyhear;
    @BindView(R.id.play_next_babyhear)
    ImageView playNextBabyhear;
    @BindView(R.id.play_word_babyhear)
    ImageView playWordBabyhear;
    private ArrayList<Fragment> fs;
    private ArrayList<String> title;
//    private Unbinder unbinder;
    private static final String TAG = "BabyHearFragment";
    private ServiceConnection con;
    private MediaPlayer mediaPlayer;
    private HandPickService pickService;
    private ArrayList<PlayMusicBean> play;


    public BabyHearFragment() {
        // Required empty public constructor
    }


    public static BabyHearFragment newInstance() {

        return new BabyHearFragment();
    }

    @Override
    protected int createLayout() {
        return R.layout.fragment_baby_hear;
    }

    @Override
    protected void initViewAndData() {

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("id");
        intentFilter.addAction("play");

        intentFilter.addAction("isPlay1");
        intentFilter.addAction("up1");
        intentFilter.addAction("next1");
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(broadcastReceiver, intentFilter);

        fs = new ArrayList<>();
        title = new ArrayList<>();
        mPresenter.http();
    }


    @Override
    protected BabyHearPresenter createPresenter() {
        return new BabyHearPresenter();
    }

    @Override
    public void showSuccess(BabyHearBean data) {
        fs.add(new HandpickFragment());
        title.add("精选");
        List<BabyHearBean.DataBean> data1 = data.getData();
        for (int i = 0; i < data1.size(); i++) {
            BabyItemFragment babyItemFragment = new BabyItemFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id", data1.get(i).getId());
            babyItemFragment.setArguments(bundle);
            fs.add(babyItemFragment);
            title.add(data1.get(i).getName());
        }
        VpAdapter vpAdapter = new VpAdapter(getChildFragmentManager(), fs, this.title);
        babyhear_vp.setAdapter(vpAdapter);
        babyhear_tab.setupWithViewPager(babyhear_vp);
    }

    @Override
    public void showError(String error) {
        Log.e(TAG, "showError: " + error);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //unbinder.unbind();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getData(String title) {

    }

    private MediaPlayer player1;
    //广播接收器
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            //点击更多，跳转到相应的tab页面
            if ("id".equals(action)) {
                int id = intent.getIntExtra("id", -1);
                babyhear_tab.setScrollPosition(id, 0, false);

                //设vp当前显示的tab页面
                babyhear_vp.setCurrentItem(id);

            } else if ("progress".equals(action)){

                int currentPosition = intent.getIntExtra("currentPosition", -1);
                int duration = intent.getIntExtra("duration", -1);


//                progressBar.setProgress(duration);
//                progressBar.setMax(currentPosition);

                //点击条目，广播集合
             }else if ("play".equals(action)) {


//                NameIndex = intent.getIntExtra("id",-1);
                play = intent.getParcelableArrayListExtra("play");
                namePlayBabyhear.setText(play.get(Constants.MUSICINDEX).getName());


                //启动后台服务
                Intent intent1 = new Intent(getContext(), HandPickService.class);
                con = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {

                        HandPickService.MusicBinder binder = (HandPickService.MusicBinder) service;
                        pickService = binder.getService();
                        mediaPlayer = binder.getPlayer();

                        pickService.getProgress(progressBar,progressPlayBabyhear,lenthPlayBabyhear);
                        pickService.playProgress(play,Constants.MUSICINDEX);////////////
                        pickService.playMusic(play.get(Constants.MUSICINDEX).getResource());///////////
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {

                    }
                };
                getActivity().bindService(intent1, con, Context.BIND_AUTO_CREATE);

            }else if("isPlay1".equals(action)){

                Log.e("liangxq", "onReceive: 停止" );
                pickService.playOrPause();

            }else if("up1".equals(action)){

                pickService.upMusic(play);

            }else if("next1".equals(action)){

                pickService.nextMusic(play);
            }
        }
    };


    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(broadcastReceiver);
        getActivity().unbindService(con);

    }

    private boolean isPlay=false;
    @OnClick({R.id.play_babyhear, R.id.play_up_babyhear, R.id.play_next_babyhear, R.id.play_word_babyhear})
    public void onClick(View view) {

//        Intent intentMusic = new Intent();

        switch (view.getId()) {
            case R.id.play_babyhear:

                //歌曲播放、暂停
                pickService.playOrPause();//需要非空判断

                if (!Constants.ISPLAY){
                    Constants.ISPLAY=true;
                    playBabyhear.setImageResource(R.drawable.audio_player_pause);
                }else {
                    Constants.ISPLAY=false;
                    playBabyhear.setImageResource(R.drawable.audio_player_play);
                }

                Intent intentMusic = new Intent();
                intentMusic.putParcelableArrayListExtra("play",play);
                intentMusic.setAction("isPlay");
                LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(intentMusic);
                break;
            case R.id.play_up_babyhear:

                //上首歌曲
                if ( Constants.MUSICINDEX >0){

                    namePlayBabyhear.setText(play.get(Constants.MUSICINDEX-1).getName());////////
                    pickService.upMusic(play);
//                    NameIndex--;
                    Constants.MUSICINDEX--;
                }



                Intent intentMusic1 = new Intent();
                intentMusic1.setAction("up");
                intentMusic1.putExtra("index",Constants.MUSICINDEX);
                LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(intentMusic1);
                break;
            case R.id.play_next_babyhear:

                //下首歌曲
                if ( Constants.MUSICINDEX < play.size()){

                    namePlayBabyhear.setText(play.get(Constants.MUSICINDEX+1).getName());
                    pickService.nextMusic(play);
//                    NameIndex++;
                    Constants.MUSICINDEX++;
                }

//
                Intent intentMusic2 = new Intent();
                intentMusic2.setAction("next");
                intentMusic2.putExtra("index",Constants.MUSICINDEX);
                LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(intentMusic2);
                break;
            case R.id.play_word_babyhear:

                Intent intent = new Intent(getActivity(), PlayMusicActivity.class);
                intent.putParcelableArrayListExtra("play",play);
                intent.putExtra("index",Constants.MUSICINDEX);

                startActivity(intent);

                break;
        }


//        LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(intentMusic);
    }
}
