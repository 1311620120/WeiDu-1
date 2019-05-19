package com.bw.movie.bean;

import java.util.List;

/**
 * @Auther: 白俊岭
 * @Date: 2019/5/13 15:32:01
 * @Description:
 */
public class My_ShopBean {
    /**
     * result : [{"amount":3,"beginTime":40800000,"cinemaName":"青春光线电影院","createTime":1533805513000,"endTime":47880000,"id":52,"movieName":"西虹市首富","orderId":"20180809170513183","price":66.5,"screeningHall":"2号厅","status":1,"userId":5},{"amount":3,"beginTime":40800000,"cinemaName":"青春光线电影院","createTime":1533805499000,"endTime":47880000,"id":51,"movieName":"西虹市首富","orderId":"20180809170459908","price":66.5,"screeningHall":"2号厅","status":1,"userId":5}]
     * message : 请求成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * amount : 3
         * beginTime : 40800000
         * cinemaName : 青春光线电影院
         * createTime : 1533805513000
         * endTime : 47880000
         * id : 52
         * movieName : 西虹市首富
         * orderId : 20180809170513183
         * price : 66.5
         * screeningHall : 2号厅
         * status : 1
         * userId : 5
         */

        private String amount;
        private String beginTime;
        private String cinemaName;
        private String createTime;
        private String endTime;
        private String id;
        private String movieName;
        private String orderId;
        private String price;
        private String screeningHall;
        private int status;
        private String userId;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getCinemaName() {
            return cinemaName;
        }

        public void setCinemaName(String cinemaName) {
            this.cinemaName = cinemaName;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getScreeningHall() {
            return screeningHall;
        }

        public void setScreeningHall(String screeningHall) {
            this.screeningHall = screeningHall;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
