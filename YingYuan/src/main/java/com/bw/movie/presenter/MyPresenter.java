package com.bw.movie.presenter;

import android.util.Log;

import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.PostBean;
import com.bw.movie.data.Content;
import com.bw.movie.inter.MyInterface;
import com.bw.movie.model.MyModel;

import java.util.Map;

/**
 * @Author: zhang
 * @Date: 2019/5/10 14:08
 * @Description:
 */
public class MyPresenter<T> implements MyInterface.PresenterInter {
    MyInterface.ModelInter modelInter;
    T tt;

    public MyPresenter(T tt) {
        modelInter = new MyModel();
        this.tt = tt;
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
    public void toLogi(Map<String, String> map) {
        modelInter.doLogin(map, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
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
