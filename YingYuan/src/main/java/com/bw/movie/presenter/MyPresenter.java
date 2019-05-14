package com.bw.movie.presenter;

import android.util.Log;

import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.PostBean;
import com.bw.movie.bean.ShowMovieBean;
import com.bw.movie.data.Content;
import com.bw.movie.inter.MyInterface;
import com.bw.movie.model.MyModel;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhang
 * @Date: 2019/5/10 14:08
 * @Description:
 */
public class MyPresenter<T> implements MyInterface.PresenterInter {
    MyInterface.ModelInter modelInter;
    T tt;

    public MyPresenter(T tt) {
        modelInter = new MyModel();
        this.tt = tt;
    }

    @Override
    public void toComment(Map<String, String> map) {
        final MyInterface.ViewInter.CommentInter commentInter = (MyInterface.ViewInter.CommentInter) tt;
        modelInter.doComment(map, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                commentInter.showComment(object);
            }
        });
    }

    @Override
    public void toRegister(Map<String, String> map) {
        final MyInterface.ViewInter.RegisterInter registerInter = (MyInterface.ViewInter.RegisterInter) tt;
        modelInter.doPost(Content.Register, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                registerInter.showRegister((String) object);
            }
        });
    }

    @Override
    public void toLogin(Map<String, String> map) {
        final MyInterface.ViewInter.LoginInter loginInter = (MyInterface.ViewInter.LoginInter) tt;
        modelInter.doLogin(map, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                loginInter.showLogin(object);
            }
        });
    }

    @Override
    public void toHotMovie() {
        final MyInterface.ViewInter.HotMovie hotMovie = (MyInterface.ViewInter.HotMovie) tt;
        Map<String,String> map = new HashMap<>();
        map.put("page","1");
        map.put("count","15");
        modelInter.doMovieShow(Content.HotMovie, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                hotMovie.HotMovie(object);
            }
        });
    }

    @Override
    public void toReleaseMovie() {
        final MyInterface.ViewInter.ReleaseMovie releaseMovie = (MyInterface.ViewInter.ReleaseMovie) tt;
        Map<String,String> map = new HashMap<>();
        map.put("page","1");
        map.put("count","15");
        modelInter.doMovieShow(Content.ReleaseMovie, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                releaseMovie.ReleaseMovie(object);
            }
        });
    }

    @Override
    public void toComingSoonMovie() {
        final MyInterface.ViewInter.ComingSoonMovie comingSoonMovie = (MyInterface.ViewInter.ComingSoonMovie) tt;
        Map<String,String> map = new HashMap<>();
        map.put("page","1");
        map.put("count","15");
        modelInter.doMovieShow(Content.ComingSoonMovie, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                comingSoonMovie.ComingSoonMovie(object);
            }
        });
    }

    @Override
    public void toMovieDetail(int movieId) {
        final MyInterface.ViewInter.DetailInter detailInter = (MyInterface.ViewInter.DetailInter) tt;
        modelInter.doMovieDetail(movieId, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                detailInter.ShowMovieDetail(object);
            }
        });
    }

    @Override
    public void toFollowMovie(int movieId) {
        final MyInterface.ViewInter.FollowInter followInter = (MyInterface.ViewInter.FollowInter) tt;
        modelInter.doGet(Content.FollowMovie,movieId, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                followInter.FollowMovie((String) object);
            }
        });
    }

    @Override
    public void toCancelFollowMovie(int movieId) {
        final MyInterface.ViewInter.FollowInter followInter = (MyInterface.ViewInter.FollowInter) tt;
        modelInter.doGet(Content.CancelFollowMovie,movieId, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                followInter.CancelFollowMovie((String) object);
            }
        });
    }


    @Override
    public void onDestroy() {
        if (tt != null){
            tt = null;
        }
    }
}
