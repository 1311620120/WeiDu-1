package com.bw.movie.fragmentmdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
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
public class HotFragment extends Fragment implements MyInterface.ViewInter.HotMovie  {

    @BindView(R.id.hot_recycler_id)
    XRecyclerView hotRecyclerId;
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
            presenterInter.toHotMovie();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        hotRecyclerId.setLayoutManager(layoutManager);
        adapter = new MyDetailMovieAdapter(list, getActivity());
        hotRecyclerId.setAdapter(adapter);
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
    public void HotMovie(Object object) {
        ShowMovieBean bean = (ShowMovieBean) object;
        list.addAll(bean.getResult());
        adapter.notifyDataSetChanged();
    }


}
