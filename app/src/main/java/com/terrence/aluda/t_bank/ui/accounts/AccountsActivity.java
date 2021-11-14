package com.terrence.aluda.t_bank.ui.accounts;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.terrence.aluda.t_bank.R;
import com.terrence.aluda.t_bank.adapters.AccountsAdapter;
import com.terrence.aluda.t_bank.adapters.AccountsAdapter;
import com.terrence.aluda.t_bank.netrequests.AccountStatements;
import com.terrence.aluda.t_bank.retrofit.APIClient;
import com.terrence.aluda.t_bank.retrofit.APIInterface;
import com.terrence.aluda.t_bank.ui.accounts.AccountsActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.Locale;

public class AccountsActivity extends AppCompatActivity {
    private RecyclerView accRV;
    private ArrayList<AccountStatements> statementsArray;
    private SharedPreferences sharedPreferences;
    private String firstName, lastName, total, accNo;
    private TextView nameLbl, totalDisplay, accNoDisplay;
    private AccountsAdapter statAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);
        accRV = findViewById(R.id.accountsRV);
        nameLbl = findViewById(R.id.accNameLbl);
        totalDisplay = findViewById(R.id.accAmtLbl);
        accNoDisplay = findViewById(R.id.accNoActLbl);

        sharedPreferences = this.getSharedPreferences("MyTax", 0);
        firstName = sharedPreferences.getString("Name", "defaultValue").toUpperCase(Locale.ROOT);
        lastName = sharedPreferences.getString("Last", "defaultValue").toUpperCase(Locale.ROOT);
        total = sharedPreferences.getString("tot", "defaultValue");
        accNo = sharedPreferences.getString("natID", "defaultValue");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        accRV.setLayoutManager(linearLayoutManager);

        nameLbl.setText(firstName+" "+ lastName);
        totalDisplay.setText(" KES "+total);
        accNoDisplay.setText(accNo);
        statementsArray = new ArrayList<>();
        APIInterface apiInterface;
        final ProgressDialog progressDialog = new ProgressDialog(AccountsActivity.this);
        progressDialog.setMessage("Testing");
        progressDialog.show();
        statementsArray = new ArrayList<>();

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<ArrayList<AccountStatements>> call = apiInterface.getStatements();

        call.enqueue(new Callback<ArrayList<AccountStatements>>() {
            @Override
            public void onResponse(Call<ArrayList<AccountStatements>> call, Response<ArrayList<AccountStatements>> response) {
                statementsArray = response.body();
                progressDialog.dismiss();

                int i;
                for(i=0; i<6; i++){
                    statementsArray.get(i).setAmount(statementsArray.get(i).getAmount());
                    statementsArray.get(i).setTransDate(statementsArray.get(i).getTransDate());
                    statementsArray.get(i).setTransID(statementsArray.get(i).getTransID());
                    statementsArray.get(i).setTransType(statementsArray.get(i).getTransType());
                    i+=1;
                }

                statAdapter = new AccountsAdapter(getApplicationContext(),statementsArray);
                accRV.setAdapter(statAdapter);

            }

            @Override
            public void onFailure(Call<ArrayList<AccountStatements>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(AccountsActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });

    }
}