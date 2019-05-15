package com.bw.movie.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @Author: zhang
 * @Date: 2019/5/11 11:17
 * @Description:
 */
@Entity
public class MyIdBean {
    private String sessionId;
    private int userId;
    @Generated(hash = 1473863735)
    public MyIdBean(String sessionId, int userId) {
        this.sessionId = sessionId;
        this.userId = userId;
    }
    @Generated(hash = 1352153929)
    public MyIdBean() {
    }
    public String getSessionId() {
        return this.sessionId;
    }
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    public int getUserId() {
        return this.userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
