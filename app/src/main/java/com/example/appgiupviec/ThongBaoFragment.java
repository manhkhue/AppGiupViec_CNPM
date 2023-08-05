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
import com.example.appgiupviec.Model.TinTuc;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Set;
import java.util.zip.Inflater;

import Adapter.ThongBaoAdapter;
import Adapter.TinTucAdapter;
import api.ApiGetDSThongBao;
import interfaces.getDSThongBaoFromApi;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThongBaoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThongBaoFragment extends Fragment implements getDSThongBaoFromApi {

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
    ArrayList<ThongBao> arrThongBao;
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
        //Ánh Xạ
        //
        AnhXa();
        //Set manager
        SetUp();
        //
        XuLy();
        new ApiGetDSThongBao(this).execute();
    }

    private void AnhXa(){
        rcvThongBao = getView().findViewById(R.id.rcvThongBao);
        KhongThongBao = getView().findViewById(R.id.KhongThongBao);
        XoaThongBao = getView().findViewById(R.id.XoaThongBao);
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
    }

    private void XuLy(){
        XoaThongBao.setOnClickListener(v -> {
            arrThongBao.clear();
            thongBaoAdapter.notifyDataSetChanged();
            if(arrThongBao.isEmpty()){
                rcvThongBao.setVisibility(View.INVISIBLE);
                KhongThongBao.setVisibility(View.VISIBLE);
            }
        });

    }


    @Override
    public void Start() {

    }

    @Override
    public void End(String data) {
        try {
            arrThongBao = new ArrayList<>();
            arrThongBao.clear();
            JSONArray jsonArray = new JSONArray(data);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject object = jsonArray.getJSONObject(i);
                arrThongBao.add(new ThongBao(object));
            }
            thongBaoAdapter = new ThongBaoAdapter(getContext(),arrThongBao);
            rcvThongBao.setAdapter(thongBaoAdapter);
        }
        catch (JSONException e){
        }
    }

    @Override
    public void Error() {
    }
}