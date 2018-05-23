package com.example.java.androidfire.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.java.androidfire.R;
import com.example.java.androidfire.ui.adapter.Adapter;
import com.example.java.androidfire.ui.weight.GlideCircleTransform;
import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DongtaiActivity extends AppCompatActivity {


    @BindView(R.id.fab_1)
    FloatingActionButton fab1;
    @BindView(R.id.fab_2)
    FloatingActionButton fab2;
    @BindView(R.id.fab_3)
    FloatingActionButton fab3;
    @BindView(R.id.fab_4)
    FloatingActionButton fab4;
    @BindView(R.id.fab_5)
    FloatingActionButton fab5;
    private ImageView img;
    private CollapsingToolbarLayout collapsing_toolbar_layout;
    private AppBarLayout app222;
    private ImageView fab;
    private RecyclerView recy;
    private CoordinatorLayout c;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dongtai);
        ButterKnife.bind(this);
        initView();

        Glide.with(this).load("http://ww1.sinaimg.cn/large/0065oQSqly1fri9zqwzkoj30ql0w3jy0.jpg")
                .transform(new GlideCircleTransform(this)).into(fab);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ArrayList<String[]> strings = new ArrayList<>();
        strings.add(new String[]{"孙贺淞", "2018-5-21", "弄死你算了", "http://cms-bucket.nosdn.127.net/01fb193db6f5427486afd291cc832b2020180521083136.jpeg", "http://ww1.sinaimg.cn/large/0065oQSqly1fri9zqwzkoj30ql0w3jy0.jpg"});
        strings.add(new String[]{"孙贺淞2", "2018-5-22", "弄死你算了2", "http://cms-bucket.nosdn.127.net/01fb193db6f5427486afd291cc832b2020180521083136.jpeg", "http://ww1.sinaimg.cn/large/0065oQSqly1frg40vozfnj30ku0qwq7s.jpg"});
        strings.add(new String[]{"孙贺淞3", "2018-5-23", "弄死你算了3", "http://cms-bucket.nosdn.127.net/01fb193db6f5427486afd291cc832b2020180521083136.jpeg", "http://ww1.sinaimg.cn/large/0065oQSqly1frevscw2wej30je0ps78h.jpg"});
        strings.add(new String[]{"孙贺淞4", "2018-5-24", "弄死你算了4", "http://cms-bucket.nosdn.127.net/01fb193db6f5427486afd291cc832b2020180521083136.jpeg", "http://ww1.sinaimg.cn/large/0065oQSqly1frepozc5taj30qp0yg7aq.jpg"});
        strings.add(new String[]{"孙贺淞5", "2018-5-25", "弄死你算了5", "http://cms-bucket.nosdn.127.net/01fb193db6f5427486afd291cc832b2020180521083136.jpeg", "http://ww1.sinaimg.cn/large/0065oQSqly1frepq6mfvdj30p00wcwmq.jpg"});
        strings.add(new String[]{"孙贺淞6", "2018-5-26", "弄死你算了6", "http://cms-bucket.nosdn.127.net/01fb193db6f5427486afd291cc832b2020180521083136.jpeg", "http://ww1.sinaimg.cn/large/0065oQSqly1frepqtwifwj30no0ti47n.jpg"});
        Adapter adapter = new Adapter(strings);
        recy.setLayoutManager(new LinearLayoutManager(this));

        recy.setAdapter(adapter);


    }

    private void initView() {
        img = (ImageView) findViewById(R.id.img);
        collapsing_toolbar_layout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        app222 = (AppBarLayout) findViewById(R.id.app222);
        fab = (ImageView) findViewById(R.id.fab);
        recy = (RecyclerView) findViewById(R.id.recy);
        c = (CoordinatorLayout) findViewById(R.id.c);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DongtaiActivity.this, ShuoshuoActivity.class));

            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DongtaiActivity.this, ShuoshuoActivity.class));

            }
        });
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DongtaiActivity.this, ShuoshuoActivity.class));

            }
        });
        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DongtaiActivity.this, ShuoshuoActivity.class));

            }
        });
        fab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DongtaiActivity.this, ShuoshuoActivity.class));

            }
        });
    }

}
