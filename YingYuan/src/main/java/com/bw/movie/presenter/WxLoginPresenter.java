package com.bw.movie.presenter;

import com.bw.movie.bai.BasePresenter;
import com.bw.movie.bai.IMainView;
import com.bw.movie.bean.Wx_LoginBean;
import com.bw.movie.util.RetrofitUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @Auther: 白俊岭
 * @Date: 2019/5/18 15:23:08
 * @Description:
 */
public class WxLoginPresenter extends BasePresenter<IMainView> {

    private final RetrofitUtil instance;

    public WxLoginPresenter(){
        instance = RetrofitUtil.getInstance();
     }

     public void WxLoginData(String code){
         Observable<Wx_LoginBean> wx_loginBeanObservable = instance.api.WX_Login(code);
         wx_loginBeanObservable.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Consumer<Wx_LoginBean>() {
                     @Override
                     public void accept(Wx_LoginBean wx_loginBean) throws Exception {
                          getView().onCheng(wx_loginBean);
                     }
                 });
     }
}
