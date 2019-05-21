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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.adapter.MyCoverFlowAdapter;
import com.bw.movie.adapter.MyHotMovieAdapter;
import com.bw.movie.bean.ShowMovieBean;
import com.bw.movie.inter.MyInterface;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.view.DYDetailActivity;
import com.bw.movie.view.MovieDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import recycler.coverflow.CoverFlowLayoutManger;
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
    LinearLayout filmFragmentSearchId;
    @BindView(R.id.file_radio_id)
    RadioGroup radioId;
    @BindView(R.id.rb1_file_id)
    RadioButton rb1FileId;
    @BindView(R.id.rb2_file_id)
    RadioButton rb2FileId;
    @BindView(R.id.rb3_file_id)
    RadioButton rb3FileId;
    @BindView(R.id.rb4_file_id)
    RadioButton rb4FileId;
    @BindView(R.id.rb5_file_id)
    RadioButton rb5FileId;
    @BindView(R.id.rb6_file_id)
    RadioButton rb6FileId;
    @BindView(R.id.text_search_id)
    TextView textSearchId;
    private MyHotMovieAdapter adapter1;
    private MyHotMovieAdapter adapter2;
    private MyHotMovieAdapter adapter3;
    private MyCoverFlowAdapter adapter;
    private TranslateAnimation animation;
    ImageView butSearchId;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.filmfragment, null);
        unbinder = ButterKnife.bind(this, view);
        butSearchId = view.findViewById(R.id.but_search_id);
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
        animation = new TranslateAnimation(0, -270, 0, 0);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //filmFragmentSearchId.clearAnimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        butSearchId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filmFragmentSearchId.startAnimation(animation);
            }
        });
        adapter.setOnCLickListener(new MyCoverFlowAdapter.setOnClick() {
            @Override
            public void onClick(int j) {
                Intent intent = new Intent(getActivity(), DYDetailActivity.class);
                intent.putExtra("movieId", j);
                startActivity(intent);
            }
        });
        adapter1.setOnCLickListener(new MyHotMovieAdapter.setOnClick() {
            @Override
            public void onClick(int j) {
                Intent intent = new Intent(getActivity(), DYDetailActivity.class);
                intent.putExtra("movieId", j);
                startActivity(intent);
            }
        });
        adapter2.setOnCLickListener(new MyHotMovieAdapter.setOnClick() {
            @Override
            public void onClick(int j) {
                Intent intent = new Intent(getActivity(), DYDetailActivity.class);
                intent.putExtra("movieId", j);
                startActivity(intent);
            }
        });
        adapter3.setOnCLickListener(new MyHotMovieAdapter.setOnClick() {
            @Override
            public void onClick(int j) {
                Intent intent = new Intent(getActivity(), DYDetailActivity.class);
                intent.putExtra("movieId", j);
                startActivity(intent);
            }
        });

        filmRecyclerFlowId.setOnItemSelectedListener(new CoverFlowLayoutManger.OnSelected() {


            @Override
            public void onItemSelected(int position) {
                switch (position) {
                    case 0:
                        rb1FileId.setChecked(true);
                        break;
                    case 1:
                        rb2FileId.setChecked(true);
                        break;
                    case 2:
                        rb3FileId.setChecked(true);
                        break;
                    case 3:
                        rb4FileId.setChecked(true);
                        break;
                    case 4:
                        rb5FileId.setChecked(true);
                        break;
                    case 5:
                        rb6FileId.setChecked(true);
                        break;
                }
            }
        });
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

    @OnClick({R.id.re01, R.id.re02, R.id.re03})
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
        }
    }

}
