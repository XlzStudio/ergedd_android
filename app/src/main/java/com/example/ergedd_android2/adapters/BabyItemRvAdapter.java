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
import com.example.ergedd_android2.bean.BabyHearItemBean;

import java.util.ArrayList;

public class BabyItemRvAdapter extends RecyclerView.Adapter<BabyItemRvAdapter.ViewHolder> {
    private ArrayList<BabyHearItemBean.DataBean> list;
    private Context context;

    public BabyItemRvAdapter(ArrayList<BabyHearItemBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.item_babyhear_bybyitem, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(list.get(i).getSquare_image_url()).into(viewHolder.babyitem_iv);
        viewHolder.babyitem_title.setText(list.get(i).getName());
        viewHolder.babyitem_text.setText(list.get(i).getDescription());
        viewHolder.babyitem_count.setText(list.get(i).getCount()+"首");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView babyitem_iv;
        private final TextView babyitem_title;
        private final TextView babyitem_text;
        private final TextView babyitem_count;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            babyitem_iv = itemView.findViewById(R.id.babyitem_iv);
            babyitem_title = itemView.findViewById(R.id.babyitem_title);
            babyitem_text = itemView.findViewById(R.id.babyitem_text);
            babyitem_count = itemView.findViewById(R.id.babyitem_count);
        }
    }
}
