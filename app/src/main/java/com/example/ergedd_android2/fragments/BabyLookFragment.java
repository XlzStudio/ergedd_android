package com.example.ergedd_android2.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ergedd_android2.R;
import com.example.ergedd_android2.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class BabyLookFragment extends BaseFragment {


    public BabyLookFragment() {
        // Required empty public constructor
    }
    public static BabyLookFragment newInstance() {

        return new BabyLookFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_baby_look, container, false);
    }

}
