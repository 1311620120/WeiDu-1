package com.bw.movie.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.movie.R;
import com.bw.movie.adapter.MyPagerAdapter;
import com.bw.movie.fragmentpage.FourFragment;
import com.bw.movie.fragmentpage.OneFragment;
import com.bw.movie.fragmentpage.ThreeFragment;
import com.bw.movie.fragmentpage.TwoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PagerActivity extends BaseActivity {

    @BindView(R.id.viewPager_id)
    ViewPager viewPagerId;
    @BindView(R.id.radioGroup_id)
    RadioGroup radioGroupId;
    List<Fragment> list = new ArrayList<>();
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
        list.add(new OneFragment());
        list.add(new TwoFragment());
        list.add(new ThreeFragment());
        list.add(new FourFragment());
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(),list, this);
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
                        break;
                    case 1:
                        rb2.setChecked(true);
                        break;
                    case 2:
                        rb3.setChecked(true);
                        break;
                    case 3:
                        rb4.setChecked(true);
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
