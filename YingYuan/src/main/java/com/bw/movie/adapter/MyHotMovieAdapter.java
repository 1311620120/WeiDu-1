package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.bean.ShowMovieBean;
import com.bw.movie.R;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @Author: zhang
 * @Date: 2019/5/12 20:38
 * @Description:
 */
public class MyHotMovieAdapter extends RecyclerView.Adapter<MyHotMovieAdapter.ViewHolder> {
    List<ShowMovieBean.ResultBean> list;
    Context context;

    setOnClick setOnClick;
    public void setOnCLickListener(setOnClick onCLickListener){
        setOnClick = onCLickListener;
    }
    public interface setOnClick{
        void onClick(int j);
    }
    public MyHotMovieAdapter(List<ShowMovieBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_hot_movie, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.simple.setImageURI(list.get(position).getImageUrl());
        holder.simple.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(20));
        holder.title.setText(list.get(position).getName());
        holder.simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClick.onClick(list.get(position).getId());
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
        TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            simple = itemView.findViewById(R.id.file_hot_simple_id);
            title = itemView.findViewById(R.id.file_hot_title_id);
        }
    }
}
