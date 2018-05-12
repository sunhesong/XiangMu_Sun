package com.example.java.androidfire.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.java.androidfire.R;

import java.util.List;

/**
 * Created by java on 2018/5/12.
 */

public class MyRecyclerADapter extends BaseItemDraggableAdapter<String,BaseViewHolder> {
    public MyRecyclerADapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv,item);
    }
}
