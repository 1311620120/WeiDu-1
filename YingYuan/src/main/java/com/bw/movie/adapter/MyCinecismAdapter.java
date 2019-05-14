package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bw.movie.bean.CommentBean;
import com.bw.movie.view.R;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: zhang
 * @Date: 2019/5/13 21:30
 * @Description:
 */
public class MyCinecismAdapter extends RecyclerView.Adapter<MyCinecismAdapter.ViewHolder> {
    List<CommentBean.ResultBean> list;
    Context context;

    public MyCinecismAdapter(List<CommentBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_cinecism_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.simple.setImageURI(list.get(position).getCommentHeadPic());
        holder.simple.getHierarchy().setRoundingParams(RoundingParams.asCircle());
        holder.name.setText(list.get(position).getCommentUserName());
        holder.comment.setText(list.get(position).getCommentContent());
        Date date = new Date(list.get(position).getCommentTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");
        holder.time.setText(format.format(date));
        holder.greatNum.setText(list.get(position).getGreatNum()+"");
        holder.replyNum.setText(list.get(position).getReplyNum()+"");
        //holder.time.setText(list.get(position).getCommentTime());
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
        TextView name,comment,time;
        CheckBox greatNum,replyNum;
        public ViewHolder(View itemView) {
            super(itemView);
            simple = itemView.findViewById(R.id.cinecism_simple_item_id);
            name = itemView.findViewById(R.id.cinecism_commentUserName_item_id);
            comment = itemView.findViewById(R.id.cinecism_movieComment_item_id);
            time = itemView.findViewById(R.id.cinecism_commentTime_item_id);
            greatNum = itemView.findViewById(R.id.cinecism_greatNum_item_id);
            replyNum = itemView.findViewById(R.id.cinecism_replyNum_item_id);
        }
    }
}
