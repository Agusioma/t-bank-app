package com.terrence.aluda.t_bank.ui.borrow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.terrence.aluda.t_bank.R;
import com.terrence.aluda.t_bank.adapters.BorrowAdapter;
import com.terrence.aluda.t_bank.models.borrow.BorrowModel;

import java.util.ArrayList;

public class BorrowFragment extends Fragment {

    private RecyclerView loanRV;
    private ArrayList<BorrowModel> loanModelArrayList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_borrow, container, false);
        loanRV = root.findViewById(R.id.loanRV);

        loanModelArrayList = new ArrayList<>();
        loanModelArrayList.add(new BorrowModel("Get Loan", R.drawable.ic_outline_arrow_circle_down_24));
        loanModelArrayList.add(new BorrowModel("Pay Loan", R.drawable.ic_outline_arrow_circle_up_24));

        BorrowAdapter loanAdapter = new BorrowAdapter(this, loanModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        loanRV.setLayoutManager(linearLayoutManager);
        loanRV.setAdapter(loanAdapter);
        return root;
    }
}