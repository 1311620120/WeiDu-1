package com.bw.movie.wxapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.bw.movie.IMainView;
import com.bw.movie.LaActivity;
import com.bw.movie.WeiXinUtil;
import com.bw.movie.WxLoginPresenter;
import com.bw.movie.Wx_LoginBean;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

public class WXEntryActivity extends AppCompatActivity implements IWXAPIEventHandler ,IMainView {

    private WxLoginPresenter wxLoginPresenter;
    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WeiXinUtil.reg(this).handleIntent(getIntent(), this);
        wxLoginPresenter = new WxLoginPresenter();
        wxLoginPresenter.WxLoginData(code);
        wxLoginPresenter.setView(this);
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }


    @Override
    public void onResp(BaseResp resp) {
        if(resp instanceof SendAuth.Resp){
            SendAuth.Resp newResp = (SendAuth.Resp) resp;
            //获取微信传回的code
            code = newResp.code;
            Log.i("获取微信传回的code", code);

        }
        Log.d("获取微信传回的code", "onPayFinish, errCode = " + resp.errCode);


    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onCheng(Object o) {
          if(o instanceof Wx_LoginBean)
          {
              Wx_LoginBean  wx_loginBean = (Wx_LoginBean) o;
        Log.e("获取微信传回的code",wx_loginBean.getStatus()+"");
              Intent intent = new Intent(WXEntryActivity.this, LaActivity.class);
              startActivity(intent);
              finish();
          }
    }
}
