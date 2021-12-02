package com.terrence.aluda.t_bank.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.terrence.aluda.t_bank.R;
import com.terrence.aluda.t_bank.models.transact.TransactModel;
import com.terrence.aluda.t_bank.ui.transaction.*;
import org.jetbrains.annotations.NotNull;;

import java.util.ArrayList;

public class TransactAdapter extends RecyclerView.Adapter<TransactAdapter.ViewHolder> {
    private TransactionFragment context;
    private ArrayList<TransactModel> transModelArrayList;

    public TransactAdapter(TransactionFragment context, ArrayList<TransactModel> transactModelArrayList) {
        this.context = context;
        this.transModelArrayList = transactModelArrayList;
    }
    @NonNull
    @NotNull
    @Override
    public TransactAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transact_list, parent, false);
        return new TransactAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TransactAdapter.ViewHolder holder, int position) {
        TransactModel model = transModelArrayList.get(position);
        holder.our_image.setImageResource(model.getImage_id());
        holder.our_label.setText(model.getFirst_label());
    }
    public int getItemCount() {
        return transModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        private ImageView our_image;
        private TextView our_label;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            our_image = itemView.findViewById(R.id.imageViewTrans);
            our_label = itemView.findViewById(R.id.text_trans_list1);
        }

        @Override
        public void onClick(View v) {

            if(getLayoutPosition()==0){
                Intent intent= new Intent(v.getContext(), DepositActivity.class);
                v.getContext().startActivity(intent);
            }else if(getLayoutPosition()==1){
                Intent intent= new Intent(v.getContext(), WithdrawActivity.class);
                v.getContext().startActivity(intent);
            }else if(getLayoutPosition()==2){
                //Intent intent= new Intent(v.getContext(), SendActivity.class);
                //v.getContext().startActivity(intent);
                Intent intent= new Intent(v.getContext(), StatementActivity.class);
                v.getContext().startActivity(intent);
            }else if(getLayoutPosition()==3){
                Intent intent= new Intent(v.getContext(), StatementActivity.class);
                v.getContext().startActivity(intent);
            }
        }
    }
}
