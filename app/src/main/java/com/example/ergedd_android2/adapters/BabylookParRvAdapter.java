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
import com.example.ergedd_android2.bean.BabylookParBean;

import java.util.ArrayList;

public class BabylookParRvAdapter extends RecyclerView.Adapter<BabylookParRvAdapter.ViewHoder> {

    private ArrayList<BabylookParBean.DataBean> list;
    private Context context;

    public BabylookParRvAdapter(ArrayList<BabylookParBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.item_baby_look_sift_recyclerview, null);
        return new ViewHoder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder viewHoder, int i) {
        viewHoder.title.setText(list.get(i).getName());
        Glide.with(context).load(list.get(i).getImage()).into(viewHoder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView title;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
        }
    }
}
