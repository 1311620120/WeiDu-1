package com.bw.movie.inter;


import android.util.Log;

import com.bw.movie.model.MyModel;

import java.util.Map;

/**
 * @Author: zhang
 * @Date: 2019/5/10 14:07
 * @Description:
 */
public interface MyInterface {
    interface ModelInter{
        void doPost(String url, Map<String,String> map , MyModel.MyCallBack myCallBack);
        void doLogin(Map<String,String> map, MyModel.MyCallBack myCallBack);
        void doMovieShow(String url,Map<String,String> map, MyModel.MyCallBack myCallBack);
        void doMovieDetail(int movieId, MyModel.MyCallBack myCallBack);
        //影片评论
        void doComment(Map<String,String> map, MyModel.MyCallBack myCallBack);
        //关注/取关
        void doGet(String url,int movieId, MyModel.MyCallBack myCallBack);
    }
    interface PresenterInter{
        //影片评论
        void toComment(Map<String,String> map);
        //注册
        void toRegister(Map<String,String> map);
        //登录
        void toLogin(Map<String,String> map);
        //热门电影
        void toHotMovie();
        //正在热映
        void toReleaseMovie();
        //即将上映
        void toComingSoonMovie();
        //查看电影详情
        void toMovieDetail(int movieId);
        //关注
        void toFollowMovie(int movieId);
        // 取关
        void toCancelFollowMovie(int movieId);
        void onDestroy();
    }
    interface ViewInter{
        interface RegisterInter{
            void showRegister(String str);
        }
        interface LoginInter{
            void showLogin(Object object);
        }
        interface HotMovie{
            void HotMovie(Object object);
        }
        interface ReleaseMovie{
            void ReleaseMovie(Object object);
        }
        interface ComingSoonMovie{
            void ComingSoonMovie(Object object);
        }
        interface DetailInter{
            void ShowMovieDetail(Object object);
        }
        interface CommentInter{
            void showComment(Object object);
        }
        interface FollowInter{
            void CancelFollowMovie(String string);
            void FollowMovie(String string);
        }
    }
}
