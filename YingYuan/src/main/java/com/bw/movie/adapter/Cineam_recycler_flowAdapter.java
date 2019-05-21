package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.activity.Select_CineamActivity;
import com.bw.movie.bean.JiCineamBean;

import com.bw.movie.bean.ShowMovieBean;
import com.bw.movie.R;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import recycler.coverflow.RecyclerCoverFlow;

/**
 * @Auther: 白俊岭
 * @Date: 2019/5/15 11:27:48
 * @Description:
 */
public class Cineam_recycler_flowAdapter extends RecyclerCoverFlow.Adapter<Cineam_recycler_flowAdapter.ViewHolder>{
    Context context;List<JiCineamBean.ResultBean> result;
    Select_CineamActivity activity;
    public Cineam_recycler_flowAdapter(Context context,List<JiCineamBean.ResultBean> result) {
        this.context=context;
        this.result=result;
        activity = (Select_CineamActivity) context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_cover_flow, null);
        return new Cineam_recycler_flowAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.simple.setImageURI(result.get(position).getImageUrl());
        holder.simple.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(20));
        holder.title.setText(result.get(position).getName());

//        Date date = new Date(movieList.get(position).getReleaseTime());
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");
//        holder.time.setText(format.format(date));
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               activity.SelectId(result.get(position).getId());

           }
       });
    }



    @Override
    public int getItemCount() {
        if (result!=null){
            return result.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView simple;
        TextView title,time;
        public ViewHolder(View itemView) {
                super(itemView);
                simple = itemView.findViewById(R.id.file_flow_simple_id);
                title = itemView.findViewById(R.id.file_flow_title_id);
                time = itemView.findViewById(R.id.file_flow_time_id);
        }
    }
}
