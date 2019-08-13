package com.example.ergedd_android2.api;

import com.example.ergedd_android2.bean.BabyHearBean;
import com.example.ergedd_android2.bean.BabyHearItemBean;
import com.example.ergedd_android2.bean.BabyLookInnerBean;
import com.example.ergedd_android2.bean.BabyLookSiftGridBean;
import com.example.ergedd_android2.bean.BabyLookSiftItemBean;
import com.example.ergedd_android2.bean.BabyLookSiftThreeImgBean;
import com.example.ergedd_android2.bean.BabyLookTabBean;
import com.example.ergedd_android2.bean.BabylookParBean;
import com.example.ergedd_android2.bean.HandPicAlbumBean;
import com.example.ergedd_android2.bean.HandPicBottomListBean;
import com.example.ergedd_android2.bean.HandPicDetailBean;
import com.example.ergedd_android2.bean.HandPicTopBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
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
     * 第二个页面的精选头部列表网络解析
     *http://api.t.ergedd.com/api/v1/audio_playlists/261
     * */
    @Headers("Cache-Control: public, max-age=28800")
    @GET
    Observable<HandPicTopBean>getTopData(@Url String url);



/*
* 第二个页面的精选底部列表网络解析
*http://api.ergedd.com/api/v1/audio_categories?channel=original
* */
@Headers("Cache-Control: public, max-age=28800")
@GET
Observable<HandPicBottomListBean>getBottomData(@Url String url, @Query("channel") String channel);



    /*
* 第二个页面的精选详情列表
*http://api.ergedd.com/getAudioByPlaylistId?apid=258&offset=0&limit=20&os=3&code=20618&uuid=88f90448-1cac-4f10-8e80-34cafd428ce8&channel=qihu
* */
@Headers("Cache-Control: public, max-age=28800")
@FormUrlEncoded
@POST("getAudioByPlaylistId")
Observable<HandPicDetailBean>getDetailData(@Field("apid") int id,@Field("offset") int offset,
                                           @Field("limit") int limit,@Field("os") int os,
                                            @Field("code") String code,@Field("uuid") String uuid,
                                           @Field("channel") String channel);


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

//http://api.t.ergedd.com/api/v1/albums/33/videos?channel=new&offset=0&limit=20&sensitive=8
//宝宝看精选3个图片网路请求
@GET
Observable<BabyLookSiftThreeImgBean> getLookSift(@Url String url, @Query("channel") String channel, @Query("offset") int offset, @Query("limit") int limit, @Query("sensitive") int sensitive);


//http://api.t.ergedd.com/api/v1/albums/home_recommended?channel=new&offset=0&limit=16
// 宝宝看详情GridView
    @GET
    Observable<BabyLookSiftGridBean> getLookGrid(@Url String url, @Query("channel") String channel, @Query("offset") int offset, @Query("limit") int limit);

    //http://api.ergedd.com/api/v1/home_items?type=1&channel=new&offset=0&limit=20&sensitive=8
    //宝宝看详情item
    @GET
    Observable<BabyLookSiftItemBean> getLookItemUp(@Url String url, @Query("type") int type, @Query("channel") String channel, @Query("offset") int offset, @Query("limit") int limit, @Query("sensitive") int sensitive);


    /*
     * 第二个页面的精选专辑网络解析
     *http://api.ergedd.com/api/v1/audio_playlists/excellent
     * */
    @Headers("Cache-Control: public, max-age=28800")
    @GET
    Observable<HandPicAlbumBean>getAlbum(@Url String url, @Query("channel") String channel);


    //http://api.t.ergedd.com/api/v1/album_categories/1/albums?channel=new&offset=0&limit=20&sensitive=8
    //宝宝看tab
    @GET
    Observable<BabyLookInnerBean> getLookInner(@Url String url,@Query("channel") String channel,@Query("offset") int offset,@Query("limit") int limit,@Query("sensitive") int sensitive);//http://api.t.ergedd.com/api/v1/album_categories/1/albums?channel=new&offset=0&limit=20&sensitive=8
    //http://api.t.ergedd.com/api/v1/albums/514/videos?channel=new&offset=0&limit=20&sensitive=8
    //宝宝看tab
    @GET("albums/{id}/videos?channel=new&offset=0&limit=20&sensitive=8")
    Observable<BabylookParBean> getBabylookParData(@Path("id") int id);


}
