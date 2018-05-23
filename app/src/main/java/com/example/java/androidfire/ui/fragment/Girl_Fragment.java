package com.example.java.androidfire.ui.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.java.androidfire.R;
import com.example.java.androidfire.data.bean.Girl_Bean;
import com.example.java.androidfire.presenter.contract.IContract;
import com.example.java.androidfire.presenter.impl.IPresenter_Girl;
import com.example.java.androidfire.ui.activity.Gril_Activity;
import com.example.java.androidfire.ui.activity.ZhuActivity;
import com.example.java.androidfire.ui.adapter.Girl_adapter;
import com.example.java.androidfire.ui.weight.RxManager;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

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
 * Use the {@link Girl_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Girl_Fragment extends Fragment implements IContract.IView_Video_Girl<IContract.IPresenter_Girl> {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.sr)
    SmartRefreshLayout sr;
    Unbinder unbinder;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private TextView tv;
    private Toolbar toolbar;
    private RecyclerView recy;
    private Girl_adapter girl_adapter;
    private int tabLayoutHeight;
    private RxManager rxManager;

    public Girl_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Girl_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Girl_Fragment newInstance(String param1, String param2) {
        Girl_Fragment fragment = new Girl_Fragment();
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
        View inflate = inflater.inflate(R.layout.fragment_girl_, container, false);
        initView(inflate);
        unbinder = ButterKnife.bind(this, inflate);

        sr.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);
                iPresenter_girl.Girl_Data(0);
                list.clear();
            }
        });
        sr.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000);
                iPresenter_girl.Girl_Data(next++);
            }
        });

        return inflate;
    }

    int next = 0;

    // TODO: Rename method, update argument and hook method into UI event
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

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void initView(View inflate) {
        tv = (TextView) inflate.findViewById(R.id.tv);
        toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
        recy = (RecyclerView) inflate.findViewById(R.id.recy);
        new IPresenter_Girl(this);
        iPresenter_girl.Girl_Data(0);
        girl_adapter = new Girl_adapter(R.layout.girl_item, list);
        recy.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recy.setAdapter(girl_adapter);
        initWeight();
    }

    List<Girl_Bean.ResultsBean> list = new ArrayList<>();

    @Override

    public void showData_Girl(List<Girl_Bean.ResultsBean> t1348647909107) {
        list.addAll(t1348647909107);
        Log.e("-[--", list.toString());
        girl_adapter.notifyDataSetChanged();
        girl_adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String url = list.get(position).getUrl();
                Intent intent = new Intent(getActivity(), Gril_Activity.class);
                intent.putExtra("img", url);
                startActivity(intent);
            }
        });
    }

    private void initWeight() {
        rxManager = new RxManager();
        ZhuActivity.tab_layout.measure(0, 0);
        tabLayoutHeight = ZhuActivity.tab_layout.getMeasuredHeight();
        startAnimation();

    }

    boolean a;
    private ValueAnimator valueAnimator;
    private ObjectAnimator alpha;

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
    public void setPresenter(IContract.IPresenter_Girl iPresenter_girl) {
        this.iPresenter_girl = iPresenter_girl;
    }

    IContract.IPresenter_Girl iPresenter_girl;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
