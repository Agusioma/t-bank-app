package com.terrence.aluda.t_bank.ui.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.terrence.aluda.t_bank.MainActivity;
import com.terrence.aluda.t_bank.netrequests.AccountStatements;
import com.terrence.aluda.t_bank.netrequests.LoginTest;
import com.terrence.aluda.t_bank.netrequests.TotalSavings;
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
    private String loggedInCheck, firstname, lastname, email, natID, userPassword, regDate, phoneParam, passwordParam, statCheck, totals;
    private EditText editNum, editPassword;
    private Button btnAuth, btnFgPwd;
    private ProgressBar loginProgress;
    private TextView numDisc, passDisc;
    List<AccountStatements> statementsArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editNum = findViewById(R.id.edit_usernumber);
        editPassword = findViewById(R.id.edit_password);
        btnAuth = findViewById(R.id.btn_login);
        btnFgPwd = findViewById(R.id.forgotPwd);
        loginProgress = findViewById(R.id.progressBarLgn);
        numDisc = findViewById(R.id.numDisc);
        passDisc = findViewById(R.id.passDisc);

        numDisc.setVisibility(View.GONE);
        passDisc.setVisibility(View.GONE);
        loginProgress.setVisibility(View.GONE);

        editNum.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    passDisc.setVisibility(View.GONE);
                    numDisc.setVisibility(View.GONE);
                }
            }
        });

        editPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    passDisc.setVisibility(View.GONE);
                    numDisc.setVisibility(View.GONE);
                }
            }
        });
        editPassword.addTextChangedListener(new TextWatcher() {
            boolean ignore = false;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (ignore)
                    return;
                ignore = true;
                passDisc.setVisibility(View.GONE);
                numDisc.setVisibility(View.GONE);
                ignore = false;
            }
        });

        editNum.addTextChangedListener(new TextWatcher() {
            boolean ignore = false;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (ignore)
                    return;
                ignore = true;
                passDisc.setVisibility(View.GONE);
                numDisc.setVisibility(View.GONE);
                ignore = false;
            }
        });

        btnAuth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkInput();
            }
        });
    }

    private void sendAuthToken() {
        try {
            APIInterface apiInterface;

            btnAuth.setVisibility(View.GONE);
            btnFgPwd.setVisibility(View.GONE);
            loginProgress.setVisibility(View.VISIBLE);
            phoneParam = editNum.getText().toString();
            passwordParam = editPassword.getText().toString();

            phoneParam = "254" + phoneParam.substring(phoneParam.length() - 9);

            responseArray = new ArrayList<>();

            apiInterface = APIClient.getClient().create(APIInterface.class);
            Call<List<LoginTest>> call = apiInterface.doAuthenticate(phoneParam, passwordParam);

            call.enqueue(new Callback<List<LoginTest>>() {
                @Override
                public void onResponse(Call<List<LoginTest>> call, Response<List<LoginTest>> response) {
                    hideBar();
                    responseArray = response.body();
                    loggedInCheck = responseArray.get(0).getId();

                    if (loggedInCheck.equals("wrong55")) {
                        numDisc.setVisibility(View.VISIBLE);
                        numDisc.setText("Please sign up. Rong");
                        passDisc.setVisibility(View.VISIBLE);
                        passDisc.setText("Please register");
                    } else if (loggedInCheck.equals("wrong00")) {
                        passDisc.setVisibility(View.VISIBLE);
                        passDisc.setText("Wrong password");
                    } else {
                        //retrieveStatements();
                        //retrieveTotals();


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
                    hideBar();
                    Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
                    call.cancel();
                }
            });
        } catch (Exception e) {
            hideBar();
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void checkInput() {
        if (editNum.getText().length() == 0) {
            numDisc.setVisibility(View.VISIBLE);
            numDisc.setText("Please enter your phone number");
        } else if (editNum.getText().length() < 10) {
            numDisc.setVisibility(View.VISIBLE);
            numDisc.setText("Please enter 10 digits");
        } else if (editPassword.getText().length() == 0) {
            passDisc.setVisibility(View.VISIBLE);
            passDisc.setText("Please enter your password");
        } else {
            sendAuthToken();
        }
    }

    private void hideBar() {
        btnAuth.setVisibility(View.VISIBLE);
        btnFgPwd.setVisibility(View.VISIBLE);
        loginProgress.setVisibility(View.GONE);
    }
 /*   private void retrieveStatements() {
        APIInterface apiInterface;
        statementsArray = new ArrayList<>();

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<List<AccountStatements>> call = apiInterface.getStatements();

        call.enqueue(new Callback<List<AccountStatements>>() {
            @Override
            public void onResponse(Call<List<AccountStatements>> call, Response<List<AccountStatements>> response) {
                statementsArray = response.body();
                statCheck = statementsArray.get(0).getTransID();
                Toast.makeText(getApplicationContext(), statCheck, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<AccountStatements>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });
    }*/


    /**
     GET List Resources
     **/
}