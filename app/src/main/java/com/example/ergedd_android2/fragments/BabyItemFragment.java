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
public class BabyItemFragment extends Fragment {


    public BabyItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_baby_item, container, false);
        return inflate;
    }

}
