package com.bw.movie.fragmentmdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.adapter.MyDetailMovieAdapter;
import com.bw.movie.bean.ShowMovieBean;
import com.bw.movie.inter.MyInterface;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.view.DYDetailActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Author: zhang
 * @Date: 2019/5/13 8:45
 * @Description:
 */
public class ComingSoonFragment extends Fragment implements MyInterface.ViewInter.ComingSoonMovie ,MyInterface.ViewInter.FollowInter {
    @BindView(R.id.comingSoon_recycler_id)
    XRecyclerView comingSoonRecyclerId;
    Unbinder unbinder;
    List<ShowMovieBean.ResultBean> list = new ArrayList<>();
    MyInterface.PresenterInter presenterInter;
    private MyDetailMovieAdapter adapter;
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            presenterInter = new MyPresenter<>(this);
            list.clear();
            presenterInter.toComingSoonMovie();
        }
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comingsoon, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        comingSoonRecyclerId.setLayoutManager(layoutManager);
        adapter = new MyDetailMovieAdapter(list, getActivity());
        comingSoonRecyclerId.setAdapter(adapter);
        adapter.setOnClickListener(new MyDetailMovieAdapter.mySetOnClick() {
            @Override
            public void OnClick(int i) {
                Intent intent = new Intent(getActivity(),DYDetailActivity.class);
                intent.putExtra("movieId",i);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenterInter != null){
            presenterInter.onDestroy();
            presenterInter = null;
        }
    }

    @Override
    public void ComingSoonMovie(Object object) {
        ShowMovieBean bean = (ShowMovieBean) object;
        list.addAll(bean.getResult());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void CancelFollowMovie(String string) {
        Toast.makeText(getActivity(),string,Toast.LENGTH_SHORT).show();
        list.clear();
        presenterInter.toHotMovie();
    }

    @Override
    public void FollowMovie(String string) {
        Toast.makeText(getActivity(),string,Toast.LENGTH_SHORT).show();
        list.clear();
        presenterInter.toComingSoonMovie();
    }
}
