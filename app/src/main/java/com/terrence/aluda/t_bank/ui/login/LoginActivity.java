package com.terrence.aluda.t_bank.ui.login;

import android.app.ProgressDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.terrence.aluda.t_bank.login.LoginTest;
import com.terrence.aluda.t_bank.retrofit.APIClient;
import com.terrence.aluda.t_bank.retrofit.APIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.google.gson.Gson;
import com.terrence.aluda.t_bank.R;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    List<LoginTest> responseArray;
    private String loggedInCheck, firstname, lastname, natID, userPassword, regDate, phoneParam, passwordParam;
    private EditText editNum, editPassword;
    private Button btnAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editNum = findViewById(R.id.edit_usernumber);
        editPassword = findViewById(R.id.edit_password);
        btnAuth = findViewById(R.id.btn_login);

        btnAuth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                //Intent activityChangeIntent = new Intent(PresentActivity.this, NextActivity.class);
                // currentContext.startActivity(activityChangeIntent);
                //PresentActivity.this.startActivity(activityChangeIntent);
                sendAuthToken();
            }
        });
    }

    private void sendAuthToken() {
        APIInterface apiInterface;
        Gson gson = new Gson();
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);

        phoneParam = editNum.getText().toString();
        passwordParam = editPassword.getText().toString();

        phoneParam = "254"+phoneParam.substring(phoneParam.length() - 9);

        progressDialog.setMessage("Testing");
        progressDialog.show();
        responseArray = new ArrayList<>();
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Toast.makeText(getApplicationContext(), "skrr", Toast.LENGTH_SHORT).show();
        Call<List<LoginTest>> call = apiInterface.doAuthenticate(phoneParam, passwordParam);
        call.enqueue(new Callback<List<LoginTest>>() {
            @Override
            public void onResponse(Call<List<LoginTest>> call, Response<List<LoginTest>> response) {
                progressDialog.dismiss();
                responseArray = response.body();
                //String testdisplayToken = responseArray.get(0).getFirstname();
                //Toast.makeText(getApplicationContext(), testdisplayToken, Toast.LENGTH_SHORT).show();
                loggedInCheck = responseArray.get(0).getId();
                if(loggedInCheck.equals("wrong55")){
                    Toast.makeText(getApplicationContext(), "Registeer", Toast.LENGTH_SHORT).show();
                }else if(loggedInCheck.equals("wrong00")){
                    Toast.makeText(getApplicationContext(), "Wrong password", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "HTTP OK! :)", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<LoginTest>> call, Throwable t) {

                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });
    }


    /**
     GET List Resources
     **/
}