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
import com.example.ergedd_android2.bean.BabyLookInnerBean;

import java.util.ArrayList;
import java.util.List;

public class BabyLookInnerAdapter extends RecyclerView.Adapter<BabyLookInnerAdapter.ViewHolder> {
    private List<BabyLookInnerBean.DataBean> data=new ArrayList<>();
    private Fragment fragment;

    public BabyLookInnerAdapter(Fragment fragment) {
        this.fragment = fragment;
    }

    public void initData( List<BabyLookInnerBean.DataBean> data){
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(fragment.getContext(), R.layout.item_baby_look_inner, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.name.setText(data.get(i).getName());
        int video_count = data.get(i).getVideo_count();
        viewHolder.quantity.setText("共"+video_count+"集");
        viewHolder.title.setText(data.get(i).getDescription());

        Glide.with(fragment.getContext()).load(data.get(i).getImage_url()).into(viewHolder.img);
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
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,title,quantity;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            title=itemView.findViewById(R.id.title);
            quantity=itemView.findViewById(R.id.quantity);
            img=itemView.findViewById(R.id.img);
        }
    }
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener{
        void OnItemClick(int p,BabyLookInnerBean.DataBean dataBean);
    }
}
