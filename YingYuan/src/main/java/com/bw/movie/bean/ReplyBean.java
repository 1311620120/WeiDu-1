package com.bw.movie.bean;

import java.util.List;

/**
 * @Author: zhang
 * @Date: 2019/5/15 11:28
 * @Description:
 */
public class ReplyBean {


    /**
     * result : [{"replyContent":"111","replyHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg","replyTime":1557840317000,"replyUserId":1300,"replyUserName":"张三三"}]
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
         * replyContent : 111
         * replyHeadPic : http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg
         * replyTime : 1557840317000
         * replyUserId : 1300
         * replyUserName : 张三三
         */

        private String replyContent;
        private String replyHeadPic;
        private long replyTime;
        private int replyUserId;
        private String replyUserName;

        public String getReplyContent() {
            return replyContent;
        }

        public void setReplyContent(String replyContent) {
            this.replyContent = replyContent;
        }

        public String getReplyHeadPic() {
            return replyHeadPic;
        }

        public void setReplyHeadPic(String replyHeadPic) {
            this.replyHeadPic = replyHeadPic;
        }

        public long getReplyTime() {
            return replyTime;
        }

        public void setReplyTime(long replyTime) {
            this.replyTime = replyTime;
        }

        public int getReplyUserId() {
            return replyUserId;
        }

        public void setReplyUserId(int replyUserId) {
            this.replyUserId = replyUserId;
        }

        public String getReplyUserName() {
            return replyUserName;
        }

        public void setReplyUserName(String replyUserName) {
            this.replyUserName = replyUserName;
        }
    }
}
