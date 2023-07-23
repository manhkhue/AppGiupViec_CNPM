package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.appgiupviec.R;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appgiupviec.Model.ThoiLuong;

import java.util.ArrayList;

public class ThoiLuongAdapter extends RecyclerView.Adapter<ThoiLuongAdapter.ThoiLuongViewHolder> {
    private ArrayList<ThoiLuong> thoiLuongList;

    public ThoiLuongAdapter(ArrayList<ThoiLuong> thoiLuongList) {
        this.thoiLuongList = thoiLuongList;
    }

    @NonNull
    @Override
    public ThoiLuongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_dat_app, parent, false);
        return new ThoiLuongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThoiLuongViewHolder holder, int position) {
        ThoiLuong thoiLuong = thoiLuongList.get(position);
        holder.txtThoiLuong.setText(thoiLuong.getThoiLuong());
    }

    @Override
    public int getItemCount() {
        return thoiLuongList.size();
    }

    public class ThoiLuongViewHolder extends RecyclerView.ViewHolder {
        TextView txtThoiLuong;

        public ThoiLuongViewHolder(@NonNull View itemView) {
            super(itemView);
            txtThoiLuong = itemView.findViewById(R.id.ThoiLuong);
        }
    }
}
