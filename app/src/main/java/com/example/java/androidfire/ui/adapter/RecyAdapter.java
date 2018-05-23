package com.example.java.androidfire.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.java.androidfire.R;
import com.example.java.androidfire.data.bean.TouTiao_Bean;

import java.util.List;

/**
 * Created by java on 2018/5/11.
 */

public class RecyAdapter extends BaseQuickAdapter<TouTiao_Bean.T1348647909107Bean,BaseViewHolder>{
    public RecyAdapter(int layoutResId, @Nullable List<TouTiao_Bean.T1348647909107Bean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TouTiao_Bean.T1348647909107Bean item) {
        helper.setText(R.id.tv,item.getTitle()).setText(R.id.tv2,item.getSource()).setText(R.id.time,item.getLmodify());
        Glide.with(mContext).load(item.getImgsrc()).crossFade().into((ImageView) helper.getView(R.id.img));
    }
}
