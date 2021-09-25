package com.terrence.aluda.t_bank.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.terrence.aluda.t_bank.models.more.MoreModel;
import com.terrence.aluda.t_bank.ui.more.MoreFragment;
import org.jetbrains.annotations.NotNull;

import com.terrence.aluda.t_bank.R;

import java.util.ArrayList;
public class MoreAdapter extends RecyclerView.Adapter<MoreAdapter.ViewHolder> {
    private MoreFragment context;
    private ArrayList<MoreModel> moreModelArrayList;

    public MoreAdapter(MoreFragment context, ArrayList<MoreModel> moreModelArrayList) {
        this.context = context;
        this.moreModelArrayList = moreModelArrayList;
    }
    @NonNull
    @NotNull
    @Override
    public MoreAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.more_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MoreAdapter.ViewHolder holder, int position) {
        MoreModel model = moreModelArrayList.get(position);
        holder.imagee.setImageResource(model.getImage_id());
    }

    @Override
    public int getItemCount() {
        return moreModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imagee;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagee = itemView.findViewById(R.id.imageView1);
        }
    }
}