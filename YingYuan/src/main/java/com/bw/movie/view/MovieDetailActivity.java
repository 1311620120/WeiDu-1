package com.bw.movie.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.movie.R;
import com.bw.movie.adapter.MyMovieDetailAdapter;
import com.bw.movie.fragmentmdetail.ComingSoonFragment;
import com.bw.movie.fragmentmdetail.HotFragment;
import com.bw.movie.fragmentmdetail.ReleaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MovieDetailActivity extends BaseActivity {

    @BindView(R.id.radioGroup_detail_id)
    RadioGroup radioGroupDetailId;
    @BindView(R.id.viewPager_detail_id)
    ViewPager viewPagerDetailId;
    @BindView(R.id.movie_detail_back_id)
    ImageView movieDetailBackId;
    List<Fragment> list = new ArrayList<>();
    @BindView(R.id.rb1_detail_id)
    RadioButton rb1DetailId;
    @BindView(R.id.rb2_detail_id)
    RadioButton rb2DetailId;
    @BindView(R.id.rb3_detail_id)
    RadioButton rb3DetailId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);
        String type = getIntent().getStringExtra("type");

        list.add(new HotFragment());
        list.add(new ReleaseFragment());
        list.add(new ComingSoonFragment());
        MyMovieDetailAdapter adapter = new MyMovieDetailAdapter(getSupportFragmentManager(), list);
        viewPagerDetailId.setAdapter(adapter);
        if (type.equals("hot")) {
            rb1DetailId.setChecked(true);
            viewPagerDetailId.setCurrentItem(0);
        } else if (type.equals("release")) {
            rb2DetailId.setChecked(true);
            viewPagerDetailId.setCurrentItem(1);
        } else if (type.equals("comingSoon")) {
            rb3DetailId.setChecked(true);
            viewPagerDetailId.setCurrentItem(2);
        }
        viewPagerDetailId.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radioGroupDetailId.check(radioGroupDetailId.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radioGroupDetailId.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb1_detail_id:
                        viewPagerDetailId.setCurrentItem(0,false);
                        break;
                    case R.id.rb2_detail_id:
                        viewPagerDetailId.setCurrentItem(1,false);
                        break;
                    case R.id.rb3_detail_id:
                        viewPagerDetailId.setCurrentItem(2,false);
                        break;
                }
            }
        });
    }

    @OnClick(R.id.movie_detail_back_id)
    public void onViewClicked() {
        finish();
    }

}
