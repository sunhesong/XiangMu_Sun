package com.example.java.androidfire.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.java.androidfire.R;
import com.example.java.androidfire.ui.weight.GlideCircleTransform;

import java.util.List;

public class Adapter extends BaseQuickAdapter<String[], BaseViewHolder> {
    public Adapter(@Nullable List<String[]> data) {
        super(R.layout.dongtai_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String[] item) {
        helper.setText(R.id.name, item[0]).setText(R.id.content,item[2]).setText(R.id.time,item[1]);
        Glide.with(mContext).load(item[3]).crossFade().into((ImageView) helper.getView(R.id.img));
        Glide.with(mContext).load(item[4]).transform(new GlideCircleTransform(mContext)).crossFade().into((ImageView) helper.getView(R.id.tou));
    }
}
