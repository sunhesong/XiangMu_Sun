package com.example.java.androidfire.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by java on 2018/5/13.
 */

public class Tab_Adapter extends FragmentStatePagerAdapter{
    private ArrayList<Fragment> fragments;
    private ArrayList<String[]> list;

    public Tab_Adapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String[]> list) {
        super(fm);
        this.fragments = fragments;
        this.list = list;
    }

    @Override
    public int getCount() {
        return fragments==null?0:fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments==null?null:fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Log.e("----",list.size()+"");
        return list==null?null:list.get(position)[0];
    }
    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == ((Fragment) obj).getView();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Fragment fragment = ((Fragment) object);
    }

}
