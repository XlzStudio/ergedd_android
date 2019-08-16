package com.example.ergedd_android2.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ergedd_android2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MusicFragment extends Fragment {


    private View view;
    private ImageView img_music;

    public MusicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        img_music = (ImageView) view.findViewById(R.id.img_music);
        Bundle bundle = getArguments();
        String url = bundle.getString("url");

        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(getActivity()).load(url).apply(requestOptions).into(img_music);

    }
}
