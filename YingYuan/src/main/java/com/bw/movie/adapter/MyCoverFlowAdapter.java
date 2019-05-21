package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.bean.ShowMovieBean;
import com.bw.movie.R;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import recycler.coverflow.RecyclerCoverFlow;

/**
 * @Author: zhang
 * @Date: 2019/5/13 9:37
 * @Description:
 */
public class MyCoverFlowAdapter extends RecyclerCoverFlow.Adapter<MyCoverFlowAdapter.ViewHolder> {
    List<ShowMovieBean.ResultBean> list;
    Context context;

    setOnClick setOnClick;
    public void setOnCLickListener(setOnClick onCLickListener){
        setOnClick = onCLickListener;
    }
    public interface setOnClick{
        void onClick(int j);
    }
    public MyCoverFlowAdapter(List<ShowMovieBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_cover_flow, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.simple.setImageURI(list.get(position).getImageUrl());
        holder.simple.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(20));
        holder.title.setText(list.get(position).getName());
        holder.time.setText("");
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

    public class ViewHolder extends RecyclerCoverFlow.ViewHolder{
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
