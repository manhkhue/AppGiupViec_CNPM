package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
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
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TinTuc tinTuc = arrTinTuc.get(position);
        if(arrTinTuc.size()>0){
            holder.TieuDe.setText(tinTuc.getTieuDe());
            Glide.with(context).load(tinTuc.getHinhAnh()).into(holder.AnhTinTuc);
        }
    }



    @Override
    public int getItemCount() {
        return arrTinTuc.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView AnhTinTuc;
        TextView TieuDe;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            AnhTinTuc = itemView.findViewById(R.id.imgAnhTinTuc);
            TieuDe = itemView.findViewById(R.id.TieuDe);
        }
    }
}
