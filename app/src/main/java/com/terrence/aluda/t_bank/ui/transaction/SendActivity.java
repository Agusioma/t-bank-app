package com.terrence.aluda.t_bank.ui.transaction;

import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.terrence.aluda.t_bank.R;

public class SendActivity extends AppCompatActivity {
    private EditText editDefault;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
    editDefault = findViewById(R.id.edit_sendd);
    editDefault.setText("1520177747921\nAvailable Balance: 415,757,841.78 KES");
    }
}