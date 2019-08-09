package com.example.ergedd_android2.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ergedd_android2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BabyLookInnerFragment extends Fragment {
private int cid;

    public BabyLookInnerFragment() {
        // Required empty public constructor
    }
    public BabyLookInnerFragment bundle(int id) {
        this.cid = id;
        return new BabyLookInnerFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_baby_look_inner, container, false);
    }

}
