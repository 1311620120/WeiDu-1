package com.bw.movie.view;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.net.NetWork;
import com.bw.movie.service.NetBroadcastReceiver;
import com.bw.movie.util.AlertAndAnimationUtils;

/**
 * @Author: zhang
 * @Date: 2019/5/19 13:09
 * @Description:
 */
public class BaseActivity extends AppCompatActivity implements NetBroadcastReceiver.NetChangeListener {
    public static NetBroadcastReceiver.NetChangeListener even;
    private int netType;
    private NetBroadcastReceiver netBroadcastReceiver;
    private AlertAndAnimationUtils utils;
    private View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        even = this;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //实例化IntentFilter对象
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            netBroadcastReceiver = new NetBroadcastReceiver();
            //注册广播接收
            registerReceiver(netBroadcastReceiver, filter);
        }
        utils = new AlertAndAnimationUtils();
        view = LayoutInflater.from(this).inflate(R.layout.layout_not_net, null);
        view.findViewById(R.id.net_work_cancel_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utils.hideDialog();
            }
        });
        view.findViewById(R.id.net_work_intent_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wifiSettingsIntent = new Intent("android.settings.WIFI_SETTINGS");
                startActivity(wifiSettingsIntent);
            }
        });
        utils.AlertDialog(this,view);
        checkNet();
    }

    public boolean checkNet(){
        this.netType = NetWork.getNetWorkState(BaseActivity.this);
        if (!isNetConnect()){
            utils.showDialog();
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
            utils.showDialog();
        } else {
            utils.hideDialog();
        }
    }

    protected void setStatusBar(){

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(netBroadcastReceiver);
    }
}
