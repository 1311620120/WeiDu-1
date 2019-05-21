package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.bean.My_CinemaBean;
import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @Auther: 白俊岭
 * @Date: 2019/5/13 10:26:23
 * @Description:
 */
public class My_CinemaAdapter extends RecyclerView.Adapter<My_CinemaAdapter.ViewHolder> {
    Context context; List<My_CinemaBean.ResultBean> result;
    public My_CinemaAdapter(Context context, List<My_CinemaBean.ResultBean> result) {
        this.context=context;
        this.result=result;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_film_cinemafragment, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.my_film_cinemafragment_img.setImageURI(result.get(position).getLogo());
        holder.my_film_cinemafragment_title.setText(result.get(position).getName());
        holder.my_film_cinemafragment_diess.setText(result.get(position).getAddress());
    }


    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView my_film_cinemafragment_img;
        private final TextView my_film_cinemafragment_title;
        private final TextView my_film_cinemafragment_diess;

        public ViewHolder(View itemView) {
            super(itemView);
            my_film_cinemafragment_img = itemView.findViewById(R.id.my_film_cinemafragment_img);
            my_film_cinemafragment_title = itemView.findViewById(R.id.my_film_cinemafragment_title);
            my_film_cinemafragment_diess = itemView.findViewById(R.id.my_film_cinemafragment_diess);
        }
    }
}
