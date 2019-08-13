package com.example.ergedd_android2.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ergedd_android2.R;
import com.example.ergedd_android2.bean.BabyLookSiftGridBean;

import java.util.List;

public class BabyLookSiftGridAdapter extends RecyclerView.Adapter<BabyLookSiftGridAdapter.ViewHolder> {
    private List<BabyLookSiftGridBean.DataBean> data;
    private Context context;

    public BabyLookSiftGridAdapter(List<BabyLookSiftGridBean.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.item_baby_look_sift_grid, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Glide.with(context).load(data.get(i).getIcon_url()).into(viewHolder.img);
        viewHolder.title.setText(data.get(i).getName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener!=null){
                    onClickListener.OnItemClick(i,data.get(i));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (data.size()>0){
            return 8;
        }
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
        }
    }
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener{
        void OnItemClick(int p,BabyLookSiftGridBean.DataBean dataBean);
    }
}
