package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.bean.LoginBean;
import com.bw.movie.inter.MyInterface;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.util.EncryptUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements MyInterface.ViewInter.LoginInter {

    @BindView(R.id.login_phone_id)
    EditText phoneId;
    @BindView(R.id.login_pwd_id)
    EditText pwdId;
    @BindView(R.id.login_checkbox_pwd_id)
    CheckBox loginCheckboxPwdId;
    @BindView(R.id.login_checkbox_phone_id)
    CheckBox loginCheckboxPhoneId;
    @BindView(R.id.to_register)
    TextView toRegister;
    @BindView(R.id.intent_login)
    Button intentLogin;
    MyInterface.PresenterInter presenterInter;
    public static SharedPreferences sp;
    public static SharedPreferences.Editor edit;
    public static String key = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenterInter = new MyPresenter<>(this);
        sp = getSharedPreferences("myId", MODE_PRIVATE);
        edit = sp.edit();
    }

    @OnClick({R.id.login_checkbox_pwd_id, R.id.login_checkbox_phone_id, R.id.to_register, R.id.intent_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_checkbox_pwd_id:
                break;
            case R.id.login_checkbox_phone_id:
                break;
            case R.id.to_register:
                Intent intent = new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.intent_login:
                String phone = phoneId.getText().toString();
                String pwd = pwdId.getText().toString();
                String encrypt = EncryptUtil.encrypt(pwd);
                Map<String,String> map = new HashMap<>();
                map.put("phone",phone);
                map.put("pwd",encrypt);
                presenterInter.toLogin(map);
                break;
        }
    }

    @Override
    public void showLogin(Object object) {
        LoginBean bean = (LoginBean) object;
        if (bean != null){
            Toast.makeText(this,bean.getMessage(),Toast.LENGTH_SHORT).show();
            if (bean.getMessage().equals("登陆成功")){
                key = bean.getMessage();
                Log.i("tag",bean.getResult().getUserId()+"--"+bean.getResult().getSessionId());
                edit.clear();
                edit.putString("userId", String.valueOf(bean.getResult().getUserId()));
                edit.putString("sessionId",bean.getResult().getSessionId());
                edit.commit();
                Intent intent = new Intent(this,ViewActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
}