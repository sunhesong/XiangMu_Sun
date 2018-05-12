package com.example.java.androidfire.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.example.java.androidfire.R;
import com.example.java.androidfire.ui.fragment.Care_Fragment;
import com.example.java.androidfire.ui.fragment.Girl_Fragment;
import com.example.java.androidfire.ui.fragment.Home_Fragment;
import com.example.java.androidfire.ui.fragment.Video_Fragment;
import com.flyco.tablayout.CommonTabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZhuActivity extends AppCompatActivity {


    private Care_Fragment care_fragment = null;
    private Girl_Fragment girl_fragment = null;
    private Home_Fragment home_fragment = null;
    private Video_Fragment video_fragment = null;
    @BindView(R.id.Shouye)
    RadioButton Shouye;
    @BindView(R.id.meinv)
    RadioButton meinv;
    @BindView(R.id.shipin)
    RadioButton shipin;
    @BindView(R.id.guanzhu)
    RadioButton guanzhu;
    private FragmentManager supportFragmentManager;
    public static CommonTabLayout tab_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        ButterKnife.bind(this);
        initView();
//        //透明状态栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        //透明导航栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        if (home_fragment == null) {
            home_fragment = new Home_Fragment();
            fragmentTransaction.add(R.id.fl, home_fragment);
        } else {
            fragmentTransaction.show(home_fragment);
        }
        fragmentTransaction.commit();
        Shouye.setChecked(true);


    }

    private void initView() {
        supportFragmentManager = getSupportFragmentManager();
        tab_layout = (CommonTabLayout) findViewById(R.id.tab_layout);
    }

    @OnClick({R.id.Shouye, R.id.meinv, R.id.shipin, R.id.guanzhu})
    public void onViewClicked(View view) {
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        if (care_fragment != null) {
            fragmentTransaction.hide(care_fragment);
        }
        if (girl_fragment != null) {
            fragmentTransaction.hide(girl_fragment);
        }
        if (home_fragment != null) {
            fragmentTransaction.hide(home_fragment);
        }
        if (video_fragment != null) {
            fragmentTransaction.hide(video_fragment);
        }
        switch (view.getId()) {
            case R.id.Shouye:
                if (home_fragment == null) {
                    home_fragment = new Home_Fragment();
                    fragmentTransaction.add(R.id.fl, home_fragment);
                } else {
                    fragmentTransaction.show(home_fragment);
                }
                break;
            case R.id.meinv:
                if (girl_fragment == null) {
                    girl_fragment = new Girl_Fragment();
                    fragmentTransaction.add(R.id.fl, girl_fragment);
                } else {
                    fragmentTransaction.show(girl_fragment);
                }
                break;
            case R.id.shipin:
                if (video_fragment == null) {
                    video_fragment = new Video_Fragment();
                    fragmentTransaction.add(R.id.fl, video_fragment);
                } else {
                    fragmentTransaction.show(video_fragment);
                }
                break;
            case R.id.guanzhu:
                if (care_fragment == null) {
                    care_fragment = new Care_Fragment();
                    fragmentTransaction.add(R.id.fl, care_fragment);
                } else {
                    fragmentTransaction.show(care_fragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }
}
