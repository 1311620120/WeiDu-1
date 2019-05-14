package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.bean.Select_CinmaBeanFu;
import com.bw.movie.view.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @Auther: 白俊岭
 * @Date: 2019/5/13 19:40:25
 * @Description:
 */
public class Select_CinmaFuAdapter extends RecyclerView.Adapter<Select_CinmaFuAdapter.ViewHolder> {
    Context context; List<Select_CinmaBeanFu.ResultBean> result;
    public Select_CinmaFuAdapter(Context context, List<Select_CinmaBeanFu.ResultBean> result) {
        this.context=context;
        this.result=result;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cinema_tui, null);
        Select_CinmaFuAdapter.ViewHolder viewHolder = new Select_CinmaFuAdapter.ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cineam_diess.setText(result.get(position).getAddress());
        holder.cineam_juli.setText(result.get(position).getCommentTotal()+"km");
        holder.cineam_title.setText(result.get(position).getName());
        holder.cinema_logo.setImageURI(result.get(position).getLogo());
    }


    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView cinema_logo;
        TextView cineam_title;
        TextView cineam_juli;
        TextView cineam_diess;
        ImageView cinema_dianzan;
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
