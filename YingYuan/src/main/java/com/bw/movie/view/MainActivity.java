package com.bw.movie.view;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    int i = 2;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            i--;
            if (i < 1){
                Intent intent = new Intent(MainActivity.this,PagerActivity.class);
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
        Message message = handler.obtainMessage(1);
        handler.sendMessageDelayed(message,1000);
    }
}
