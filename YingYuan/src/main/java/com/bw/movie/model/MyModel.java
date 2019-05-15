package com.bw.movie.model;

import com.bw.movie.bean.CommentBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.MovieDetailBean;
import com.bw.movie.bean.ReplyBean;
import com.bw.movie.bean.ScheduleBean;
import com.bw.movie.bean.Select_CinemaBean;
import com.bw.movie.bean.ShowMovieBean;
import com.bw.movie.inter.MyInterface;
import com.bw.movie.util.Api;
import com.bw.movie.util.RetrofitUtil;

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
    int i = 1;

    @Override
    public void doSchedule(Map<String, String> map, final MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
        RetrofitUtil.getInstance().getApi(Api.class)
                .requestSchedule(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ScheduleBean>() {
                    @Override
                    public void accept(ScheduleBean scheduleBean) throws Exception {
                        myCallBack.success(scheduleBean);
                    }
                });
    }

    @Override
    public void doPost(String url, Map<String, String> map, final MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
        RetrofitUtil.getInstance().getApi(Api.class)
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
        RetrofitUtil.getInstance().getApi(Api.class)
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

    @Override
    public void doMovieShow(String url, Map<String, String> map, final MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
        RetrofitUtil.getInstance().getApi(Api.class)
                .requestMovieShow(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShowMovieBean>() {
                    @Override
                    public void accept(ShowMovieBean showMovieBean) throws Exception {
                        myCallBack.success(showMovieBean);
                    }
                });
    }

    @Override
    public void doMovieDetail(int movieId, final MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
        RetrofitUtil.getInstance().getApi(Api.class)
                .requestMovieDetail(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MovieDetailBean>() {
                    @Override
                    public void accept(MovieDetailBean movieDetailBean) throws Exception {
                        myCallBack.success(movieDetailBean);
                    }
                });
    }

    @Override
    public void doComment(Map<String, String> map, final MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
        RetrofitUtil.getInstance().getApi(Api.class)
                .requestComment(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CommentBean>() {
                    @Override
                    public void accept(CommentBean commentBean) throws Exception {
                        myCallBack.success(commentBean);
                    }
                });
    }

    @Override
    public void doGet(String url,int movieId, final MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
        RetrofitUtil.getInstance().getApi(Api.class)
                .requestGet(url,movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        JSONObject object = new JSONObject(responseBody.string());
                        String json = object.getString("message");
                        myCallBack.success(json);
                    }
                });
    }

    @Override
    public void doCommentReply(Map<String, String> map, final MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
        RetrofitUtil.getInstance().getApi(Api.class)
                .requestReply(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ReplyBean>() {
                    @Override
                    public void accept(ReplyBean replyBean) throws Exception {
                        myCallBack.success(replyBean);
                    }
                });
    }

    @Override
    public void doByMovie(int movieId, final MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
        RetrofitUtil.getInstance().getApi(Api.class)
                .requestByMovie(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Select_CinemaBean>() {
                    @Override
                    public void accept(Select_CinemaBean select_cinemaBean) throws Exception {
                        myCallBack.success(select_cinemaBean);
                    }
                });
    }

    public interface MyCallBack{
        void success(Object object);
    }
}
