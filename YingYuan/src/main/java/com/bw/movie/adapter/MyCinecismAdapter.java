package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.bean.CommentBean;
import com.bw.movie.inter.MyInterface;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.view.DYDetailActivity;
import com.bw.movie.view.R;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.bw.movie.view.R.drawable.com_icon_meiyoudianzan_hdpi;
import static com.bw.movie.view.R.drawable.com_icon_youdianzan_hdpi;

/**
 * @Author: zhang
 * @Date: 2019/5/13 21:30
 * @Description:
 */
public class MyCinecismAdapter extends RecyclerView.Adapter<MyCinecismAdapter.ViewHolder> implements MyInterface.ViewInter.CommentGreatInter {
    List<CommentBean.ResultBean> list;
    Context context;
    DYDetailActivity activity ;
    MyInterface.PresenterInter presenterInter;
    public MyCinecismAdapter(List<CommentBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
        activity = (DYDetailActivity) context;
        presenterInter = new MyPresenter<>(this);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_cinecism_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.simple.setImageURI(list.get(position).getCommentHeadPic());
        holder.simple.getHierarchy().setRoundingParams(RoundingParams.asCircle());
        holder.name.setText(list.get(position).getCommentUserName());
        holder.comment.setText(list.get(position).getCommentContent());
        Date date = new Date(list.get(position).getCommentTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");
        holder.time.setText(format.format(date));
        if (list.get(position).getIsGreat() == 0){
            holder.isgreatNum.setBackgroundResource(com_icon_meiyoudianzan_hdpi);
        }else {
            holder.isgreatNum.setBackgroundResource(com_icon_youdianzan_hdpi);
        }
        holder.greatNum.setText(list.get(position).getGreatNum()+"");
        holder.replyNum.setText(list.get(position).getReplyNum()+"");
        holder.reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.Reply(list.get(position).getCommentId());
            }
        });
        holder.isgreatNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterInter.toCommentGreat(list.get(position).getCommentId());
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

    @Override
    public void CommentGreat(String str) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView simple;
        TextView name,comment,time,greatNum,replyNum;
        CheckBox isgreatNum;
        ImageView reply;
        public ViewHolder(View itemView) {
            super(itemView);
            simple = itemView.findViewById(R.id.cinecism_simple_item_id);
            name = itemView.findViewById(R.id.cinecism_commentUserName_item_id);
            comment = itemView.findViewById(R.id.cinecism_movieComment_item_id);
            time = itemView.findViewById(R.id.cinecism_commentTime_item_id);
            isgreatNum = itemView.findViewById(R.id.cinecism_isgreatNum_item_id);
            reply = itemView.findViewById(R.id.cinecism_reply_item_id);
            greatNum = itemView.findViewById(R.id.cinecism_greatNum_item_id);
            replyNum = itemView.findViewById(R.id.cinecism_replyNum_item_id);
        }
    }
}
