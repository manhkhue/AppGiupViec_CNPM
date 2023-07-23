package com.example.appgiupviec;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appgiupviec.Model.TinTuc;

import java.util.ArrayList;

import Adapter.TinTucAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TinTucFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TinTucFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TinTucFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TinTucFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TinTucFragment newInstance(String param1, String param2) {
        TinTucFragment fragment = new TinTucFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    private ArrayList<TinTuc> arrTinTuc;
    RecyclerView rcvTinTuc;

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
        return inflater.inflate(R.layout.fragment_tin_tuc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcvTinTuc = view.findViewById(R.id.RcvTinTuc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rcvTinTuc.setLayoutManager(layoutManager);
        rcvTinTuc.addItemDecoration(new SpacesItemDecorations(30));
        addTinTuc();
        TinTucAdapter adapter = new TinTucAdapter(getContext(),arrTinTuc);
        rcvTinTuc.setAdapter(adapter);
    }

    private void addTinTuc(){
        arrTinTuc = new ArrayList<>();
        arrTinTuc.add(new TinTuc("Tin Hot 1","data:image/jpeg;base64,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"));
        arrTinTuc.add(new TinTuc("Tin Hot 2","data:image/png;base64,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"));
        arrTinTuc.add(new TinTuc("Tin Hot 3","data:image/jpeg;base64,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"));
        arrTinTuc.add(new TinTuc("Tin Hot 4","https://png.pngtree.com/png-vector/20191026/ourlarge/pngtree-hot-news-icon-cartoon-style-png-image_1861665.jpg"));
    }
}