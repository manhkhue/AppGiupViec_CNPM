package Adapter;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appgiupviec.Model.ThoiLuong;
import com.example.appgiupviec.R;

import java.util.ArrayList;

public class ThoiLuongAdapter extends RecyclerView.Adapter<ThoiLuongAdapter.ThoiLuongViewHolder> {
    private ArrayList<ThoiLuong> thoiLuongList;
    private OnItemClickListener itemClickListener;
    private int selectedItemPosition = RecyclerView.NO_POSITION;

    public interface OnItemClickListener {
        void onItemClick(ThoiLuong thoiLuong);
    }

    public ThoiLuongAdapter(ArrayList<ThoiLuong> thoiLuongList, OnItemClickListener itemClickListener) {
        this.thoiLuongList = thoiLuongList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ThoiLuongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thoi_luong, parent, false);
        return new ThoiLuongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThoiLuongViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ThoiLuong thoiLuong = thoiLuongList.get(position);
        holder.txtThoiLuong.setText(thoiLuong.getThoiLuong());
        holder.tvTongGia.setText(thoiLuong.getTongGia());
        holder.txtThoiLuong.setTypeface(null, position == selectedItemPosition ? Typeface.BOLD : Typeface.NORMAL);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    // Đánh dấu mục thời lượng được chọn
                    selectedItemPosition = position;
                    notifyDataSetChanged();
                    itemClickListener.onItemClick(thoiLuong);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return thoiLuongList.size();
    }

    public class ThoiLuongViewHolder extends RecyclerView.ViewHolder {
        TextView txtThoiLuong;
        TextView tvTongGia;
        public ThoiLuongViewHolder(@NonNull View itemView) {
            super(itemView);
            txtThoiLuong = itemView.findViewById(R.id.tvThoiLuong);
            tvTongGia = itemView.findViewById(R.id.tvTongGia);
        }
    }
}
