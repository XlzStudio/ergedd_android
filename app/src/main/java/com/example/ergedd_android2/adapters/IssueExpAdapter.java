package com.example.ergedd_android2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.ergedd_android2.R;

import java.util.ArrayList;

public class IssueExpAdapter extends BaseExpandableListAdapter {
    //group数据
    private ArrayList<String> mGroupList;
    //item数据
    private ArrayList<ArrayList<String>> mItemList;
    private Context context;
    private LayoutInflater mInflater;

    public IssueExpAdapter(ArrayList<String> mGroupList, ArrayList<ArrayList<String>> mItemList, Context context) {
        this.mGroupList = mGroupList;
        this.mItemList = mItemList;
        this.context = context;
        this.mInflater =LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return mGroupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mItemList.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mItemList.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView = mInflater.inflate(R.layout.item_issue_group,parent,false);
        }
        TextView txt = convertView.findViewById(R.id.issue_group_txt);
        txt.setText(mGroupList.get(groupPosition));

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String s = mItemList.get(groupPosition).get(childPosition);
        if (convertView==null){
            convertView = mInflater.inflate(R.layout.item_issue_item1,parent,false);
        }
        TextView itemtxt = convertView.findViewById(R.id.issue_item_txt);
        itemtxt.setText(s);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }


}
