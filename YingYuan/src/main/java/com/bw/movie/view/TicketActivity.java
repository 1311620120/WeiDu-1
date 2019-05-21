package com.bw.movie.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.adapter.MyTicketAdapter;
import com.bw.movie.bean.Select_CinemaBean;
import com.bw.movie.inter.MyInterface;
import com.bw.movie.presenter.MyPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TicketActivity extends BaseActivity implements MyInterface.ViewInter.ByMovieInter {


    MyInterface.PresenterInter presenterInter;
    List<Select_CinemaBean.ResultBean> result = new ArrayList<>();
    @BindView(R.id.ticket_name_id)
    TextView ticketNameId;
    @BindView(R.id.ticket_recycler_id)
    RecyclerView ticketRecyclerId;
    private MyTicketAdapter select_cinemaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kicket);
        ButterKnife.bind(this);
        presenterInter = new MyPresenter<>(this);
        final int id = getIntent().getIntExtra("movieId", 0);
        String name = getIntent().getStringExtra("name");
        ticketNameId.setText(name);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ticketRecyclerId.setLayoutManager(layoutManager);
        select_cinemaAdapter = new MyTicketAdapter(TicketActivity.this, result);
        ticketRecyclerId.setAdapter(select_cinemaAdapter);
        if (id != 0) {
            Toast.makeText(this, id + "", Toast.LENGTH_SHORT).show();
            presenterInter.toByMovie(id);
        }
        select_cinemaAdapter.setOnClickListener(new MyTicketAdapter.setOnClick() {
            @Override
            public void onClick(int j, String name, String cont) {
                Intent intent = new Intent(TicketActivity.this,ScheduleActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("address",cont);
                intent.putExtra("movieId",id);
                intent.putExtra("cinemasId",j);
                startActivity(intent);
            }
        });
    }

    @Override
    public void ByMovie(Object object) {
        Select_CinemaBean bean = (Select_CinemaBean) object;
        if (bean.getMessage().equals("查询成功")){
            result.addAll(bean.getResult());
            select_cinemaAdapter.notifyDataSetChanged();
        }
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
