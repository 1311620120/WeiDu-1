package com.bw.movie.bean;

/**
 * @Author: zhang
 * @Date: 2019/5/17 19:34
 * @Description:
 */
public class CinemaInfoBean {


    /**
     * result : {"address":"朝阳区建国路93号万达广场三层","businessHoursContent":"星期一 至 星期日   早09:00:00 - 晚24:00:00","commentTotal":0,"distance":0,"followCinema":1,"id":6,"logo":"http://mobile.bwstudent.com/images/movie/logo/wd.jpg","name":"北京CBD万达广场店","phone":"010-59603399","vehicleRoute":"公交车1.57等路在郎家园下车；地铁1号线大望路下车，往西走500米。"}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean {
        /**
         * address : 朝阳区建国路93号万达广场三层
         * businessHoursContent : 星期一 至 星期日   早09:00:00 - 晚24:00:00
         * commentTotal : 0
         * distance : 0
         * followCinema : 1
         * id : 6
         * logo : http://mobile.bwstudent.com/images/movie/logo/wd.jpg
         * name : 北京CBD万达广场店
         * phone : 010-59603399
         * vehicleRoute : 公交车1.57等路在郎家园下车；地铁1号线大望路下车，往西走500米。
         */

        private String address;
        private String businessHoursContent;
        private int commentTotal;
        private int distance;
        private int followCinema;
        private int id;
        private String logo;
        private String name;
        private String phone;
        private String vehicleRoute;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getBusinessHoursContent() {
            return businessHoursContent;
        }

        public void setBusinessHoursContent(String businessHoursContent) {
            this.businessHoursContent = businessHoursContent;
        }

        public int getCommentTotal() {
            return commentTotal;
        }

        public void setCommentTotal(int commentTotal) {
            this.commentTotal = commentTotal;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getFollowCinema() {
            return followCinema;
        }

        public void setFollowCinema(int followCinema) {
            this.followCinema = followCinema;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getVehicleRoute() {
            return vehicleRoute;
        }

        public void setVehicleRoute(String vehicleRoute) {
            this.vehicleRoute = vehicleRoute;
        }
    }
}
