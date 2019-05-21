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
    private MyInterface.ViewInter.CommentReplyInter commentReplyInter;

    public MyPresenter(T tt) {
        modelInter = new MyModel();
        this.tt = tt;
    }

    @Override
    public void toWXPay(int payType, String orderId) {
        final MyInterface.ViewInter.WXPayInter wxPayInter = (MyInterface.ViewInter.WXPayInter) tt;
        modelInter.doWXPay(payType, orderId, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                wxPayInter.WXPay(object);
            }
        });
    }

    @Override
    public void toUpdatePwd(Map<String, String> map) {
        final MyInterface.ViewInter.UpdatePwdInter updatePwdInter = (MyInterface.ViewInter.UpdatePwdInter) tt;
        modelInter.doPost(Content.UpdatePwd, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                updatePwdInter.updatePWd((String) object);
            }
        });
    }

    @Override
    public void toCinemaInfo(Map<String, String> map) {
        final MyInterface.ViewInter.CinemaInfoInter cinemaInfoInter = (MyInterface.ViewInter.CinemaInfoInter) tt;
        modelInter.doCinemaInfo(map, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                cinemaInfoInter.CinemaInfo(object);
            }
        });
    }

    @Override
    public void toCinemaComment(Map<String, String> map) {
        final MyInterface.ViewInter.CinemaCommentInter cinemaCommentInter = (MyInterface.ViewInter.CinemaCommentInter) tt;
        modelInter.doCinemaComment(map, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                cinemaCommentInter.CinemaComment(object);
            }
        });
    }

    @Override
    public void toFollowCinema(int cinemaId) {
        final MyInterface.ViewInter.CinemaFollowInter cinemaFollowInter = (MyInterface.ViewInter.CinemaFollowInter) tt;
        modelInter.doCinemaGet(Content.FollowCinema, cinemaId, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                cinemaFollowInter.Follow((String) object);
            }
        });
    }

    @Override
    public void toCancelFollowCinema(int cinemaId) {
        final MyInterface.ViewInter.CinemaFollowInter cinemaFollowInter = (MyInterface.ViewInter.CinemaFollowInter) tt;
        modelInter.doCinemaGet(Content.CancelFollowCinema, cinemaId, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                cinemaFollowInter.CancelFollow((String) object);
            }
        });
    }

    @Override
    public void toTicket(Map<String, String> map) {
        final MyInterface.ViewInter.TicketInter ticketInter = (MyInterface.ViewInter.TicketInter) tt;
        modelInter.doTicket(map, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                ticketInter.Ticket((String) object);
            }
        });
    }

    @Override
    public void toSchedule(Map<String, String> map) {
        final MyInterface.ViewInter.ScheduleInter scheduleInter = (MyInterface.ViewInter.ScheduleInter) tt;
        modelInter.doSchedule(map, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                scheduleInter.ScheduleInter(object);
            }
        });
    }

    @Override
    public void toByMovie(int movieId) {
        final MyInterface.ViewInter.ByMovieInter byMovieInter = (MyInterface.ViewInter.ByMovieInter) tt;
        modelInter.doByMovie(movieId, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                byMovieInter.ByMovie(object);
            }
        });
    }

    @Override
    public void toAddReply(Map<String, String> map) {
        commentReplyInter = (MyInterface.ViewInter.CommentReplyInter) tt;
        modelInter.doPost(Content.AddCommentReply, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                commentReplyInter.AddReply((String) object);
            }
        });
    }

    @Override
    public void toCommentReply(Map<String, String> map) {
        commentReplyInter = (MyInterface.ViewInter.CommentReplyInter) tt;
        modelInter.doCommentReply(map, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                commentReplyInter.CommentReply(object);
            }
        });
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
    public void toMovieComment(Map<String, String> map) {
        final MyInterface.ViewInter.MovieCommentInter  movieCommentInter = (MyInterface.ViewInter.MovieCommentInter) tt;
        modelInter.doPost(Content.MovieComment, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                movieCommentInter.MovieComment((String) object);
            }
        });
    }

    @Override
    public void toCommentGreat(int id) {
        final MyInterface.ViewInter.CommentGreatInter commentGreatInter = (MyInterface.ViewInter.CommentGreatInter) tt;
        Map<String,String> map = new HashMap<>();
        map.put("commentId",id+"");
        modelInter.doPost(Content.CommentGreat, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                commentGreatInter.CommentGreat((String) object);
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
