package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.bean.ShowMovieBean;
import com.bw.movie.fragmentmdetail.HotFragment;
import com.bw.movie.inter.MyInterface;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.R;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @Author: zhang
 * @Date: 2019/5/12 20:38
 * @Description:
 */
public class MyDetailMovieAdapter extends RecyclerView.Adapter<MyDetailMovieAdapter.ViewHolder> implements MyInterface.ViewInter.FollowInter{
    List<ShowMovieBean.ResultBean> list;
    Context context;
    MyInterface.PresenterInter presenterInter;
    public MyDetailMovieAdapter(List<ShowMovieBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
        presenterInter = new MyPresenter<>(this);
    }
    mySetOnClick mySetOnClick;
    public void setOnClickListener(mySetOnClick onClickListener){
        mySetOnClick = onClickListener;
    }

    @Override
    public void CancelFollowMovie(String string) {
        Toast.makeText(context,string,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void FollowMovie(String string) {
        Toast.makeText(context,string,Toast.LENGTH_SHORT).show();
    }

    public interface mySetOnClick{
        void OnClick(int i);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_movie_detail, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.simple.setImageURI(list.get(position).getImageUrl());
        holder.simple.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(20));
        holder.title.setText(list.get(position).getName());
        holder.summary.setText("简介:"+list.get(position).getSummary());
        holder.simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySetOnClick.OnClick(list.get(position).getId());
            }
        });
        if (list.get(position).getFollowMovie() == 2)
            holder.checkBox.setChecked(false);
        else {
            holder.checkBox.setChecked(true);
        }
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("tag",holder.checkBox.isChecked()+"1");
                if (holder.checkBox.isChecked()){
                    presenterInter.toFollowMovie(list.get(position).getId());
                }else {
                    presenterInter.toCancelFollowMovie(list.get(position).getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView simple;
        CheckBox checkBox;
        TextView title,summary;

        public ViewHolder(View itemView) {
            super(itemView);
            simple = itemView.findViewById(R.id.detail_simple_id);
            title = itemView.findViewById(R.id.detail_title_id);
            summary = itemView.findViewById(R.id.detail_summary_id);
            checkBox = itemView.findViewById(R.id.detail_follow_id);
        }
    }
}
