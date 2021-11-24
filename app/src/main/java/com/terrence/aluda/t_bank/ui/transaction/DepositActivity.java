package com.terrence.aluda.t_bank.ui.transaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.terrence.aluda.t_bank.R;

import java.util.Locale;

public class DepositActivity extends AppCompatActivity {
    private EditText our_edit;
    private TextView nameDisplay, balanceDisplay;
    private SharedPreferences sharedPreferences;
    private String firstName, lastName, total;
    private ProgressBar ourBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_deposit);
        nameDisplay = findViewById(R.id.name_labelTxt);
        balanceDisplay = findViewById(R.id.depoAccAmount);
        ourBar = findViewById(R.id.progressBarDepo);

        ourBar.setVisibility(View.GONE);

        sharedPreferences = this.getSharedPreferences("MyTax", 0);
        firstName = sharedPreferences.getString("Name", "defaultValue").toUpperCase(Locale.ROOT);
        lastName = sharedPreferences.getString("Last", "defaultValue").toUpperCase(Locale.ROOT);
        total = sharedPreferences.getString("tot", "defaultValue");

        nameDisplay.setText(firstName+" "+lastName);
        balanceDisplay.setText(total+" KES");


    }

}