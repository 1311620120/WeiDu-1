package com.bw.movie.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.bai.IMainView;
import com.bw.movie.bean.My_ziliaoBean;
import com.bw.movie.presenter.MyziliaoPresenter;
import com.bw.movie.view.R;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonalActivity extends AppCompatActivity implements IMainView {
    String userId;
    String sessionId;
    @BindView(R.id.view1)
    TextView view1;
    @BindView(R.id.personal_nane)
    TextView personalNane;
    @BindView(R.id.view2)
    TextView view2;
    @BindView(R.id.personal_sex)
    TextView personalSex;
    @BindView(R.id.view3)
    TextView view3;
    @BindView(R.id.personal_birboth)
    TextView personalBirboth;
    @BindView(R.id.personal_phonr)
    TextView personalPhonr;
    @BindView(R.id.view4)
    TextView view4;
    @BindView(R.id.personal_enilo)
    TextView personalEnilo;
    @BindView(R.id.relative)
    RelativeLayout relative;
    @BindView(R.id.personal_pwd)
    ImageView personalPwd;
    @BindView(R.id.relativelayou)
    RelativeLayout relativelayou;
    @BindView(R.id.personal_back)
    ImageView personalBack;
    @BindView(R.id.personal_head)
    SimpleDraweeView personalHead;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        ButterKnife.bind(this);

        SharedPreferences sp = PersonalActivity.this.getSharedPreferences("myId", Context.MODE_PRIVATE);
        String Id = sp.getString("userId", "1");
        String Sid = sp.getString("sessionId", "1");
        Log.e("ssss", Id + "");
        Log.e("ssss", Sid + "");
        userId = Id;
        sessionId = Sid;
        initData();
    }

    private void initData() {
        MyziliaoPresenter myziliaoPresenter = new MyziliaoPresenter();
        myziliaoPresenter.getZiliao(userId, sessionId);
        myziliaoPresenter.setView(this);
    }

    @Override
    public void onCheng(Object o) {
        My_ziliaoBean my_ziliaoBean = (My_ziliaoBean) o;
        My_ziliaoBean.ResultBean result = my_ziliaoBean.getResult();
        String headPic = result.getHeadPic();
        personalHead.setImageURI(headPic);
        String nickName = result.getNickName();
        personalNane.setText(nickName);
        String phone = result.getPhone();
        personalPhonr.setText(phone);
        String sex = result.getSex();
        personalSex.setText(sex);
    }

    @OnClick({R.id.personal_nane, R.id.personal_sex, R.id.personal_birboth, R.id.personal_phonr, R.id.personal_enilo, R.id.personal_pwd, R.id.relativelayou, R.id.personal_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personal_nane:
                break;
            case R.id.personal_sex:
                break;
            case R.id.personal_birboth:
                break;
            case R.id.personal_phonr:
                break;
            case R.id.personal_enilo:
                break;
            case R.id.personal_pwd:
                break;
            case R.id.relativelayou:
                break;
            case R.id.personal_back:
                finish();
                break;
        }
    }


}
