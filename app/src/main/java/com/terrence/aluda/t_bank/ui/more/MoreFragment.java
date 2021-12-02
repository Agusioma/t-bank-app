package com.terrence.aluda.t_bank.ui.more;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.terrence.aluda.t_bank.R;
import com.terrence.aluda.t_bank.adapters.MoreAdapter;
import com.terrence.aluda.t_bank.models.more.MoreModel;

import java.util.ArrayList;

public class MoreFragment extends Fragment {
    private RecyclerView moreRV;
    private ArrayList<MoreModel> moreModelArrayList;
    private TextView text_prof, text_prof1, text_prof2;
    private SharedPreferences sharedPreferences;
    private String loggedInCheck, firstname, lastname, email, natID, phonee, userPassword, regDate, phoneParam;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_more, container, false);
        moreRV = root.findViewById(R.id.moreRV);
        text_prof = root.findViewById(R.id.text_prof);
        text_prof1 = root.findViewById(R.id.text_prof1);
        text_prof2 = root.findViewById(R.id.text_prof2);

        sharedPreferences = getActivity().getSharedPreferences("MyTax", 0);
        firstname = sharedPreferences.getString("Name", "defaultValue");
        lastname = sharedPreferences.getString("Last", "defaultValue");
        phonee = sharedPreferences.getString("userPhone", "defaultValue");
        email = sharedPreferences.getString("emailAddress", "defaultValue");

        text_prof.setText(firstname+lastname);
        text_prof1.setText(email);
        text_prof2.setText(phonee);

        // here we have created new array list and added data to it.
        moreModelArrayList = new ArrayList<>();
        moreModelArrayList.add(new MoreModel("Security & Updates","Change your account details and password",R.drawable.ic_outline_security_24));
        moreModelArrayList.add(new MoreModel("Support","Email, call or find us on social media ",R.drawable.ic_outline_call_24));
        moreModelArrayList.add(new MoreModel("Sign out","",R.drawable.ic_outline_logout_24));

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