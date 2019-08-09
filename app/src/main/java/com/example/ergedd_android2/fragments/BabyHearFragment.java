package com.example.ergedd_android2.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ergedd_android2.R;
import com.example.ergedd_android2.adapters.VpAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BabyHearFragment extends Fragment {


    private View view;
    private TabLayout babyhear_tab;
    private ViewPager babyhear_vp;
    private ArrayList<Fragment> fs;
    private ArrayList<String> title;

    public BabyHearFragment() {
        // Required empty public constructor
    }
    public static BabyHearFragment newInstance() {
        return new BabyHearFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_baby_hear, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        babyhear_tab = (TabLayout) inflate.findViewById(R.id.babyhear_tab);
        babyhear_vp = (ViewPager) inflate.findViewById(R.id.babyhear_vp);

        fs = new ArrayList<>();
        title = new ArrayList<>();
        initTitle();
        initFragment();
    }

    private void initFragment() {
        fs.add(new HandpickFragment());
        for (int i = 0; i <title.size()-1; i++) {
            fs.add(new BabyItemFragment());
        }
        VpAdapter vpAdapter = new VpAdapter(getChildFragmentManager(), fs, title);
        babyhear_vp.setAdapter(vpAdapter);
        babyhear_tab.addTab(babyhear_tab.newTab().setText(title.get(0)));
        babyhear_tab.addTab(babyhear_tab.newTab().setText(title.get(1)));
        babyhear_tab.addTab(babyhear_tab.newTab().setText(title.get(2)));
        babyhear_tab.addTab(babyhear_tab.newTab().setText(title.get(3)));
        babyhear_tab.addTab(babyhear_tab.newTab().setText(title.get(4)));
        babyhear_tab.addTab(babyhear_tab.newTab().setText(title.get(5)));
        babyhear_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                babyhear_vp.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        babyhear_vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(babyhear_tab));
    }

    private void initTitle() {
        title.add("精选");
        title.add("儿歌");
        title.add("故事");
        title.add("英文");
        title.add("国学");
        title.add("纯音乐");
    }
}
