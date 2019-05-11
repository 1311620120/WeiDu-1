package com.bw.movie.util;

import com.bw.movie.bean.LoginBean;
import com.bw.movie.data.Content;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
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
}
