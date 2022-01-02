package com.terrence.aluda.t_bank.ui.transaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.terrence.aluda.t_bank.R;
import com.terrence.aluda.t_bank.SignUp;
import com.terrence.aluda.t_bank.ui.login.LoginActivity;

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
                new MaterialAlertDialogBuilder(DepositActivity.this)
                        .setTitle("Coming soon")
                        .setMessage("This functionality is currently being worked on. For now, please head on to the web version(https://sacco.terrence-aluda.com) to access it.")

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