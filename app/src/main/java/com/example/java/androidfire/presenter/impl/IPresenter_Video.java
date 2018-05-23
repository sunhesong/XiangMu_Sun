package com.example.java.androidfire.presenter.impl;

import com.example.java.androidfire.data.bean.Video_Bean;
import com.example.java.androidfire.data.model.Model;
import com.example.java.androidfire.data.model.impl.ModelImpl;
import com.example.java.androidfire.presenter.contract.IContract;

/**
 * Created by java on 2018/5/14.
 */

public class IPresenter_Video implements IContract.IPresenter_Video {
    IContract.IView_Video iView_video;
    private  ModelImpl model;

    public IPresenter_Video(IContract.IView_Video iView_video) {
        this.iView_video = iView_video;
        iView_video.setPresenter(this);
        model = new ModelImpl();
    }

    @Override
    public void Video_Data(String mParam1) {
        model.showData_Video(mParam1,new Model.CallBackListener_video() {
            @Override
            public void requestData(Video_Bean t1348647909107) {
                iView_video.showData_Video(t1348647909107);
            }
        });
    }
}
