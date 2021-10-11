package com.terrence.aluda.t_bank.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.terrence.aluda.t_bank.R;
import com.terrence.aluda.t_bank.models.transact.StatementModel;
import com.terrence.aluda.t_bank.ui.transaction.StatementActivity;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class StatementAdapter extends RecyclerView.Adapter<com.terrence.aluda.t_bank.adapters.StatementAdapter.ViewHolder> {
    private StatementActivity context;
    private ArrayList<StatementModel> statementModelArrayList;

    public StatementAdapter(StatementActivity context, ArrayList<StatementModel> statementModelArrayList) {
        this.context = context;
        this.statementModelArrayList = statementModelArrayList;
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
        StatementModel model = statementModelArrayList.get(position);
        holder.trans_Type.setText(model.getTrans_type());
        holder.trans_ID.setText(model.getTrans_id());
        holder.trans_Date.setText(model.getTrans_date());
        holder.trans_Amount.setText(model.getAmount());
    }

    public int getItemCount() {
        return statementModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView trans_Type;
        private TextView trans_ID;
        private TextView trans_Date;
        private TextView trans_Amount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            trans_Type = itemView.findViewById(R.id.text_transType);
            trans_ID = itemView.findViewById(R.id.text_transID);
            trans_Date = itemView.findViewById(R.id.text_transDate);
            trans_Amount = itemView.findViewById(R.id.text_transAmount);
        }
    }
}
