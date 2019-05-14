package com.bw.movie.presenter;

import com.bw.movie.bai.BasePresenter;
import com.bw.movie.bai.IMainView;
import com.bw.movie.bean.My_CinemaBean;
import com.bw.movie.bean.My_filmBean;
import com.bw.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @Auther: 白俊岭
 * @Date: 2019/5/13 09:34:31
 * @Description:
 */
public class My_film_cinema extends BasePresenter<IMainView> {

    private final RetrofitUtil instance;

    public  My_film_cinema(){
        instance = RetrofitUtil.getInstance();
     }

     public  void My_filmData(String userId ,String sessionId,int page,int count){
         Observable<My_filmBean> my_filmObservable = instance.api.My_film(userId, sessionId, page, count);
         my_filmObservable.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Consumer<My_filmBean>() {
                     @Override
                     public void accept(My_filmBean my_filmBean) throws Exception {
                         getView().onCheng(my_filmBean);
                     }
                 });
     }
    public  void My_CinemaData(String userId ,String sessionId,int page,int count){
        Observable<My_CinemaBean> my_cinemaObservable = instance.api.My_Cinema(userId, sessionId, page, count);
        my_cinemaObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<My_CinemaBean>() {
                    @Override
                    public void accept(My_CinemaBean my_cinemaBean) throws Exception {
                         getView().onCheng(my_cinemaBean);
                    }
                });
    }
}
