package com.example.ergedd_android2.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ergedd_android2.R;
import com.example.ergedd_android2.bean.BabyLookSiftGridBean;

import java.util.ArrayList;
import java.util.List;

public class BabyLookSiftGridAdapter extends BaseAdapter {
    private List<BabyLookSiftGridBean.DataBean> data = new ArrayList<>();
    private Fragment fragment;

    public BabyLookSiftGridAdapter(Fragment fragment) {
        this.fragment = fragment;
    }

    public void initData(List<BabyLookSiftGridBean.DataBean> data){
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
       if (data.size()>0){
           return 8;
       }
       return 0;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(fragment.getContext()).inflate(R.layout.item_baby_look_sift_grid, null);
            viewHolder = new ViewHolder();
            viewHolder.img = convertView.findViewById(R.id.img);
            viewHolder.title = convertView.findViewById(R.id.title);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(data.get(position).getName());
        Glide.with(fragment.getContext()).load(data.get(position).getIcon_url()).into(viewHolder.img);
        return convertView;
    }

    class ViewHolder {
        ImageView img;
        TextView title;
    }
}
