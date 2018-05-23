package com.example.java.androidfire.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;

import com.example.java.androidfire.R;
import com.example.java.androidfire.ui.activity.DongtaiActivity;
import com.example.java.androidfire.ui.activity.GuanyuActivity;
import com.example.java.androidfire.ui.activity.ZhuActivity;
import com.example.java.androidfire.ui.weight.Night;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Care_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Care_Fragment extends Fragment implements Night.OnThemeChangeListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Unbinder unbinder;
    @BindView(R.id.guanzhu2)
    LinearLayout guanzhu2;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private LinearLayout haoyou;
    private LinearLayout riye;
    private SharedPreferences sp;
    private int id;
    private AppCompatActivity appCompatActivity;
    private LinearLayout ll;
    private ActionBar supportActionBar;

    public Care_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Care_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Care_Fragment newInstance(String param1, String param2) {
        Care_Fragment fragment = new Care_Fragment();
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
//
//    static {
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        appCompatActivity = (AppCompatActivity) getActivity();
        // 判断是否有主题存储
        View inflate = inflater.inflate(R.layout.fragment_care_, container, false);
        initView(inflate);
        unbinder = ButterKnife.bind(this, inflate);
        supportActionBar = ((ZhuActivity) getActivity()).getSupportActionBar();
        Night.getCurrentThemeRes(getContext(), R.color.backgroundColor_night);
guanzhu2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), GuanyuActivity.class);

        startActivity(intent);
    }
});
        haoyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),DongtaiActivity.class));
            }
        });

//        sp = appCompatActivity.getSharedPreferences("sp", 0);
//        id = sp.getInt("id", AppCompatDelegate.MODE_NIGHT_YES);

//        riye.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SharedPreferences sp = appCompatActivity.getSharedPreferences("sp", 0);
//                SharedPreferences.Editor edit = sp.edit();
//
//                if (id  == AppCompatDelegate.MODE_NIGHT_YES) {
//                    edit.putInt("id",AppCompatDelegate.MODE_NIGHT_NO);
//                    appCompatActivity.getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//
//
//                } else {
//                    edit.putInt("id", AppCompatDelegate.MODE_NIGHT_YES);
//                    appCompatActivity.getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//
//                }
//                Log.e("----",id+"");
//                edit.commit();
//                appCompatActivity.recreate();
//            }
//        });
        riye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Night.setThemeMode(Night.getThemeMode() == Night.ThemeMode.DAY
                        ? Night.ThemeMode.NIGHT : Night.ThemeMode.DAY);

            }
        });
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
        haoyou = (LinearLayout) inflate.findViewById(R.id.haoyou);
        riye = (LinearLayout) inflate.findViewById(R.id.riye);
        guanzhu2 = (LinearLayout) inflate.findViewById(R.id.guanzhu);
        ll = (LinearLayout) inflate.findViewById(R.id.ll);
        Night.registerThemeChangeListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Night.unregisterThemeChangeListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onThemeChanged() {
//        guanzhu2.setBackgroundColor(getResources().getColor(Night.getCurrentThemeRes(getContext(),R.color.backgroundColor)));
        //toogle_text.setTextColor(getResources().getColor(ThemeManager.getCurrentThemeRes(getContext(), R.color.textColor)));
//btn_theme.setTextColor(getResources().getColor(ThemeManager.getCurrentThemeRes(getContext(), R.color.textColor)));
//        ll.setBackgroundColor(getResources().getColor(Night.getCurrentThemeRes(getContext(), R.color.backgroundColor)));

        ((ZhuActivity) getActivity()).findViewById(R.id.Shouye).setBackgroundColor(getResources().getColor(Night.getCurrentThemeRes(getContext(), R.color.backgroundColor)));
        ((ZhuActivity) getActivity()).findViewById(R.id.meinv).setBackgroundColor(getResources().getColor(Night.getCurrentThemeRes(getContext(), R.color.backgroundColor)));
        ((ZhuActivity) getActivity()).findViewById(R.id.shipin).setBackgroundColor(getResources().getColor(Night.getCurrentThemeRes(getContext(), R.color.backgroundColor)));
        ((ZhuActivity) getActivity()).findViewById(R.id.guanzhu).setBackgroundColor(getResources().getColor(Night.getCurrentThemeRes(getContext(), R.color.backgroundColor)));
        ((ZhuActivity) getActivity()).findViewById(R.id.fl).setBackgroundColor(getResources().getColor(Night.getCurrentThemeRes(getContext(), R.color.backgroundColor)));
// 设置标题栏颜色
        if (supportActionBar != null) {
            supportActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(Night.getCurrentThemeRes(getContext(), R.color.colorPrimary))));
        }
// 设置状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
//            window.setStatusBarColor(getResources().getColor(Night.getCurrentThemeRes(getContext(), R.color.colorPrimary)));
        }

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
