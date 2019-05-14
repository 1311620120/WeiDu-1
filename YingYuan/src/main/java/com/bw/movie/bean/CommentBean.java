package com.bw.movie.bean;

import java.util.List;

/**
 * @Author: zhang
 * @Date: 2019/5/13 21:58
 * @Description:
 */
public class CommentBean {

    /**
     * result : [{"commentContent":"得得","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg","commentId":4681,"commentTime":1557739387000,"commentUserId":1247,"commentUserName":"爸爸爸爸","greatNum":0,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"啊啊啊","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg","commentId":4672,"commentTime":1557398138000,"commentUserId":928,"commentUserName":"18310080508","greatNum":2,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"啊","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg","commentId":4667,"commentTime":1557315475000,"commentUserId":928,"commentUserName":"18310080508","greatNum":3,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"。。","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg","commentId":4666,"commentTime":1557315391000,"commentUserId":928,"commentUserName":"18310080508","greatNum":2,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"，","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg","commentId":4661,"commentTime":1557303861000,"commentUserId":928,"commentUserName":"18310080508","greatNum":2,"hotComment":0,"isGreat":0,"replyNum":1},{"commentContent":"啦啦啦","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2019-04-29/20190429143229.png","commentId":4660,"commentTime":1557047206000,"commentUserId":1019,"commentUserName":"念想_2o6","greatNum":2,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2019-05-05/20190505144631.png","commentId":4658,"commentTime":1557038681000,"commentUserId":933,"commentUserName":"ai琛","greatNum":1,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"12","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2019-04-30/20190430163844.jpg","commentId":4657,"commentTime":1557016325000,"commentUserId":923,"commentUserName":"1906126","greatNum":2,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"喉咙","commentHeadPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/swQ3jakZowbnRwoHkDhA6CCsgDsYIfibQ0aYz3bDzgoXoFUAz77HP9jwyqcG64SDA2jr8dJtH9XIGz6rV5Y3ujA/132","commentId":4656,"commentTime":1556976781000,"commentUserId":977,"commentUserName":"我_TmB","greatNum":3,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2019-05-10/20190510160906.png","commentId":4653,"commentTime":1556969830000,"commentUserId":944,"commentUserName":"李云龙","greatNum":4,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"我朱砂是个long人","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2019-04-30/20190430163844.jpg","commentId":4647,"commentTime":1556613496000,"commentUserId":923,"commentUserName":"1906126","greatNum":5,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg","commentId":4643,"commentTime":1556607899000,"commentUserId":1146,"commentUserName":"高盈","greatNum":2,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"我是9B班的小可爱","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg","commentId":4641,"commentTime":1556542368000,"commentUserId":1146,"commentUserName":"高盈","greatNum":2,"hotComment":0,"isGreat":0,"replyNum":1},{"commentContent":"","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg","commentId":4640,"commentTime":1556542350000,"commentUserId":1146,"commentUserName":"高盈","greatNum":1,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"rrttt","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2019-04-30/20190430171312.png","commentId":4639,"commentTime":1556535909000,"commentUserId":1021,"commentUserName":"梁公子","greatNum":2,"hotComment":0,"isGreat":0,"replyNum":0}]
     * message : 查询成功
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
         * commentContent : 得得
         * commentHeadPic : http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg
         * commentId : 4681
         * commentTime : 1557739387000
         * commentUserId : 1247
         * commentUserName : 爸爸爸爸
         * greatNum : 0
         * hotComment : 0
         * isGreat : 0
         * replyNum : 0
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int hotComment;
        private int isGreat;
        private int replyNum;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentHeadPic() {
            return commentHeadPic;
        }

        public void setCommentHeadPic(String commentHeadPic) {
            this.commentHeadPic = commentHeadPic;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getCommentUserName() {
            return commentUserName;
        }

        public void setCommentUserName(String commentUserName) {
            this.commentUserName = commentUserName;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public int getHotComment() {
            return hotComment;
        }

        public void setHotComment(int hotComment) {
            this.hotComment = hotComment;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }

        public int getReplyNum() {
            return replyNum;
        }

        public void setReplyNum(int replyNum) {
            this.replyNum = replyNum;
        }
    }
}
