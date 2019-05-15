package com.bw.movie.presenter;

import com.bw.movie.bai.BasePresenter;
import com.bw.movie.bai.IMainView;
import com.bw.movie.util.RetrofitUtil;

import org.json.JSONObject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * @Auther: 白俊岭
 * @Date: 2019/5/15 19:41:12
 * @Description:
 */
public class MinssPresenter extends BasePresenter<IMainView> {

    private final RetrofitUtil instance;

    public  MinssPresenter(){
        instance = RetrofitUtil.getInstance();
     }
     public void MinrssData(String userId ,String sessionId,String content){
         Observable<ResponseBody> minessss = instance.api.minessss(userId, sessionId, content);
         minessss.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Consumer<ResponseBody>() {
                     @Override
                     public void accept(ResponseBody responseBody) throws Exception {
                         JSONObject object = new JSONObject(responseBody.string());
                         String str = object.getString("message");
                       getView().onCheng(str);

                     }
                 });
     }
}
