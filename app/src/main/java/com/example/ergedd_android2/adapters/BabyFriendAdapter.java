package com.example.ergedd_android2.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ergedd_android2.R;
import com.example.ergedd_android2.activitys.BabyFriendDetailActivity;
import com.example.ergedd_android2.bean.BabyFriendBean;
import com.example.ergedd_android2.bean.HandPicDetailBean;
import com.example.ergedd_android2.bean.PlayMusicBean;

import java.util.ArrayList;
import java.util.List;

public class BabyFriendAdapter extends RecyclerView.Adapter<BabyFriendAdapter.ViewHolder> {
    private List<BabyFriendBean.DataBean> audios=new ArrayList<>();
    private Context context;
    public BabyFriendAdapter(Context context) {
        this.context = context;
    }

    public void initData(List<BabyFriendBean.DataBean> audios){
        this.audios.clear();
        this.audios.addAll(audios);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_baby_friend, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        BabyFriendBean.DataBean audiosBean = audios.get(i);
        viewHolder.name.setText(audiosBean.getTitle());

        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(context).load(audiosBean.getImage_url()).apply(requestOptions).into(viewHolder.img);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BabyFriendDetailActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return audios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img_baby_friend);
            name=itemView.findViewById(R.id.name_baby_friend);
        }
    }
}
