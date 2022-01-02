package com.terrence.aluda.t_bank.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.terrence.aluda.t_bank.R;
import com.terrence.aluda.t_bank.models.more.MoreModel;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<com.terrence.aluda.t_bank.adapters.ContactAdapter.ViewHolder> {
    private Context context;
    //private ArrayList<AccountStatements> contactsArray;
    List<MoreModel> contactsArray;

    public ContactAdapter(Context context, ArrayList<MoreModel> contactsArray) {
        this.context = context;
        this.contactsArray = contactsArray;
    }

    @NonNull
    @NotNull
    @Override
    public com.terrence.aluda.t_bank.adapters.ContactAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list, parent, false);
        return new com.terrence.aluda.t_bank.adapters.ContactAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull com.terrence.aluda.t_bank.adapters.ContactAdapter.ViewHolder holder, int position) {
        MoreModel model = contactsArray.get(position);
        holder.contactBadge.setImageResource(model.getImage_id());
        holder.contactLbl1.setText(model.getFirst_label());
        holder.contactLbl2.setText(model.getSecond_label());
    }

    public int getItemCount() {
        return contactsArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView contactLbl1;
        private TextView contactLbl2;
        private ImageView contactBadge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contactBadge = itemView.findViewById(R.id.contactBadge);
            contactLbl1 = itemView.findViewById(R.id.contactLbl1);
            contactLbl2 = itemView.findViewById(R.id.contactLbl2);
        }
    }
}
