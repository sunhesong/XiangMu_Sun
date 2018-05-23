package com.example.java.androidfire.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.java.androidfire.R;

import java.util.List;

/**
 * Created by java on 2018/5/12.
 */

public class MyRecyclerADapter extends BaseItemDraggableAdapter<String[], BaseViewHolder> {
    public MyRecyclerADapter(int layoutResId, @Nullable List<String[]> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String[] item) {
        if (item[0].equals("头条") || item[0].equals("体育") ||
                item[0].equals("军事") || item[0].equals("科技") || item[0].equals("财经")) {

            helper.setText(R.id.tv, item[0]).setAlpha(R.id.tv, 0.5f);
        }else
        helper.setText(R.id.tv, item[0]);
    }
}
