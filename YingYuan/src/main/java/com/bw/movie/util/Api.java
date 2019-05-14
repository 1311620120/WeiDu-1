package com.bw.movie.util;

import com.bw.movie.bean.CommentBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.MovieDetailBean;
import com.bw.movie.bean.ShowMovieBean;
import com.bw.movie.data.Content;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * @Author: zhang
 * @Date: 2019/5/10 14:12
 * @Description:
 */
public interface Api {
    @FormUrlEncoded
    @POST()
    Observable<ResponseBody> requestPost(@Url String url, @FieldMap Map<String, String> map);
    @FormUrlEncoded
    @POST(Content.Login)
    Observable<LoginBean> requestLogin(@FieldMap Map<String, String> map);
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

}
