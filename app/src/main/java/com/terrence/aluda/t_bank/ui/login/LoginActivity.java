package com.terrence.aluda.t_bank.ui.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.terrence.aluda.t_bank.MainActivity;
import com.terrence.aluda.t_bank.netrequests.LoginTest;
import com.terrence.aluda.t_bank.retrofit.APIClient;
import com.terrence.aluda.t_bank.retrofit.APIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.terrence.aluda.t_bank.R;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    List<LoginTest> responseArray;
    private String loggedInCheck, firstname, lastname, email, natID, userPassword, regDate, phoneParam, passwordParam;
    private EditText editNum, editPassword;
    private Button btnAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editNum = findViewById(R.id.edit_usernumber);
        editPassword = findViewById(R.id.edit_password);
        btnAuth = findViewById(R.id.btn_login);
        sendAuthToken();
       /* btnAuth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendAuthToken();
            }
        });*/
    }

    private void sendAuthToken() {
        APIInterface apiInterface;
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);

        //phoneParam = editNum.getText().toString();
        //passwordParam = editPassword.getText().toString();

        //phoneParam = "254" + phoneParam.substring(phoneParam.length() - 9);
        phoneParam = "254702277060";
        passwordParam = "4141";
        progressDialog.setMessage("Testing");
        progressDialog.show();

        responseArray = new ArrayList<>();

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<List<LoginTest>> call = apiInterface.doAuthenticate(phoneParam, passwordParam);

        call.enqueue(new Callback<List<LoginTest>>() {
            @Override
            public void onResponse(Call<List<LoginTest>> call, Response<List<LoginTest>> response) {

                progressDialog.dismiss();
                responseArray = response.body();
                loggedInCheck = responseArray.get(0).getId();

                if (loggedInCheck.equals("wrong55")) {
                    Toast.makeText(getApplicationContext(), "Registeer", Toast.LENGTH_SHORT).show();
                } else if (loggedInCheck.equals("wrong00")) {
                    Toast.makeText(getApplicationContext(), "Wrong password", Toast.LENGTH_SHORT).show();
                } else {

                    firstname = responseArray.get(0).getFirstname();
                    lastname = responseArray.get(0).getLastname();
                    natID = responseArray.get(0).getNatID();
                    userPassword = responseArray.get(0).getPassword();
                    regDate = responseArray.get(0).getRegDate();
                    email = responseArray.get(0).getEmail();
                    Intent toMain = new Intent(LoginActivity.this, MainActivity.class);

                    toMain.putExtra("firstname", firstname);
                    toMain.putExtra("lastname", lastname);
                    toMain.putExtra("natID", natID);
                    toMain.putExtra("userPassword", userPassword);
                    toMain.putExtra("regDate", regDate);
                    toMain.putExtra("email", email);

                    startActivity(toMain);
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