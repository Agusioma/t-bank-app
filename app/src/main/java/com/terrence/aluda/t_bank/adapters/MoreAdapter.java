package com.terrence.aluda.t_bank.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.terrence.aluda.t_bank.models.more.MoreModel;
import com.terrence.aluda.t_bank.ui.login.LoginActivity;
import com.terrence.aluda.t_bank.ui.login.TestActivity;
import com.terrence.aluda.t_bank.ui.more.MoreFragment;
import com.terrence.aluda.t_bank.ui.more.UpdateActivity;
import com.terrence.aluda.t_bank.ui.transaction.DepositActivity;
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
        holder.firstLabel.setText(model.getFirst_label());
        holder.secondLabel.setText(model.getSecond_label());
    }

    @Override
    public int getItemCount() {
        return moreModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        private ImageView imagee;
        private TextView firstLabel;
        private TextView secondLabel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imagee = itemView.findViewById(R.id.imageView1);
            firstLabel = itemView.findViewById(R.id.text_prof);
            secondLabel = itemView.findViewById(R.id.text_prof1);
        }

        @Override
        public void onClick(View v) {
            if(getLayoutPosition()==0){
                Intent intent= new Intent(v.getContext(), UpdateActivity.class);
                v.getContext().startActivity(intent);
            }else if(getLayoutPosition()==1){
               // Intent intent= new Intent(v.getContext(), LoginActivity.class);
                //v.getContext().startActivity(intent);
            }if(getLayoutPosition()==2){
                Intent intent= new Intent(v.getContext(), LoginActivity.class);
                v.getContext().startActivity(intent);
            }
        }
    }
}