package com.bw.movie.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


import com.bw.movie.activity.PersonalActivity;
import com.bw.movie.view.R;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * @Auther: 白俊岭
 * @Date: 2019/5/10 19:15:09
 * @Description:
 */
public class MyFragment extends Fragment {

    @BindView(R.id.My_megess)
    ImageView MyMegess;
    @BindView(R.id.My_button)
    Button MyButton;
    @BindView(R.id.my_xinxi)
    ImageView myXinxi;
    @BindView(R.id.my_guanzu)
    ImageView myGuanzu;
    @BindView(R.id.my_goupiao)
    ImageView myGoupiao;
    @BindView(R.id.my_yijian)
    ImageView myYijian;
    @BindView(R.id.my_banben)
    ImageView myBanben;
    @BindView(R.id.my_tuichu)
    ImageView myTuichu;
    Unbinder unbinder;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.myfragment, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.My_megess, R.id.My_button, R.id.my_xinxi, R.id.my_guanzu, R.id.my_goupiao, R.id.my_yijian, R.id.my_banben, R.id.my_tuichu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.My_megess:
                break;
            case R.id.My_button:
                break;
            case R.id.my_xinxi:
                Intent intent = new Intent(getActivity(), PersonalActivity.class);
                startActivity(intent);
                break;
            case R.id.my_guanzu:
                break;
            case R.id.my_goupiao:
                break;
            case R.id.my_yijian:
                break;
            case R.id.my_banben:
                break;
            case R.id.my_tuichu:
                break;
        }
    }
}
