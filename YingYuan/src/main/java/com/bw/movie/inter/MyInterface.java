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
        void doWXPay(int payType, String orderId, MyModel.MyCallBack myCallBack);
        void doSchedule(Map<String,String> map, MyModel.MyCallBack myCallBack);
        void doPost(String url, Map<String,String> map , MyModel.MyCallBack myCallBack);
        void doLogin(Map<String,String> map, MyModel.MyCallBack myCallBack);
        void doMovieShow(String url,Map<String,String> map, MyModel.MyCallBack myCallBack);
        void doMovieDetail(int movieId, MyModel.MyCallBack myCallBack);
        //影片评论
        void doComment(Map<String,String> map, MyModel.MyCallBack myCallBack);
        //电影:关注/取关
        void doGet(String url,int movieId, MyModel.MyCallBack myCallBack);
        //影院:关注/取关
        void doCinemaGet(String url,int cinemaId, MyModel.MyCallBack myCallBack);
        //查看评论回复数据
        void doCommentReply(Map<String,String> map, MyModel.MyCallBack myCallBack);
        //根据电影ID查询当前排片该电影的影院列表
        void doByMovie(int movieId, MyModel.MyCallBack myCallBack);
        //
        void doTicket(Map<String,String> map, MyModel.MyCallBack myCallBack);
        //影院信息
        void doCinemaInfo(Map<String,String> map, MyModel.MyCallBack myCallBack);
        //影院评论
        void doCinemaComment(Map<String,String> map, MyModel.MyCallBack myCallBack);
    }
    interface PresenterInter{
        void toWXPay(int payType, String orderId);
        //修改密码
        void toUpdatePwd(Map<String,String> map);
        //影院信息
        void toCinemaInfo(Map<String,String> map);
        //影院评论
        void toCinemaComment(Map<String,String> map);
        //影院关注
        void toFollowCinema(int cinemaId);
        //影院取关
        void toCancelFollowCinema(int cinemaId);
        //
        void toTicket(Map<String,String> map);
        //
        void toSchedule(Map<String,String> map);
        //根据电影ID查询当前排片该电影的影院列表
        void toByMovie(int movieId);
        //用户对评论的回复
        void toAddReply(Map<String,String> map);
        //查看评论回复数据
        void toCommentReply(Map<String,String> map);
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
        //发布评论
        void toMovieComment(Map<String,String> map);
        //评论点赞
        void toCommentGreat(int id);
        void onDestroy();
    }
    interface ViewInter{
        interface WXPayInter{
            void WXPay(Object o);
        }
        //影院信息
        interface CinemaInfoInter{
            void CinemaInfo(Object object);
        }
        //影院评论
        interface CinemaCommentInter{
            void CinemaComment(Object object);
        }
        interface TicketInter{
            void Ticket(String str);
        }
        interface ScheduleInter{
            void ScheduleInter(Object object);
        }
        interface MovieCommentInter{
            void MovieComment(String string);
        }
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
        interface CommentGreatInter{
            void CommentGreat(String str);
        }
        interface CommentReplyInter{
            void CommentReply(Object object);
            void AddReply(String str);
        }
        interface ByMovieInter{
            void ByMovie(Object object);
        }
        interface CinemaFollowInter{
            void Follow(String str);
            void CancelFollow(String str);
        }
        interface UpdatePwdInter{
            void updatePWd(String str);
        }
    }
}
