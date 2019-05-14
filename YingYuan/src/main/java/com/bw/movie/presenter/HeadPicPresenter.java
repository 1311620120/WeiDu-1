package com.bw.movie.presenter;

import com.bw.movie.bai.BasePresenter;
import com.bw.movie.bai.IMainView;
import com.bw.movie.bean.My_HeadPicBean;
import com.bw.movie.util.RetrofitUtil;

import java.io.File;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @Auther: 白俊岭
 * @Date: 2019/5/13 14:24:41
 * @Description:
 */
public class HeadPicPresenter extends BasePresenter<IMainView> {

    private final RetrofitUtil instance;

    public HeadPicPresenter(){
        instance = RetrofitUtil.getInstance();
     }

     public void  HeadData(String userId ,String sessionId,File file){
         RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
         MultipartBody.Part filePart=MultipartBody.Part.createFormData("image",file.getName(),requestFile);

         Observable<My_HeadPicBean> my_headPicBeanObservable = instance.api.HeadPic(userId, sessionId, filePart);
         my_headPicBeanObservable.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Consumer<My_HeadPicBean>() {
                   @Override
                   public void accept(My_HeadPicBean my_headPicBean) throws Exception {
                       getView().onCheng(my_headPicBean);
                   }
               });
     }
}
