package com.example.ergedd_android2.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class CacheVpAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment>cachelist;
    private String[]s={"",""};


    public CacheVpAdapter(FragmentManager fm, ArrayList<Fragment> cachelist) {
        super(fm);
        this.cachelist = cachelist;
    }

    @Override
    public Fragment getItem(int i) {
        return cachelist.get(i);
    }

    @Override
    public int getCount() {
        return cachelist.size();
    }
}
