package com.bw.movie.view;

import android.content.IntentFilter;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bw.movie.R;
import com.bw.movie.net.NetWork;
import com.bw.movie.service.NetBroadcastReceiver;

public class NetWorkActivity extends AppCompatActivity implements NetBroadcastReceiver.NetChangeListener {
    public static NetBroadcastReceiver.NetChangeListener eve;
    private int netType;
    private NetBroadcastReceiver netBroadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_work);
        eve = this;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //实例化IntentFilter对象
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            netBroadcastReceiver = new NetBroadcastReceiver();
            //注册广播接收
            registerReceiver(netBroadcastReceiver, filter);
        }
        checkNet();
    }
    public boolean checkNet(){
        this.netType = NetWork.getNetWorkState(NetWorkActivity.this);
        if (!isNetConnect()){

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

            Log.e("tag","11111111111111111");
        } else {
            Log.e("tag","11111111");
            finish();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(netBroadcastReceiver);
    }
}
