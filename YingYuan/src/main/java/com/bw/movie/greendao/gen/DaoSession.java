package com.bw.movie.greendao.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.bw.movie.bean.MyIdBean;

import com.bw.movie.greendao.gen.MyIdBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig myIdBeanDaoConfig;

    private final MyIdBeanDao myIdBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        myIdBeanDaoConfig = daoConfigMap.get(MyIdBeanDao.class).clone();
        myIdBeanDaoConfig.initIdentityScope(type);

        myIdBeanDao = new MyIdBeanDao(myIdBeanDaoConfig, this);

        registerDao(MyIdBean.class, myIdBeanDao);
    }
    
    public void clear() {
        myIdBeanDaoConfig.clearIdentityScope();
    }

    public MyIdBeanDao getMyIdBeanDao() {
        return myIdBeanDao;
    }

}
