package com.terrence.aluda.t_bank.ui.more;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.terrence.aluda.t_bank.R;

public class UpdatePwdActivity extends AppCompatActivity {

    private EditText currentPwd, firstPwd, confirmPwd;
    private TextView currentDiscPwd, firstDiscPwd, confirmDiscPwd;
    private ProgressBar progressBarPwd;
    private Button btn_Pwd;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pwd);
        currentPwd = findViewById(R.id.currentPwd);
        firstPwd = findViewById(R.id.firstPwd);
        confirmPwd = findViewById(R.id.confirmPwd);
        currentDiscPwd = findViewById(R.id.currentDiscPwd);
        firstDiscPwd = findViewById(R.id.firstDiscPwd);
        progressBarPwd = findViewById(R.id.progressBarPwd);
        confirmDiscPwd = findViewById(R.id.confirmDiscPwd);
        btn_Pwd = findViewById(R.id.btn_Pwd);

        firstPwd.requestFocus();

        currentDiscPwd.setVisibility(View.GONE);
        firstDiscPwd.setVisibility(View.GONE);
        confirmDiscPwd.setVisibility(View.GONE);
        progressBarPwd.setVisibility(View.GONE);
    }
}