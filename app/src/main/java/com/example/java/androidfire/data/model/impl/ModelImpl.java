package com.example.java.androidfire.data.model.impl;

import android.os.Environment;
import android.util.Log;

import com.example.java.androidfire.api.ApiService;
import com.example.java.androidfire.data.bean.Girl_Bean;
import com.example.java.androidfire.data.bean.TouTiao_Bean;
import com.example.java.androidfire.data.bean.Video_Bean;
import com.example.java.androidfire.data.model.Model;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by java on 2018/5/11.
 */

public class ModelImpl implements Model {

    @Override
    public void showData(int i, String mParam1, String mParam2, final CallBackListener callBackListener) {
        long max = 20 * 1024 * 1024;
        String path = Environment.getExternalStorageDirectory().getAbsoluteFile() + "/myooooooooooooCache/";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
        Cache cache = new Cache(file, max);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().cache(cache).addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request request = chain.request();//获取请求体
                Response proceed = chain.proceed(request);//重新发起请求，获取Response
                //移除Response响应体中的关于缓存的头信息，并重新设置缓存机制
                Response.Builder pragma = proceed.newBuilder().removeHeader("Pragma").removeHeader("Cache-Control").addHeader("Cache-Control", "max-age=" + 1000 * 20);
                return pragma.build();

            }
        }).build();


        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://c.m.163.com/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();
        retrofit.create(ApiService.class).getData(mParam1, mParam2,i+"")
                .subscribeOn(Schedulers.newThread())
                .delay(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {

                    }
                }).subscribe(new Observer<TouTiao_Bean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("Error信息：：：：：", "onError: " + e);
                callBackListener.ErrorMessage(e.getMessage());
            }

            @Override
            public void onNext(TouTiao_Bean touTiao_bean) {
                List<TouTiao_Bean.T1348647909107Bean> t1348647909107 = touTiao_bean.getT1348647909107();
                callBackListener.requestData(t1348647909107);
            }
        });
        ;

//        data.observeOn(Schedulers.io())
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<TouTiao_Bean>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("=====", e.toString());
//                    }
//
//                    @Override
//                    public void onNext(TouTiao_Bean touTiao_bean) {
//                        Log.e("-----", touTiao_bean.toString());
////                        callBackListener.requestData(touTiao_bean);
//                    }
//                });

    }

    @Override
    public void showData_Video(String mParam1, final CallBackListener_video callBackListener_video) {
//        new OkHttpClient.Builder().build().newCall(new Request.Builder().url("http://192.168.43.120/shipin.txt").build())
//            .enqueue(new Callback() {
//        @Override
//        public void onFailure(Call call, IOException e) {
//            Log.e("-----", e.getMessage());
//        }
//
//        @Override
//        public void onResponse(Call call, Response response) throws IOException {
//            String string = response.body().string();
//            callBackListener_video.requestData(string);
//        }
//    });
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://c.m.163.com/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Observable<Video_Bean> data_video = apiService.getData_Video(mParam1);
        data_video.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .retry(1000)
                .subscribe(new Observer<Video_Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Video_Bean video_bean) {
callBackListener_video.requestData(video_bean);
                    }
                });
    }

    @Override
    public void showData_Girl(int i, final CallBackListener_Girl callBackListener_girl) {
//        new OkHttpClient.Builder().build()
//                .newCall(new Request.Builder().url("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/1").build())
//                .enqueue(new Callback() {
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//                        Log.e("-----", e.getMessage());
//                    }
//
//                    @Override
//                    public void onResponse(Call call, Response response) throws IOException {
//                        callBackListener_girl.requestData(response.body().string());
//                    }
//                });
        Retrofit build = new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .baseUrl("http://gank.io/")
                .build();

        ApiService apiService = build.create(ApiService.class);
        Observable<Girl_Bean> data_girl = apiService.getData_Girl(i);
        data_girl.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Girl_Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("----",e.getMessage());
                    }

                    @Override
                    public void onNext(Girl_Bean girl_bean) {
                        List<Girl_Bean.ResultsBean> results = girl_bean.getResults();
                        callBackListener_girl.requestData(results);
                    }
                });
    }
}
