package com.bw.movie.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import com.bw.movie.net.NetWork;
import com.bw.movie.view.BaseActivity;
import com.bw.movie.view.LoginActivity;
import com.bw.movie.view.NetWorkActivity;

/**
 * @Author: zhang
 * @Date: 2019/5/18 9:54
 * @Description:
 */
public class NetBroadcastReceiver extends BroadcastReceiver {
    public NetChangeListener even = BaseActivity.even;
    public NetChangeListener eve = NetWorkActivity.eve;
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION));{
            int state = NetWork.getNetWorkState(context);
            if (even != null){
                even.onChangeListener(state);
            }
            if (eve != null){
                eve.onChangeListener(state);
            }
        }
    }

    public interface NetChangeListener{
        void onChangeListener(int netMobile);
    }
}
