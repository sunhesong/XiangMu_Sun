package com.example.java.androidfire.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.java.androidfire.R;
import com.example.java.androidfire.ui.activity.AddActivity;
import com.example.java.androidfire.ui.adapter.Tab_Adapter;
import com.example.java.androidfire.ui.fragment.child_Fragment.ShuJuFragment;

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
    public static ArrayList<String[]>  My_Pin = new ArrayList<>();
    public static ArrayList<String[]> Gengduo_Pin = new ArrayList<>();
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
    public static ArrayList<android.support.v4.app.Fragment> fragments=new ArrayList<>();
    private static  Tab_Adapter tab_adapter;

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


    My_Pin.add(new String[]{"头条","T1348647909107"});
    My_Pin.add(new String[]{"科技","T1348648756099"});
    My_Pin.add(new String[]{"财经","T1348648141035"});
    My_Pin.add(new String[]{"军事","T1348649079062"});
    My_Pin.add(new String[]{"体育","T1348649079062"});

    Gengduo_Pin.add(new String[]{"彩票","T1348654225495"});
    Gengduo_Pin.add(new String[]{"NBA","T1348649776727"});
    Gengduo_Pin.add(new String[]{"教育","T1349837670307"});
    Gengduo_Pin.add(new String[]{"CBA","T1371543208049"});
    Gengduo_Pin.add(new String[]{"数码","T1351233117091"});
    Gengduo_Pin.add(new String[]{"精选","T1379038288239"});

    Gengduo_Pin.add(new String[]{"旅游","T1348649654285"});
    Gengduo_Pin.add(new String[]{"游戏","T1348650593803"});
    Gengduo_Pin.add(new String[]{"博客","T1348648037603"});

    Gengduo_Pin.add(new String[]{"娱乐","T1348648650048"});
    Gengduo_Pin.add(new String[]{"暴雪","T1397116135282"});
    Gengduo_Pin.add(new String[]{"手机","T1349837698345"});
    Gengduo_Pin.add(new String[]{"汽车","T1350383429665"});


    Gengduo_Pin.add(new String[]{"论坛","T1348654204705"});
    Gengduo_Pin.add(new String[]{"足球","T1348648517839"});
    Gengduo_Pin.add(new String[]{"时尚","T1348650839000"});

    Gengduo_Pin.add(new String[]{"移动","T1356600029035"});
    Gengduo_Pin.add(new String[]{"情感","T1370583240249"});
    Gengduo_Pin.add(new String[]{"消息","T1348648650048"});
    Gengduo_Pin.add(new String[]{"亲子","T1348649475931"});

    Gengduo_Pin.add(new String[]{"社会","T1348654105308"});
    Gengduo_Pin.add(new String[]{"电影","T1348654060988"});
    Gengduo_Pin.add(new String[]{"电台","T1348649145984"});
    Gengduo_Pin.add(new String[]{"房产","T1399700447917"});

    Gengduo_Pin.add(new String[]{"家居","T1397016069906"});
    Gengduo_Pin.add(new String[]{"笑话","T1348654151579"});

    fragments.add( ShuJuFragment.newInstance("headline","T1348647909107"));
    fragments.add( ShuJuFragment.newInstance("list","T1348648756099"));
    fragments.add( ShuJuFragment.newInstance("list","T1348648141035"));
    fragments.add( ShuJuFragment.newInstance("list","T1348649079062"));
    fragments.add( ShuJuFragment.newInstance("list","T1399700447917"));
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
        tab.setTabMode( TabLayout.MODE_SCROLLABLE);



        tab_adapter = new Tab_Adapter(getChildFragmentManager(), fragments, My_Pin);
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
