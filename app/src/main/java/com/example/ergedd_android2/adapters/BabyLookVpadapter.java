package com.example.ergedd_android2.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ergedd_android2.bean.BabyLookTabBean;

import java.util.ArrayList;
import java.util.List;

public class BabyLookVpadapter  extends FragmentPagerAdapter {
    private ArrayList<Fragment>list;
    private List<BabyLookTabBean.DataBean> tablist;


    public BabyLookVpadapter(FragmentManager fm, ArrayList<Fragment> list, List<BabyLookTabBean.DataBean> tablist) {
        super(fm);
        this.list = list;
        this.tablist = tablist;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tablist.get(position).getName();
    }
}
