package com.bw.movie.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.adapter.MyCoverFlowAdapter;
import com.bw.movie.adapter.MyHotMovieAdapter;
import com.bw.movie.bean.ShowMovieBean;
import com.bw.movie.inter.MyInterface;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.view.MovieDetailActivity;
import com.bw.movie.view.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import recycler.coverflow.RecyclerCoverFlow;


/**
 * @Auther: 白俊岭
 * @Date: 2019/5/10 19:15:09
 * @Description:
 */
public class FilmFragment extends Fragment implements MyInterface.ViewInter.HotMovie, MyInterface.ViewInter.ReleaseMovie, MyInterface.ViewInter.ComingSoonMovie {

    MyInterface.PresenterInter presenterInter;
    @BindView(R.id.film_hot_recycler_id)
    RecyclerView filmHotRecyclerId;
    @BindView(R.id.film_Release_recycler_id)
    RecyclerView filmReleaseRecyclerId;
    @BindView(R.id.film_ComingSoon_recycler_id)
    RecyclerView filmComingSoonRecyclerId;
    Unbinder unbinder;
    List<ShowMovieBean.ResultBean> list1 = new ArrayList<>();
    List<ShowMovieBean.ResultBean> list2 = new ArrayList<>();
    List<ShowMovieBean.ResultBean> list3 = new ArrayList<>();
    List<ShowMovieBean.ResultBean> list = new ArrayList<>();
    @BindView(R.id.re01)
    RelativeLayout re01;
    @BindView(R.id.re02)
    RelativeLayout re02;
    @BindView(R.id.re03)
    RelativeLayout re03;
    @BindView(R.id.film_recycler_flow_id)
    RecyclerCoverFlow filmRecyclerFlowId;
    @BindView(R.id.film_fragment_search_id)
    RelativeLayout filmFragmentSearchId;
    private MyHotMovieAdapter adapter1;
    private MyHotMovieAdapter adapter2;
    private MyHotMovieAdapter adapter3;
    private MyCoverFlowAdapter adapter;
    private ObjectAnimator translationX;
    private ObjectAnimator translationY;
    private AnimatorSet animatorSet;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.filmfragment, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenterInter = new MyPresenter<>(this);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        filmHotRecyclerId.setLayoutManager(layoutManager1);
        adapter1 = new MyHotMovieAdapter(list1, getActivity());
        filmHotRecyclerId.setAdapter(adapter1);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        adapter2 = new MyHotMovieAdapter(list2, getActivity());
        filmReleaseRecyclerId.setAdapter(adapter2);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(getActivity());
        layoutManager3.setOrientation(LinearLayoutManager.HORIZONTAL);
        adapter3 = new MyHotMovieAdapter(list3, getActivity());
        filmComingSoonRecyclerId.setAdapter(adapter3);
        filmReleaseRecyclerId.setLayoutManager(layoutManager2);
        filmComingSoonRecyclerId.setLayoutManager(layoutManager3);

        adapter = new MyCoverFlowAdapter(list, getActivity());
        filmRecyclerFlowId.setAdapter(adapter);
        presenterInter.toHotMovie();
        presenterInter.toReleaseMovie();
        presenterInter.toComingSoonMovie();

        translationX = ObjectAnimator.ofFloat(filmFragmentSearchId, "translationX", 0, -270, -270);
        translationY = ObjectAnimator.ofFloat(filmFragmentSearchId, "translationX", -270, 0, 0);
        animatorSet = new AnimatorSet();


    }

    @Override
    public void HotMovie(Object object) {
        ShowMovieBean bean = (ShowMovieBean) object;
        list1.addAll(bean.getResult());
        list.addAll(bean.getResult());
        adapter1.notifyDataSetChanged();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void ReleaseMovie(Object object) {
        ShowMovieBean bean = (ShowMovieBean) object;
        list2.addAll(bean.getResult());
        adapter2.notifyDataSetChanged();
    }

    @Override
    public void ComingSoonMovie(Object object) {
        ShowMovieBean bean = (ShowMovieBean) object;
        list3.addAll(bean.getResult());
        adapter3.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenterInter.onDestroy();
        presenterInter = null;
        unbinder.unbind();
    }

    @OnClick({R.id.re01, R.id.re02, R.id.re03,R.id.but_search_id, R.id.text_search_id})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.re01:
                Intent hot = new Intent(getActivity(), MovieDetailActivity.class);
                hot.putExtra("type", "hot");
                startActivity(hot);
                break;
            case R.id.re02:
                Intent release = new Intent(getActivity(), MovieDetailActivity.class);
                release.putExtra("type", "release");
                startActivity(release);
                break;
            case R.id.re03:
                Intent comingSoon = new Intent(getActivity(), MovieDetailActivity.class);
                comingSoon.putExtra("type", "comingSoon");
                startActivity(comingSoon);
                break;
            case R.id.but_search_id:
                animatorSet.play(translationX);
                animatorSet.setDuration(2000).start();
                break;
            case R.id.text_search_id:
                animatorSet.play(translationY);
                animatorSet.setDuration(2000).start();
                break;
        }
    }

}
