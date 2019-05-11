package com.bw.movie.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bw.movie.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PagerActivity extends AppCompatActivity {

    @BindView(R.id.viewPager_id)
    ViewPager viewPagerId;
    @BindView(R.id.pager_name)
    TextView pagerName;
    @BindView(R.id.pager_title)
    TextView pagerTitle;
    @BindView(R.id.radioGroup_id)
    RadioGroup radioGroupId;
    List<Integer> list = new ArrayList<>();
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.rb3)
    RadioButton rb3;
    @BindView(R.id.rb4)
    RadioButton rb4;
    @BindView(R.id.intent_activity)
    Button intentActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        ButterKnife.bind(this);
        pagerName.setText("一场电影");
        pagerTitle.setText("净化你的灵魂");
        list.add(R.layout.tuceng1);
        list.add(R.drawable.tuceng2);
        list.add(R.drawable.tuceng3);
        list.add(R.drawable.tuceng4);
        MyPagerAdapter adapter = new MyPagerAdapter(list, this);
        viewPagerId.setAdapter(adapter);
        viewPagerId.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (list.size() - 1 == position) {
                    intentActivity.setVisibility(View.VISIBLE);
                }else {
                    intentActivity.setVisibility(View.GONE);
                }
                radioGroupId.check(radioGroupId.getChildAt(position).getId());
                switch (position){
                    case 0:
                        rb1.setChecked(true);
                        pagerName.setText("一场电影");
                        pagerTitle.setText("净化你的灵魂");
                        break;
                    case 1:
                        rb2.setChecked(true);
                        pagerName.setText("一场电影");
                        pagerTitle.setText("看遍人生百态");
                        break;
                    case 2:
                        rb3.setChecked(true);
                        pagerName.setText("一场电影");
                        pagerTitle.setText("荡涤你的心灵");
                        break;
                    case 3:
                        rb4.setChecked(true);
                        pagerName.setText("八维移动通信学院作品");
                        pagerTitle.setText("带您开启一段美好的电影之旅");
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick(R.id.intent_activity)
    public void onViewClicked() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
