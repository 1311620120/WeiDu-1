package com.bw.movie.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.activity.GuanzuActivity;
import com.bw.movie.adapter.My_CinemaAdapter;
import com.bw.movie.adapter.My_filmAdapter;
import com.bw.movie.adapter.Select_CinmaFuAdapter;
import com.bw.movie.adapter.select_cinemaAdapter;
import com.bw.movie.bai.IMainView;
import com.bw.movie.bean.My_CinemaBean;
import com.bw.movie.bean.My_filmBean;
import com.bw.movie.bean.Select_CinemaBean;
import com.bw.movie.bean.Select_CinmaBeanFu;
import com.bw.movie.presenter.Select_Cinema_Presenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * @Auther: 白俊岭
 * @Date: 2019/5/10 19:15:09
 * @Description:
 */
public class CinemaFragment extends Fragment implements IMainView {
    String userId;
    String sessionId;
    int page = 1, count = 20;
     String longitude= "116.30551391385724";
    String latitude="40.04571807462411";
    @BindView(R.id.select_Cinema_but_tui)
    RadioButton selectCinemaButTui;
    @BindView(R.id.select_Cinema_but_fujin)
    RadioButton selectCinemaButFujin;
    @BindView(R.id.la)
    LinearLayout la;

    Unbinder unbinder;
    private View view;
    private RecyclerView select_cinema_recycler;
    private RecyclerView select_cinemafu_recycler;
    private Select_Cinema_Presenter select_cinema_presenter;
    private com.bw.movie.adapter.select_cinemaAdapter select_cinemaAdapter;
    private Select_CinmaFuAdapter select_cinmaFuAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.cimemafragment, null);
        SharedPreferences sp = getActivity().getSharedPreferences("myId", Context.MODE_PRIVATE);
        String Id = sp.getString("userId", "1");
        String Sid = sp.getString("sessionId", "1");
        userId = Id;
        sessionId = Sid;
        initData();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    private void initData() {
        select_cinema_recycler = view.findViewById(R.id.select_cinema_recycler);
        select_cinemafu_recycler = view.findViewById(R.id.select_Cinemafu_recycler);

        select_cinema_presenter = new Select_Cinema_Presenter();
        select_cinema_presenter.SeleteTuiData(userId, sessionId, page, count);

        select_cinema_presenter.setView(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        select_cinema_recycler.setLayoutManager(linearLayoutManager);

        LinearLayoutManager linearLayout = new LinearLayoutManager(getActivity());
        linearLayout.setOrientation(OrientationHelper.VERTICAL);
        select_cinemafu_recycler.setLayoutManager(linearLayout);


    }

    @Override
    public void onCheng(Object o) {
       if (o instanceof Select_CinemaBean){
            Select_CinemaBean select_cinemaBean=(Select_CinemaBean)o;
            List<Select_CinemaBean.ResultBean> result = select_cinemaBean.getResult();
            select_cinemaAdapter = new select_cinemaAdapter(getActivity(), result);
            select_cinema_recycler.setAdapter(select_cinemaAdapter);

        }
        if (o instanceof Select_CinmaBeanFu){
            Select_CinmaBeanFu select_cinmaBeanFu =(Select_CinmaBeanFu)o;
            List<Select_CinmaBeanFu.ResultBean> result = select_cinmaBeanFu.getResult();
            select_cinmaFuAdapter = new Select_CinmaFuAdapter(getActivity(), result);
            select_cinemafu_recycler.setAdapter(select_cinmaFuAdapter);
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.select_Cinema_but_tui, R.id.select_Cinema_but_fujin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.select_Cinema_but_tui:
                select_cinemafu_recycler.setVisibility(View.GONE);
                select_cinema_recycler.setVisibility(View.VISIBLE);
                select_cinema_presenter.SeleteTuiData(userId, sessionId, page, count);
                break;
            case R.id.select_Cinema_but_fujin:
                select_cinema_recycler.setVisibility(View.GONE);
                select_cinemafu_recycler.setVisibility(View.VISIBLE);
                select_cinema_presenter.SeletefujinData(userId, sessionId,longitude,latitude, page, count);
                break;
        }
    }
}
