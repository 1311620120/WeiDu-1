package com.bw.movie.model;

import android.util.Log;

import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.PostBean;
import com.bw.movie.inter.MyInterface;
import com.bw.movie.util.Api;
import com.bw.movie.util.RetrofitUtil;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * @Author: zhang
 * @Date: 2019/5/10 14:06
 * @Description:
 */
public class MyModel implements MyInterface.ModelInter {
    MyCallBack myCallBack;
    @Override
    public void doPost(String url, Map<String, String> map, final MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
        RetrofitUtil.getRetrofitUtil().getApi(Api.class)
                .requestPost(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        JSONObject object = new JSONObject(responseBody.string());
                        String str = object.getString("message");
                        myCallBack.success(str);
                    }
                });
    }

    @Override
    public void doLogin(Map<String, String> map, final MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
        RetrofitUtil.getRetrofitUtil().getApi(Api.class)
                .requestLogin(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        myCallBack.success(loginBean);
                    }
                });
    }

    public interface MyCallBack{
        void success(Object object);
    }
}
