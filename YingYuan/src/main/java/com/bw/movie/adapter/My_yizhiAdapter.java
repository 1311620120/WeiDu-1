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

import java.util.List;

/**
 * @Auther: 白俊岭
 * @Date: 2019/5/17 10:31:52
 * @Description:
 */
public class My_yizhiAdapter extends RecyclerView.Adapter<My_yizhiAdapter.ViewHolder> {
    Context context; List<My_ShopBean.ResultBean> result;
    public My_yizhiAdapter(Context context, List<My_ShopBean.ResultBean> result) {
        this.context=context;
        this.result=result;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.my_shop_yizhi, null);
        My_yizhiAdapter.ViewHolder holder = new My_yizhiAdapter.ViewHolder(inflate);
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.My_yizhi_Bianhao.setText(result.get(position).getOrderId());
        holder.My_yizhi_money.setText(result.get(position).getPrice());
        holder.My_yizhi_mun.setText(result.get(position).getAmount());
        holder.my_yizhi_title.setText(result.get(position).getMovieName());
        holder.My_yizhi_yingting.setText(result.get(position).getScreeningHall());
        holder.My_yizhi_yingyuan.setText(result.get(position).getCinemaName());
    }



    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView my_yizhi_title;
        private final TextView My_yizhi_Bianhao;
        private final TextView My_yizhi_yingyuan;
        private final TextView My_yizhi_yingting;
        private final TextView My_yizhi_mun;
        private final TextView My_yizhi_money;
        public ViewHolder(View itemView) {
            super(itemView);
            my_yizhi_title = itemView.findViewById(R.id.my_yizhi_title);

            My_yizhi_Bianhao = itemView.findViewById(R.id.My_yizhi_Bianhao);

            My_yizhi_yingyuan = itemView.findViewById(R.id.My_yizhi_yingyuan);
            My_yizhi_yingting = itemView.findViewById(R.id.My_yizhi_yingting);

            My_yizhi_mun = itemView.findViewById(R.id.My_yizhi_mun);
            My_yizhi_money = itemView.findViewById(R.id.My_yizhi_money);
        }
    }
}
