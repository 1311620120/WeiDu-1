package com.bw.movie.view;

import android.app.Application;
import android.content.SharedPreferences;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @Author: zhang
 * @Date: 2019/5/11 11:28
 * @Description:
 */
public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }

}
