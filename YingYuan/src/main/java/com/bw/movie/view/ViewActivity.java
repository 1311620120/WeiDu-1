package com.bw.movie.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bw.movie.inter.MyInterface;
import com.bw.movie.presenter.MyPresenter;

import java.util.HashMap;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        MyInterface.PresenterInter presenterInter = new MyPresenter<>(this);
        presenterInter.toLogi(new HashMap<String, String>());
        presenterInter.toLogi(new HashMap<String, String>());
    }
}
