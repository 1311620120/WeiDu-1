package com.bw.movie.view;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.facebook.drawee.backends.pipeline.Fresco;
<<<<<<< HEAD
=======
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.UMShareAPI;
>>>>>>> b4cfb84bd0a3f8f71e80fb0bef4337037310ad1b

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
<<<<<<< HEAD
=======
        UMConfigure.init(this, "5cda16ab0cafb251e0000975", null, 1, "");
>>>>>>> b4cfb84bd0a3f8f71e80fb0bef4337037310ad1b
    }

}
