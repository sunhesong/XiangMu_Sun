package com.example.java.androidfire.data.model.impl;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.java.androidfire.api.ApiService;
import com.example.java.androidfire.data.bean.TouTiao_Bean;
import com.example.java.androidfire.data.model.Model;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by java on 2018/5/11.
 */

public class ModelImpl implements Model {

    @Override
    public void showData(final CallBackListener callBackListener) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://c.m.163.com/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<TouTiao_Bean> data = apiService.getData();
        data.subscribeOn(Schedulers.newThread())
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
                        Log.e("--------error----------",e.getMessage());
                    }

                    @Override
                    public void onNext(TouTiao_Bean touTiao_bean) {
                        List<TouTiao_Bean.T1348647909107Bean> t1348647909107 = touTiao_bean.getT1348647909107();
                        Log.e("-----", touTiao_bean.toString());
                        callBackListener.requestData(t1348647909107);
                    }
                });
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
}
