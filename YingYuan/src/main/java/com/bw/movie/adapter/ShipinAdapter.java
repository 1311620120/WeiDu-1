package com.bw.movie.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bw.movie.bean.MovieDetailBean;
import com.bw.movie.R;

import java.util.List;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * @Auther: 白俊岭
 * @Date: 2019/5/17 19:07:14
 * @Description:
 */
public class ShipinAdapter extends RecyclerView.Adapter<ShipinAdapter.ViewHolder> {
    Context context; List<MovieDetailBean.ResultBean.ShortFilmListBean> shortFilmList;
    public ShipinAdapter(Context context, List<MovieDetailBean.ResultBean.ShortFilmListBean> shortFilmList) {
          this.context=context;
          this.shortFilmList=shortFilmList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.shipinfragment, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String imageUrl = shortFilmList.get(position).getImageUrl();
        String videoUrl = shortFilmList.get(position).getVideoUrl();

//        holder.videoplayer.setUp(videoUrl,
//                JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,"");
//     //   Glide.with(context).load(shortFilmList.get(position).getImageUrl()).into(holder.videoplayer)
//       holder.videoplayer.thumbImageView.setImageURI(Uri.parse(imageUrl));
        holder.videoplayer.TOOL_BAR_EXIST = false;
        holder.videoplayer.setUp(videoUrl
                , JZVideoPlayerStandard.SCROLL_AXIS_HORIZONTAL, "这里是视频标题");


//下边这个是视频的缩略图地址
        Glide.with(context).load(imageUrl)
                .into(holder.videoplayer.thumbImageView);
        holder.videoplayer.widthRatio = 4;//播放比例,可以设置为16:9,4:3
        holder.videoplayer.heightRatio = 3;

    }


    @Override
    public int getItemCount() {
        return shortFilmList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

          JZVideoPlayerStandard videoplayer;

        public ViewHolder(View itemView) {
            super(itemView);
            videoplayer = itemView.findViewById(R.id.videoplayer);
        }
    }
}
