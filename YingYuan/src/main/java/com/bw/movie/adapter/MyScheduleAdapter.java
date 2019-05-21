package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.bean.ScheduleBean;
import com.bw.movie.R;
import com.bw.movie.view.ScheduleActivity;

import java.util.List;

/**
 * @Auther: zhang
 * @Date: 2019/5/15 15:45:12
 * @Description:
 */
public class MyScheduleAdapter extends RecyclerView.Adapter <MyScheduleAdapter.ViewHolder>{
    Context context; List<ScheduleBean.ResultBean> result;
    ScheduleActivity activity;
    public MyScheduleAdapter(Context context, List<ScheduleBean.ResultBean> result) {
        this.context=context;
        this.result=result;
        activity = (ScheduleActivity) context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.cinramgoufragment, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.cineam_gou_name.setText(result.get(position).getScreeningHall());
        holder.cineam_gou_staTime.setText(result.get(position).getBeginTime());
        holder.endtime.setText(result.get(position).getEndTime());
        holder.cineam_gou_price.setText(result.get(position).getPrice()+"");
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.IntentPay(result.get(position).getSeatsTotal(),
                        result.get(position).getId(),
                        result.get(position).getBeginTime(),
                        result.get(position).getEndTime(),
                        result.get(position).getScreeningHall(),
                        result.get(position).getPrice());
            }
        });
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
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            cineam_gou_name = itemView.findViewById(R.id.cineam_gou_name);
            cineam_gou_yuyan = itemView.findViewById(R.id.cineam_gou_yuyan);
            cineam_gou_staTime = itemView.findViewById(R.id.cineam_gou_staTime);
            endtime = itemView.findViewById(R.id.endtime);
            cineam_gou_price = itemView.findViewById(R.id.cineam_gou_price);
            imageView = itemView.findViewById(R.id.cineam_gou_image_id);
        }
    }
}
