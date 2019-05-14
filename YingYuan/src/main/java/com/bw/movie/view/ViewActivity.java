package com.bw.movie.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bw.movie.fragment.CinemaFragment;
import com.bw.movie.fragment.FilmFragment;
import com.bw.movie.fragment.MyFragment;
import com.bw.movie.inter.MyInterface;
import com.bw.movie.presenter.MyPresenter;
import com.hjm.bottomtabbar.BottomTabBar;

import java.util.HashMap;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        BottomTabBar buttonBar = findViewById(R.id.buttonBar);


        buttonBar.init(getSupportFragmentManager())
                .setTabBarBackgroundColor(0x0fff)
                .setFontSize(0)
                .setImgSize(100,100)
                .addTabItem("",R.mipmap.film_selected_xhdpi,R.mipmap.film_fault_xhdpi,FilmFragment.class)
                .addTabItem("",R.mipmap.selected_xhdpi,R.mipmap.default_xhdpi,CinemaFragment.class)
                .addTabItem("",R.mipmap.icon_my_selected_xhdpi,R.mipmap.icon_my_default_xhdpi,MyFragment.class)
                .isShowDivider(false);

    }
}
