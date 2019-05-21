package com.bw.movie.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.bai.IMainView;
import com.bw.movie.presenter.MinssPresenter;
import com.bw.movie.view.BaseActivity;
import com.bw.movie.R;

public class MinessActivity extends BaseActivity implements IMainView {

    String userId;
    String sessionId;
    private EditText miness_context;
    private TextView miness_tijiao;
    private ImageView miness_back,miness_bac;
   String content;
    private MinssPresenter minssPresenter;
    private LinearLayout xianshi;

    private LinearLayout yincang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miness);
        SharedPreferences sp = MinessActivity.this.getSharedPreferences("myId", Context.MODE_PRIVATE);
        String Id = sp.getString("userId", "1");
        String Sid = sp.getString("sessionId", "1");
        userId = Id;
        sessionId = Sid;
        minssPresenter = new MinssPresenter();

        minssPresenter.setView(this);

        miness_context = findViewById(R.id.miness_context);
        miness_tijiao = findViewById(R.id.miness_tijiao);
        miness_back = findViewById(R.id.miness_back);
        miness_bac = findViewById(R.id.miness_bac);
        xianshi = findViewById(R.id.xianshi);
        yincang = findViewById(R.id.yincang);
        miness_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        miness_bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        miness_tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 content = miness_context.getText().toString();
                minssPresenter.MinrssData(userId,sessionId,content);

            }
        });
    }

    @Override
    public void onCheng(Object o) {
          String str=(String) o;
        Toast.makeText(MinessActivity.this,str+"",Toast.LENGTH_SHORT).show();
         xianshi.setVisibility(View.GONE);
         yincang.setVisibility(View.VISIBLE);
        Log.e("haha",str+"");
    }
}
