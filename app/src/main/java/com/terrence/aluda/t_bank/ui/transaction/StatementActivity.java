package com.terrence.aluda.t_bank.ui.transaction;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.terrence.aluda.t_bank.MainActivity;
import com.terrence.aluda.t_bank.R;
import com.terrence.aluda.t_bank.adapters.StatementAdapter;
import com.terrence.aluda.t_bank.models.transact.StatementModel;
import com.terrence.aluda.t_bank.netrequests.AccountStatements;
import com.terrence.aluda.t_bank.retrofit.APIClient;
import com.terrence.aluda.t_bank.retrofit.APIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StatementActivity extends AppCompatActivity {
    private RecyclerView statRV;
    private ArrayList<AccountStatements> statementsArray;
    private SharedPreferences sharedPreferences;
    private String firstName, lastName, total;
    private TextView nameLbl, totalDisplay;
    private StatementAdapter statAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statement);
        statRV = findViewById(R.id.statRV);
        nameLbl = findViewById(R.id.text_transact);
        totalDisplay = findViewById(R.id.totalDisplay);
        sharedPreferences = this.getSharedPreferences("MyTax", 0);
        firstName = sharedPreferences.getString("Name", "defaultValue").toUpperCase(Locale.ROOT);
        lastName = sharedPreferences.getString("Last", "defaultValue").toUpperCase(Locale.ROOT);
        total = sharedPreferences.getString("tot", "defaultValue");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        statRV.setLayoutManager(linearLayoutManager);

        nameLbl.setText(firstName+" "+ lastName);
        totalDisplay.setText(total +" KES");
        statementsArray = new ArrayList<>();
        APIInterface apiInterface;
        final ProgressDialog progressDialog = new ProgressDialog(StatementActivity.this);
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
                for(i=0; i<statementsArray.size(); i++){
                    statementsArray.get(i).setAmount(statementsArray.get(0).getAmount());
                    statementsArray.get(i).setTransDate(statementsArray.get(0).getTransDate());
                    statementsArray.get(i).setTransID(statementsArray.get(0).getTransID());
                    statementsArray.get(i).setTransType(statementsArray.get(0).getTransType());
                    i+=1;
                }

                statAdapter = new StatementAdapter(getApplicationContext(),statementsArray);
                statRV.setAdapter(statAdapter);

            }

            @Override
            public void onFailure(Call<ArrayList<AccountStatements>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(StatementActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });

    }
}