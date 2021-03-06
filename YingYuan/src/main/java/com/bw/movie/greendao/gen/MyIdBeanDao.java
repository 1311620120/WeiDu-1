package com.bw.movie.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.bw.movie.bean.MyIdBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MY_ID_BEAN".
*/
public class MyIdBeanDao extends AbstractDao<MyIdBean, Void> {

    public static final String TABLENAME = "MY_ID_BEAN";

    /**
     * Properties of entity MyIdBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property SessionId = new Property(0, String.class, "sessionId", false, "SESSION_ID");
        public final static Property UserId = new Property(1, int.class, "userId", false, "USER_ID");
    }


    public MyIdBeanDao(DaoConfig config) {
        super(config);
    }
    
    public MyIdBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MY_ID_BEAN\" (" + //
                "\"SESSION_ID\" TEXT," + // 0: sessionId
                "\"USER_ID\" INTEGER NOT NULL );"); // 1: userId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MY_ID_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, MyIdBean entity) {
        stmt.clearBindings();
 
        String sessionId = entity.getSessionId();
        if (sessionId != null) {
            stmt.bindString(1, sessionId);
        }
        stmt.bindLong(2, entity.getUserId());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, MyIdBean entity) {
        stmt.clearBindings();
 
        String sessionId = entity.getSessionId();
        if (sessionId != null) {
            stmt.bindString(1, sessionId);
        }
        stmt.bindLong(2, entity.getUserId());
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public MyIdBean readEntity(Cursor cursor, int offset) {
        MyIdBean entity = new MyIdBean( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // sessionId
            cursor.getInt(offset + 1) // userId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, MyIdBean entity, int offset) {
        entity.setSessionId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setUserId(cursor.getInt(offset + 1));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(MyIdBean entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(MyIdBean entity) {
        return null;
    }

    @Override
    public boolean hasKey(MyIdBean entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
