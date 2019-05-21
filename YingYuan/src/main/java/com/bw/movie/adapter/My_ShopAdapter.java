package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.bean.My_ShopBean;
import com.bw.movie.R;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Auther: 白俊岭
 * @Date: 2019/5/13 15:58:10
 * @Description:
 */
public class My_ShopAdapter extends RecyclerView.Adapter<My_ShopAdapter.ViewHolder> {
    Context context; List<My_ShopBean.ResultBean> result;
    public My_ShopAdapter(Context context, List<My_ShopBean.ResultBean> result) {
        this.context=context;
        this.result=result;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(context).inflate(R.layout.my_shop_wei, null);
        My_ShopAdapter.ViewHolder holder = new My_ShopAdapter.ViewHolder(inflate);
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.my_shop_bianhao.setText(result.get(position).getCreateTime());
        holder.my_shop_money.setText(result.get(position).getPrice());
        holder.my_shop_mun.setText(result.get(position).getAmount());
        holder.my_shop_title.setText(result.get(position).getMovieName());
        holder.my_shop_yingting.setText(result.get(position).getScreeningHall());
        holder.my_shop_yingyuan.setText(result.get(position).getCinemaName());
    }


    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView my_shop_title;
        private final TextView my_shop_zhifu;
        private final TextView my_shop_bianhao;
        private final TextView my_shop_yingyuan;
        private final TextView my_shop_yingting;
        private final TextView my_shop_statime;
        private final TextView my_shop_endtime;
        private final TextView my_shop_mun;
        private final TextView my_shop_money;

        public ViewHolder(View itemView) {
            super(itemView);
            my_shop_title = itemView.findViewById(R.id.my_shop_title);
            my_shop_zhifu = itemView.findViewById(R.id.my_shop_zhifu);
            my_shop_bianhao = itemView.findViewById(R.id.My_shop_Bianhao);
            my_shop_yingyuan = itemView.findViewById(R.id.My_shop_yingyuan);
            my_shop_yingting = itemView.findViewById(R.id.My_shop_yingting);
            my_shop_statime = itemView.findViewById(R.id.My_shop_statime);
            my_shop_endtime = itemView.findViewById(R.id.My_shop_endtime);
            my_shop_mun = itemView.findViewById(R.id.My_shop_mun);
            my_shop_money = itemView.findViewById(R.id.My_shop_money);
        }
    }
}
