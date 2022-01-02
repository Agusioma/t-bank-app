package com.terrence.aluda.t_bank.ui.accounts;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.terrence.aluda.t_bank.R;
import com.terrence.aluda.t_bank.adapters.AccountsAdapter;
import com.terrence.aluda.t_bank.adapters.AccountsAdapter;
import com.terrence.aluda.t_bank.netrequests.AccountStatements;
import com.terrence.aluda.t_bank.retrofit.APIClient;
import com.terrence.aluda.t_bank.retrofit.APIInterface;
import com.terrence.aluda.t_bank.ui.accounts.AccountsActivity;
import com.terrence.aluda.t_bank.ui.transaction.DepositActivity;
import com.terrence.aluda.t_bank.ui.transaction.StatementActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.Locale;

public class AccountsActivity extends AppCompatActivity {
    private RecyclerView accRV;
    private ArrayList<AccountStatements> statementsArray;
    private SharedPreferences sharedPreferences;
    private String firstName, lastName, total, accNo, natID;
    private TextView nameLbl, totalDisplay, accNoDisplay, acctsLoadingTxt;
    private AccountsAdapter statAdapter;
    private Button openTrans, btnD, btnW;
    private ProgressBar accountsPg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);
        accRV = findViewById(R.id.accountsRV);
        nameLbl = findViewById(R.id.accNameLbl);
        totalDisplay = findViewById(R.id.accAmtLbl);
        accNoDisplay = findViewById(R.id.accNoActLbl);
        openTrans = findViewById(R.id.btnViewMore);
        acctsLoadingTxt = findViewById(R.id.acctsLoadingTxt);
        accountsPg = findViewById(R.id.accountsPg);
        btnD = findViewById(R.id.btnD);
        btnW = findViewById(R.id.btnW);

        accountsPg.setVisibility(View.GONE);
        acctsLoadingTxt.setVisibility(View.GONE);
        openTrans.setVisibility(View.GONE);

        sharedPreferences = this.getSharedPreferences("MyTax", 0);
        firstName = sharedPreferences.getString("Name", "defaultValue").toUpperCase(Locale.ROOT);
        lastName = sharedPreferences.getString("Last", "defaultValue").toUpperCase(Locale.ROOT);
        total = sharedPreferences.getString("tot", "defaultValue");
        accNo = sharedPreferences.getString("natID", "defaultValue");
        natID = sharedPreferences.getString("natID", "defaultValue");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        accRV.setLayoutManager(linearLayoutManager);

        nameLbl.setText(firstName + " " + lastName);
        totalDisplay.setText(" KES " + total);
        accNoDisplay.setText(accNo);
        statementsArray = new ArrayList<>();
        APIInterface apiInterface;
        statementsArray = new ArrayList<>();

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<ArrayList<AccountStatements>> call = apiInterface.getStatPreview(natID);
        accountsPg.setVisibility(View.VISIBLE);
        acctsLoadingTxt.setVisibility(View.VISIBLE);
        openTrans.setVisibility(View.GONE);
        call.enqueue(new Callback<ArrayList<AccountStatements>>() {
            @Override
            public void onResponse(Call<ArrayList<AccountStatements>> call, Response<ArrayList<AccountStatements>> response) {
                statementsArray = response.body();
                accountsPg.setVisibility(View.GONE);
                acctsLoadingTxt.setVisibility(View.GONE);
                openTrans.setVisibility(View.VISIBLE);
                int i;
                for (i = 0; i < statementsArray.size(); i++) {
                    statementsArray.get(i).setAmount(statementsArray.get(i).getAmount());
                    statementsArray.get(i).setTransDate(statementsArray.get(i).getTransDate());
                    statementsArray.get(i).setTransID(statementsArray.get(i).getTransID());
                    statementsArray.get(i).setTransType(statementsArray.get(i).getTransType());
                    i += 1;
                }

                statAdapter = new AccountsAdapter(getApplicationContext(), statementsArray);
                accRV.setAdapter(statAdapter);

            }

            @Override
            public void onFailure(Call<ArrayList<AccountStatements>> call, Throwable t) {
                accountsPg.setVisibility(View.GONE);
                acctsLoadingTxt.setVisibility(View.GONE);
                openTrans.setVisibility(View.VISIBLE);
                Toast.makeText(AccountsActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });
        openTrans.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AccountsActivity.this, StatementActivity.class);
                startActivity(intent);
            }
        });
        btnD.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AccountsActivity.this, DepositActivity.class);
                startActivity(intent);
            }
        });
        btnW.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new MaterialAlertDialogBuilder(AccountsActivity.this)
                        .setTitle("Coming soon")
                        .setMessage("This functionality is currently being worked on.")

                        .setPositiveButton("OK, I got it", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        .setCancelable(true)
                        .show();
            }
        });
    }
}