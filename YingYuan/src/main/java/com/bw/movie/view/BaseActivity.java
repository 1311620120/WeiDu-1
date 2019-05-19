package com.bw.movie.view;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.bw.movie.net.NetWork;
import com.bw.movie.service.NetBroadcastReceiver;

/**
 * @Author: zhang
 * @Date: 2019/5/19 13:09
 * @Description:
 */
public class BaseActivity extends AppCompatActivity implements NetBroadcastReceiver.NetChangeListener {
    public static NetBroadcastReceiver.NetChangeListener even;
    private int netType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        even = this;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //实例化IntentFilter对象
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            NetBroadcastReceiver netBroadcastReceiver = new NetBroadcastReceiver();
            //注册广播接收
            registerReceiver(netBroadcastReceiver, filter);
        }
        checkNet();
    }

    public boolean checkNet(){
        this.netType = NetWork.getNetWorkState(BaseActivity.this);
        if (!isNetConnect()){
            Log.e("tag","网络异常");
            Toast.makeText(this,"网络异常",Toast.LENGTH_SHORT).show();
        }
        return isNetConnect();
    }
    public boolean isNetConnect(){
        if (netType == 1){
            return true;
        }else if (netType == 0){
            return true;
        }else if (netType == -1){
            return false;
        }
        return false;
    }

    @Override
    public void onChangeListener(int netMobile) {
        this.netType = netMobile;
        if (!isNetConnect()) {
            Toast.makeText(this,"网络异常",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"网络恢复正常",Toast.LENGTH_SHORT).show();
        }
    }

    protected void setStatusBar(){

    }
}
