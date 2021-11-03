package com.terrence.aluda.t_bank.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.terrence.aluda.t_bank.MainActivity;
import com.terrence.aluda.t_bank.R;
import com.terrence.aluda.t_bank.adapters.HomeAdapter;
import com.terrence.aluda.t_bank.models.home.HomeModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView courseRV;
    private MainActivity testActivity;
    // Arraylist for storing data
    private String firstname, lastname, natID, userPassword, regDate;
    private String nameTest;
    private ArrayList<HomeModel> courseModelArrayList;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        courseRV = root.findViewById(R.id.homeRV);
        //thisActivity = new MainActivity();
        courseModelArrayList = new ArrayList<>();
        courseModelArrayList.add(new HomeModel("KES"));

        // we are initializing our adapter class and passing our arraylist to it.
        HomeAdapter courseAdapter = new HomeAdapter(this, courseModelArrayList);
        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        courseRV.setLayoutManager(linearLayoutManager);
        courseRV.setAdapter(courseAdapter);
        return root;

    }




}