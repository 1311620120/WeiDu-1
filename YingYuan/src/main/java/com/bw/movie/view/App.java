package com.bw.movie.view;

import android.app.Application;
<<<<<<< HEAD

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

=======
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
>>>>>>> f107b0ad161be316938253bc5ab36156ec2fd93c

import com.bw.movie.greendao.gen.DaoMaster;
import com.bw.movie.greendao.gen.DaoSession;
import com.facebook.drawee.backends.pipeline.Fresco;

<<<<<<< HEAD



import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.UMShareAPI;

=======

import com.umeng.commonsdk.UMConfigure;
>>>>>>> f107b0ad161be316938253bc5ab36156ec2fd93c

/**
 * @Author: zhang
 * @Date: 2019/5/11 11:28
 * @Description:
 */
public class App extends Application {

<<<<<<< HEAD

    public static int id;

    public static DaoSession dao;

=======
    public static int id;
    public static DaoSession dao;
>>>>>>> f107b0ad161be316938253bc5ab36156ec2fd93c

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

        UMConfigure.init(this, "5cda16ab0cafb251e0000975", null, 1, "");
        DaoMaster.DevOpenHelper user = new DaoMaster.DevOpenHelper(this, "user");
        SQLiteDatabase userDatabase = user.getWritableDatabase();
        dao = new DaoMaster(userDatabase).newSession();
<<<<<<< HEAD

=======
>>>>>>> f107b0ad161be316938253bc5ab36156ec2fd93c
    }

}
