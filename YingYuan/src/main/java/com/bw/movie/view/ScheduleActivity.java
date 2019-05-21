package com.bw.movie.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Adapter;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.adapter.MyScheduleAdapter;
import com.bw.movie.bean.MovieDetailBean;
import com.bw.movie.bean.ScheduleBean;
import com.bw.movie.inter.MyInterface;
import com.bw.movie.presenter.MyPresenter;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScheduleActivity extends BaseActivity implements MyInterface.ViewInter.DetailInter, MyInterface.ViewInter.ScheduleInter {

    MyInterface.PresenterInter presenterInter;
    @BindView(R.id.schedule_movie_name_id)
    TextView scheduleMovieNameId;
    @BindView(R.id.schedule_movie_address_id)
    TextView scheduleMovieAddressId;
    @BindView(R.id.schedule_simple_id)
    SimpleDraweeView scheduleSimpleId;
    @BindView(R.id.schedule_name_id)
    TextView scheduleNameId;
    @BindView(R.id.schedule_type_id)
    TextView scheduleTypeId;
    @BindView(R.id.schedule_direct_id)
    TextView scheduleDirectId;
    @BindView(R.id.schedule_time_id)
    TextView scheduleTimeId;
    @BindView(R.id.detail_address_id)
    TextView detailAddressId;
    @BindView(R.id.schedule_recycler_id)
    RecyclerView scheduleRecyclerId;
    List<ScheduleBean.ResultBean> list = new ArrayList<>();
    private MyScheduleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        ButterKnife.bind(this);
        presenterInter = new MyPresenter<>(this);
        Intent intent = getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        int cinemasId = intent.getIntExtra("cinemasId", 0);
        String name = intent.getStringExtra("name");
        String address = intent.getStringExtra("address");
        scheduleMovieNameId.setText(name);
        scheduleMovieAddressId.setText(address);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        scheduleRecyclerId.setLayoutManager(layoutManager);
        adapter = new MyScheduleAdapter(this,list);
        scheduleRecyclerId.setAdapter(adapter);
        if (movieId != 0) {
            presenterInter.toMovieDetail(movieId);
        }
        if (movieId != 0 || cinemasId != 0) {
            Map<String, String> map = new HashMap<>();
            map.put("movieId", movieId + "");
            map.put("cinemasId", cinemasId + "");
            presenterInter.toSchedule(map);
        }
    }

    @Override
    public void ScheduleInter(Object object) {
        ScheduleBean bean = (ScheduleBean) object;
        list.addAll(bean.getResult());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void ShowMovieDetail(Object object) {
        MovieDetailBean bean = (MovieDetailBean) object;
        scheduleSimpleId.setImageURI(bean.getResult().getImageUrl());
        scheduleSimpleId.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(12));
        scheduleNameId.setText(bean.getResult().getName());
        scheduleTypeId.setText("类型:"+bean.getResult().getMovieTypes());
        scheduleDirectId.setText("导演:"+bean.getResult().getDirector());
        scheduleTimeId.setText("时长:"+bean.getResult().getDuration());
        detailAddressId.setText("产地:"+bean.getResult().getPlaceOrigin());
    }

    public void IntentPay(int i, int id, String beginTime, String endTime, String screeningHall,double price) {
        Intent intent = new Intent(ScheduleActivity.this,PayActivity.class);
        intent.putExtra("scheduleId",id);
        intent.putExtra("seatsTotal",i);
        intent.putExtra("beginTime",beginTime);
        intent.putExtra("endTime",endTime);
        intent.putExtra("screeningHall",screeningHall);
        intent.putExtra("price",price);
        startActivity(intent);
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
