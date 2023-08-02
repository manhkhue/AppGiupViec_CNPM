package com.example.appgiupviec;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appgiupviec.Model.DichVu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Adapter.BannerAdapter;
import Adapter.DichVuAdapter;
import api.ApiGetDSDichVu;
import interfaces.getDSDichVuFromApi;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements getDSDichVuFromApi {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private ArrayList<String> listImages = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView RcvDichVu;
    DichVuAdapter dichVuAdapter;
    ArrayList<DichVu> arrDichVu;
    Timer timer;
    TimerTask timerTask;
    int position;
    LinearLayoutManager layoutManager;


    GridView gdvDS;
    @Override
    public void onResume() {
        super.onResume();
        AutoScrollBanner();
    }
    @Override
    public void onPause() {
        super.onPause();
        StopAutoScrollBanner();
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getImages();
        recyclerView = view.findViewById(R.id.horizontal_RCV);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        BannerAdapter adapter = new BannerAdapter(getContext(),listImages);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //auto Scroll
        if(listImages!=null){
            position = Integer.MAX_VALUE/2;
            recyclerView.scrollToPosition(position);
        }

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        recyclerView.smoothScrollBy(5,0);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState==1){
                    StopAutoScrollBanner();
                }
                else if(newState==0){
                    position = layoutManager.findFirstCompletelyVisibleItemPosition();
                    AutoScrollBanner();
                }
            }
        });
        //
        RcvDichVu = view.findViewById(R.id.RcvDichVu);
        RcvDichVu.setLayoutManager(new GridLayoutManager(getContext(),4));
        arrDichVu = new ArrayList<>();
        onClick();
        new ApiGetDSDichVu(this).execute();
    }

    private void AutoScrollBanner(){
        if(timer == null && timerTask == null){
            timer = new Timer();
            timerTask = new TimerTask() {
                @Override
                public void run() {
                    if(position == Integer.MAX_VALUE){
                        position = Integer.MAX_VALUE/2;
                        recyclerView.scrollToPosition(position);
                        recyclerView.smoothScrollBy(2,0);
                    }
                    else{
                        position++;
                        recyclerView.smoothScrollToPosition(position);
                    }
                }
            };
            timer.schedule(timerTask,5000,5000);
        }
    }
    private void StopAutoScrollBanner(){
        if(timer!=null && timerTask == null){
            timerTask.cancel();
            timer.cancel();
            timer = null;
            timerTask = null;
            position = layoutManager.findFirstCompletelyVisibleItemPosition();
        }
    }

    private void onClick(){
//        RcvDichVu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getActivity(),DatAppActivity.class);
//                startActivity(i);
//            }
//        });
    }

    private void getImages(){
        listImages.add("https://inanaz.com.vn/wp-content/uploads/2023/03/mau-banner-quang-cao-dep.jpg");
        listImages.add("data:image/jpeg;base64,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");
        listImages.add("https://inanaz.com.vn/wp-content/uploads/2020/02/mau-banner-quang-cao-3.jpg");
        listImages.add("https://intphcm.com/data/upload/banner-quang-cao.jpg");
    }

    @Override
    public void Start() {
        Toast.makeText(getContext(),"Dang lay ve",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void End(String data) {
        try {
            arrDichVu.clear();
            JSONArray jsonArray = new JSONArray(data);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject object = jsonArray.getJSONObject(i);
                arrDichVu.add(new DichVu(object));
            }
            dichVuAdapter = new DichVuAdapter(getContext(),arrDichVu);
            RcvDichVu.setAdapter(dichVuAdapter);
        }
        catch (JSONException e){

        }
    }

    @Override
    public void Error() {
        Toast.makeText(getContext(), "Loi Ket Noi", Toast.LENGTH_SHORT).show();
    }
}