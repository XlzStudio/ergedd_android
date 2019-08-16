package com.example.ergedd_android2.model;

import android.util.Log;

import com.example.ergedd_android2.Contract.BabyFriendContract;
import com.example.ergedd_android2.Contract.BabyHearItemContract;
import com.example.ergedd_android2.api.ApiServer;
import com.example.ergedd_android2.base.BaseObsever;
import com.example.ergedd_android2.bean.BabyFriendBean;
import com.example.ergedd_android2.utils.HttpManager;
import com.example.ergedd_android2.utils.RxUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BabyFriendModel implements BabyFriendContract.BabyFriendModel {

    private static final String TAG = "BabyFriendModel";

    @Override
    public void getData(final CallBack callBack) {

        OkHttpClient okHttpClient = new OkHttpClient();
        Request build = new Request.Builder()
                .url("http://api.ergedd.com/api/v1/app_configs?types=brand_area")
                .addHeader("Time-Stamp", "1565767625")
                .addHeader("Device-Key", "00000000-4e86-7324-ef6b-6e9720b0bdd5")
                .addHeader("Version", "2.6.18")
                .addHeader("Authorization", "bberge_android:Android")
                .addHeader("channel", "qihu")
                .removeHeader("User-Agent")
                .addHeader("User-Agent", "android okhttp 3.3.1")
                .build();

        okHttpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                BabyFriendBean babyFriendBean = new Gson().fromJson(string, BabyFriendBean.class);
                callBack.showSuccess(babyFriendBean);
            }
        });
    }


}