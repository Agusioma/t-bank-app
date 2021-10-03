package com.terrence.aluda.t_bank.ui.transaction;

import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.terrence.aluda.t_bank.R;

public class DepositActivity extends AppCompatActivity {
private EditText our_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_deposit);
    }

}