package com.terrence.aluda.t_bank.ui.more;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.terrence.aluda.t_bank.R;
import com.terrence.aluda.t_bank.adapters.MoreAdapter;
import com.terrence.aluda.t_bank.models.more.MoreModel;

import java.util.ArrayList;

public class MoreFragment extends Fragment {
    private RecyclerView moreRV;
    private ArrayList<MoreModel> moreModelArrayList;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_more, container, false);
        moreRV = root.findViewById(R.id.moreRV);

        // here we have created new array list and added data to it.
        moreModelArrayList = new ArrayList<>();
        moreModelArrayList.add(new MoreModel(R.drawable.ic_baseline_call_24));
        moreModelArrayList.add(new MoreModel(R.drawable.ic_baseline_security_24));
        moreModelArrayList.add(new MoreModel(R.drawable.ic_baseline_logout_24));

        // we are initializing our adapter class and passing our arraylist to it.
       MoreAdapter moreeAdapter = new MoreAdapter(this, moreModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        moreRV.setLayoutManager(linearLayoutManager);
        moreRV.setAdapter(moreeAdapter);
        return root;
    }
}