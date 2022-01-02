package com.terrence.aluda.t_bank.adapters;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.terrence.aluda.t_bank.R;
import com.terrence.aluda.t_bank.models.borrow.BorrowModel;
import com.terrence.aluda.t_bank.ui.borrow.BorrowFragment;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BorrowAdapter extends RecyclerView.Adapter<BorrowAdapter.ViewHolder> {
    private BorrowFragment context;
    private ArrayList<BorrowModel> loanModelArrayList;

    public BorrowAdapter(BorrowFragment context, ArrayList<BorrowModel> loanModelArrayList) {
        this.context = context;
        this.loanModelArrayList = loanModelArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public BorrowAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.loan_list, parent, false);
        new MaterialAlertDialogBuilder(context.getActivity())
                .setTitle("Coming soon")
                .setMessage("The loan functionality is currently being worked on and will appear soon.")

                .setPositiveButton("OK, I got it", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .setCancelable(true)
                .show();
        return new BorrowAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BorrowAdapter.ViewHolder holder, int position) {
        BorrowModel model = loanModelArrayList.get(position);
        holder.our_image.setImageResource(model.getImage_id());
        holder.our_label.setText(model.getFirst_label());
    }

    public int getItemCount() {
        return loanModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView our_image;
        private TextView our_label;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            our_image = itemView.findViewById(R.id.imageViewLoan);
            our_label = itemView.findViewById(R.id.text_loan_list1);
        }
    }
}
