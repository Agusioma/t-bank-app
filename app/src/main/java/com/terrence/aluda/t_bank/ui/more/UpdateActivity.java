package com.terrence.aluda.t_bank.ui.more;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.terrence.aluda.t_bank.MainActivity;
import com.terrence.aluda.t_bank.R;
import com.terrence.aluda.t_bank.netrequests.LoginTest;
import com.terrence.aluda.t_bank.retrofit.APIClient;
import com.terrence.aluda.t_bank.retrofit.APIInterface;
import com.terrence.aluda.t_bank.ui.login.LoginActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class UpdateActivity extends AppCompatActivity {
    private String loggedInCheck, firstname, lastname, email, natID, phonee, userPassword, regDate, phoneParam;
    private EditText firstnameEdit, secondnameEdit, emailEdit;
    private TextView firstnameDiscEdit, secondnameDiscEdit, emailDiscEdit;
    private ProgressBar progressBarEdit;
    private Button btn_update, toUpdatePwdBtn;
    private SharedPreferences sharedPreferences;
    List<LoginTest> responseArray;

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
        emailDiscEdit = findViewById(R.id.emailDiscEdit);
        btn_update = findViewById(R.id.btn_update);
        toUpdatePwdBtn = findViewById(R.id.toUpdatePwdBtn);

        firstnameEdit.requestFocus();

        sharedPreferences = getSharedPreferences("MyTax", 0);
        firstname = sharedPreferences.getString("Name", "defaultValue");
        lastname = sharedPreferences.getString("Last", "defaultValue");
        natID = sharedPreferences.getString("natID", "defaultValue");
        phonee = sharedPreferences.getString("userPhone", "defaultValue");
        email = sharedPreferences.getString("emailAddress", "defaultValue");

        firstnameDiscEdit.setVisibility(View.GONE);
        secondnameDiscEdit.setVisibility(View.GONE);
        emailDiscEdit.setVisibility(View.GONE);
        progressBarEdit.setVisibility(View.GONE);

        firstnameEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    firstnameDiscEdit.setVisibility(View.GONE);
                    secondnameDiscEdit.setVisibility(View.GONE);
                    emailDiscEdit.setVisibility(View.GONE);
                }
            }
        });

        secondnameEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    firstnameDiscEdit.setVisibility(View.GONE);
                    secondnameDiscEdit.setVisibility(View.GONE);
                    emailDiscEdit.setVisibility(View.GONE);
                }
            }
        });

        emailEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    firstnameDiscEdit.setVisibility(View.GONE);
                    secondnameDiscEdit.setVisibility(View.GONE);
                    emailDiscEdit.setVisibility(View.GONE);
                }
            }
        });

        firstnameEdit.addTextChangedListener(new TextWatcher() {
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
                firstnameDiscEdit.setVisibility(View.GONE);
                secondnameDiscEdit.setVisibility(View.GONE);
                emailDiscEdit.setVisibility(View.GONE);
                ignore = false;
            }
        });

        secondnameEdit.addTextChangedListener(new TextWatcher() {
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
                firstnameDiscEdit.setVisibility(View.GONE);
                secondnameDiscEdit.setVisibility(View.GONE);
                emailDiscEdit.setVisibility(View.GONE);
                ignore = false;
            }
        });

        emailEdit.addTextChangedListener(new TextWatcher() {
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
                firstnameDiscEdit.setVisibility(View.GONE);
                secondnameDiscEdit.setVisibility(View.GONE);
                emailDiscEdit.setVisibility(View.GONE);
                ignore = false;
            }
        });

        firstnameEdit.setText(firstname);
        secondnameEdit.setText(lastname);
        emailEdit.setText(email);

        btn_update.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkInput();
            }
        });
        toUpdatePwdBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent toUpdatePwd = new Intent(UpdateActivity.this, UpdatePwdActivity.class);
                startActivity(toUpdatePwd);
            }
        });
    }

    private void checkInput() {
        if (firstnameEdit.getText().length() == 0) {

            firstnameDiscEdit.setVisibility(View.VISIBLE);
            firstnameDiscEdit.setText("Please enter your first name");

        } else if (secondnameEdit.getText().length() == 0) {

            secondnameDiscEdit.setVisibility(View.VISIBLE);
            secondnameDiscEdit.setText("Please enter your last name");

        } else if (emailEdit.getText().length() == 0) {

            emailDiscEdit.setVisibility(View.VISIBLE);
            emailDiscEdit.setText("Please enter your email address");

        } else {
            sendUpdateTokens();
        }
    }

    private void hideBar() {
        btn_update.setVisibility(View.VISIBLE);
        progressBarEdit.setVisibility(View.GONE);
    }

    private void showBar() {
        btn_update.setVisibility(View.GONE);
        progressBarEdit.setVisibility(View.VISIBLE);
    }

    private void sendUpdateTokens() {
        responseArray = new ArrayList<>();
        try {
            APIInterface apiInterface;

            showBar();
            firstname = firstnameEdit.getText().toString();
            lastname = secondnameEdit.getText().toString();
            email = emailEdit.getText().toString();

            apiInterface = APIClient.getClient().create(APIInterface.class);
            Call<List<LoginTest>> call = apiInterface.doUpdate(firstname, lastname, email, natID, phonee);

            call.enqueue(new Callback<List<LoginTest>>() {
                @Override
                public void onResponse(Call<List<LoginTest>> call, Response<List<LoginTest>> response) {
                    hideBar();
                    responseArray = response.body();
                    loggedInCheck = responseArray.get(0).getId();


                    firstname = responseArray.get(0).getFirstname();
                    lastname = responseArray.get(0).getLastname();
                    natID = responseArray.get(0).getNatID();
                    userPassword = responseArray.get(0).getPassword();
                    regDate = responseArray.get(0).getRegDate();
                    email = responseArray.get(0).getEmail();
                    phonee = responseArray.get(0).getPhoneNo();

                    updateSharedPreferences(firstname, lastname, natID, email, phonee);
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

    public void updateSharedPreferences(String param1, String param2, String param3, String param4, String param5){
        SharedPreferences sharedpreferencesUpdated;
        sharedpreferencesUpdated = this.getSharedPreferences("MyTax", 0);
        SharedPreferences.Editor editor = sharedpreferencesUpdated.edit();
        editor.putString("Name", param1);
        editor.putString("Last", param2);
        editor.putString("natID", param3);
        editor.putString("emailAddress", param4);
        editor.putString("userPhone", param5);
        editor.commit();
    }
}