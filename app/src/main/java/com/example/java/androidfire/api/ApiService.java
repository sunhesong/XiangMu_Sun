package com.example.java.androidfire.api;

import com.example.java.androidfire.data.bean.TouTiao_Bean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by java on 2018/5/11.
 */

public interface ApiService {
    @GET("nc/article/headline/T1348647909107/0-20.html")
    Observable<TouTiao_Bean> getData();
}
