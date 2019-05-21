package com.bw.movie.data;

import retrofit2.http.POST;

/**
 * @Author: zhang
 * @Date: 2019/5/11 10:20
 * @Description:
 */
public class Content {
    //注册
    public static final String Register = "movieApi/user/v1/registerUser";
    //登录
    public static final String Login = "movieApi/user/v1/login";
    //查询热门电影列表
    public static final String HotMovie = "movieApi/movie/v1/findHotMovieList";
    //查询正在上映电影列表
    public static final String ReleaseMovie = "movieApi/movie/v1/findReleaseMovieList";
    //查询即将上映电影列表
    public static final String ComingSoonMovie = "movieApi/movie/v1/findComingSoonMovieList";
    //关注
    public static final String FollowMovie = "movieApi/movie/v1/verify/followMovie";
    //取关
    public static final String CancelFollowMovie = "movieApi/movie/v1/verify/cancelFollowMovie";
    //发布评论
    public static final String MovieComment = "movieApi/movie/v1/verify/movieComment";
    //评论点赞
    public static final String CommentGreat = "movieApi/movie/v1/verify/movieCommentGreat";
    //用户对评论的回复
    public static final String AddCommentReply = "movieApi/movie/v1/verify/commentReply";
    //
    public static final String FollowCinema = "movieApi/cinema/v1/verify/followCinema";

    public static final String CancelFollowCinema = "movieApi/cinema/v1/verify/cancelFollowCinema";
    //修改密码
    public static final String UpdatePwd = "movieApi/user/v1/verify/modifyUserPwd";



}
