package com.bw.movie.util;

import android.util.Log;

import com.bw.movie.bean.MyIdBean;
import com.bw.movie.view.App;
import com.bw.movie.view.LoginActivity;

import java.io.IOException;
import java.util.List;

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
    private int userId;
    private String sessionId;
    public Api api;

    private RetrofitUtil(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLogging());
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request build = chain.request()
                                .newBuilder()
                                .addHeader("userId", String.valueOf(userId))
                                .addHeader("sessionId", String.valueOf(sessionId))
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
            api = retrofit.create(Api.class);
        }
        return retrofit;
    }
    public <T>T getApi(Class<T> service){
        List<MyIdBean> list = App.dao.getMyIdBeanDao().loadAll();
       // Log.e("tag",list.toString());
        if (list.size() != 0){
            userId = list.get(0).getUserId();
            sessionId = list.get(0).getSessionId();
        }
        //Log.i("tag", this.userId + this.sessionId);
        return getRetrofit().create(service);
    }
    public class HttpLogging implements HttpLoggingInterceptor.Logger{
        @Override
        public void log(String message) {
            Log.i("拦截",message);
        }
    }
}
