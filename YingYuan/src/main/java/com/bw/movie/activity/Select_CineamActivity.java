package com.bw.movie.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.adapter.Cineam_gouAdapter;
import com.bw.movie.adapter.Cineam_recycler_flowAdapter;
import com.bw.movie.bai.IMainView;
import com.bw.movie.bean.JiCineamBean;
import com.bw.movie.bean.ScheduleBean;
import com.bw.movie.bean.Select_CinemaIdBean;
import com.bw.movie.bean.ShowMovieBean;
import com.bw.movie.inter.MyInterface;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.presenter.Select_CineamIdPresenter;
import com.bw.movie.view.App;
import com.bw.movie.view.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import recycler.coverflow.RecyclerCoverFlow;

public class Select_CineamActivity extends AppCompatActivity implements IMainView ,MyInterface.ViewInter.ScheduleInter  {

    String userId;
    String sessionId;

    private RecyclerView selecrt_cineam_recycler;
    private TextView selecrt_cineam_dizhi;
    private ImageView selecrt_cineam_logo;
    private TextView selecrt_cineam_yuanname;
    private RecyclerCoverFlow Cineam_recycler_flow_id;
    private Select_CineamIdPresenter select_cineamIdPresenter;
int cinemaId;

    private String name;
    private String logo;
    private String saddress;

    MyInterface.PresenterInter presenterInter;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__cineam);

        SharedPreferences sp = Select_CineamActivity.this.getSharedPreferences("myId", Context.MODE_PRIVATE);
        String Id = sp.getString("userId", "1");
        String Sid = sp.getString("sessionId", "1");
        userId = Id;
        sessionId = Sid;
        initView();
          initData();
    }
    private void initView() {
        Cineam_recycler_flow_id = findViewById(R.id.Cineam_recycler_flow_id);
        selecrt_cineam_dizhi = findViewById(R.id.selecrt_cineam_dizhi);
        selecrt_cineam_logo = findViewById(R.id.selecrt_cineam_logo);
        selecrt_cineam_yuanname = findViewById(R.id.selecrt_cineam_yuanname);
        selecrt_cineam_recycler = findViewById(R.id.selecrt_cineam_recycler);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        name = intent.getStringExtra("name");
        logo = intent.getStringExtra("logo");
        saddress = intent.getStringExtra("saddress");
        cinemaId= id;

        Log.e("aaaa","影院"+id+"");
        Select_CineamIdPresenter select_cineamIdPresenter = new Select_CineamIdPresenter();
        select_cineamIdPresenter.ji_Cineam_IdData(userId,sessionId,cinemaId);
        select_cineamIdPresenter.setView(this);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        selecrt_cineam_recycler.setLayoutManager(linearLayoutManager);

        presenterInter = new MyPresenter<>(this);
//        presenterInter.toReleaseMovie();

    }
    private void initData() {
        selecrt_cineam_logo.setImageURI(Uri.parse(logo));
        selecrt_cineam_yuanname.setText(name);
        selecrt_cineam_dizhi.setText(saddress);



    }


    @Override
    public void onCheng(Object o) {
        JiCineamBean jiCineamBean =(JiCineamBean)o;
        List<JiCineamBean.ResultBean> result = jiCineamBean.getResult();
        Log.e("aaaa","movieList"+result+"");
        Cineam_recycler_flowAdapter cineam_recycler_flowAdapter = new Cineam_recycler_flowAdapter(Select_CineamActivity.this,result);
      Cineam_recycler_flow_id.setAdapter(cineam_recycler_flowAdapter);

    }
//    @Override
//    public void ReleaseMovie(Object object) {
//        ShowMovieBean showMovieBean=(ShowMovieBean)object;
//        List<ShowMovieBean.ResultBean> result = showMovieBean.getResult();
//        Cineam_recycler_flowAdapter cineam_recycler_flowAdapter = new Cineam_recycler_flowAdapter(Select_CineamActivity.this,result);
//        Cineam_recycler_flow_id.setAdapter(cineam_recycler_flowAdapter);
//
//
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    public void SelectId(int id) {
        Log.e("aaaa","影片"+id+"");
        Map<String,String> map = new HashMap<>();
        map.put("movieId",id+"");
        map.put("cinemaId",cinemaId+"");
       presenterInter.toSchedule(map);


    }

    @Override
    public void ScheduleInter(Object object) {
        ScheduleBean scheduleBean=(ScheduleBean)object;
        List<ScheduleBean.ResultBean> result = scheduleBean.getResult();

        Log.e("aaaaresult",result+"");

        Cineam_gouAdapter cineam_gouAdapter = new Cineam_gouAdapter(Select_CineamActivity.this,result);
        selecrt_cineam_recycler.setAdapter(cineam_gouAdapter);
    }
}
