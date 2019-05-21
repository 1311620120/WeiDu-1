package com.bw.movie.bean;

/**
 * @Author: zhang
 * @Date: 2019/5/21 11:27
 * @Description:
 */
public class WXPayBean {


















    /**
     * appId : wxb3852e6a6b7d9516
     * message : 支付成功
     * nonceStr : 63FFWiTsixjkVU0X
     * packageValue : Sign=WXPay
     * partnerId : 1510865081
     * prepayId : wx21112710525611d9a2227e220701951955
     * sign : F36BBF27533303E67F90C55BEC5671A4
     * status : 0000
     * timeStamp : 1558409230
     */

    private String appId;
    private String message;
    private String nonceStr;
    private String packageValue;
    private String partnerId;
    private String prepayId;
    private String sign;
    private String status;
    private String timeStamp;
    /**
     * result : alipay_sdk=alipay-sdk-java-3.1.0&app_id=2018080760951276&biz_content=%7B%22out_trade_no%22%3A%2220190521201345927%22%2C%22subject%22%3A%22%E5%85%AB%E7%BB%B4%E7%A7%BB%E5%8A%A8%E9%80%9A%E4%BF%A1%E5%AD%A6%E9%99%A2-%E7%BB%B4%E5%BA%A6%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%220.01%22%7D&charset=utf-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fmobile.bwstudent.com%2FpayApiProd%2FaliPay%2FmovieNotification&sign=GmtDQmzWHA%2FVDMZi0dkLOfGGKDRKrPJ0axJWjcEhh1K%2BwPNZZkYiBSYZdXNFHV%2F54zNza0ry4XaASdvOZHLiHf7pBMwpvwB8G8LBo9fXkpFT1mGZWm%2BOV6yyl4wVlfPQITIp9AaW4g1rZ%2BA3YXBTkZ1fXQtFc5hjmw3CSnDc4A%2FfktrtrvotbqiD76lF%2BHIxhFTtFOBso162%2BmPgASknHx7fBQhQ13ijd3Pp5gDfkyVpJoHDf3gY6%2FQJKUlwvXMEvqFUNImtqdwTfCBAQZ9uik4%2B7mi7G9A4aWv%2BaODwFltA866%2BEfFXnEDotjYGJYibeDdrcwQBi2LdsWnN7hHU%2Fw%3D%3D&sign_type=RSA2&timestamp=2019-05-21+20%3A13%3A48&version=1.0
     */

    private String result;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(String packageValue) {
        this.packageValue = packageValue;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
