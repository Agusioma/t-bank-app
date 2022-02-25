package com.terrence.aluda.t_bank.ui.transaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.terrence.aluda.t_bank.MainActivity;
import com.terrence.aluda.t_bank.R;
import com.terrence.aluda.t_bank.SignUp;
import com.terrence.aluda.t_bank.netrequests.LoginTest;
import com.terrence.aluda.t_bank.retrofit.APIClient;
import com.terrence.aluda.t_bank.retrofit.APIInterface;
import com.terrence.aluda.t_bank.ui.login.LoginActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DepositActivity extends AppCompatActivity {
    private EditText our_edit;
    private TextView nameDisplay, balanceDisplay;
    private SharedPreferences sharedPreferences;
    private String firstName, lastName, total;
    private ProgressBar ourBar;
    private Button btn_depo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_deposit);
        nameDisplay = findViewById(R.id.name_labelTxt);
        balanceDisplay = findViewById(R.id.depoAccAmount);
        ourBar = findViewById(R.id.progressBarDepo);
        btn_depo = findViewById(R.id.btn_depo);

        ourBar.setVisibility(View.GONE);

        sharedPreferences = this.getSharedPreferences("MyTax", 0);
        firstName = sharedPreferences.getString("Name", "defaultValue").toUpperCase(Locale.ROOT);
        lastName = sharedPreferences.getString("Last", "defaultValue").toUpperCase(Locale.ROOT);
        total = sharedPreferences.getString("tot", "defaultValue");

        nameDisplay.setText(firstName+" "+lastName);
        balanceDisplay.setText(total+" KES");

        btn_depo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    APIInterface apiInterface;

                    btn_depo.setVisibility(View.GONE);
                    ourBar.setVisibility(View.VISIBLE);
                    passwordParam = editPassword.getText().toString();

                    apiInterface = APIClient.getClient().create(APIInterface.class);
                    Call<List<LoginTest>> call = apiInterface.doAuthenticate(phoneParam, passwordParam);

                    call.enqueue(new Callback<List<LoginTest>>() {
                        @Override
                        public void onResponse(Call<List<LoginTest>> call, Response<List<LoginTest>> response) {
                            btn_depo.setVisibility(View.VISIBLE);
                            ourBar.setVisibility(View.GONE);

                        }

                        @Override
                        public void onFailure(Call<List<LoginTest>> call, Throwable t) {
                            btn_depo.setVisibility(View.VISIBLE);
                            ourBar.setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
                            call.cancel();
                        }
                    });
                } catch (Exception e) {
                    btn_depo.setVisibility(View.VISIBLE);
                    ourBar.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                }
                /*
                *
                * new MaterialAlertDialogBuilder(DepositActivity.this)
                        .setTitle("Coming soon")
                        .setMessage("This functionality is currently being worked on. For now, please head on to the web version(https://sacco.terrence-aluda.com) to access it.")

                        .setPositiveButton("OK, I got it", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                            }
                        })
                        .setCancelable(true)
                        .show();*/
            }
        });

    }

}