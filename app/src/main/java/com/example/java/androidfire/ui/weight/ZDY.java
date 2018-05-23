package com.example.java.androidfire.ui.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ZDY extends View{
    public ZDY(Context context) {
        super(context);
    }

    Paint mAbovePaint;
    Paint mBelowPaint;
    Path mAbovePath;
    Path mBelowPath;
    public ZDY(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //上边的画笔
        mAbovePaint = new Paint();
        mAbovePaint.setAntiAlias(true);
        mAbovePaint.setStyle(Paint.Style.FILL);
        mAbovePaint.setColor(Color.WHITE);
        //下边的画笔
        mBelowPaint = new Paint();
        mBelowPaint.setAntiAlias(true);
        mBelowPaint.setStyle(Paint.Style.FILL);
        mBelowPaint.setColor(Color.WHITE);
        mBelowPaint.setAlpha(100);

        mAbovePath = new Path();
        mBelowPath = new Path();
    }
    float t;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        PaintFlagsDrawFilter filter = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG|Paint.FILTER_BITMAP_FLAG);
        canvas.setDrawFilter(filter);
        mAbovePath.reset();
        mBelowPath.reset();

        //两根线的起始点都是左下
        mAbovePath.moveTo(getLeft(),getTop());
        mBelowPath.moveTo(getLeft(),getTop());

        float A =8;
        float w = 6;
        t -= 0.04;
        float k=8;
        float y1,y2;
        for (int x = 0; x < getWidth(); x+=20) {
            y1 = (float) (A*Math.cos(w*x+t)+k);
            y2 = (float) (A*Math.sin(w*x+t)+k);
            mAbovePath.lineTo(x,getHeight()-y1);
            mBelowPath.lineTo(x,getHeight()-y2);
        }
        mAbovePath.lineTo(getRight(),getTop());
        mBelowPath.lineTo(getRight(),getTop());
        //画两根线
        canvas.drawPath(mAbovePath,mAbovePaint);
        canvas.drawPath(mBelowPath,mBelowPaint);
        postInvalidateDelayed(20);
    }
}
