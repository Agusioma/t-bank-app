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

public class AccountsAdapter extends RecyclerView.Adapter<com.terrence.aluda.t_bank.adapters.AccountsAdapter.ViewHolder>{
        private Context context;
        //private ArrayList<AccountStatements> statementsArray;
        List<AccountStatements> statementsArray;

public AccountsAdapter(Context context,ArrayList<AccountStatements> statementsArray){
        this.context=context;
        this.statementsArray=statementsArray;
        }

@NonNull
@NotNull
@Override
public com.terrence.aluda.t_bank.adapters.AccountsAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent,int viewType){
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.account_list,parent,false);
        return new com.terrence.aluda.t_bank.adapters.AccountsAdapter.ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull @NotNull com.terrence.aluda.t_bank.adapters.AccountsAdapter.ViewHolder holder,int position){
        AccountStatements model=statementsArray.get(position);
        holder.trans_Type.setText(model.getTransType());
        holder.trans_ID.setText(model.getTransID());
        holder.trans_Date.setText(model.getTransDate());
        holder.trans_Amount.setText(model.getAmount());
        }

public int getItemCount(){
        return statementsArray.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView trans_Type;
    private TextView trans_ID;
    private TextView trans_Date;
    private TextView trans_Amount;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        trans_Type = itemView.findViewById(R.id.transaction_label);
        trans_ID = itemView.findViewById(R.id.transaction_ID);
        trans_Date = itemView.findViewById(R.id.transaction_date);
        trans_Amount = itemView.findViewById(R.id.transaction_amount);
    }
}
}
