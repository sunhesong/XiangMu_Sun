package com.example.java.androidfire.data.model;

import com.example.java.androidfire.data.bean.Girl_Bean;
import com.example.java.androidfire.data.bean.TouTiao_Bean;
import com.example.java.androidfire.data.bean.Video_Bean;

import java.util.List;

/**
 * Created by java on 2018/5/11.
 */

public interface Model {
    void showData(int i, String mParam1, String mParam2, CallBackListener callBackListener);
    interface CallBackListener{
        void requestData(List<TouTiao_Bean.T1348647909107Bean> t1348647909107);
        void ErrorMessage(String t1348647909107);
    }


    void showData_Video(String mParam1, CallBackListener_video callBackListener_video);
    interface CallBackListener_video{
        void requestData(Video_Bean t1348647909107);
    }


    void showData_Girl(int i, CallBackListener_Girl callBackListener_girl);
    interface CallBackListener_Girl{
        void requestData(List<Girl_Bean.ResultsBean> t1348647909107);
    }
}
