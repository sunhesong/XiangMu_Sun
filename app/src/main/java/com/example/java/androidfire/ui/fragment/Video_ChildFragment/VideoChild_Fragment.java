package com.example.java.androidfire.ui.fragment.Video_ChildFragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.java.androidfire.R;
import com.example.java.androidfire.data.bean.Video_Bean;
import com.example.java.androidfire.presenter.contract.IContract;
import com.example.java.androidfire.presenter.impl.IPresenter_Video;
import com.example.java.androidfire.ui.activity.ZhuActivity;
import com.example.java.androidfire.ui.adapter.VideoAdapter;
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
 * Use the {@link VideoChild_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoChild_Fragment extends Fragment implements IContract.IView_Video<IContract.IPresenter_Video> {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.smart)
    SmartRefreshLayout smart;
    Unbinder unbinder;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private RecyclerView recy;
    private List<Video_Bean.V9LG4E6VRBean> list = new ArrayList<>();
    private VideoAdapter videoAdapter;
    private RxManager rxManager;
    private int tabLayoutHeight;
    private LinearLayout ll;

    public VideoChild_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VideoChild_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VideoChild_Fragment newInstance(String param1, String param2) {
        VideoChild_Fragment fragment = new VideoChild_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    IContract.IPresenter_Video iPresenter_video;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_blank, container, false);
        initView(inflate);
        unbinder = ButterKnife.bind(this, inflate);
        new IPresenter_Video(this);
        iPresenter_video.Video_Data(mParam1);
        videoAdapter = new VideoAdapter(list, getActivity());
        recy.setLayoutManager(new LinearLayoutManager(getActivity()));
        recy.setAdapter(videoAdapter);
        smart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                iPresenter_video.Video_Data(mParam1);
                refreshlayout.finishRefresh(2000);

            }
        });
        smart.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000);
                iPresenter_video.Video_Data(mParam1);
            }
        });
        initWeight();
        return inflate;
    }

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
        recy = (RecyclerView) inflate.findViewById(R.id.recy);
        ll = (LinearLayout) inflate.findViewById(R.id.ll);
    }

    @Override
    public void setPresenter(IContract.IPresenter_Video iPresenter_video) {
        this.iPresenter_video = iPresenter_video;
    }

    @Override
    public void showData_Video(final Video_Bean t1348647909107) {

        ll.setVisibility(View.GONE);
        list.addAll(t1348647909107.getV9LG4E6VR());
        Log.e("---", list.toString());

        videoAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
