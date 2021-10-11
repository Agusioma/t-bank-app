package com.terrence.aluda.t_bank.ui.transaction;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.terrence.aluda.t_bank.R;
import com.terrence.aluda.t_bank.adapters.StatementAdapter;
import com.terrence.aluda.t_bank.models.transact.StatementModel;

import java.util.ArrayList;

public class StatementActivity extends AppCompatActivity {
    private RecyclerView statRV;
    private ArrayList<StatementModel> statementModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statement);
        statRV = findViewById(R.id.statRV);
        statementModelArrayList = new ArrayList<>();
        statementModelArrayList.add(new StatementModel("4E43DJTF", "DEPOSIT","06 Oct 2021", "14207.00"));
        statementModelArrayList.add(new StatementModel("4E43DJTF", "DEPOSIT","06 Oct 2021", "14207.00"));
        statementModelArrayList.add(new StatementModel("4E43DJTF", "DEPOSIT","06 Oct 2021", "14207.00"));
        statementModelArrayList.add(new StatementModel("4E43DJTF", "DEPOSIT","06 Oct 2021", "14207.00"));
        statementModelArrayList.add(new StatementModel("4E43DJTF", "DEPOSIT","06 Oct 2021", "14207.00"));
        statementModelArrayList.add(new StatementModel("4E43DJTF", "DEPOSIT","06 Oct 2021", "14207.00"));
        statementModelArrayList.add(new StatementModel("4E43DJTF", "DEPOSIT","06 Oct 2021", "14207.00"));
        statementModelArrayList.add(new StatementModel("4E43DJTF", "DEPOSIT","06 Oct 2021", "14207.00"));
        statementModelArrayList.add(new StatementModel("4E43DJTF", "DEPOSIT","06 Oct 2021", "14207.00"));
        statementModelArrayList.add(new StatementModel("4E43DJTF", "DEPOSIT","06 Oct 2021", "14207.00"));
        statementModelArrayList.add(new StatementModel("4E43DJTF", "DEPOSIT","06 Oct 2021", "14207.00"));
        statementModelArrayList.add(new StatementModel("4E43DJTF", "DEPOSIT","06 Oct 2021", "14207.00"));


        StatementAdapter statAdapter = new StatementAdapter(this, statementModelArrayList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        statRV.setLayoutManager(linearLayoutManager);
        statRV.setAdapter(statAdapter);
    }
}