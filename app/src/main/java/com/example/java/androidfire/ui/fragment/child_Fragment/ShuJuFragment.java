package com.example.java.androidfire.ui.fragment.child_Fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.java.androidfire.R;
import com.example.java.androidfire.data.EventBus.EventBusMessage;
import com.example.java.androidfire.data.bean.TouTiao_Bean;
import com.example.java.androidfire.presenter.contract.IContract;
import com.example.java.androidfire.presenter.impl.IPresenter;
import com.example.java.androidfire.ui.activity.XiangQingActivity;
import com.example.java.androidfire.ui.activity.ZhuActivity;
import com.example.java.androidfire.ui.adapter.RecyAdapter;
import com.example.java.androidfire.ui.weight.RxManager;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ShuJuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShuJuFragment extends Fragment implements IContract.IView<IContract.IPresenter> {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static RecyclerView recy;
    Unbinder unbinder;
    private static int tabLayoutHeight;
    ValueAnimator valueAnimator;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.sma)
    SmartRefreshLayout sma;
    private RxManager rxManager;
    ObjectAnimator alpha;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private ProgressBar pb;

    public ShuJuFragment() {
        // Required empty public constructor
    }

    String param;

    public ShuJuFragment(String param) {
        this.param = param;

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShuJuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShuJuFragment newInstance(String param1, String param2) {
        ShuJuFragment fragment = new ShuJuFragment(param2);
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_shuju, container, false);
        initView(inflate);
        unbinder = ButterKnife.bind(this, inflate);
        NewPresenter();
        initNewAdapter();
        // 使用重写后的线性布局管理器
        initWeight();
        //        recy.smoothScrollToPosition(0);
        initRefreshData();

        initTouch();
        return inflate;
    }

    private void initTouch() {
    recyAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            Intent intent = new Intent(getActivity(), XiangQingActivity.class);
            EventBusMessage eventBusMessage = new EventBusMessage(list.get(position).getImgsrc(),list.get(position).getTitle(),list.get(position).getUrl());
            EventBus.getDefault().postSticky(eventBusMessage);
            startActivity(intent);

        }
    });

    }

    private void initNewAdapter() {
        recyAdapter = new RecyAdapter(R.layout.item, list);
        recyAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        recyAdapter.isFirstOnly(false);
        recy.setLayoutManager(new LinearLayoutManager(getContext()));
        recy.setAdapter(recyAdapter);
//        recyAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
//            @Override
//            public void onLoadMoreRequested() {
//                new IPresenter(ShuJuFragment.this);
//                iPresenter.Data(mParam1, mParam2, next += 1);
//
//                Log.e("=====", next + "" + mParam1 + mParam2);
//            }
//        }, recy);
    }

    int next = 0;

    private void initWeight() {
        rxManager = new RxManager();
        ZhuActivity.tab_layout.measure(0, 0);
        tabLayoutHeight = ZhuActivity.tab_layout.getMeasuredHeight();
        startAnimation();

    }

    private void initRefreshData() {
        sma.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);
                iPresenter.Data(mParam1,mParam2,0);
                next=0;
            }
        });
        sma.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                next++;
                iPresenter.Data(mParam1, mParam2, 0);
                Log.e("===",next+"");
                refreshlayout.finishLoadmore(2000);

            }
        });
    }

    private void NewPresenter() {
        new IPresenter(this);
        iPresenter.Data(mParam1, mParam2, 0);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
        }


    }

    IContract.IPresenter iPresenter;

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void setPresenter(IContract.IPresenter iPresenter) {
        this.iPresenter = iPresenter;
    }

    private RecyAdapter recyAdapter;
    List<TouTiao_Bean.T1348647909107Bean> list = new ArrayList<>();

    @Override
    public void showData(final List<TouTiao_Bean.T1348647909107Bean> t1348647909107) {
        ll.setVisibility(View.GONE);
        pb.setVisibility(View.GONE);
        AppCompatActivity compatActivity = (AppCompatActivity) getActivity();
        compatActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {

                list.addAll(t1348647909107);
                recyAdapter.notifyDataSetChanged();

                Log.e("----}}}===", t1348647909107.toString());
            }
        });


    }

    @Override
    public void Loading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void Error(String message) {
        recyAdapter.loadMoreFail();
        pb.setVisibility(View.GONE);
        ll.setVisibility(View.VISIBLE);
    }

    boolean a = true;

    private void startAnimation() {
        recy.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                final ViewGroup.LayoutParams layoutParams = ZhuActivity.tab_layout.getLayoutParams();
                if (a) {
                    ZhuActivity.ftab.setVisibility(View.VISIBLE);

                    valueAnimator = ValueAnimator.ofInt(tabLayoutHeight, 0);
                    alpha = ObjectAnimator.ofFloat(ZhuActivity.tab_layout, "alpha", 1, 0);
                    ZhuActivity.tab_layout.setVisibility(View.VISIBLE);
                } else {
                    ZhuActivity.ftab.setVisibility(View.GONE);
                    valueAnimator = ValueAnimator.ofInt(0, tabLayoutHeight);
                    alpha = ObjectAnimator.ofFloat(ZhuActivity.tab_layout, "alpha", 0, 1);
                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            layoutParams.height = (int) valueAnimator.getAnimatedValue();
                            ZhuActivity.tab_layout.setLayoutParams(layoutParams);
                        }
                    });
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setDuration(500);
                    animatorSet.playTogether(valueAnimator, alpha);
                    animatorSet.start();
                    ZhuActivity.tab_layout.setVisibility(View.GONE);

                }


            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy < -1) {
                    a = true;
                } else if (dy > 1) {
                    a = false;
                }
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initView(View inflate) {
        recy = inflate.findViewById(R.id.recy);
        pb = (ProgressBar) inflate.findViewById(R.id.pb);
        ZhuActivity.ftab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "nihaoz", Toast.LENGTH_SHORT).show();
            recy.smoothScrollToPosition(0);
            }
        });
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
