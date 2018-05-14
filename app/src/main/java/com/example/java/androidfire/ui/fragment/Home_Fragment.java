package com.example.java.androidfire.ui.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.example.java.androidfire.R;
import com.example.java.androidfire.ui.activity.AddActivity;
import com.example.java.androidfire.ui.adapter.Tab_Adapter;
import com.example.java.androidfire.ui.fragment.child_Fragment.ShujuFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Home_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    public static ArrayList<String> My_Pin = new ArrayList<>();
    public static ArrayList<String> Gengduo_Pin = new ArrayList<>();
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;
    @BindView(R.id.add)
    ImageView add;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;
    public static ArrayList<Fragment> fragments;
    private Tab_Adapter tab_adapter;

    public Home_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();


        Log.e("--------", My_Pin.size()+"");
        tab_adapter.notifyDataSetChanged();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Home_Fragment newInstance(String param1, String param2) {
        Home_Fragment fragment = new Home_Fragment();
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
static {
    My_Pin.add("头条");
    My_Pin.add("体育");
    My_Pin.add("军事");
    My_Pin.add("科技");
    My_Pin.add("财经");

    Gengduo_Pin.add("彩票");
    Gengduo_Pin.add("NBA");
    Gengduo_Pin.add("教育");
    Gengduo_Pin.add("CBA");
    Gengduo_Pin.add("数码");
    Gengduo_Pin.add("精选");

    Gengduo_Pin.add("旅游");
    Gengduo_Pin.add("游戏");
    Gengduo_Pin.add("博客");

    Gengduo_Pin.add("娱乐");
    Gengduo_Pin.add("暴雪");
    Gengduo_Pin.add("手机");
    Gengduo_Pin.add("汽车");


    Gengduo_Pin.add("论坛");
    Gengduo_Pin.add("足球");
    Gengduo_Pin.add("时尚");

    Gengduo_Pin.add("移动");
    Gengduo_Pin.add("情感");
    Gengduo_Pin.add("消息");
    Gengduo_Pin.add("亲子");

    Gengduo_Pin.add("社会");
    Gengduo_Pin.add("电影");
    Gengduo_Pin.add("电台");
    Gengduo_Pin.add("房产");

    Gengduo_Pin.add("家居");
    Gengduo_Pin.add("笑话");
}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home_, container, false);
        unbinder = ButterKnife.bind(this, inflate);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddActivity.class);
                startActivity(intent);
            }
        });
        tab.setupWithViewPager(vp);
        Log.e("==",My_Pin.size()+"");
        tab.setTabMode( TabLayout.MODE_SCROLLABLE);

        fragments = new ArrayList<>();
        fragments.add(new ShujuFragment());
        fragments.add(new ShujuFragment());
        fragments.add(new ShujuFragment());
        fragments.add(new ShujuFragment());
        fragments.add(new ShujuFragment());


        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        tab_adapter = new Tab_Adapter(appCompatActivity.getSupportFragmentManager(), fragments, My_Pin);
        vp.setAdapter(tab_adapter);
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
