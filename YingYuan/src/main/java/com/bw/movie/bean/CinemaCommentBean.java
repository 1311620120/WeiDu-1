package com.bw.movie.bean;

import java.util.List;

/**
 * @Author: zhang
 * @Date: 2019/5/17 19:35
 * @Description:
 */
public class CinemaCommentBean {

    /**
     * result : [{"commentContent":"就到家就是","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2019-05-14/20190514194041.png","commentId":284,"commentTime":1557907173000,"commentUserId":1243,"commentUserName":"华仔","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"还是都觉得","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2019-04-25/20190425115134.png","commentId":258,"commentTime":1555751495000,"commentUserId":937,"commentUserName":"qwe","greatNum":2,"hotComment":0,"isGreat":0},{"commentContent":"啦啦啦","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2019-04-08/20190408151953.jpeg","commentId":233,"commentTime":1554600729000,"commentUserId":475,"commentUserName":"金木","greatNum":5,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg","commentId":212,"commentTime":1554255606000,"commentUserId":583,"commentUserName":"潘文凯","greatNum":9,"hotComment":0,"isGreat":0},{"commentContent":"111","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2019-03-23/20190323110045.png","commentId":205,"commentTime":1554125792000,"commentUserId":662,"commentUserName":"寂      然","greatNum":4,"hotComment":0,"isGreat":0},{"commentContent":"可笑","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2019-03-23/20190323110045.png","commentId":196,"commentTime":1554101222000,"commentUserId":662,"commentUserName":"寂      然","greatNum":3,"hotComment":0,"isGreat":0},{"commentContent":"啦啦啦","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2019-03-23/20190323110045.png","commentId":195,"commentTime":1554101119000,"commentUserId":662,"commentUserName":"寂      然","greatNum":2,"hotComment":0,"isGreat":0},{"commentContent":"哇咔咔","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2019-04-08/20190408151953.jpeg","commentId":188,"commentTime":1553849540000,"commentUserId":475,"commentUserName":"金木","greatNum":5,"hotComment":0,"isGreat":0},{"commentContent":"哇咔咔","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2019-04-08/20190408151953.jpeg","commentId":186,"commentTime":1553849539000,"commentUserId":475,"commentUserName":"金木","greatNum":2,"hotComment":0,"isGreat":0},{"commentContent":"哇咔咔","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2019-04-08/20190408151953.jpeg","commentId":187,"commentTime":1553849539000,"commentUserId":475,"commentUserName":"金木","greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"哇咔咔","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2019-04-08/20190408151953.jpeg","commentId":183,"commentTime":1553849538000,"commentUserId":475,"commentUserName":"金木","greatNum":2,"hotComment":0,"isGreat":0},{"commentContent":"哇咔咔","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2019-04-08/20190408151953.jpeg","commentId":184,"commentTime":1553849538000,"commentUserId":475,"commentUserName":"金木","greatNum":2,"hotComment":0,"isGreat":0},{"commentContent":"哇咔咔","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2019-04-08/20190408151953.jpeg","commentId":185,"commentTime":1553849538000,"commentUserId":475,"commentUserName":"金木","greatNum":3,"hotComment":0,"isGreat":0},{"commentContent":"哇咔咔","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2019-04-08/20190408151953.jpeg","commentId":182,"commentTime":1553849537000,"commentUserId":475,"commentUserName":"金木","greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"哇咔咔","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2019-04-08/20190408151953.jpeg","commentId":181,"commentTime":1553849535000,"commentUserId":475,"commentUserName":"金木","greatNum":0,"hotComment":0,"isGreat":0}]
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
         * commentContent : 就到家就是
         * commentHeadPic : http://mobile.bwstudent.com/images/movie/head_pic/2019-05-14/20190514194041.png
         * commentId : 284
         * commentTime : 1557907173000
         * commentUserId : 1243
         * commentUserName : 华仔
         * greatNum : 0
         * hotComment : 0
         * isGreat : 0
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
    }
}
