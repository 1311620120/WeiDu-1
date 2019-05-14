package com.bw.movie.presenter;

import com.bw.movie.bai.BasePresenter;
import com.bw.movie.bai.IMainView;
import com.bw.movie.bean.My_ziliaoBean;
import com.bw.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @Auther: 白俊岭
 * @Date: 2019/5/12 19:20:47
 * @Description:
 */
public class MyziliaoPresenter extends BasePresenter<IMainView<My_ziliaoBean>> {

    private final RetrofitUtil instance;

    public  MyziliaoPresenter(){
        instance = RetrofitUtil.getInstance();
     }
        public  void getZiliao(String userId ,String sessionId){
            Observable<My_ziliaoBean> ziliao = instance.api.Ziliao(userId, sessionId);
            ziliao.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<My_ziliaoBean>() {
                        @Override
                        public void accept(My_ziliaoBean my_ziliaoBean) throws Exception {
                            getView().onCheng(my_ziliaoBean);
                        }
                    });
        }
}
