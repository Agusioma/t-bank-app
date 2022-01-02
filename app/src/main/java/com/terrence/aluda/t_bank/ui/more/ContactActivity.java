package com.terrence.aluda.t_bank.ui.more;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.terrence.aluda.t_bank.R;
import com.terrence.aluda.t_bank.adapters.ContactAdapter;
import com.terrence.aluda.t_bank.adapters.StatementAdapter;
import com.terrence.aluda.t_bank.models.more.MoreModel;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {
    private ContactAdapter contactAdapter;
    private RecyclerView contactsRV;
    private ArrayList<MoreModel> contactsArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        contactsRV = findViewById(R.id.contactRV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        contactsRV.setLayoutManager(linearLayoutManager);
        contactsArray = new ArrayList<>();
        contactsArray = new ArrayList<>();
        contactsArray.add(new MoreModel("Call us","+254757153404",R.drawable.ic_outline_call_24));
        contactsArray.add(new MoreModel("Email us","contact@sacco.terrence-aluda.com",R.drawable.ic_baseline_email_24));
        contactsArray.add(new MoreModel("Visit our website","https://sacco.terrence-aluda.com",R.drawable.ic_outline_insert_link_24));
        contactsArray.add(new MoreModel("Contact the developer","https://contact.terrence-aluda.com",R.drawable.ic_baseline_developer_mode_24));

        contactAdapter = new ContactAdapter(getApplicationContext(), contactsArray);
        contactsRV.setAdapter(contactAdapter);
    }
}