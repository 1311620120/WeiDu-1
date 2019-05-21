package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.inter.MyInterface;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.util.EncryptUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdatePwdActivity extends AppCompatActivity implements MyInterface.ViewInter.UpdatePwdInter {

    MyInterface.PresenterInter presenterInter;
    @BindView(R.id.update_pwd_id)
    TextView updatePwdId;
    @BindView(R.id.update_pwd2_id)
    EditText updatePwd2Id;
    @BindView(R.id.update_pwd3_id)
    EditText updatePwd3Id;
    @BindView(R.id.but_update_pwd_id)
    Button butUpdatePwdId;
    private String old;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pwd);
        ButterKnife.bind(this);
        presenterInter = new MyPresenter<>(this);
        SharedPreferences user = getSharedPreferences("user", MODE_PRIVATE);
        String old_pwd = user.getString("old_pwd", null);
        old = EncryptUtil.encrypt(old_pwd);
        updatePwdId.setText(old_pwd);


    }

    @Override
    public void updatePWd(String str) {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
        if (str.equals("密码修改成功")){
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @OnClick(R.id.but_update_pwd_id)
    public void onViewClicked() {
        String string = updatePwd2Id.getText().toString();
        String string1 = updatePwd3Id.getText().toString();
        if (string != null || string != ""){
            String newPwd1 = EncryptUtil.encrypt(string);
            String newPwd2 = EncryptUtil.encrypt(string1);
            //Log.e("tag",string+"---"+string1);
            Map<String, String> map = new HashMap<>();
            map.put("oldPwd", old);
            map.put("newPwd",newPwd1);
            map.put("newPwd2",newPwd2);
            presenterInter.toUpdatePwd(map);
        }else {
            Toast.makeText(this,"新密码不能为空",Toast.LENGTH_SHORT).show();
        }
    }
}
