package com.bw.movie;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @Auther: 白俊岭
 * @Date: 2019/5/18 17:29:51
 * @Description:
 */
public interface Api {

    //微信登录
    @FormUrlEncoded
    @POST("movieApi/user/v1/weChatBindingLogin")
    Observable<Wx_LoginBean> WX_Login(@Field("code") String code);
}
