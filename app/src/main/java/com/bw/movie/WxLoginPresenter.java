package com.bw.movie;



import android.util.Log;

import com.bw.movie.wxapi.WXEntryActivity;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * @Auther: 白俊岭
 * @Date: 2019/5/18 15:23:08
 * @Description:
 */
public class WxLoginPresenter extends BasePresenter<WXEntryActivity> {


    private final HttpUitls instance;

    public WxLoginPresenter(){
        instance = HttpUitls.getInstance();
    }

     public void WxLoginData(String code){
         Observable<Wx_LoginBean> wx_loginBeanObservable = instance.api.WX_Login(code);
         wx_loginBeanObservable.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new DisposableObserver<Wx_LoginBean>() {
                     @Override
                     public void onNext(Wx_LoginBean wx_loginBean) {
                         getView().onCheng(wx_loginBean);
                         Log.e("lallallala","成功了");
                     }

                     @Override
                     public void onError(Throwable e) {
                         Log.e("lallallala","失败了");
                     }

                     @Override
                     public void onComplete() {

                     }
                 });
     }
}
