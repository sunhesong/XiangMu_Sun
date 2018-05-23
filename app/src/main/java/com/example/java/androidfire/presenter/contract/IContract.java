package com.example.java.androidfire.presenter.contract;

import com.example.java.androidfire.base.BasePresenter;
import com.example.java.androidfire.base.BaseView;
import com.example.java.androidfire.data.bean.Girl_Bean;
import com.example.java.androidfire.data.bean.TouTiao_Bean;
import com.example.java.androidfire.data.bean.Video_Bean;

import java.util.List;

/**
 * Created by java on 2018/5/11.
 */

public interface IContract {
    interface IPresenter extends BasePresenter {
        void Data(String mParam1, String mParam2, int i);
    }

    interface IView<IPresenter> extends BaseView<IPresenter> {
        void showData(List<TouTiao_Bean.T1348647909107Bean> t1348647909107);
        void Loading();
        void Error(String message);
    }

    interface IPresenter_Video extends BasePresenter {
        void Video_Data(String mParam1);
    }

    interface IView_Video<IPresenter_Video> extends BaseView<IPresenter_Video> {
        void showData_Video(Video_Bean t1348647909107);
    }

    interface IPresenter_Girl extends BasePresenter {
        void Girl_Data(int i);
    }

    interface IView_Video_Girl<IPresenter_Girl> extends BaseView<IPresenter_Girl> {
        void showData_Girl(List<Girl_Bean.ResultsBean> t1348647909107);
    }
}
