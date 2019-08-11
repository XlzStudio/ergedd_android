package com.example.ergedd_android2.api;

import com.example.ergedd_android2.bean.BabyHearBean;
import com.example.ergedd_android2.bean.BabyHearItemBean;
import com.example.ergedd_android2.bean.BabyLookTabBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;


public interface ApiServer {


    /*
     * 第一个页面的Tablayout网络解析
     *http://api.ergedd.com/api/v1/album_categories?offset=0&limit=100&addition_album_count=20&channel=new
     * */
    @Headers("Cache-Control: public, max-age=28800")
    @GET
    Observable<BabyLookTabBean> getlookTab(@Url String url, @Query("channel") String channel, @Query("offset") int offset, @Query("limit") int limit, @Query("addition_album_count") int addition_album_count);

    /*
     * 宝宝听页面精选下半部分及tab栏接口
     *http://api.ergedd.com/api/v1/audio_categories?channel=original
     * */
    @GET("audio_categories?channel=original")
    Observable<BabyHearBean> getBabyHearTab();

    /*
     * 宝宝听页面fragment复用子条目接口
     *http://api.ergedd.com/api/v1/audio_categories/1/playlists?channel=new&offset=0&limit=20
     * */
    @GET("audio_categories/{id}/playlists?channel=new&offset=0&limit=20")
    Observable<BabyHearItemBean> getBabyHearItem(@Path("id") int id);
}
