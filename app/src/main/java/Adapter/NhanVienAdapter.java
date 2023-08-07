package Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appgiupviec.ChiTietNGVActivity;
import com.example.appgiupviec.DatAppActivity;
import com.example.appgiupviec.Model.DichVu;
import com.example.appgiupviec.Model.NhanVien;
import com.example.appgiupviec.R;

import java.util.ArrayList;

public class NhanVienAdapter extends RecyclerView.Adapter<NhanVienAdapter.ViewHolder> {
    ArrayList <NhanVien> arrNhanVien;
    Context context;

    public NhanVienAdapter(Context context,ArrayList<NhanVien> arrNhanVien){
        this.context = context;
        this.arrNhanVien = arrNhanVien;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_timkiem,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                if(position!=RecyclerView.NO_POSITION){
                    NhanVien nhanVien = arrNhanVien.get(position);
                    Bundle bundle =new Bundle();
                    bundle.putString("MaNGV",nhanVien.getMaNGV());
                    bundle.putString("TenNGV", nhanVien.getTen());
                    bundle.putString("GioiTinh",nhanVien.getGioiTinh());
                    bundle.putString("SDT",nhanVien.getSDT());
                    bundle.putString("HinhAnh",nhanVien.getHinhAnh());
                    Intent i = new Intent(view.getContext(), ChiTietNGVActivity.class);
                    i.putExtra("data",bundle);
                    view.getContext().startActivity(i);
                }
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NhanVien nhanVien = this.arrNhanVien.get(position);
        holder.tvTenNGV.setText(nhanVien.getTen());
        holder.tvSDT.setText(nhanVien.getSDT());
        holder.tvDanhGia.setText("Đánh giá: "+nhanVien.getTenDG());
        Glide.with(context).load(nhanVien.getHinhAnh()).into(holder.anhNGV);
    }

    @Override
    public int getItemCount() {
        return arrNhanVien.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView anhNGV;
        TextView tvTenNGV,tvSDT,tvDanhGia;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            anhNGV = itemView.findViewById(R.id.anhNGV);
            tvTenNGV = itemView.findViewById(R.id.tvTenNGV);
            tvSDT = itemView.findViewById(R.id.tvSDT);
            tvDanhGia = itemView.findViewById(R.id.tvDanhGia);
        }
    }
}
