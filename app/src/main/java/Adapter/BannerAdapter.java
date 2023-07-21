package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appgiupviec.R;

import java.util.ArrayList;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.ViewhHolder> {
    private ArrayList<String> ImageURL = new ArrayList<>();
    private Context context;

    public BannerAdapter(Context context, ArrayList<String> imageURL) {
        this.ImageURL = imageURL;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewhHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_item,parent,false);
        return new ViewhHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewhHolder holder, int position) {
        Glide.with(context).asBitmap()
                .load(ImageURL.get(position%ImageURL.size()))
                .into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Banner",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ImageURL==null?0:Integer.MAX_VALUE;
    }

    public class ViewhHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public ViewhHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgBanner);

        }
    }
}
