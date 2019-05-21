package com.bw.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.tencent.mm.opensdk.modelmsg.SendAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.wei).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!WeiXinUtil.success(MainActivity.this)) {
                    Toast.makeText(MainActivity.this, "请先安装应用", Toast.LENGTH_SHORT).show();
                } else {
                    //  验证
                    SendAuth.Req req = new SendAuth.Req();
                    req.scope = "snsapi_userinfo";
                    req.state = "wechat_sdk_demo_test_neng";
                    WeiXinUtil.reg(MainActivity.this).sendReq(req);

                }
            }
        });
    }
}
