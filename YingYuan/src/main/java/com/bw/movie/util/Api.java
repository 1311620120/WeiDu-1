package com.bw.movie.util;

import com.bw.movie.bean.CommentBean;
import com.bw.movie.bean.LoginBean;

import com.bw.movie.bean.My_CinemaBean;
import com.bw.movie.bean.My_HeadPicBean;
import com.bw.movie.bean.My_MegessBean;
import com.bw.movie.bean.My_ShopBean;
import com.bw.movie.bean.My_filmBean;
import com.bw.movie.bean.My_ziliaoBean;
import com.bw.movie.bean.Select_CinemaBean;
import com.bw.movie.bean.Select_CinemaIdBean;
import com.bw.movie.bean.Select_CinmaBeanFu;

import com.bw.movie.bean.MovieDetailBean;
import com.bw.movie.bean.ShowMovieBean;

import com.bw.movie.data.Content;

import java.io.File;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * @Author: zhang
 * @Date: 2019/5/10 14:12
 * @Description:
 */
public interface Api {
    //Post请求
    @FormUrlEncoded
    @POST()
    Observable<ResponseBody> requestPost(@Url String url, @FieldMap Map<String, String> map);
    //登录
    @FormUrlEncoded
    @POST(Content.Login)
    Observable<LoginBean> requestLogin(@FieldMap Map<String, String> map);

   //查询用户信息
    @GET("movieApi/user/v1/verify/getUserInfoByUserId")
    Observable<My_ziliaoBean> Ziliao(@Header("userId") String userId, @Header("sessionId") String sessionId);
    //系统消息
    @GET("movieApi/tool/v1/verify/findAllSysMsgList")
    Observable<My_MegessBean> Megess(@Header("userId") String userId,
                                     @Header("sessionId") String sessionId,
                                     @Query("page")int page,@Query("count") int count);
    //关注影院
    @GET("movieApi/cinema/v1/verify/findCinemaPageList")
    Observable<My_CinemaBean> My_Cinema(@Header("userId") String userId,
                                     @Header("sessionId") String sessionId,
                                     @Query("page")int page, @Query("count") int count);
    //关注电影
    @GET("movieApi/movie/v1/verify/findMoviePageList")
    Observable<My_filmBean> My_film(@Header("userId") String userId,
                                   @Header("sessionId") String sessionId,
                                   @Query("page")int page, @Query("count") int count);
    //头像上传
    @POST("movieApi/user/v1/verify/uploadHeadPic")
    @Multipart
    Observable<My_HeadPicBean> HeadPic( @Header("userId") String userId,
                                              @Header("sessionId") String sessionId,
                                        @Part MultipartBody.Part parts);
    //购买记录   http://172.17.8.100/movieApi/user/v1/verify/findUserBuyTicketRecordList
    @GET("movieApi/user/v1/verify/findUserBuyTicketRecordList")
    Observable<My_ShopBean> Shop(@Header("userId") String userId,
                                 @Header("sessionId") String sessionId,
                                 @Query("page")int page, @Query("count") int count,
                                 @Query("status") int status);
    // 查询推荐电影 http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas
    @GET("movieApi/cinema/v1/findRecommendCinemas")
    Observable<Select_CinemaBean> select_tui(@Header("userId") String userId,
                                       @Header("sessionId") String sessionId,
                                       @Query("page")int page, @Query("count") int count);
    // 查询推荐电影 http://172.17.8.100/movieApi/cinema/v1/findNearbyCinemas
    @GET("movieApi/cinema/v1/findNearbyCinemas")
    Observable<Select_CinmaBeanFu> select_fujin(@Header("userId") String userId,
                                                @Header("sessionId") String sessionId,
                                                @Query("page")int page, @Query("count") int count);

    //首页展示请求
    @GET()
    Observable<ShowMovieBean> requestMovieShow(@Url String url, @QueryMap Map<String,String> map);
    //查看电影详情
    @GET("movieApi/movie/v1/findMoviesDetail")
    Observable<MovieDetailBean> requestMovieDetail(@Query("movieId") int movieId);
    //查询影片评论
    @GET("movieApi/movie/v1/findAllMovieComment")
    Observable<CommentBean> requestComment(@QueryMap Map<String,String> map);
    //关注/取关
    @GET()
    Observable<ResponseBody> requestGet(@Url String url,@Query("movieId") int movieId);
//根据影院Id 影院Id查询电影排挡
@GET("movieApi/movie/v1/findMovieScheduleList")
Observable<Select_CinemaIdBean> SelectCinemaId(@Header("userId") String userId,
                                               @Header("sessionId") String sessionId,
                                               @Query("cinemasId") int cinemasId,
                                               @Query("movieId") int movieId);
   // 意见反馈  http://172.17.8.100/movieApi/tool/v1/verify/recordFeedBack
   @FormUrlEncoded
   @POST("movieApi/tool/v1/verify/recordFeedBack")
   Observable<ResponseBody> minessss(@Header("userId") String userId,
                                        @Header("sessionId") String sessionId,
                                        @Field("content") String content);
}
