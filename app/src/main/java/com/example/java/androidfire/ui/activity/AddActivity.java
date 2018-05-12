package com.example.java.androidfire.ui.activity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.example.java.androidfire.R;
import com.example.java.androidfire.ui.adapter.MyRecyclerADapter;
import com.example.java.androidfire.ui.fragment.Home_Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddActivity extends AppCompatActivity {
    @BindView(R.id.toobar)
    Toolbar toobar;
    @BindView(R.id.My_recy)
    RecyclerView MyRecy;
    @BindView(R.id.Gengduo_recy)
    RecyclerView GengduoRecy;
    private MyRecyclerADapter myRecyclerADapter;
    private MyRecyclerADapter myRecyclerADapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);


        toobar.setTitle("频道管理");
        setSupportActionBar(toobar);
        toobar.setNavigationIcon(R.drawable.ic_arrow_back);
        toobar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        myRecyclerADapter = new MyRecyclerADapter(R.layout.pindao_item, Home_Fragment.My_Pin);
        MyRecy.setLayoutManager(new GridLayoutManager(this, 4));
        MyRecy.setAdapter(myRecyclerADapter);
        myRecyclerADapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Home_Fragment.My_Pin.remove(Home_Fragment.My_Pin.get(position));
                Home_Fragment.Gengduo_Pin.add(Home_Fragment.My_Pin.get(position));
                myRecyclerADapter.notifyDataSetChanged();
                myRecyclerADapter1.notifyDataSetChanged();
            }
        });
        myRecyclerADapter1 = new MyRecyclerADapter(R.layout.pindao_item, Home_Fragment.Gengduo_Pin);
        GengduoRecy.setLayoutManager(new GridLayoutManager(this, 4));
        myRecyclerADapter1.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                Home_Fragment.Gengduo_Pin.remove(Home_Fragment.Gengduo_Pin.get(position));
                Home_Fragment.My_Pin.add(Home_Fragment.Gengduo_Pin.get(position));
                myRecyclerADapter.notifyDataSetChanged();
                myRecyclerADapter1.notifyDataSetChanged();
            }
        });
        GengduoRecy.setAdapter(myRecyclerADapter1);
        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(myRecyclerADapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(MyRecy);
// 开启拖拽
        myRecyclerADapter.enableDragItem(itemTouchHelper, R.id.tv, true);
        myRecyclerADapter.setOnItemDragListener(onItemDragListener);

// 开启滑动删除
        myRecyclerADapter.enableSwipeItem();
        myRecyclerADapter.setOnItemSwipeListener(onItemSwipeListener);
    }

    OnItemDragListener onItemDragListener = new OnItemDragListener() {
        @Override
        public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {
        }

        @Override
        public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {
        }

        @Override
        public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {
        }
    };

    OnItemSwipeListener onItemSwipeListener = new OnItemSwipeListener() {
        @Override
        public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {
        }

        @Override
        public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {
        }

        @Override
        public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {
        }

        @Override
        public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float dX, float dY, boolean isCurrentlyActive) {

        }
    };



}
