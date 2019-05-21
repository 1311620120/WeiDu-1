package com.bw.movie.view;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.inter.MyInterface;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.util.EncryptUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements MyInterface.ViewInter.RegisterInter {

    @BindView(R.id.register_name_id)
    EditText nameId;
    @BindView(R.id.register_sex_id)
    EditText sexId;
    @BindView(R.id.register_data_id)
    EditText dataId;
    @BindView(R.id.register_phone_id)
    EditText phoneId;
    @BindView(R.id.register_email_id)
    EditText emailId;
    @BindView(R.id.register_pwd_id)
    EditText pwdId;
    @BindView(R.id.register_id)
    Button registerId;
    MyInterface.PresenterInter presenterInter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        presenterInter = new MyPresenter<>(this);
    }

    @Override
    public void showRegister(String str) {
        if (str != null){
            Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
            if (str.equals("注册成功")){
                finish();
            }
        }
    }

    @OnClick(R.id.register_id)
    public void onViewClicked() {
        String nickName = nameId.getText().toString();
        String phone = phoneId.getText().toString();
        String pwd = pwdId.getText().toString();
        String birthday = dataId.getText().toString();
        String sex = sexId.getText().toString();
        String email = emailId.getText().toString();
        String encrypt = EncryptUtil.encrypt(pwd);
        int i = 0;
        if (sex.equals("男")){i = 1;}else if (sex.equals("女")){i = 2;}
        //String imei = getIMEI(this);
        Map<String,String> map = new HashMap<>();
        map.put("nickName",nickName);
        map.put("phone",phone);
        map.put("pwd",encrypt);
        map.put("pwd2",encrypt);
        Log.i("tag",pwd);
        if (i == 1 || i == 2){
            map.put("sex", String.valueOf(i));
        }
        map.put("birthday",birthday);
        map.put("email",email);
        presenterInter.toRegister(map);
    }

    public String getIMEI(Context context) {
        TelephonyManager manager = (TelephonyManager) context.getSystemService(TELEPHONY_SERVICE);
        String cls;


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return "";
        }
        cls = "" + manager.getDeviceId();

        /*String imei = "";
        try {
            Method getImei = cls.getDeclaredMethod("getImei", int.class);
            getImei.setAccessible(true);
            imei = (String) getImei.invoke(manager);
            Log.i("tag",getImei.invoke(manager)+"2222");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return cls;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenterInter != null){
            presenterInter.onDestroy();
            presenterInter = null;
        }
    }
}
