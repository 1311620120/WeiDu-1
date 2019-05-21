package com.bw.movie.util;

/**
 * @Author: zhang
 * @Date: 2019/5/20 11:26
 * @Description:
 */
public class OnClickUtil {
    public static class onClick{
        private static final int MIN_CLICK_DELAY_TIME = 1000;
        private static long lastClickTime;
        public static boolean isFastClick() {
            boolean flag = false;
            long curClickTime = System.currentTimeMillis();
            if ((curClickTime - lastClickTime) >= MIN_CLICK_DELAY_TIME) {
                flag = true;
            }
            lastClickTime = curClickTime; return flag;
        }
    }
}
