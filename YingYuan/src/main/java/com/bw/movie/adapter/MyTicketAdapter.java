package com.bw.movie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.activity.Select_CineamActivity;
import com.bw.movie.bean.Select_CinemaBean;
import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @Auther: 白俊岭
 * @Date: 2019/5/13 19:37:51
 * @Description:
 */
public class MyTicketAdapter extends  RecyclerView.Adapter<MyTicketAdapter.ViewHolder> {
    Context context;
    List<Select_CinemaBean.ResultBean> result;
    public MyTicketAdapter(Context context, List<Select_CinemaBean.ResultBean> result) {
        this.context=context;
        this.result=result;
    }
    setOnClick setOnClick;
    public void setOnClickListener(setOnClick onClickListener){
        setOnClick = onClickListener;
    }
    public interface setOnClick{
        void onClick(int j, String name, String cont);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cinema_tui, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
                holder.cineam_diess.setText(result.get(position).getAddress());
                holder.cineam_juli.setText(result.get(position).getCommentTotal()+"km");
                holder.cineam_title.setText(result.get(position).getName());
                holder.cinema_logo.setImageURI(result.get(position).getLogo());
        if (result.get(position).getFollowCinema() == 2)
            holder.cinema_dianzan.setChecked(false);
        else {
            holder.cinema_dianzan.setChecked(true);
        }

        holder.cinema_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClick.onClick(result.get(position).getId(),result.get(position).getName(),result.get(position).getAddress());
            }
        });

    }

    @Override
    public int getItemCount() {
        if (result != null){
            return result.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final SimpleDraweeView cinema_logo;
        private final TextView cineam_title;
        private final TextView cineam_juli;
        private final TextView cineam_diess;
        private final CheckBox cinema_dianzan;

        public ViewHolder(View itemView) {
            super(itemView);
            cinema_logo = itemView.findViewById(R.id.cinema_logo);
            cineam_title = itemView.findViewById(R.id.cineam_title);
            cineam_juli = itemView.findViewById(R.id.cineam_juli);
            cineam_diess = itemView.findViewById(R.id.cineam_diess);
            cinema_dianzan = itemView.findViewById(R.id.cinema_dianzan);
        }
    }
}

