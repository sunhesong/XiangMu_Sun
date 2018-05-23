package com.example.java.androidfire.presenter.impl;

import com.example.java.androidfire.data.bean.TouTiao_Bean;
import com.example.java.androidfire.data.model.Model;
import com.example.java.androidfire.data.model.impl.ModelImpl;
import com.example.java.androidfire.presenter.contract.IContract;

import java.util.List;

/**
 * Created by java on 2018/5/11.
 */

public class IPresenter implements IContract.IPresenter {
    IContract.IView iView;
    private  ModelImpl model;

    public IPresenter(IContract.IView iView) {
        this.iView = iView;
        iView.setPresenter(this);
        model = new ModelImpl();
    }

    @Override
    public void Data(String mParam1, String mParam2, int i) {
        iView.Loading();
        model.showData(i,mParam1,mParam2,new Model.CallBackListener() {

            @Override
            public void requestData(List<TouTiao_Bean.T1348647909107Bean> t1348647909107) {
                iView.showData(t1348647909107);
            }

            @Override
            public void ErrorMessage(String t1348647909107) {
                iView.Error(t1348647909107);
            }
        });
    }
}
