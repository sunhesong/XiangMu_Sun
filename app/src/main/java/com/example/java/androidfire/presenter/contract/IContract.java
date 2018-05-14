package com.example.java.androidfire.presenter.contract;

import com.example.java.androidfire.base.BasePresenter;
import com.example.java.androidfire.base.BaseView;
import com.example.java.androidfire.data.bean.TouTiao_Bean;

import java.util.List;

/**
 * Created by java on 2018/5/11.
 */

public interface IContract {
    interface IPresenter extends BasePresenter {
        void Data();
    }

    interface IView<IPresenter> extends BaseView<IPresenter> {
        void showData(List<TouTiao_Bean.T1348647909107Bean> t1348647909107);
    }


    interface IPresenter_Video extends BasePresenter {
        void Video_Data();
    }

    interface IView_Video<IPresenter_Video> extends BaseView<IPresenter_Video> {
        void showData_Video(String t1348647909107);
    }

}
