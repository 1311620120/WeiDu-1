package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.bean.My_MegessBean;
import com.bw.movie.R;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Auther: 白俊岭
 * @Date: 2019/5/12 21:34:50
 * @Description:
 */
public class My_MagessAdapter extends RecyclerView.Adapter<My_MagessAdapter.ViewHolder> {
    Context context; List<My_MegessBean.ResultBean> result;
    public My_MagessAdapter(Context context, List<My_MegessBean.ResultBean> result) {
        this.context=context;
        this.result=result;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_magess,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.my_magess_title.setText(result.get(position).getTitle());

        holder.my_magess_countent.setText(result.get(position).getContent());
        //时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        String data = simpleDateFormat.format(result.get(position).getPushTime());
        holder.my_magess_time.setText(data);
    }


    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView my_magess_title;
        private final TextView my_magess_countent;
        private final TextView my_magess_time;

        public ViewHolder(View itemView) {
            super(itemView);
            my_magess_title = itemView.findViewById(R.id.my_magess_title);
            my_magess_countent = itemView.findViewById(R.id.my_magess_countent);
            my_magess_time = itemView.findViewById(R.id.my_magess_time);
        }
    }
}
