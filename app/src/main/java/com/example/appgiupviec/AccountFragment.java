package com.example.appgiupviec;

import static com.example.appgiupviec.LoginActivity.user;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView tvTenUser;

    //private static final int CAP_NHAT_REQUEST_CODE = 1;

    public AccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
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
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        tvTenUser = view.findViewById(R.id.tvTenUser);// Liên kết với TextView tại đây
        loadUserProfile();

        edtChinhSuaHS = view.findViewById(R.id.edtChinhSuaHS);
        edtChinhSuaHS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), CT_AccountActivity.class);
               // startActivityForResult(i, CAP_NHAT_REQUEST_CODE);
            }
        });

        return view;
    }

    private void loadUserProfile() {
        SharedPreferences preferences = getActivity().getSharedPreferences("user_profile", Context.MODE_PRIVATE);
        tvTenUser.setText(user.getTenUser()); // Hiển thị tên người dùng
    }


    ConstraintLayout Favorite,Logout,TimKiem;
    TextView edtChinhSuaHS;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AnhXa();
        setClick();
    }
    private void AnhXa(){
        Favorite = getView().findViewById(R.id.Favorite);
        edtChinhSuaHS = getView().findViewById(R.id.edtChinhSuaHS);
        Logout  = getView().findViewById(R.id.DangXuat);
        TimKiem = getView().findViewById(R.id.TimKiem);
    }

    private void setClick(){
        Favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),YeuThichActivity.class);
                startActivity(i);
            }
        });

        edtChinhSuaHS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),CT_AccountActivity.class);
                startActivity(i);
            }
        });
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        TimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),TimKiemNGVActivity.class);
                startActivity(i);
            }
        });
    }
}