package com.example.java.androidfire.api;

import com.example.java.androidfire.data.bean.Girl_Bean;
import com.example.java.androidfire.data.bean.TouTiao_Bean;
import com.example.java.androidfire.data.bean.Video_Bean;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by java on 2018/5/11.
 */

public interface ApiService {
    @GET("nc/article/{type}/{id}/{page}-20.html")
    Observable<TouTiao_Bean> getData(@Path("type") String type, @Path("id") String id,@Path("page") String page);
    @GET("nc/video/list/{id}/n/0-10.html")
    Observable<Video_Bean> getData_Video(
           @Path("id") String id
    );
    @GET("api/data/%E7%A6%8F%E5%88%A9/20/{page}")
    Observable<Girl_Bean> getData_Girl(@Path("page") int page);
}
