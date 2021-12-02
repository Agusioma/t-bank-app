package com.terrence.aluda.t_bank.ui.more;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.terrence.aluda.t_bank.R;

public class UpdateActivity extends AppCompatActivity {
    private String loggedInCheck, firstname, lastname, email, natID, userPassword, phoneParam;
    private EditText firstnameEdit, secondnameEdit, emailEdit;
    private TextView firstnameDiscEdit, secondnameDiscEdit;
    private ProgressBar progressBarEdit;
    private Button btn_update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        firstnameEdit = findViewById(R.id.firstnameEdit);
        secondnameEdit = findViewById(R.id.secondnameEdit);
        emailEdit = findViewById(R.id.emailEdit);
        firstnameDiscEdit = findViewById(R.id.firstnameDiscEdit);
        secondnameDiscEdit = findViewById(R.id.secondnameDiscEdit);
        progressBarEdit = findViewById(R.id.progressBarEdit);

        firstnameDiscEdit.setVisibility(View.GONE);
        secondnameDiscEdit.setVisibility(View.GONE);
        progressBarEdit.setVisibility(View.GONE);


    }
}