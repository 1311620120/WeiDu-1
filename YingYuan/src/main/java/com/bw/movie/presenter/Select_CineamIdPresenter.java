package com.bw.movie.presenter;

import android.util.Log;

import com.bw.movie.bai.BasePresenter;
import com.bw.movie.bai.IMainView;
import com.bw.movie.bean.Select_CinemaIdBean;
import com.bw.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @Auther: 白俊岭
 * @Date: 2019/5/15 08:59:59
 * @Description:
 */
public class Select_CineamIdPresenter extends BasePresenter<IMainView> {

    private final RetrofitUtil instance;

    public  Select_CineamIdPresenter(){
        instance = RetrofitUtil.getInstance();
      }
      public  void Select_Cineam_IdData(String userId ,String sessionId,int cinemasId,int movieId){
          Observable<Select_CinemaIdBean> select_cinemaIdBeanObservable = instance.api.SelectCinemaId(userId,sessionId,cinemasId,movieId);
          select_cinemaIdBeanObservable.subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(new Consumer<Select_CinemaIdBean>() {
                      @Override
                      public void accept(Select_CinemaIdBean select_cinemaIdBean) throws Exception {
                          getView().onCheng(select_cinemaIdBean);
                      }
                  }, new Consumer<Throwable>() {
                      @Override
                      public void accept(Throwable throwable) throws Exception {
                          Log.e("aaaa", "查询失败 "+throwable.toString());
                      }
                  });
      }
}
