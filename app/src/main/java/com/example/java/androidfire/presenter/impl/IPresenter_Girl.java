package com.example.java.androidfire.presenter.impl;

import com.example.java.androidfire.data.bean.Girl_Bean;
import com.example.java.androidfire.data.model.Model;
import com.example.java.androidfire.data.model.impl.ModelImpl;
import com.example.java.androidfire.presenter.contract.IContract;

import java.util.List;

public class IPresenter_Girl implements IContract.IPresenter_Girl{
    IContract.IView_Video_Girl iView_video_girl;
    private  ModelImpl model;


    public IPresenter_Girl(IContract.IView_Video_Girl iView_video_girl) {
        this.iView_video_girl = iView_video_girl;
        iView_video_girl.setPresenter(this);
        model = new ModelImpl();
    }


    @Override
    public void Girl_Data(int i) {
        model.showData_Girl(i,new Model.CallBackListener_Girl() {
            @Override
            public void requestData(List<Girl_Bean.ResultsBean> t1348647909107) {
                iView_video_girl.showData_Girl(t1348647909107);
            }
        });
    }
}
