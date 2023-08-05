package Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appgiupviec.CT_ThongBaoActivity;
import com.example.appgiupviec.CT_TinTucActivity;
import com.example.appgiupviec.Model.ThongBao;
import com.example.appgiupviec.Model.TinTuc;
import com.example.appgiupviec.R;
import com.example.appgiupviec.ThongBaoFragment;

import java.util.ArrayList;

public class ThongBaoAdapter extends RecyclerView.Adapter<ThongBaoAdapter.ViewHolder> {
    ArrayList<ThongBao> arrThongBao;
    private Context context;

    public ThongBaoAdapter(Context context,ArrayList<ThongBao> arrThongBao) {
        this.arrThongBao = arrThongBao;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thongbao,null);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                if(position!=RecyclerView.NO_POSITION){
                    ThongBao thongBao = arrThongBao.get(position);
                    Bundle bundle =new Bundle();
                    bundle.putString("TieuDe", thongBao.getTieuDe());
                    bundle.putString("NoiDung",thongBao.getNoiDung());
                    bundle.putString("linkAnh",thongBao.getHinhAnh());
                    Intent i = new Intent(view.getContext(), CT_ThongBaoActivity.class);
                    i.putExtra("data",bundle);
                    view.getContext().startActivity(i);
                }
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ThongBao thongBao = this.arrThongBao.get(position);
        holder.tvNoiDung.setText(thongBao.getNoiDung());
        holder.tvTieuDe.setText(thongBao.getTieuDe());
    }

    @Override
    public int getItemCount() {
        return arrThongBao.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTieuDe;
        TextView tvNoiDung;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTieuDe = itemView.findViewById(R.id.tvTieuDeThongBao);
            tvNoiDung = itemView.findViewById(R.id.NoiDungThongBao);
        }
    }
}
