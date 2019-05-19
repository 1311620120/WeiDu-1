package com.bw.movie.bean;

import android.net.Uri;

import java.util.List;

/**
 * @Author: zhang
 * @Date: 2019/5/13 16:24
 * @Description:
 */
public class MovieDetailBean {

    /**
     * result : {"director":"贾樟柯","duration":"136分钟","followMovie":1,"id":19,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/jhen/jhen1.jpg","movieTypes":"爱情 / 犯罪","name":"江湖儿女","placeOrigin":"中国大陆","posterList":["http://mobile.bwstudent.com/images/movie/stills/jhen/jhen1.jpg","http://mobile.bwstudent.com/images/movie/stills/jhen/jhen2.jpg","http://mobile.bwstudent.com/images/movie/stills/jhen/jhen3.jpg","http://mobile.bwstudent.com/images/movie/stills/jhen/jhen4.jpg","http://mobile.bwstudent.com/images/movie/stills/jhen/jhen5.jpg","http://mobile.bwstudent.com/images/movie/stills/jhen/jhen6.jpg"],"rank":0,"shortFilmList":[{"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/jhen/jhen3.jpg","videoUrl":"http://mobile.bwstudent.com/video/movie/jhen/jhen1.mp4"},{"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/jhen/jhen2.jpg","videoUrl":"http://mobile.bwstudent.com/video/movie/jhen/jhen2.mp4"},{"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/jhen/jhen4.jpg","videoUrl":"http://mobile.bwstudent.com/video/movie/jhen/jhen3.mp4"}],"starring":"赵涛,廖凡,徐峥,梁嘉艳","summary":"故事起始于2001年的山西大同，模特巧巧（赵涛 饰）与出租车公司老板斌哥（廖凡 饰）是一对恋人，斌哥每天在外面呼朋唤友，巧巧却希望两人能够尽快步入婚姻的殿堂。然而一次斌哥在街头遭到竞争对手的袭击，巧巧为了保护斌哥在街头开枪，被判刑五年。巧巧出狱以后，开始寻找斌哥以便重新开始，然而事情却发生了意想不到的变化。"}
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
         * director : 贾樟柯
         * duration : 136分钟
         * followMovie : 1
         * id : 19
         * imageUrl : http://mobile.bwstudent.com/images/movie/stills/jhen/jhen1.jpg
         * movieTypes : 爱情 / 犯罪
         * name : 江湖儿女
         * placeOrigin : 中国大陆
         * posterList : ["http://mobile.bwstudent.com/images/movie/stills/jhen/jhen1.jpg","http://mobile.bwstudent.com/images/movie/stills/jhen/jhen2.jpg","http://mobile.bwstudent.com/images/movie/stills/jhen/jhen3.jpg","http://mobile.bwstudent.com/images/movie/stills/jhen/jhen4.jpg","http://mobile.bwstudent.com/images/movie/stills/jhen/jhen5.jpg","http://mobile.bwstudent.com/images/movie/stills/jhen/jhen6.jpg"]
         * rank : 0
         * shortFilmList : [{"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/jhen/jhen3.jpg","videoUrl":"http://mobile.bwstudent.com/video/movie/jhen/jhen1.mp4"},{"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/jhen/jhen2.jpg","videoUrl":"http://mobile.bwstudent.com/video/movie/jhen/jhen2.mp4"},{"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/jhen/jhen4.jpg","videoUrl":"http://mobile.bwstudent.com/video/movie/jhen/jhen3.mp4"}]
         * starring : 赵涛,廖凡,徐峥,梁嘉艳
         * summary : 故事起始于2001年的山西大同，模特巧巧（赵涛 饰）与出租车公司老板斌哥（廖凡 饰）是一对恋人，斌哥每天在外面呼朋唤友，巧巧却希望两人能够尽快步入婚姻的殿堂。然而一次斌哥在街头遭到竞争对手的袭击，巧巧为了保护斌哥在街头开枪，被判刑五年。巧巧出狱以后，开始寻找斌哥以便重新开始，然而事情却发生了意想不到的变化。
         */

        private String director;
        private String duration;
        private int followMovie;
        private int id;
        private String imageUrl;
        private String movieTypes;
        private String name;
        private String placeOrigin;
        private int rank;
        private String starring;
        private String summary;
        private List<String> posterList;
        private List<ShortFilmListBean> shortFilmList;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "director='" + director + '\'' +
                    ", duration='" + duration + '\'' +
                    ", followMovie=" + followMovie +
                    ", id=" + id +
                    ", imageUrl='" + imageUrl + '\'' +
                    ", movieTypes='" + movieTypes + '\'' +
                    ", name='" + name + '\'' +
                    ", placeOrigin='" + placeOrigin + '\'' +
                    ", rank=" + rank +
                    ", starring='" + starring + '\'' +
                    ", summary='" + summary + '\'' +
                    ", posterList=" + posterList +
                    ", shortFilmList=" + shortFilmList +
                    '}';
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public int getFollowMovie() {
            return followMovie;
        }

        public void setFollowMovie(int followMovie) {
            this.followMovie = followMovie;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getMovieTypes() {
            return movieTypes;
        }

        public void setMovieTypes(String movieTypes) {
            this.movieTypes = movieTypes;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPlaceOrigin() {
            return placeOrigin;
        }

        public void setPlaceOrigin(String placeOrigin) {
            this.placeOrigin = placeOrigin;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getStarring() {
            return starring;
        }

        public void setStarring(String starring) {
            this.starring = starring;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public List<String> getPosterList() {
            return posterList;
        }

        public void setPosterList(List<String> posterList) {
            this.posterList = posterList;
        }

        public List<ShortFilmListBean> getShortFilmList() {
            return shortFilmList;
        }

        public void setShortFilmList(List<ShortFilmListBean> shortFilmList) {
            this.shortFilmList = shortFilmList;
        }

        public static class ShortFilmListBean {
            /**
             * imageUrl : http://mobile.bwstudent.com/images/movie/stills/jhen/jhen3.jpg
             * videoUrl : http://mobile.bwstudent.com/video/movie/jhen/jhen1.mp4
             */

            private String imageUrl;
            private String videoUrl;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getVideoUrl() {
                return videoUrl;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
            }
        }
    }
}
