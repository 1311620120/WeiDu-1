package com.bw.movie.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.adapter.Cineam_gouAdapter;
import com.bw.movie.adapter.Cineam_recycler_flowAdapter;
import com.bw.movie.adapter.MyCinemaCommentAdapter;
import com.bw.movie.bai.IMainView;
import com.bw.movie.bean.CinemaCommentBean;
import com.bw.movie.bean.CinemaInfoBean;
import com.bw.movie.bean.JiCineamBean;
import com.bw.movie.bean.ScheduleBean;
import com.bw.movie.bean.Select_CinemaIdBean;
import com.bw.movie.bean.ShowMovieBean;
import com.bw.movie.inter.MyInterface;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.presenter.Select_CineamIdPresenter;
import com.bw.movie.view.App;
import com.bw.movie.view.BaseActivity;
import com.bw.movie.view.PayActivity;
import com.bw.movie.R;
import com.bw.movie.view.ScheduleActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import recycler.coverflow.RecyclerCoverFlow;

public class Select_CineamActivity extends BaseActivity implements IMainView ,MyInterface.ViewInter.ScheduleInter
                                        ,MyInterface.ViewInter.CinemaInfoInter
                                        ,MyInterface.ViewInter.CinemaCommentInter {

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
    RecyclerView recyclerView;
    private MyCinemaCommentAdapter adapter;
    private List<CinemaCommentBean.ResultBean> list;
    LinearLayout layout1;
    RelativeLayout layout;
    ImageView imageView;
    TextView detail,comment,address,phone,route;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__cineam);


        presenterInter = new MyPresenter<>(this);
        SharedPreferences sp = Select_CineamActivity.this.getSharedPreferences("myId", Context.MODE_PRIVATE);
        String Id = sp.getString("userId", "1");
        String Sid = sp.getString("sessionId", "1");
        userId = Id;
        sessionId = Sid;
        initView();
        initData();
    }
    private void initView() {
        address = findViewById(R.id.cinema_address_id);
        phone = findViewById(R.id.cinema_phone_id);
        route = findViewById(R.id.cinema_route_id);
        detail = findViewById(R.id.select_detail_id);
        comment = findViewById(R.id.select_comment_id);
        Cineam_recycler_flow_id = findViewById(R.id.Cineam_recycler_flow_id);
        selecrt_cineam_dizhi = findViewById(R.id.selecrt_cineam_dizhi);
        selecrt_cineam_logo = findViewById(R.id.selecrt_cineam_logo);
        selecrt_cineam_yuanname = findViewById(R.id.selecrt_cineam_yuanname);
        selecrt_cineam_recycler = findViewById(R.id.selecrt_cineam_recycler);
        recyclerView = findViewById(R.id.select_recycler_id);
        layout1 = findViewById(R.id.select_linear1_id);
        layout = findViewById(R.id.select_linear_id);
        imageView = findViewById(R.id.select_back_id);
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        name = intent.getStringExtra("name");
        logo = intent.getStringExtra("logo");
        saddress = intent.getStringExtra("saddress");
        cinemaId= id;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        Log.e("aaaa","影院"+id+"");
        Select_CineamIdPresenter select_cineamIdPresenter = new Select_CineamIdPresenter();
        select_cineamIdPresenter.ji_Cineam_IdData(userId,sessionId,cinemaId);
        select_cineamIdPresenter.setView(this);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        selecrt_cineam_recycler.setLayoutManager(linearLayoutManager);

//        presenterInter.toReleaseMovie();

    }
    private void initData() {
        selecrt_cineam_logo.setImageURI(Uri.parse(logo));
        selecrt_cineam_yuanname.setText(name);
        selecrt_cineam_dizhi.setText(saddress);
        selecrt_cineam_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.VISIBLE);
                Map<String,String> map = new HashMap<>();
                map.put("cinemaId",id+"");
                presenterInter.toCinemaInfo(map);
                Map<String,String> map1 = new HashMap<>();
                map1.put("cinemaId",id+"");
                map1.put("page","1");
                map1.put("count","15");
                presenterInter.toCinemaComment(map1);
                layout.setVisibility(View.VISIBLE);
                layout1.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.GONE);
            }
        });
        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout1.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
            }
        });
        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout1.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }
        });
    }


    @Override
    public void onCheng(Object o) {
        JiCineamBean jiCineamBean =(JiCineamBean)o;
        List<JiCineamBean.ResultBean> result = jiCineamBean.getResult();
        //Log.e("aaaa","movieList"+result+"");
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
        Map<String,String> map = new HashMap<>();
        map.put("movieId",id+"");
        map.put("cinemasId",cinemaId+"");
       presenterInter.toSchedule(map);
    }

    @Override
    public void ScheduleInter(Object object) {
        ScheduleBean scheduleBean=(ScheduleBean)object;
        if (scheduleBean.getResult() != null){
            List<ScheduleBean.ResultBean> result = new ArrayList<>();
            result.addAll(scheduleBean.getResult());
            Cineam_gouAdapter cineam_gouAdapter = new Cineam_gouAdapter(Select_CineamActivity.this,result);
            selecrt_cineam_recycler.setAdapter(cineam_gouAdapter);
        }else {
            Toast.makeText(this,"没有当前电影排期",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void CinemaInfo(Object object) {
        CinemaInfoBean bean = (CinemaInfoBean) object;
        address.setText(bean.getResult().getAddress());
        phone.setText(bean.getResult().getPhone());
        route.setText(bean.getResult().getVehicleRoute());
    }

    @Override
    public void CinemaComment(Object object) {
        CinemaCommentBean bean = (CinemaCommentBean) object;
        list = new ArrayList<>();
        list.addAll(bean.getResult());
        adapter = new MyCinemaCommentAdapter(list, this);
        recyclerView.setAdapter(adapter);
    }
    public void IntentPay(int i, int id, String beginTime, String endTime, String screeningHall,double price) {
        Intent intent = new Intent(Select_CineamActivity.this, PayActivity.class);
        intent.putExtra("scheduleId", id);
        intent.putExtra("seatsTotal", i);
        intent.putExtra("beginTime", beginTime);
        intent.putExtra("endTime", endTime);
        intent.putExtra("screeningHall", screeningHall);
        intent.putExtra("price", price);
        startActivity(intent);
    }
}
