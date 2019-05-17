package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.activity.Select_CineamActivity;
import com.bw.movie.bean.ScheduleBean;
import com.bw.movie.bean.Select_CinemaIdBean;
import com.bw.movie.view.R;

import java.util.List;

/**
 * @Auther: 白俊岭
 * @Date: 2019/5/15 15:45:12
 * @Description:
 */
public class Cineam_gouAdapter extends RecyclerView.Adapter <Cineam_gouAdapter.ViewHolder>{
    Context context;  List<ScheduleBean.ResultBean> result;
    public Cineam_gouAdapter(Context context,  List<ScheduleBean.ResultBean> result) {
        this.context=context;
        this.result=result;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.cinramgoufragment, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

                holder.cineam_gou_name.setText(result.get(position).getScreeningHall());
        holder.cineam_gou_staTime.setText(result.get(position).getBeginTime());
        holder.endtime.setText(result.get(position).getEndTime());
        holder.cineam_gou_price.setText(result.get(position).getSeatsUseCount()+"");
    }


    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView cineam_gou_name;
        private final TextView cineam_gou_yuyan;
        private final TextView cineam_gou_staTime;
        private final TextView endtime;
        private final TextView cineam_gou_price;

        public ViewHolder(View itemView) {
            super(itemView);
            cineam_gou_name = itemView.findViewById(R.id.cineam_gou_name);
            cineam_gou_yuyan = itemView.findViewById(R.id.cineam_gou_yuyan);
            cineam_gou_staTime = itemView.findViewById(R.id.cineam_gou_staTime);
            endtime = itemView.findViewById(R.id.endtime);
            cineam_gou_price = itemView.findViewById(R.id.cineam_gou_price);

        }
    }
}
