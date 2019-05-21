package com.bw.movie;

/**
 * @Auther: 白俊岭
 * @Date: 2019/5/12 19:26:48
 * @Description:
 */
public class BasePresenter<V> {
     private  V view;

    public void setView(V view) {
        this.view = view;
    }

    public V getView() {
        return view;
    }
    public  void  detacher(){
        this.view=null;
    }
}
