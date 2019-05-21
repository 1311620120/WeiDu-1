package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.bean.ReplyBean;
import com.bw.movie.R;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: zhang
 * @Date: 2019/5/15 11:40
 * @Description:
 */
public class MyReplayAdapter extends RecyclerView.Adapter<MyReplayAdapter.ViewHolder> {
    List<ReplyBean.ResultBean> list;
    Context context;

    public MyReplayAdapter(List<ReplyBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_replay_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.simple.setImageURI(list.get(position).getReplyHeadPic());
        holder.simple.getHierarchy().setRoundingParams(RoundingParams.asCircle());
        holder.name.setText(list.get(position).getReplyUserName());
        holder.cont.setText(list.get(position).getReplyContent());
        Date date = new Date(list.get(position).getReplyTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");
        holder.time.setText(format.format(date));
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
        TextView name,cont,time;
        public ViewHolder(View itemView) {
            super(itemView);
            simple = itemView.findViewById(R.id.replay_simple_item_id);
            name = itemView.findViewById(R.id.replay_commentUserName_item_id);
            cont = itemView.findViewById(R.id.replay_movieComment_item_id);
            time = itemView.findViewById(R.id.replay_commentTime_item_id);
        }
    }
}
