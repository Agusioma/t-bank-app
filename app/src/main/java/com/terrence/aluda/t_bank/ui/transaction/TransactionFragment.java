package com.terrence.aluda.t_bank.ui.transaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.terrence.aluda.t_bank.R;
import com.terrence.aluda.t_bank.adapters.TransactAdapter;
import com.terrence.aluda.t_bank.models.transact.TransactModel;

import java.util.ArrayList;

public class TransactionFragment extends Fragment {
    private RecyclerView transRV;
    private ArrayList<TransactModel> transModelArrayList;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_transact, container, false);
        transRV = root.findViewById(R.id.transRV);

        transModelArrayList = new ArrayList<>();
        transModelArrayList.add(new TransactModel("Deposit", R.drawable.ic_transact_credit_card_24));
        transModelArrayList.add(new TransactModel("Withdraw", R.drawable.ic_outline_point_of_sale_24));
        transModelArrayList.add(new TransactModel("Send Money", R.drawable.ic_outline_send_to_mobile_24));

            TransactAdapter transAdapter = new TransactAdapter(this, transModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        transRV.setLayoutManager(linearLayoutManager);
        transRV.setAdapter(transAdapter);
        
        return root;
    }
}