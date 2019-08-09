package com.example.ergedd_android2.api;

import com.example.ergedd_android2.bean.BabyLookTabBean;
import com.example.ergedd_android2.bean.ListData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;


public interface ApiServer {


/*
* 第一个页面的Tablayout网络解析
*http://api.ergedd.com/api/v1/album_categories?offset=0&limit=100&addition_album_count=20&channel=new
* */
@Headers("Cache-Control: public, max-age=28800")
@GET
Observable<BabyLookTabBean>getlookTab(@Url String url,@Query("channel") String channel, @Query("offset") int offset, @Query("limit") int limit, @Query("addition_album_count") int addition_album_count);
}
