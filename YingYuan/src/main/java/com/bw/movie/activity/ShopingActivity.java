package com.bw.movie.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;


import com.bw.movie.adapter.My_ShopAdapter;
import com.bw.movie.bai.IMainView;

import com.bw.movie.bean.My_ShopBean;
import com.bw.movie.presenter.My_ShopPresenter;
import com.bw.movie.view.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;


public class ShopingActivity extends AppCompatActivity implements IMainView {
    String userId;
    String sessionId;
    int page=1,count=10;
    int status=1;
    private My_ShopPresenter my_shopPresenter;
    private RecyclerView shopingDai;
    private ImageView my_shop_cinemaBack;
    private My_ShopAdapter my_shopAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoping);
        SharedPreferences sp = ShopingActivity.this.getSharedPreferences("myId", Context.MODE_PRIVATE);
        String Id = sp.getString("userId", "1");
        String Sid = sp.getString("sessionId", "1");
        userId = Id;
        sessionId = Sid;

        initData();
    }

    private void initData() {

        my_shopPresenter = new My_ShopPresenter();
        my_shopPresenter.ShophaData(userId,sessionId,page,count,status);
         my_shopPresenter.setView(this);

        shopingDai = findViewById(R.id.shopingDai);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        shopingDai.setLayoutManager(linearLayoutManager);


        my_shop_cinemaBack = findViewById(R.id.My_shop_cinemaBack);
        my_shop_cinemaBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    };


    @Override
    public void onCheng(Object o) {
     My_ShopBean my_shopBean =(My_ShopBean)o;
        List<My_ShopBean.ResultBean> result = my_shopBean.getResult();
        my_shopAdapter = new My_ShopAdapter(ShopingActivity.this, result);
        shopingDai.setAdapter(my_shopAdapter);


    }
}
