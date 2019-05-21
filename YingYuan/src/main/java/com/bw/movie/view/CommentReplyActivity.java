package com.bw.movie.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.adapter.MyReplayAdapter;
import com.bw.movie.bean.ReplyBean;
import com.bw.movie.inter.MyInterface;
import com.bw.movie.presenter.MyPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommentReplyActivity extends BaseActivity implements MyInterface.ViewInter.CommentReplyInter {

    MyInterface.PresenterInter presenterInter;
    @BindView(R.id.comment_replay_recycler_id)
    RecyclerView commentReplayRecyclerId;
    @BindView(R.id.edit_replay_comment_id)
    EditText editReplayCommentId;
    @BindView(R.id.edit_replay_over_id)
    TextView editReplayOverId;
    @BindView(R.id.edit_cinecism_relative_id)
    RelativeLayout editCinecismRelativeId;
    @BindView(R.id.comment_replay_image_id)
    ImageView commentReplayImageId;
    private Map<String, String> map;
    List<ReplyBean.ResultBean> list = new ArrayList<>();
    MyReplayAdapter adapter;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_reply);
        ButterKnife.bind(this);
        presenterInter = new MyPresenter<>(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        commentReplayRecyclerId.setLayoutManager(layoutManager);
        adapter = new MyReplayAdapter(list, this);
        commentReplayRecyclerId.setAdapter(adapter);
        id = getIntent().getIntExtra("commentId", 0);
        if (id == 0) {
            Toast.makeText(this, "传值失败", Toast.LENGTH_SHORT).show();
        } else {
            map = new HashMap<>();
            map.put("commentId", id + "");
            map.put("page", "1");
            map.put("count", "10");
            presenterInter.toCommentReply(map);
        }
    }

    @Override
    public void CommentReply(Object object) {
        ReplyBean bean = (ReplyBean) object;
        Log.i("tag",bean.getMessage());
        if (bean.getMessage().equals("查询成功")){
            list.addAll(bean.getResult());
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void AddReply(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        if (str.equals("回复成功")) {
            list.clear();
            presenterInter.toCommentReply(map);
            editCinecismRelativeId.setVisibility(View.GONE);
        }
    }

    @OnClick({R.id.edit_replay_over_id, R.id.comment_replay_image_id})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.edit_replay_over_id:
                String string = editReplayCommentId.getText().toString();
                Map<String,String> map = new HashMap<>();
                map.put("replyContent",string);
                map.put("commentId",id+"");
                presenterInter.toAddReply(map);
                break;
            case R.id.comment_replay_image_id:
                editCinecismRelativeId.setVisibility(View.VISIBLE);
                break;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenterInter != null){
            presenterInter.onDestroy();
            presenterInter = null;
        }
    }
}
