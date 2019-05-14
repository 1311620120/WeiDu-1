package com.bw.movie.util;

import android.util.Log;

import com.bw.movie.view.LoginActivity;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author: zhang
 * @Date: 2019/5/10 11:51
 * @Description:
 */
public class RetrofitUtil {
    OkHttpClient okHttpClient;
    Retrofit retrofit;
    private String userId = "1";
    private String sessionId = "1";

    private RetrofitUtil(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLogging());
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request build = chain.request()
                                .newBuilder()
                                .addHeader("userId", userId)
                                .addHeader("sessionId", sessionId)
                                .build();
                        return chain.proceed(build);
                    }
                })
                .addNetworkInterceptor(interceptor)
                .build();
    }
    private static class HttpUtils {
        private static RetrofitUtil retrofitUtil = new RetrofitUtil();
    }

    public static RetrofitUtil getInstance() {
        return HttpUtils.retrofitUtil;
    }

    public Retrofit getRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://mobile.bwstudent.com/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public <T>T getApi(Class<T> service){
        if (userId == "1" && sessionId == "1"){
            if (LoginActivity.key.equals("登陆成功")){
                userId = LoginActivity.sp.getString("userId", "1");
                sessionId = LoginActivity.sp.getString("sessionId", "1");
            }
        }
        Log.i("tag",userId+sessionId);
        return getRetrofit().create(service);
    }
    public class HttpLogging implements HttpLoggingInterceptor.Logger{
        @Override
        public void log(String message) {
            Log.i("拦截",message);
        }
    }
}
