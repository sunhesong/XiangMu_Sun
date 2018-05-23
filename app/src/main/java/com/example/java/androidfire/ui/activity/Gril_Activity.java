package com.example.java.androidfire.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.java.androidfire.R;
import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class Gril_Activity extends SwipeBackActivity {

    private PhotoView pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gril_);

        initView();
        SwipeBackLayout swipeBackLayout = getSwipeBackLayout();
        //设置可以滑动的区域，推荐用屏幕像素的一半来指定
        swipeBackLayout.setEdgeSize(50);
        //设定滑动关闭的方向，SwipeBackLayout.EDGE_ALL表示向下、左、右滑动均可。EDGE_LEFT，EDGE_RIGHT，EDGE_BOTTOM
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_ALL);

        Intent intent = getIntent();
        String img = intent.getStringExtra("img");
        Picasso.with(this).load(img).into(pb);


    }

    private void initView() {
        pb = (PhotoView) findViewById(R.id.pb);
    }

}
