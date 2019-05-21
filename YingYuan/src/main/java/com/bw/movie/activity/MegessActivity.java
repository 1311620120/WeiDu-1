package com.bw.movie.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.View;
import android.widget.ImageView;

import com.bw.movie.adapter.My_MagessAdapter;
import com.bw.movie.bai.IMainView;
import com.bw.movie.bean.My_MegessBean;
import com.bw.movie.presenter.MegessPresenter;
import com.bw.movie.view.BaseActivity;
import com.bw.movie.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class MegessActivity extends BaseActivity implements IMainView {
    String userId;
    String sessionId;
    int page=1,count=10;
    private XRecyclerView my__magessXrecycler;
    private MegessPresenter megessPresenter;
    private My_MagessAdapter my_magessAdapter;
    private ImageView my_magess_backe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_megess);
        SharedPreferences sp = MegessActivity.this.getSharedPreferences("myId", Context.MODE_PRIVATE);
        String Id = sp.getString("userId", "1");
        String Sid = sp.getString("sessionId", "1");
        userId = Id;
        sessionId = Sid;
        initData();
    }

    private void initData() {
        megessPresenter = new MegessPresenter();
        megessPresenter.Megess(userId,sessionId,page,count);
        megessPresenter.setView(this);
        my__magessXrecycler = findViewById(R.id.My__magessXrecycler);

        my__magessXrecycler.setPullRefreshEnabled(true);
        my__magessXrecycler.setLoadingMoreEnabled(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        my__magessXrecycler.setLayoutManager(linearLayoutManager);

          my__magessXrecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
              @Override
              public void onRefresh() {
                  page =1;
                  megessPresenter.Megess(userId,sessionId,page,count);
                  my__magessXrecycler.refreshComplete();
                 my_magessAdapter .notifyDataSetChanged();
              }

              @Override
              public void onLoadMore() {
                  page++;
                  megessPresenter.Megess(userId,sessionId,page,count);
                  my__magessXrecycler.loadMoreComplete();

                  my_magessAdapter.notifyDataSetChanged();

              }
          });

        my_magess_backe = findViewById(R.id.my_magess_back);
        my_magess_backe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    public void onCheng(Object o) {
        My_MegessBean my_megessBean=(My_MegessBean)o;
        List<My_MegessBean.ResultBean> result = my_megessBean.getResult();
        my_magessAdapter = new My_MagessAdapter(MegessActivity.this,result);
        my__magessXrecycler.setAdapter(my_magessAdapter);
        my_magessAdapter.notifyDataSetChanged();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (megessPresenter==null){
            megessPresenter.detacher();
        }
    }
}
