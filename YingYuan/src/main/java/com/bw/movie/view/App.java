package com.bw.movie.view;

import android.app.Application;
<<<<<<< HEAD

=======
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
>>>>>>> cda23c8fc281b71fb5feb1b3aaf061ec94fe912f

import com.bw.movie.greendao.gen.DaoMaster;
import com.bw.movie.greendao.gen.DaoSession;
import com.facebook.drawee.backends.pipeline.Fresco;

<<<<<<< HEAD


=======
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.UMShareAPI;
>>>>>>> cda23c8fc281b71fb5feb1b3aaf061ec94fe912f

/**
 * @Author: zhang
 * @Date: 2019/5/11 11:28
 * @Description:
 */
public class App extends Application {

<<<<<<< HEAD
    public static int id;
=======
    public static DaoSession dao;
>>>>>>> cda23c8fc281b71fb5feb1b3aaf061ec94fe912f

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

<<<<<<< HEAD


=======
        UMConfigure.init(this, "5cda16ab0cafb251e0000975", null, 1, "");
        DaoMaster.DevOpenHelper user = new DaoMaster.DevOpenHelper(this, "user");
        SQLiteDatabase userDatabase = user.getWritableDatabase();
        dao = new DaoMaster(userDatabase).newSession();
>>>>>>> cda23c8fc281b71fb5feb1b3aaf061ec94fe912f
    }

}
