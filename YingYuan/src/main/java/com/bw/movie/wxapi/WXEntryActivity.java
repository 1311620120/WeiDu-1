package com.bw.movie.wxapi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.bw.movie.bai.IMainView;
import com.bw.movie.bean.MyIdBean;
import com.bw.movie.bean.Wx_LoginBean;
import com.bw.movie.greendao.gen.MyIdBeanDao;
import com.bw.movie.presenter.WxLoginPresenter;
import com.bw.movie.util.WeiXinUtil;
import com.bw.movie.view.App;
import com.bw.movie.view.ViewActivity;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

public class WXEntryActivity extends AppCompatActivity implements IWXAPIEventHandler ,IMainView {

    private WxLoginPresenter wxLoginPresenter;
    private String code;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;
    private MyIdBeanDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WeiXinUtil.reg(this).handleIntent(getIntent(), this);
        wxLoginPresenter = new WxLoginPresenter();
        wxLoginPresenter.WxLoginData(code);
        wxLoginPresenter.setView(this);

        sp = getSharedPreferences("myId", MODE_PRIVATE);
        dao = App.dao.getMyIdBeanDao();
        edit = sp.edit();
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
            //Log.i("获取微信传回的code", code);
        }
        //Log.d("获取微信传回的code", "onPayFinish, errCode = " + resp.errCode);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onCheng(Object o) {
          if(o instanceof Wx_LoginBean) {
              final Wx_LoginBean  bean = (Wx_LoginBean) o;
              dao.deleteAll();
              runOnUiThread(new Runnable() {
                  @Override
                  public void run() {
                      MyIdBean idBean = new MyIdBean();
                      idBean.setUserId(bean.getResult().getUserId());
                      idBean.setSessionId(bean.getResult().getSessionId());
                      dao.insert(idBean);
                  }
              });
              //Log.i("tag", bean.getResult().getUserId() + "--" + bean.getResult().getSessionId());
              edit.clear();
              edit.putString("userId", String.valueOf(bean.getResult().getUserId()));
              edit.putString("sessionId", bean.getResult().getSessionId());
              edit.commit();
              Intent intent = new Intent(WXEntryActivity.this, ViewActivity.class);
              startActivity(intent);
              finish();
          }
    }
}
