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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.ergedd_android2.R;
import com.example.ergedd_android2.activitys.HandPicDetailActivity;
import com.example.ergedd_android2.bean.HandPicAlbumBean;
import com.example.ergedd_android2.bean.HandPicBottomListBean;

import java.util.ArrayList;
import java.util.List;

public class HandPicRecyclerAdapter extends RecyclerView.Adapter<HandPicRecyclerAdapter.ViewHolder> {
    Context context;
    List<HandPicBottomListBean.DataBean> data=new ArrayList<>();

    public HandPicRecyclerAdapter(Context context) {
        this.context = context;
    }

    public void getBottom(List<HandPicBottomListBean.DataBean> data){
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context, R.layout.item_babyhear_album_bottom,null);
        return new HandPicRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final HandPicBottomListBean.DataBean dataBean = data.get(i);
        viewHolder.title.setText(dataBean.getName());
        Glide.with(context).load(dataBean.getImage()).into(viewHolder.img0);

        RoundedCorners roundedCorners = new RoundedCorners(15);
        RequestOptions requestOptions = RequestOptions.bitmapTransform(roundedCorners);

            HandPicBottomListBean.DataBean.PlaylistsBean playlistsBean = dataBean.getPlaylists().get(0);
            viewHolder.name1.setText(playlistsBean.getName());
            viewHolder.count1.setText(playlistsBean.getCount()+"");
            Glide.with(context).load(playlistsBean.getSquare_image_url()).apply(requestOptions).into(viewHolder.img1);

            HandPicBottomListBean.DataBean.PlaylistsBean playlistsBean1 = dataBean.getPlaylists().get(1);
            viewHolder.name2.setText(playlistsBean1.getName());
            viewHolder.count2.setText(playlistsBean1.getCount()+"");
            Glide.with(context).load(playlistsBean1.getSquare_image_url()).apply(requestOptions).into(viewHolder.img2);

            HandPicBottomListBean.DataBean.PlaylistsBean playlistsBean2 = dataBean.getPlaylists().get(2);
            viewHolder.name3.setText(playlistsBean2.getName());
            viewHolder.count3.setText(playlistsBean2.getCount()+"");
            Glide.with(context).load(playlistsBean2.getSquare_image_url()).apply(requestOptions).into(viewHolder.img3);
            imgClick(i,viewHolder.img1,viewHolder.img2,viewHolder.img3);

            viewHolder.more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = dataBean.getId();
                    Intent intent = new Intent();
                    intent.setAction("id");
                    intent.putExtra("id",i+1);
                    LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                }
            });
    }

    private void imgClick(@NonNull final int i,ImageView img1,ImageView img2,ImageView img3) {
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HandPicBottomListBean.DataBean.PlaylistsBean dataBean1 = data.get(i).getPlaylists().get(0);
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
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HandPicBottomListBean.DataBean.PlaylistsBean dataBean1 = data.get(i).getPlaylists().get(1);
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
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HandPicBottomListBean.DataBean.PlaylistsBean dataBean1 = data.get(i).getPlaylists().get(2);
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
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img0;
        ImageView img1;
        ImageView img2;
        ImageView img3;
        TextView title;
        TextView name1;
        TextView name2;
        TextView name3;
        TextView count1;
        TextView count2;
        TextView count3;
        TextView more;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img0=itemView.findViewById(R.id.img_babyhear_album_bottom);
            img1=itemView.findViewById(R.id.img1_babyhear_album_bottom);
            img2=itemView.findViewById(R.id.img2_babyhear_album_bottom);
            img3=itemView.findViewById(R.id.img3_babyhear_album_bottom);
            title=itemView.findViewById(R.id.title_babyhear_album_bottom);
            name1=itemView.findViewById(R.id.name1_babyhear_album_bottom);
            name2=itemView.findViewById(R.id.name2_babyhear_album_bottom);
            name3=itemView.findViewById(R.id.name3_babyhear_album_bottom);
            count1=itemView.findViewById(R.id.count1_babyhear_album_bottom);
            count2=itemView.findViewById(R.id.count2_babyhear_album_bottom);
            count3=itemView.findViewById(R.id.count3_babyhear_album_bottom);
            more=itemView.findViewById(R.id.more_babyhear_album_bottom);
        }
    }
}
