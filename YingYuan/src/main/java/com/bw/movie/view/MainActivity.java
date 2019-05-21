package com.bw.movie.view;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;

import com.bw.movie.R;


public class MainActivity extends BaseActivity {

    int i = 1;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            i--;
            if (i < 1){
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }else {
                Message message = handler.obtainMessage(1);
                handler.sendMessageDelayed(message,1000);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stateNetWork();
        Message message = handler.obtainMessage(1);
        handler.sendMessageDelayed(message,1000);

    }
    //动态注册权限
    private void stateNetWork() {
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            String[] mStatenetwork = new String[]{
                    //写的权限
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    //读的权限
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    //入网权限
                    Manifest.permission.ACCESS_NETWORK_STATE,
                    //WIFI权限
                    Manifest.permission.ACCESS_WIFI_STATE,
                    //读手机权限
                    Manifest.permission.READ_PHONE_STATE,
                    //网络权限
                    Manifest.permission.INTERNET,
                    //位置权限
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS,
                    //相机
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_APN_SETTINGS,
                    Manifest.permission.ACCESS_NETWORK_STATE,
            };
            ActivityCompat.requestPermissions(this,mStatenetwork,100);
        }
    }


}
