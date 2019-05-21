package com.bw.movie.fragment;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.activity.GuanzuActivity;
import com.bw.movie.activity.MegessActivity;
import com.bw.movie.activity.MinessActivity;
import com.bw.movie.activity.PersonalActivity;
import com.bw.movie.activity.ShopingActivity;
import com.bw.movie.bai.IMainView;
import com.bw.movie.bean.My_HeadPicBean;
import com.bw.movie.bean.My_ziliaoBean;
import com.bw.movie.presenter.HeadPicPresenter;
import com.bw.movie.presenter.MyziliaoPresenter;
import com.bw.movie.view.LoginActivity;
import com.bw.movie.view.MainActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * @Auther: 白俊岭
 * @Date: 2019/5/10 19:15:09
 * @Description:
 */
public class MyFragment extends Fragment implements IMainView {
    String userId;
    String sessionId;
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
    @BindView(R.id.head)
    SimpleDraweeView head;
    @BindView(R.id.name)
    TextView name;
    private View view;
    private HeadPicPresenter headPicPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.myfragment, null);
        unbinder = ButterKnife.bind(this, view);
        SharedPreferences sp = getActivity().getSharedPreferences("myId", Context.MODE_PRIVATE);
        String Id = sp.getString("userId", "1");
        String Sid = sp.getString("sessionId", "1");

        userId = Id;
        sessionId = Sid;
        initData();
        return view;
    }


    private void initData() {

        MyziliaoPresenter myziliaoPresenter = new MyziliaoPresenter();
        myziliaoPresenter.getZiliao(userId, sessionId);
        myziliaoPresenter.setView(this);

        headPicPresenter = new HeadPicPresenter();
        headPicPresenter.setView(this);

    }

    @Override
    public void onCheng(Object o) {
        if (o instanceof My_ziliaoBean ){
            My_ziliaoBean my_ziliaoBean = (My_ziliaoBean) o;
            My_ziliaoBean.ResultBean result = my_ziliaoBean.getResult();
            Log.e("ssss", result + "");

            String headPic = result.getHeadPic();
            head.setImageURI(headPic);
            String nickName = result.getNickName();
            name.setText(nickName);
        }
        if (o instanceof My_HeadPicBean){
            My_HeadPicBean my_headPicBean=(My_HeadPicBean)o;
            if(o.equals("0000"))
            {
                Toast.makeText(getActivity(),my_headPicBean.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //判断SD卡是否挂载
    public boolean hasSdcard(){
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            return true;
        }else{
            return false;
        }
    }


    @OnClick({R.id.My_megess, R.id.My_button, R.id.my_xinxi, R.id.my_guanzu, R.id.my_goupiao, R.id.my_yijian, R.id.my_banben, R.id.my_tuichu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.My_megess:
                startActivity(new Intent(getActivity(), MegessActivity.class));
                break;
            case R.id.My_button:
                break;
            case R.id.my_xinxi:
                Intent intent = new Intent(getActivity(), PersonalActivity.class);
                startActivity(intent);
                break;
            case R.id.my_guanzu:
                startActivity(new Intent(getActivity(), GuanzuActivity.class));
                break;
            case R.id.my_goupiao:
                startActivity(new Intent(getActivity(), ShopingActivity.class));
                break;
            case R.id.my_yijian:
                startActivity(new Intent(getActivity(), MinessActivity.class));
                break;
            case R.id.my_banben:
                Toast.makeText(getActivity(),"已是最新版本！！！",Toast.LENGTH_SHORT).show();;

                break;
            case R.id.my_tuichu:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
        }
    }


    @OnClick(R.id.head)
    public void onViewClicked() {
        final Dialog dialog = new Dialog(getActivity());
        //填充对话框的布局
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_layout, null);
        //初始化控件
        //相册

        inflate.findViewById(R.id.choosePhoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                Intent intent_choosePhoto=new Intent(Intent.ACTION_PICK);
                intent_choosePhoto.setType("image/*");
                startActivityForResult(intent_choosePhoto,2);

                dialog.dismiss();
            }
        });
        //相机
        inflate.findViewById(R.id.takeCamera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打开相机
                Intent intent_takePhoto=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent_takePhoto, 1);
                dialog.dismiss();
            }
        });
        inflate.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        //将布局设置给Dialog
        dialog.setContentView(inflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = dialog.getWindow();
        if(dialogWindow == null){
            return;
        }
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity(Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 20;//设置Dialog距离底部的距离
        //将属性设置给窗体
        dialogWindow.setAttributes(lp);
        dialog.show();//显示对话框
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == MainActivity.RESULT_OK) {//相机返回的数据
            if (hasSdcard()) {
                Bitmap bitmap = data.getParcelableExtra("data");
                //将bitmap转换为uri
                Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(getActivity().getContentResolver(), bitmap, null, null));

                String[] proj = {MediaStore.Images.Media.DATA};

                Cursor actualimagecursor = getActivity().managedQuery(uri, proj, null, null, null);

                int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

                actualimagecursor.moveToFirst();

                String img_path = actualimagecursor.getString(actual_image_column_index);

                File file = new File(img_path);
                List<File> list = new ArrayList<>();
                list.add(file);

                headPicPresenter.HeadData(userId,sessionId,file);

            } else {
                Toast.makeText(getActivity(), "未找到存储啦，无法存储照片", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == 2 && resultCode == MainActivity.RESULT_OK) {//相册返回的数据
            //得到图片的全路径
            if (data != null) {
                Uri uri = data.getData();
                String[] proj = {MediaStore.Images.Media.DATA};
                Cursor actualimagecursor = getActivity().managedQuery(uri, proj, null, null, null);
                int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                actualimagecursor.moveToFirst();
                String img_path = actualimagecursor.getString(actual_image_column_index);
                File file = new File(img_path);
                List<File> list = new ArrayList<>();
                list.add(file);
                headPicPresenter.HeadData(userId,sessionId,file);
            }
        }
    }
}
