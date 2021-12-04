package com.terrence.aluda.t_bank.ui.more;

import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.terrence.aluda.t_bank.R;
import com.terrence.aluda.t_bank.netrequests.DefaultResponse;
import com.terrence.aluda.t_bank.retrofit.APIClient;
import com.terrence.aluda.t_bank.retrofit.APIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdatePwdActivity extends AppCompatActivity {

    private EditText currentPwd, firstPwd, confirmPwd;
    private TextView currentDiscPwd, firstDiscPwd, confirmDiscPwd;
    private ProgressBar progressBarPwd;
    private Button btn_Pwd;
    private String currentPassword, newPassword, natID;
    
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

        firstPwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    firstDiscPwd.setVisibility(View.GONE);
                    currentDiscPwd.setVisibility(View.GONE);
                    confirmDiscPwd.setVisibility(View.GONE);
                }
            }
        });

        currentPwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    firstDiscPwd.setVisibility(View.GONE);
                    currentDiscPwd.setVisibility(View.GONE);
                    confirmDiscPwd.setVisibility(View.GONE);
                }
            }
        });

        confirmPwd .setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    firstDiscPwd.setVisibility(View.GONE);
                    currentDiscPwd.setVisibility(View.GONE);
                    confirmDiscPwd.setVisibility(View.GONE);
                }
            }
        });

        firstPwd.addTextChangedListener(new TextWatcher() {
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
                firstDiscPwd.setVisibility(View.GONE);
                currentDiscPwd.setVisibility(View.GONE);
                confirmDiscPwd.setVisibility(View.GONE);
                ignore = false;
            }
        });

        currentPwd.addTextChangedListener(new TextWatcher() {
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
                firstDiscPwd.setVisibility(View.GONE);
                currentDiscPwd.setVisibility(View.GONE);
                confirmDiscPwd.setVisibility(View.GONE);
                ignore = false;
            }
        });

        confirmPwd.addTextChangedListener(new TextWatcher() {
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
                firstDiscPwd.setVisibility(View.GONE);
                currentDiscPwd.setVisibility(View.GONE);
                confirmDiscPwd.setVisibility(View.GONE);
                ignore = false;
            }
        });

        /*btn_Pwd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkInput();
            }
        });*/
    }

    private void checkInput() {
        if (firstPwd.getText().length() == 0) {

            firstDiscPwd.setVisibility(View.VISIBLE);
            firstDiscPwd.setText("Please enter your current password");

        } else if (currentPwd.getText().length() == 0) {

            currentDiscPwd.setVisibility(View.VISIBLE);
            currentDiscPwd.setText("Please enter your new password");

        } else if (confirmPwd.getText().length() == 0) {

            confirmDiscPwd.setVisibility(View.VISIBLE);
            confirmDiscPwd.setText("Please confirm your new password");
        } else if(!checkAndValidatePassword(currentPwd.getText().toString())){
            currentDiscPwd.setVisibility(View.VISIBLE);
            currentDiscPwd.setText("Type in a strong password");
        } else {
            sendUpdateTokens();
        }
    }

    public static boolean checkAndValidatePassword(String password)
    {

        String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=.*[\\S])(?=.{8,})";

        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(password);

        return m.matches();
    }

    private void hideBar() {
        btn_Pwd.setVisibility(View.VISIBLE);
        progressBarPwd.setVisibility(View.GONE);
    }

    private void showBar() {
        btn_Pwd.setVisibility(View.GONE);
        progressBarPwd.setVisibility(View.VISIBLE);
    }
    private void sendUpdateTokens() {
        try {
            APIInterface apiInterface;
            SharedPreferences sharedPreferences = getSharedPreferences("MyTax", 0);
            natID = sharedPreferences.getString("natID", "defaultValue");
            showBar();
            newPassword = confirmPwd.getText().toString();


            apiInterface = APIClient.getClient().create(APIInterface.class);
            Call<List<DefaultResponse>> call = apiInterface.changePassword(natID, newPassword);

            call.enqueue(new Callback<List<DefaultResponse>>() {
                @Override
                public void onResponse(Call<List<DefaultResponse>> call, Response<List<DefaultResponse>> response) {
                    hideBar();
                }

                @Override
                public void onFailure(Call<List<DefaultResponse>> call, Throwable t) {
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
    }
}