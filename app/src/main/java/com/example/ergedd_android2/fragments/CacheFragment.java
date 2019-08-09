package com.example.ergedd_android2.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ergedd_android2.R;
import com.example.ergedd_android2.adapters.CacheVpAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CacheFragment extends Fragment {


    private TabLayout cache_tab;
    private ViewPager cache_vp;
    private ArrayList<Fragment> fragments;
    private CacheVpAdapter adapter;

    public CacheFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cache, container, false);

        initView(view);
        return view;
    }


    private void initView(View view) {
        cache_tab = (TabLayout) view.findViewById(R.id.cache_tab);
        cache_vp = (ViewPager) view.findViewById(R.id.cache_vp);

        fragments = new ArrayList<>();

        fragments.add(new VideoAlbumFragment());
        fragments.add(new VideoFragment());
        fragments.add(new FrequencyFragment());

        adapter = new CacheVpAdapter(getChildFragmentManager(),fragments);
        cache_vp.setAdapter(adapter);

        cache_tab.addTab(cache_tab.newTab().setText("视频专辑"));
        cache_tab.addTab(cache_tab.newTab().setText("视频"));
        cache_tab.addTab(cache_tab.newTab().setText("音频"));

        cache_tab.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                cache_vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        cache_vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(cache_tab));
    }
}
