package com.example.ergedd_android2.adapters;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ergedd_android2.R;
import com.example.ergedd_android2.bean.BabyLookSiftItemBean;

import java.util.ArrayList;
import java.util.List;

public class BabyLookSiftItemAdapter extends RecyclerView.Adapter<BabyLookSiftItemAdapter.ViewHoder> {
    private Fragment fragment;
    private List<BabyLookSiftItemBean.DataBean> data =new ArrayList<>();

    public BabyLookSiftItemAdapter(Fragment fragment) {
        this.fragment = fragment;
    }

    public void initData(List<BabyLookSiftItemBean.DataBean> data){
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(fragment.getContext(), R.layout.item_baby_look_sift_recyclerview, null);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder viewHoder, int i) {
        viewHoder.title.setText(data.get(i).getItem().getName());
        Glide.with(fragment.getContext()).load(data.get(i).getItem().getImage()).into(viewHoder.img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title;
        ImageView download;
        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            title=itemView.findViewById(R.id.title);
            download=itemView.findViewById(R.id.disableHome);
        }
    }
}
