package com.bw.movie.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.View;
import android.widget.ImageView;

import com.bw.movie.adapter.My_CinemaAdapter;
import com.bw.movie.adapter.My_filmAdapter;
import com.bw.movie.bai.IMainView;
import com.bw.movie.bean.My_CinemaBean;
import com.bw.movie.bean.My_filmBean;
import com.bw.movie.presenter.My_film_cinema;
import com.bw.movie.view.BaseActivity;
import com.bw.movie.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class GuanzuActivity extends BaseActivity implements IMainView, View.OnClickListener {
    String userId;
    String sessionId;
    int page=1,count=10;



    private XRecyclerView my_film_recycler;
    private XRecyclerView my_cinema_recycler;
    private My_film_cinema my_film_cinema;
    private My_filmAdapter my_filmAdapter;
    private My_CinemaAdapter my_cinemaAdapter;
    private ImageView my_film_cinemaBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guanzu);

        SharedPreferences sp = GuanzuActivity.this.getSharedPreferences("myId", Context.MODE_PRIVATE);
        String Id = sp.getString("userId", "1");
        String Sid = sp.getString("sessionId", "1");
        userId = Id;
        sessionId = Sid;
        initData();
    }

    private void initData() {
       findViewById(R.id.My_film).setOnClickListener(this);
        findViewById(R.id.My_Cinema).setOnClickListener(this);
        findViewById(R.id.My_film_cinemaBack).setOnClickListener(this);

        my_film_cinemaBack = findViewById(R.id.My_film_cinemaBack);
        my_film_cinemaBack.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
            finish();
       }
   });
        my_film_recycler = findViewById(R.id.my_film_recycler);
        my_cinema_recycler = findViewById(R.id.my_Cinema_recycler);
        my_film_cinema = new My_film_cinema();

        my_film_cinema.setView(this);

        my_film_cinema.My_filmData(userId,sessionId,page,count);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        my_film_recycler.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        linearLayout.setOrientation(OrientationHelper.VERTICAL);
        my_cinema_recycler.setLayoutManager(linearLayout);

        my_film_recycler.setPullRefreshEnabled(true);
        my_film_recycler.setLoadingMoreEnabled(true);

        my_cinema_recycler.setPullRefreshEnabled(true);
        my_cinema_recycler.setLoadingMoreEnabled(true);

        my_film_recycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page =1;
                my_film_cinema.My_filmData(userId,sessionId,page,count);
                my_film_recycler.refreshComplete();
                my_filmAdapter .notifyDataSetChanged();
            }

            @Override
            public void onLoadMore() {
                page++;

                my_film_recycler.loadMoreComplete();;
                my_film_cinema.My_filmData(userId,sessionId,page,count);
                my_filmAdapter.notifyDataSetChanged();

            }
        });

        my_cinema_recycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page =1;
                my_film_cinema.My_CinemaData(userId,sessionId,page,count);
                my_cinema_recycler.refreshComplete();
                my_cinemaAdapter .notifyDataSetChanged();
            }

            @Override
            public void onLoadMore() {
                page++;
                my_film_cinema.My_CinemaData(userId,sessionId,page,count);
                my_cinema_recycler.loadMoreComplete();;

                my_cinemaAdapter.notifyDataSetChanged();

            }
        });

    }

    @Override
    public void onCheng(Object o) {
              if (o instanceof My_filmBean){
                  My_filmBean my_filmBean=(My_filmBean)o;
                  List<My_filmBean.ResultBean> result = my_filmBean.getResult();
                  my_filmAdapter = new My_filmAdapter(GuanzuActivity.this,result);
                  my_film_recycler.setAdapter(my_filmAdapter);

              }
              if (o instanceof My_CinemaBean){
                  My_CinemaBean my_cinemaBean =(My_CinemaBean)o;
                  List<My_CinemaBean.ResultBean> result = my_cinemaBean.getResult();
                  my_cinemaAdapter = new My_CinemaAdapter(GuanzuActivity.this,result);
                  my_cinema_recycler.setAdapter(my_cinemaAdapter);
              }
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.My_film:
                my_cinema_recycler.setVisibility(View.GONE);
                my_film_recycler.setVisibility(View.VISIBLE);
                my_film_cinema.My_filmData(userId,sessionId,page,count);
                break;
            case R.id.My_Cinema:
                my_film_recycler.setVisibility(View.GONE);
                my_cinema_recycler.setVisibility(View.VISIBLE);
                my_film_cinema.My_CinemaData(userId,sessionId,page,count);
                break;
            case R.id.My_film_cinemaBack:

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (my_film_cinema==null){
            my_film_cinema.detacher();
            my_film_cinema = null;
        }

    }
}
