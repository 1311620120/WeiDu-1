package com.bw.movie.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.bw.movie.adapter.My_ShopAdapter;
import com.bw.movie.adapter.My_yizhiAdapter;
import com.bw.movie.bai.IMainView;
import com.bw.movie.bean.My_ShopBean;
import com.bw.movie.presenter.My_ShopPresenter;
import com.bw.movie.view.BaseActivity;
import com.bw.movie.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ShopingActivity extends BaseActivity implements IMainView {
    String userId;
    String sessionId;
    int page = 1, count = 10;
    int status = 1;
    @BindView(R.id.My_Shop_dai)
    RadioButton MyShopDai;
    @BindView(R.id.My_Shop_yifu)
    RadioButton MyShopYifu;
    private My_ShopPresenter my_shopPresenter;
    private RecyclerView shopingDai;
    private RecyclerView shopingyi;
    private ImageView my_shop_cinemaBack;
    private My_ShopAdapter my_shopAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoping);
        ButterKnife.bind(this);
        SharedPreferences sp = ShopingActivity.this.getSharedPreferences("myId", Context.MODE_PRIVATE);
        String Id = sp.getString("userId", "1");
        String Sid = sp.getString("sessionId", "1");
        userId = Id;
        sessionId = Sid;

        initData();
    }

    private void initData() {

        my_shopPresenter = new My_ShopPresenter();
        my_shopPresenter.ShophaData(userId, sessionId, page, count, 1);
        my_shopPresenter.setView(this);

        shopingDai = findViewById(R.id.shopingDai);
        shopingyi = findViewById(R.id.shopingyi);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        shopingDai.setLayoutManager(linearLayoutManager);

        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        linearLayout.setOrientation(OrientationHelper.VERTICAL);
        shopingyi.setLayoutManager(linearLayout);


        my_shop_cinemaBack = findViewById(R.id.My_shop_cinemaBack);
        my_shop_cinemaBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    ;


    @Override
    public void onCheng(Object o) {
        My_ShopBean my_shopBean = (My_ShopBean) o;

        List<My_ShopBean.ResultBean> result = my_shopBean.getResult();
        Log.e("bbbb",result+"");
        my_shopAdapter = new My_ShopAdapter(ShopingActivity.this, result);

       shopingDai.setAdapter(my_shopAdapter);
        My_yizhiAdapter my_shopyizhiAdapter = new My_yizhiAdapter(ShopingActivity.this, result);
        shopingyi.setAdapter(my_shopyizhiAdapter);



    }

    @OnClick({R.id.My_Shop_dai, R.id.My_Shop_yifu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.My_Shop_dai:
                shopingyi.setVisibility(View.GONE);
                shopingDai.setVisibility(View.VISIBLE);
                my_shopPresenter.ShophaData(userId, sessionId, page, count, 1);
                break;
            case R.id.My_Shop_yifu:
                shopingDai.setVisibility(View.GONE);
                shopingyi.setVisibility(View.VISIBLE);
                my_shopPresenter.ShophaData(userId, sessionId, page, count, 2);
                break;
        }
    }
}
