package com.bw.movie.presenter;

import com.bw.movie.bai.BasePresenter;
import com.bw.movie.bai.IMainView;
import com.bw.movie.bean.Select_CinemaBean;
import com.bw.movie.bean.Select_CinmaBeanFu;
import com.bw.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @Auther: 白俊岭
 * @Date: 2019/5/13 17:28:51
 * @Description:
 */
public class Select_Cinema_Presenter extends BasePresenter <IMainView> {

    private final RetrofitUtil instance;

    public  Select_Cinema_Presenter(){
        instance = RetrofitUtil.getInstance();
     }
     public  void SeleteTuiData(String userId ,String sessionId,int page,int count){
         Observable<Select_CinemaBean> select_cinemaBeanObservable = instance.api.select_tui(userId, sessionId, page, count);
         select_cinemaBeanObservable.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Consumer<Select_CinemaBean>() {
                     @Override
                     public void accept(Select_CinemaBean select_cinemaBean) throws Exception {
                         getView().onCheng(select_cinemaBean);
                     }
                 });
     }
    public  void SeletefujinData(String userId ,String sessionId,String longitude,String latitude,int page,int count){
        Observable<Select_CinmaBeanFu> select_cinmaBeanFuObservable = instance.api.select_fujin(userId, sessionId,longitude,latitude, page, count);
        select_cinmaBeanFuObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
             .subscribe(new Consumer<Select_CinmaBeanFu>() {
                 @Override
                 public void accept(Select_CinmaBeanFu select_cinmaBeanFu) throws Exception {
                     getView().onCheng(select_cinmaBeanFu);
                 }
             });
    }
}
