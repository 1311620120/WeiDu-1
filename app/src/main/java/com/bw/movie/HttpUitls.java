package com.bw.movie;

import android.content.SharedPreferences;
import android.util.Log;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Auther: 白俊岭
 * @Date: 2019/2/23 14:48:39
 * @Description:
 */
public class HttpUitls<T>{
    public static String nei = "http://172.17.8.100/";
    public static String wai = "http://mobile.bwstudent.com";
    public static Api api;
    private OkHttpClient okHttpClient;


    private  static  class  HttpUtilsInstansce{
        private  static  HttpUitls httpUitls=new HttpUitls();
    }
    public  static  HttpUitls getInstance(){
        return  HttpUtilsInstansce.httpUitls;
    }

    private HttpUitls(){
          okHttpClient = new OkHttpClient.Builder()
                 .addNetworkInterceptor(new LogginIntecepter())
                 .readTimeout(5, TimeUnit.SECONDS)
                 .writeTimeout(5, TimeUnit.SECONDS)
                  .connectTimeout(5,TimeUnit.SECONDS)
                 .build();
         Retrofit retrofit = new Retrofit.Builder()
                 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                 .addConverterFactory(GsonConverterFactory.create())
                 .baseUrl(wai)
                 .client(okHttpClient)
                 .build();
        api = retrofit.create(Api.class);
     }


     private  class  LogginIntecepter implements Interceptor {
         @Override
         public Response intercept(Chain chain) throws IOException {



             Request request = chain.request();

             Response proceed = chain.proceed(request);
             return proceed;
         }
     }

}
