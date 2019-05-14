package com.bw.movie.presenter;

import com.bw.movie.bai.BasePresenter;
import com.bw.movie.bai.IMainView;
import com.bw.movie.bean.My_ShopBean;
import com.bw.movie.bean.My_filmBean;
import com.bw.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @Auther: 白俊岭
 * @Date: 2019/5/13 15:33:35
 * @Description:
 */
public class My_ShopPresenter extends BasePresenter<IMainView> {

    private final RetrofitUtil instance;

    public  My_ShopPresenter(){
        instance = RetrofitUtil.getInstance();
     }
           public void ShophaData(String userId ,String sessionId,int page,int count,int status){
               Observable<My_ShopBean> shop = instance.api.Shop(userId, sessionId, page, count, status);
               shop.subscribeOn(Schedulers.io())
                       .observeOn(AndroidSchedulers.mainThread())
                       .subscribe(new Consumer<My_ShopBean>() {
                           @Override
                           public void accept(My_ShopBean my_shopBean) throws Exception {
                               getView().onCheng(my_shopBean);
                           }
                       });
           }

}
