package com.bw.movie.view;

import android.app.Application;
<<<<<<< HEAD
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
=======

import android.database.sqlite.SQLiteDatabase;



>>>>>>> 734b7637320a7dd90639c2837b205afc372c760b
import com.bw.movie.greendao.gen.DaoMaster;
import com.bw.movie.greendao.gen.DaoSession;
import com.facebook.drawee.backends.pipeline.Fresco;

<<<<<<< HEAD




import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.UMShareAPI;

=======



>>>>>>> 734b7637320a7dd90639c2837b205afc372c760b

import com.umeng.commonsdk.UMConfigure;


/**
 * @Author: zhang
 * @Date: 2019/5/11 11:28
 * @Description:
 */
public class App extends Application {

<<<<<<< HEAD
=======

>>>>>>> 734b7637320a7dd90639c2837b205afc372c760b
    public static int id;
    public static DaoSession dao;

<<<<<<< HEAD
=======

>>>>>>> 734b7637320a7dd90639c2837b205afc372c760b

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
