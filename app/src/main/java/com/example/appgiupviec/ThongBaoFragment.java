package com.example.appgiupviec;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.appgiupviec.Model.ThongBao;

import java.util.ArrayList;
import java.util.Set;
import java.util.zip.Inflater;

import Adapter.ThongBaoAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThongBaoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThongBaoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ThongBaoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThongBaoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThongBaoFragment newInstance(String param1, String param2) {
        ThongBaoFragment fragment = new ThongBaoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    RecyclerView rcvThongBao;
    ArrayList<ThongBao> ThongBaos;
    ConstraintLayout KhongThongBao;
    ImageButton XoaThongBao;
    ThongBaoAdapter thongBaoAdapter;
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
        return inflater.inflate(R.layout.fragment_thong_bao, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addThongBao();

        //Ánh Xạ
        rcvThongBao = view.findViewById(R.id.rcvThongBao);
        KhongThongBao = view.findViewById(R.id.KhongThongBao);
        XoaThongBao = view.findViewById(R.id.XoaThongBao);
        //

        //Set manager
        SetUp();
        //
        XuLy();

    }

    @Override
    public void onPause() {
        super.onPause();
        thongBaoAdapter.notifyDataSetChanged();
    }

    private void SetUp(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rcvThongBao.setLayoutManager(linearLayoutManager);
        rcvThongBao.addItemDecoration(new SpacesItemDecorations(20));
        thongBaoAdapter = new ThongBaoAdapter(getContext(),ThongBaos);
        rcvThongBao.setAdapter(thongBaoAdapter);
    }

    private void XuLy(){
        XoaThongBao.setOnClickListener(v -> {
            ThongBaos.clear();
            thongBaoAdapter.notifyDataSetChanged();
            if(ThongBaos.isEmpty()){
                rcvThongBao.setVisibility(View.INVISIBLE);
                KhongThongBao.setVisibility(View.VISIBLE);
            }
        });

    }


    private void addThongBao(){
        ThongBaos = new ArrayList<>();
        for (int i=0;i<10;i++)
        {
            ThongBaos.add(new ThongBao("\uD83C\uDF89\uD83C\uDF89ƯU ĐÃI HẤP DẪN\uD83C\uDF89\uD83C\uDF89","","Áp dụng ưu đãi ngay để nhận ngay 50% giảm giá cho đơn hàng tiếp theo!\n" +
                    "Thời gian áp dụng ưu đãi: từ ngày XX/XX/XXXX đến ngày XX/XX/XXXX.\n" +
                    "Hãy nhanh tay đặt hàng để không bỏ lỡ cơ hội hấp dẫn này!\n" +
                    "\uD83D\uDE80\uD83D\uDE80Áp dụng ngay và tiết kiệm cùng chúng tôi!\uD83D\uDE80\uD83D\uDE80"));
        }
    }
}