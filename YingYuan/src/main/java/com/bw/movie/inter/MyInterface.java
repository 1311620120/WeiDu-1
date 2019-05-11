package com.bw.movie.inter;


import android.util.Log;

import com.bw.movie.model.MyModel;

import java.util.Map;

/**
 * @Author: zhang
 * @Date: 2019/5/10 14:07
 * @Description:
 */
public interface MyInterface {
    interface ModelInter{
        void doPost(String url, Map<String,String> map , MyModel.MyCallBack myCallBack);
        void doLogin(Map<String,String> map, MyModel.MyCallBack myCallBack);
    }
    interface PresenterInter{
        void toRegister(Map<String,String> map);
        void toLogin(Map<String,String> map);

        void toLogi(Map<String,String> map);
        void onDestroy();
    }
    interface ViewInter{
        interface RegisterInter{
            void showRegister(String str);
        }
        interface LoginInter{
            void showLogin(Object object);
        }

    }
}
