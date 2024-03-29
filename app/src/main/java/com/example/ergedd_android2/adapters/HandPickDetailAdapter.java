package com.example.ergedd_android2.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ergedd_android2.Constant.Constants;
import com.example.ergedd_android2.R;
import com.example.ergedd_android2.bean.BabyLookInnerBean;
import com.example.ergedd_android2.bean.HandPicDetailBean;
import com.example.ergedd_android2.bean.PlayMusicBean;

import java.util.ArrayList;
import java.util.List;

public class HandPickDetailAdapter extends RecyclerView.Adapter<HandPickDetailAdapter.ViewHolder> {
    private List<HandPicDetailBean.RecordBean.AudiosBean> audios=new ArrayList<>();
    private Context context;
    public HandPickDetailAdapter(Context context) {
        this.context = context;
    }

    public void initData(List<HandPicDetailBean.RecordBean.AudiosBean> audios){
        this.audios.clear();
        this.audios.addAll(audios);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_baby_hear_detail, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final HandPicDetailBean.RecordBean.AudiosBean audiosBean = audios.get(i);
        viewHolder.lenth.setText(audiosBean.getId()+"");
        viewHolder.name.setText(audiosBean.getName());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HandPicDetailBean.RecordBean.AudiosBean audiosBean1 = audios.get(i);
                Intent intent = new Intent();
                intent.setAction("play");

                ArrayList<PlayMusicBean> playMusicBeans = new ArrayList<>();
                for (int j = 0; j <audios.size(); j++) {

                    PlayMusicBean playMusicBean = new PlayMusicBean();
                    playMusicBean.setName(audios.get(j).getName());
                    playMusicBean.setResource(audios.get(j).getResource());
                    playMusicBeans.add(playMusicBean);

                }

//                intent.putExtra("id",i);
                Constants.MUSICINDEX=i;
                intent.putParcelableArrayListExtra("play",playMusicBeans);

                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return audios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView lenth;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name_babyhear_detail);
            lenth=itemView.findViewById(R.id.lenth_babyhear_detail);
        }
    }
}
