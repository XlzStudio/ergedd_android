package com.example.ergedd_android2.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.ergedd_android2.R;
import com.example.ergedd_android2.activitys.HandPicDetailActivity;
import com.example.ergedd_android2.bean.HandPicAlbumBean;

import java.util.ArrayList;
import java.util.List;

public class HandPicAlbumRecyclerAdapter extends RecyclerView.Adapter<HandPicAlbumRecyclerAdapter.ViewHolder> {
    Context context;
    List<HandPicAlbumBean.DataBean> data=new ArrayList<>();

    public HandPicAlbumRecyclerAdapter(Context context) {
        this.context = context;
    }

    public void getAlbum(List<HandPicAlbumBean.DataBean> data){
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context, R.layout.item_babyhear_album,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        HandPicAlbumBean.DataBean dataBean = data.get(i);
        viewHolder.name.setText(dataBean.getName());

        RoundedCorners roundedCorners = new RoundedCorners(10);
        RequestOptions requestOptions = RequestOptions.bitmapTransform(roundedCorners);
        Glide.with(context).load(dataBean.getSquare_image_url()).apply(requestOptions).into(viewHolder.img);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HandPicAlbumBean.DataBean dataBean1 = data.get(i);
                Intent intent = new Intent(context, HandPicDetailActivity.class);

                intent.putExtra("id",dataBean1.getId());
                intent.putExtra("name",dataBean1.getName());
                intent.putExtra("count",dataBean1.getCount()+"");
                intent.putExtra("content",dataBean1.getDescription());
                intent.putExtra("img",dataBean1.getSquare_image_url());
                intent.putExtra("bg", dataBean1.getImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (data.size()>0){
            return 6;
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img_babyhear_album);
            name=itemView.findViewById(R.id.name_babyhear_album);
        }
    }
}
