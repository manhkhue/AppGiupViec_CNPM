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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appgiupviec.CT_TinTucActivity;
import com.example.appgiupviec.DatAppActivity;
import com.example.appgiupviec.Model.DichVu;
import com.example.appgiupviec.Model.TinTuc;
import com.example.appgiupviec.R;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class TinTucAdapter extends RecyclerView.Adapter<TinTucAdapter.ViewHolder>{
    private Context context;
    private ArrayList<TinTuc> arrTinTuc;

    public TinTucAdapter(Context context, ArrayList<TinTuc> arrTinTuc) {
        this.context = context;
        this.arrTinTuc = arrTinTuc;
    }

    @NonNull
    @Override
    public TinTucAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tintuc,null);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                if(position!=RecyclerView.NO_POSITION){
                    TinTuc tinTuc = arrTinTuc.get(position);
                    Bundle bundle =new Bundle();
                    bundle.putString("TieuDe", tinTuc.getTieuDe());
                    bundle.putString("NoiDung",tinTuc.getNoiDung());
                    bundle.putString("linkAnh",tinTuc.getHinhAnh());
                    Intent i = new Intent(view.getContext(), CT_TinTucActivity.class);
                    i.putExtra("data",bundle);
                    view.getContext().startActivity(i);
                }
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TinTuc tinTuc = arrTinTuc.get(position);
        if(arrTinTuc.size()>0){
            holder.TieuDe.setText(tinTuc.getTieuDe());
            holder.NoiDung.setText(tinTuc.getNoiDung());
            Glide.with(context).load(tinTuc.getHinhAnh()).into(holder.AnhTinTuc);
        }
    }



    @Override
    public int getItemCount() {
        return arrTinTuc.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView AnhTinTuc;
        TextView TieuDe,NoiDung;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            AnhTinTuc = itemView.findViewById(R.id.imgAnhTinTuc);
            TieuDe = itemView.findViewById(R.id.TieuDe);
            NoiDung = itemView.findViewById(R.id.NoiDung);
        }
    }
}
