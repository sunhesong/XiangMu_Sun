package com.example.java.androidfire.data.model;

import com.example.java.androidfire.data.bean.TouTiao_Bean;

import java.util.List;

/**
 * Created by java on 2018/5/11.
 */

public interface Model {
    void showData(CallBackListener callBackListener);
    interface CallBackListener{
        void requestData(List<TouTiao_Bean.T1348647909107Bean> t1348647909107);
    }
}
