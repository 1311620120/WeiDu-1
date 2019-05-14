package com.bw.movie.presenter;

import com.bw.movie.bai.BasePresenter;
import com.bw.movie.bai.IMainView;
import com.bw.movie.bean.My_MegessBean;
import com.bw.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @Auther: 白俊岭
 * @Date: 2019/5/12 21:13:51
 * @Description:
 */
public class MegessPresenter extends BasePresenter<IMainView<My_MegessBean>> {

    private final RetrofitUtil instance;

    public  MegessPresenter(){
        instance = RetrofitUtil.getInstance();
      }
       public void Megess(String userId ,String sessionId,int page,int count){
           Observable<My_MegessBean> megess = instance.api.Megess(userId, sessionId, page, count);
              megess.subscribeOn(Schedulers.io())
                      .observeOn(AndroidSchedulers.mainThread())
                      .subscribe(new Consumer<My_MegessBean>() {
                          @Override
                          public void accept(My_MegessBean my_megessBean) throws Exception {
                              getView().onCheng(my_megessBean);
                          }
                      });
       }
}
