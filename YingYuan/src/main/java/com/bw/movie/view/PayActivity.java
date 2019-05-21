package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.bean.WXPayBean;
import com.bw.movie.custom.MoveSeatView;
import com.bw.movie.inter.MyInterface;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.util.EncryptUtil;
import com.bw.movie.wxapi.WXPayEntryActivity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PayActivity extends BaseActivity implements MyInterface.ViewInter.TicketInter,MyInterface.ViewInter.WXPayInter {

    MyInterface.PresenterInter presenterInter;
    @BindView(R.id.pay_moveView_id)
    MoveSeatView payMoveViewId;
    @BindView(R.id.pay_yes_id)
    ImageView payYesId;
    @BindView(R.id.pay_close_id)
    ImageView payCloseId;
    int i = 0;
    @BindView(R.id.pay_ting_id)
    TextView payTingId;
    @BindView(R.id.pay_begin_id)
    TextView payBeginId;
    @BindView(R.id.pay_end_id)
    TextView payEndId;
    @BindView(R.id.pay_price_id)
    TextView payPriceId;
    private int scheduleId;
    private SharedPreferences sp;
    private PopupWindow pw;
    private double price;
    private RadioButton weixin;
    private RadioButton zhifubao;
    private TextView textView;
    private String[] split;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        ButterKnife.bind(this);
        presenterInter = new MyPresenter<>(this);
        Intent it = getIntent();
        sp = getSharedPreferences("myId", MODE_PRIVATE);
        scheduleId = it.getIntExtra("scheduleId", 0);
        int seatsTotal = it.getIntExtra("seatsTotal", 0);
        String screeningHall = it.getStringExtra("screeningHall");
        String endTime = it.getStringExtra("endTime");
        String beginTime = it.getStringExtra("beginTime");
        price = it.getDoubleExtra("price", 0);
        payTingId.setText(screeningHall);
        payBeginId.setText(beginTime);
        payEndId.setText(endTime);
        payMoveViewId.setMaxSelected(4);
        payMoveViewId.setSeatChecker(new MoveSeatView.SeatChecker() {

            @Override
            public boolean isValidSeat(int row, int column) {
                if (column == 2) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean isSold(int row, int column) {
                if (row == 6 && column == 6) {
                    return true;
                }
                return false;
            }

            @Override
            public void checked(int row, int column) {
                i++;
                double j = price * i;
                BigDecimal decimal = new BigDecimal(j);
                BigDecimal scale = decimal.setScale(2, BigDecimal.ROUND_HALF_UP);
                payPriceId.setText(scale + "");
            }

            @Override
            public void unCheck(int row, int column) {
                i--;
                double j = price * i;
                BigDecimal decimal = new BigDecimal(j);
                BigDecimal scale = decimal.setScale(2, BigDecimal.ROUND_HALF_UP);
                payPriceId.setText(scale + "");
            }

            @Override
            public String[] checkedSeatTxt(int row, int column) {
                return null;
            }

        });
        int j = seatsTotal/10;
        payMoveViewId.setData(j, 10);
        View v = LayoutInflater.from(this).inflate(R.layout.popup_pay_item, null);
        final ImageView imageView;
        textView = v.findViewById(R.id.popup_pay_text_id);
        imageView = v.findViewById(R.id.popup_pay_back_id);
        weixin = v.findViewById(R.id.rb1_weixin_id);
        zhifubao = v.findViewById(R.id.rb2_zhifubao_id);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int payType = 0;
                if (weixin.isChecked()){
                    payType = 1;
                }else if (zhifubao.isChecked()){
                    payType = 2;
                }
                if (payType != 0){
                    presenterInter.toWXPay(payType,split[1]);
                }
            }
        });
        pw = new PopupWindow(v, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        pw.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        pw.setOutsideTouchable(true);
        pw.setFocusable(true);
        weixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (weixin.isChecked()) {
                    double j = price * i;
                    BigDecimal decimal = new BigDecimal(j);
                    BigDecimal scale = decimal.setScale(2, BigDecimal.ROUND_HALF_UP);
                    textView.setText("微信支付" + scale + "元");
                }
            }
        });
        zhifubao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (zhifubao.isChecked()) {
                    double j = price * i;
                    BigDecimal decimal = new BigDecimal(j);
                    BigDecimal scale = decimal.setScale(2, BigDecimal.ROUND_HALF_UP);
                    textView.setText("支付宝支付" + scale + "元");
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pw.dismiss();
            }
        });
    }

    @Override
    public void Ticket(String str) {
        split = str.split(",");
        Toast.makeText(this, split[0], Toast.LENGTH_SHORT).show();
        if (split[0].equals("下单成功")) {
            pw.showAtLocation(View.inflate(PayActivity.this, R.layout.activity_pay, null), Gravity.BOTTOM, 10, 10);
            if (weixin.isChecked()) {
                double j = price * i;
                BigDecimal decimal = new BigDecimal(j);
                BigDecimal scale = decimal.setScale(2, BigDecimal.ROUND_HALF_UP);
                textView.setText("微信支付" + scale + "元");
            }
            if (zhifubao.isChecked()) {
                double j = price * i;
                BigDecimal decimal = new BigDecimal(j);
                BigDecimal scale = decimal.setScale(2, BigDecimal.ROUND_HALF_UP);
                textView.setText("支付宝支付" + scale + "元");
            }
        }
    }

    @OnClick({R.id.pay_yes_id, R.id.pay_close_id})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pay_yes_id:
                Map<String, String> map = new HashMap<>();
                map.put("scheduleId", scheduleId + "");
                map.put("amount", i + "");
                String userId = sp.getString("userId", "");
                String str = userId + scheduleId + i + "movie";
                String crypt = EncryptUtil.crypt(str);
                map.put("sign", crypt);
                presenterInter.toTicket(map);
                break;
            case R.id.pay_close_id:
                finish();
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

    @Override
    public void WXPay(Object o) {
        WXPayBean bean = (WXPayBean) o;
        if (bean.getMessage().equals("支付成功")){
            Intent intent = new Intent(this, WXPayEntryActivity.class);
            intent.putExtra("appId",bean.getAppId());
            intent.putExtra("partnerId",bean.getPartnerId());
            intent.putExtra("prepayId",bean.getPrepayId());
            intent.putExtra("nonceStr",bean.getNonceStr());
            intent.putExtra("timeStamp",bean.getTimeStamp());
            intent.putExtra("packageValue",bean.getPackageValue());
            intent.putExtra("sign",bean.getSign());
            startActivity(intent);
        }else if (bean.getMessage().equals("ok")){

        }
    }
}
