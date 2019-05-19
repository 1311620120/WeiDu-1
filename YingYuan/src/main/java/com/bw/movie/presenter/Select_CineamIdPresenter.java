package com.bw.movie.presenter;

import android.util.Log;

import com.bw.movie.bai.BasePresenter;
import com.bw.movie.bai.IMainView;
import com.bw.movie.bean.JiCineamBean;
import com.bw.movie.bean.ScheduleBean;
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

      public  void  ji_Cineam_IdData(String userId,String sessionId,int cinemaId){
          Observable<JiCineamBean> jiCineamBeanObservable = instance.api.SelectjiCinemaId(userId,sessionId,cinemaId);
          jiCineamBeanObservable.subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(new Consumer<JiCineamBean>() {
                      @Override
                      public void accept(JiCineamBean jiCineamBean) throws Exception {
                          getView().onCheng(jiCineamBean);
                      }
                  });
      }
}
