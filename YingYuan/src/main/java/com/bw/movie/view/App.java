package com.bw.movie.view;

import android.app.Application;


import com.facebook.drawee.backends.pipeline.Fresco;




/**
 * @Author: zhang
 * @Date: 2019/5/11 11:28
 * @Description:
 */
public class App extends Application {

    public static int id;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);



    }

}
