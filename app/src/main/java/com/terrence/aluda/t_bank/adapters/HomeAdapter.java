package com.terrence.aluda.t_bank.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.terrence.aluda.t_bank.models.home.HomeModel;
import com.terrence.aluda.t_bank.ui.home.HomeFragment;
import org.jetbrains.annotations.NotNull;

import com.terrence.aluda.t_bank.R;

import java.util.ArrayList;
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private HomeFragment context;
    private ArrayList<HomeModel> courseModelArrayList;

    public HomeAdapter(HomeFragment context, ArrayList<HomeModel> courseModelArrayList) {
        this.context = context;
        this.courseModelArrayList = courseModelArrayList;
    }
    @NonNull
    @NotNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_cards, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull @NotNull HomeAdapter.ViewHolder holder, int position) {
        HomeModel model = courseModelArrayList.get(position);
        holder.courseNameTV.setText(model.getCourse_name());
    }

    @Override
    public int getItemCount() {
        return courseModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView courseNameTV;
        private CardView cvt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseNameTV = itemView.findViewById(R.id.text_name);
            cvt = itemView.findViewById(R.id.our_card);
        }
    }
}
