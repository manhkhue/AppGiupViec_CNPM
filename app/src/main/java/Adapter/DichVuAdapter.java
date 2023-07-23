package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appgiupviec.Model.DichVu;
import com.example.appgiupviec.R;

import java.util.ArrayList;

public class DichVuAdapter extends RecyclerView.Adapter<DichVuAdapter.ViewHolder> {
    Context context;
    ArrayList<DichVu> arrDichVu;

    public DichVuAdapter(Context context, ArrayList<DichVu> arrDichVu) {
        this.context = context;
        this.arrDichVu = arrDichVu;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dichvu,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DichVu dichVu = this.arrDichVu.get(position);
        if(arrDichVu.size()>0){
            holder.tvTenDichVu.setText(dichVu.getTenDichVu());
            Glide.with(context).load(dichVu.getImageUrl()).into(holder.iconDichVu);

            holder.iconDichVu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,holder.tvTenDichVu.getText(),Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return arrDichVu.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageButton iconDichVu;
        TextView tvTenDichVu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconDichVu = itemView.findViewById(R.id.iconDichVu);
            tvTenDichVu = itemView.findViewById(R.id.tenDichVu);

            itemView.setOnClickListener(view -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    DichVu dichVu = arrDichVu.get(position);


                }
            });

        }
    }
}
