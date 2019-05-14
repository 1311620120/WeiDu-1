package com.bw.movie.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.adapter.MyCinecismAdapter;
import com.bw.movie.bean.CommentBean;
import com.bw.movie.bean.MovieDetailBean;
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
import butterknife.OnClick;

public class DYDetailActivity extends AppCompatActivity implements MyInterface.ViewInter.DetailInter,MyInterface.ViewInter.FollowInter, MyInterface.ViewInter.CommentInter {

    MyInterface.PresenterInter presenterInter;
    @BindView(R.id.dy_detail_title_id)
    TextView dyDetailTitleId;
    @BindView(R.id.dy_detail_simple_id)
    SimpleDraweeView dyDetailSimpleId;
    @BindView(R.id.text_detail_id)
    TextView textDetailId;
    @BindView(R.id.text_short_id)
    TextView textShortId;
    @BindView(R.id.text_poster_id)
    TextView textPosterId;
    @BindView(R.id.text_cinecism_id)
    TextView textCinecismId;
    @BindView(R.id.dy_detail_back_id)
    ImageView dyDetailBackId;
    @BindView(R.id.dy_detail_shop_id)
    ImageView dyDetailShopId;
    @BindView(R.id.dy_detail_follow_id)
    ImageView dyDetailFollowId;
    @BindView(R.id.text_detail_layout_id)
    RelativeLayout textDetailLayoutId;
    //详情
    @BindView(R.id.include_detail_back_id)
    ImageView includeDetailBackId;
    @BindView(R.id.include_detail_type_id)
    TextView includeDetailTypeId;
    @BindView(R.id.include_detail_director_id)
    TextView includeDetailDirectorId;
    @BindView(R.id.include_detail_duration_id)
    TextView includeDetailDurationId;
    @BindView(R.id.include_detail_placeOrigin_id)
    TextView includeDetailPlaceOriginId;
    @BindView(R.id.include_detail_summary_id)
    TextView includeDetailSummaryId;
    @BindView(R.id.include_detail_simple_id)
    SimpleDraweeView includeDetailSimpleId;
    @BindView(R.id.include_details_tarring1_id)
    TextView includeDetailsTarring1Id;
    @BindView(R.id.include_details_tarring2_id)
    TextView includeDetailsTarring2Id;
    @BindView(R.id.include_details_tarring3_id)
    TextView includeDetailsTarring3Id;
    //评论
    @BindView(R.id.include_cinecism_back_id)
    ImageView includeCinecismBackId;
    @BindView(R.id.include_cinecism_recycler_id)
    RecyclerView includeCinecismRecyclerId;
    @BindView(R.id.text_cinecism_layout_id)
    RelativeLayout textCinecismLayoutId;
    @BindView(R.id.text_short_layout_id)
    RelativeLayout textShortLayoutId;
    private MovieDetailBean bean;
    private List<CommentBean.ResultBean> list = new ArrayList<>();
    private Map<String, String> map;
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dydetail);
        ButterKnife.bind(this);
        presenterInter = new MyPresenter<>(this);
        id = getIntent().getIntExtra("movieId", 0);
        if (id != 0) {
            presenterInter.toMovieDetail(id);
        } else {
            Toast.makeText(this, "movieId为" + id, Toast.LENGTH_SHORT).show();
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        includeCinecismRecyclerId.setLayoutManager(layoutManager);
    }

    @Override
    public void ShowMovieDetail(Object object) {
        bean = (MovieDetailBean) object;
        dyDetailSimpleId.setImageURI(bean.getResult().getImageUrl());
        dyDetailTitleId.setText(bean.getResult().getName());
        if (bean.getResult().getFollowMovie() == 2)
            dyDetailFollowId.setImageResource(R.drawable.com_icon_collection_default_hdpi);
        else {
            dyDetailFollowId.setImageResource(R.drawable.com_icon_collection_selected_hdpi);
        }
        includeDetailTypeId.setText("类型:" + bean.getResult().getMovieTypes());
        includeDetailDirectorId.setText("导演:" + bean.getResult().getDirector());
        includeDetailDurationId.setText("时长:" + bean.getResult().getDuration());
        includeDetailPlaceOriginId.setText("产地:" + bean.getResult().getPlaceOrigin());
        includeDetailSummaryId.setText(bean.getResult().getSummary());
        includeDetailSimpleId.setImageURI(bean.getResult().getImageUrl());
        includeDetailSimpleId.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(12));
        String[] split = bean.getResult().getStarring().split(",");
        if (split.length > 0) {
            includeDetailsTarring1Id.setText(split[0]);
        }
        if (split.length > 1) {
            includeDetailsTarring2Id.setText(split[1]);
        }
        if (split.length > 2) {
            includeDetailsTarring3Id.setText(split[2]);
        }
    }

    @OnClick({R.id.text_detail_id, R.id.text_short_id, R.id.text_poster_id, R.id.text_cinecism_id, R.id.dy_detail_back_id, R.id.dy_detail_shop_id, R.id.include_detail_back_id, R.id.include_cinecism_back_id,R.id.dy_detail_follow_id})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_detail_id:
                textDetailLayoutId.setVisibility(View.VISIBLE);
                break;
            case R.id.text_short_id:
                textShortLayoutId.setVisibility(View.VISIBLE);
                break;
            case R.id.text_poster_id:
                break;
            case R.id.text_cinecism_id:
                textCinecismLayoutId.setVisibility(View.VISIBLE);
                map = new HashMap<>();
                map.put("movieId", bean.getResult().getId() + "");
                map.put("page", "1");
                map.put("count", "15");
                presenterInter.toComment(map);
                break;
            case R.id.dy_detail_back_id:
                finish();
                break;
            case R.id.dy_detail_shop_id:
                Intent intent = new Intent(this,TicketActivity.class);
                startActivity(intent);
                break;
            case R.id.include_detail_back_id:
                textDetailLayoutId.setVisibility(View.GONE);
                break;
            case R.id.include_cinecism_back_id:
                textCinecismLayoutId.setVisibility(View.GONE);
                break;
            case R.id.dy_detail_follow_id:
                if (bean.getResult().getFollowMovie() == 2){
                    presenterInter.toFollowMovie(bean.getResult().getId());
                }else {
                    presenterInter.toCancelFollowMovie(bean.getResult().getId());
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterInter.onDestroy();
        presenterInter = null;
    }

    @Override
    public void showComment(Object object) {
        CommentBean bean = (CommentBean) object;
        list.clear();
        list.addAll(bean.getResult());
        MyCinecismAdapter adapter = new MyCinecismAdapter(list, this);
        includeCinecismRecyclerId.setAdapter(adapter);
    }

    @Override
    public void CancelFollowMovie(String string) {
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show();
        list.clear();
        presenterInter.toMovieDetail(id);
    }

    @Override
    public void FollowMovie(String string) {
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show();
        list.clear();
        presenterInter.toMovieDetail(id);
    }
}
