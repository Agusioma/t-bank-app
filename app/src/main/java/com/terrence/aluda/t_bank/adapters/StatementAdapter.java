package com.terrence.aluda.t_bank.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.terrence.aluda.t_bank.R;
import com.terrence.aluda.t_bank.netrequests.AccountStatements;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class StatementAdapter extends RecyclerView.Adapter<com.terrence.aluda.t_bank.adapters.StatementAdapter.ViewHolder> {
    private Context context;
    //private ArrayList<AccountStatements> statementsArray;
    List<AccountStatements> statementsArray;

    public StatementAdapter(Context context, ArrayList<AccountStatements> statementsArray) {
        this.context = context;
        this.statementsArray = statementsArray;
    }

    @NonNull
    @NotNull
    @Override
    public com.terrence.aluda.t_bank.adapters.StatementAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.statement_list, parent, false);
        return new com.terrence.aluda.t_bank.adapters.StatementAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull com.terrence.aluda.t_bank.adapters.StatementAdapter.ViewHolder holder, int position) {
        AccountStatements model = statementsArray.get(position);
        holder.trans_Type.setText(model.getTransType());
        holder.trans_ID.setText(model.getTransID());
        holder.trans_Date.setText(model.getTransDate());
        holder.trans_Amount.setText(model.getAmount());
    }

    public int getItemCount() {
        return statementsArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView trans_Type;
        private TextView trans_ID;
        private TextView trans_Date;
        private TextView trans_Amount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            trans_Type = itemView.findViewById(R.id.acc_trans_type);
            trans_ID = itemView.findViewById(R.id.acc_trans_date);
            trans_Date = itemView.findViewById(R.id.text_transDate);
            trans_Amount = itemView.findViewById(R.id.text_transAmount);
        }
    }
}
