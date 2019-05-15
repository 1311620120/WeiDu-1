package com.bw.movie.view;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

import com.bw.movie.greendao.gen.DaoMaster;
import com.bw.movie.greendao.gen.DaoSession;
import com.facebook.drawee.backends.pipeline.Fresco;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.UMShareAPI;

/**
 * @Author: zhang
 * @Date: 2019/5/11 11:28
 * @Description:
 */
public class App extends Application {

    public static DaoSession dao;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

        UMConfigure.init(this, "5cda16ab0cafb251e0000975", null, 1, "");
        DaoMaster.DevOpenHelper user = new DaoMaster.DevOpenHelper(this, "user");
        SQLiteDatabase userDatabase = user.getWritableDatabase();
        dao = new DaoMaster(userDatabase).newSession();
    }

}
