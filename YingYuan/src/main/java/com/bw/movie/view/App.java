package com.bw.movie.view;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.bw.movie.greendao.gen.DaoMaster;
import com.bw.movie.greendao.gen.DaoSession;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @Author: zhang
 * @Date: 2019/5/11 11:28
 * @Description:
 */
public class App extends Application {

    public static int id;
    public static DaoSession dao;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        DaoMaster.DevOpenHelper user = new DaoMaster.DevOpenHelper(this, "user");
        SQLiteDatabase userDatabase = user.getWritableDatabase();
        dao = new DaoMaster(userDatabase).newSession();

    }

}
