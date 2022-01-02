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
    private TextView currentDiscPwd, firstDiscPwd, confirmDiscPwd, noteLbl, note1, note2, note3, note4, note5;
    private ProgressBar progressBarPwd;
    private Button btn_Pwd;
    private String currentPassword, newPassword, natID, checkPass;
    
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
        noteLbl = findViewById(R.id.strength_note_tt);
        note1 = findViewById(R.id.strength_note1);
        note2 = findViewById(R.id.strength_note2);
        note3 = findViewById(R.id.strength_note3);
        note4 = findViewById(R.id.strength_note4);
        note5 = findViewById(R.id.strength_note5);
        btn_Pwd = findViewById(R.id.btn_Pwd);

        currentPwd.requestFocus();

        currentDiscPwd.setVisibility(View.GONE);
        firstDiscPwd.setVisibility(View.GONE);
        confirmDiscPwd.setVisibility(View.GONE);
        progressBarPwd.setVisibility(View.GONE);

        SharedPreferences sharedPreferences = getSharedPreferences("MyTax", 0);
        checkPass = sharedPreferences.getString("userPassword", "defaultValue");
        firstPwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    hideBanners();
                }
            }
        });

        currentPwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    hideBanners();
                }
            }
        });

        confirmPwd .setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    hideBanners();
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
                hideBanners();
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
                hideBanners();
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
                hideBanners();
                ignore = false;
            }
        });

        btn_Pwd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkInput();
            }
        });
    }

    private void checkInput() {
        if (currentPwd.getText().length() == 0) {

            currentDiscPwd.setVisibility(View.VISIBLE);
            currentDiscPwd.setText("Please enter your current password");
        }else if(!((currentPwd.getText().toString()).equals(checkPass))){

                currentDiscPwd.setVisibility(View.VISIBLE);
                currentDiscPwd.setText("Wrong password");
        } else if (firstPwd.getText().length() == 0) {

            firstDiscPwd.setVisibility(View.VISIBLE);
            firstDiscPwd.setText("Please enter your new password");
        }else if(!checkAndValidatePassword(firstPwd.getText().toString())){

                firstDiscPwd.setVisibility(View.VISIBLE);
                firstDiscPwd.setText("Type in a strong password");
        } else if (confirmPwd.getText().length() == 0) {

            confirmDiscPwd.setVisibility(View.VISIBLE);
            confirmDiscPwd.setText("Please confirm your new password");
        } else if(!((confirmPwd.getText().toString()).equals(firstPwd.getText().toString()))){
            firstDiscPwd.setVisibility(View.VISIBLE);
            firstDiscPwd.setText("Your passwords don't match");
            confirmDiscPwd.setVisibility(View.VISIBLE);
            confirmDiscPwd.setText("Your passwords don't match");
        } else {
            sendUpdateTokens();
        }
    }

    public static boolean checkAndValidatePassword(String password)
    {

        String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])"+ "(?=\\S+$).{8,20}$";

        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(password);

        return m.matches();
    }

    private void hideBar() {
        btn_Pwd.setVisibility(View.VISIBLE);
        progressBarPwd.setVisibility(View.GONE);
        noteLbl.setVisibility(View.VISIBLE);
        note1.setVisibility(View.VISIBLE);
        note2.setVisibility(View.VISIBLE);
        note3.setVisibility(View.VISIBLE);
        note4.setVisibility(View.VISIBLE);
        note5.setVisibility(View.VISIBLE);
    }

    private void showBar() {
        btn_Pwd.setVisibility(View.GONE);
        progressBarPwd.setVisibility(View.VISIBLE);
        noteLbl.setVisibility(View.GONE);
        note1.setVisibility(View.GONE);
        note2.setVisibility(View.GONE);
        note3.setVisibility(View.GONE);
        note4.setVisibility(View.GONE);
        note5.setVisibility(View.GONE);

    }

    private void hideBanners(){
        firstDiscPwd.setVisibility(View.GONE);
        currentDiscPwd.setVisibility(View.GONE);
        confirmDiscPwd.setVisibility(View.GONE);
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
                    SharedPreferences sharedPreferences2 = getSharedPreferences("MyTax", 0);
                    SharedPreferences.Editor editor = sharedPreferences2.edit();
                    editor.putString("userPassword", firstPwd.getText().toString());
                    editor.commit();
                    currentPwd.setText("");
                    firstPwd.setText("");
                    confirmPwd.setText("");
                    currentPwd.requestFocus();
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