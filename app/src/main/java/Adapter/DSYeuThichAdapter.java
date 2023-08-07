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
import com.example.appgiupviec.Model.NhanVien;
import com.example.appgiupviec.R;

import java.util.ArrayList;

public class DSYeuThichAdapter extends RecyclerView.Adapter<DSYeuThichAdapter.ViewHolder>{
    ArrayList<NhanVien> arrYeuThich;
    Context context;

    public DSYeuThichAdapter( Context context,ArrayList<NhanVien> arrYeuThich) {
        this.arrYeuThich = arrYeuThich;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_yeuthich,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                if(position!=RecyclerView.NO_POSITION){
                    NhanVien nhanVien = arrYeuThich.get(position);
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
        NhanVien nhanvien = arrYeuThich.get(position);
        holder.TenNhanVien.setText(nhanvien.getTen());
        Glide.with(context).load(nhanvien.getHinhAnh()).into(holder.AnhNhanVien);
    }

    @Override
    public int getItemCount() {

        return arrYeuThich.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView AnhNhanVien;
        TextView TenNhanVien;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            AnhNhanVien = itemView.findViewById(R.id.imgAnhNhanVien);
            TenNhanVien = itemView.findViewById(R.id.TenNGV);
        }
    }
}
