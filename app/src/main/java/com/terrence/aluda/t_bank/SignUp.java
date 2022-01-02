package com.terrence.aluda.t_bank;

import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;
import com.terrence.aluda.t_bank.netrequests.DefaultResponse;
import com.terrence.aluda.t_bank.netrequests.LoginTest;
import com.terrence.aluda.t_bank.retrofit.APIClient;
import com.terrence.aluda.t_bank.retrofit.APIInterface;
import com.terrence.aluda.t_bank.ui.login.LoginActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {

    private Button btn_process_personal, btn_process_passwords, toSignInBtn, toPersonals;
    private TextInputLayout fNameTxtLayout, lNameLayout, PhoneLayout, NatIDLayout, EmailLayout, NewPassLayout, CNewPassLayout;
    private TextView regLbl, reg_strength_note_tt, reg_strength_note1;
    private TextView reg_strength_note2, reg_strength_note3, reg_strength_note4, reg_strength_note5;
    private TextView fNameDisc, lNameDisc, phoneDisc, NatIDDisc, EmailDisc, NewPassDisc, CNewPassDisc;
    private EditText fNameEditTxt, lNameEditTxt, phoneEditTxt, NatIDEditTxt, EmailEditTxt, NewPassEditTxt, CNewPassEditTxt;
    private ProgressBar progressBarReg;
    private RelativeLayout footer, footer2;
    private String _fName, _lName, _eAddress, _natID, _pNumber, _userPass, _cPass;
    List<DefaultResponse> responseArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btn_process_personal = findViewById(R.id.btn_process_personal);
        btn_process_passwords = findViewById(R.id.btn_process_passwords);
        fNameTxtLayout = findViewById(R.id.fNameTxtLayout);
        lNameLayout = findViewById(R.id.lNameLayout);
        PhoneLayout = findViewById(R.id.PhoneLayout);
        NatIDLayout = findViewById(R.id.NatIDLayout);
        EmailLayout = findViewById(R.id.EmailLayout);
        NewPassLayout = findViewById(R.id.NewPassLayout);
        CNewPassLayout = findViewById(R.id.CNewPassLayout);
        regLbl = findViewById(R.id.regLbl);
        footer = findViewById(R.id.footer);
        footer2 = findViewById(R.id.footer2);
        toSignInBtn = findViewById(R.id.toSignInBtn);
        toPersonals = findViewById(R.id.toPersonals);
        reg_strength_note_tt = findViewById(R.id.reg_strength_note_tt);
        reg_strength_note1 = findViewById(R.id.reg_strength_note1);
        reg_strength_note2 = findViewById(R.id.reg_strength_note2);
        reg_strength_note3 = findViewById(R.id.reg_strength_note3);
        reg_strength_note4 = findViewById(R.id.reg_strength_note4);
        reg_strength_note5 = findViewById(R.id.reg_strength_note5);
        fNameDisc = findViewById(R.id.fNameDisc);
        lNameDisc = findViewById(R.id.lNameDisc);
        phoneDisc = findViewById(R.id.phoneDisc);
        NatIDDisc = findViewById(R.id.NatIDDisc);
        EmailDisc = findViewById(R.id.EmailDisc);
        NewPassDisc = findViewById(R.id.NewPassDisc);
        CNewPassDisc = findViewById(R.id.CNewPassDisc);
        fNameEditTxt = findViewById(R.id.fNameEditTxt);
        lNameEditTxt = findViewById(R.id.lNameEditTxt);
        phoneEditTxt = findViewById(R.id.phoneEditTxt);
        NatIDEditTxt = findViewById(R.id.NatIDEditTxt);
        EmailEditTxt = findViewById(R.id.EmailEditTxt);
        NewPassEditTxt = findViewById(R.id.NewPassEditTxt);
        CNewPassEditTxt = findViewById(R.id.CNewPassEditTxt);
        progressBarReg = findViewById(R.id.progressBarReg);

        hidePassWordFields();
        //hidePersonalDetailsFields();

        fNameDisc.setVisibility(View.GONE);
        lNameDisc.setVisibility(View.GONE);
        phoneDisc.setVisibility(View.GONE);
        NatIDDisc.setVisibility(View.GONE);
        EmailDisc.setVisibility(View.GONE);
        NewPassDisc.setVisibility(View.GONE);
        CNewPassDisc.setVisibility(View.GONE);


        btn_process_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPersonalInput();
            }
        });

        btn_process_passwords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPasswordInput();
            }
        });

        toPersonals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hidePassWordFields();
            }
        });

        toSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSignIn = new Intent(SignUp.this, LoginActivity.class);
                startActivity(toSignIn);
            }
        });

        fNameEditTxt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    hidePersonalBanners();
                }
            }
        });

        lNameEditTxt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    hidePersonalBanners();
                }
            }
        });

        phoneEditTxt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    hidePersonalBanners();
                }
            }
        });

        NatIDEditTxt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    hidePersonalBanners();
                }
            }
        });

        EmailEditTxt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    hidePersonalBanners();
                }
            }
        });

        NewPassEditTxt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    hidePasswordBanners();
                }
            }
        });

        CNewPassEditTxt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    hidePasswordBanners();
                }
            }
        });

        fNameEditTxt.addTextChangedListener(new TextWatcher() {
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
                hidePersonalBanners();
                ignore = false;
            }
        });

        lNameEditTxt.addTextChangedListener(new TextWatcher() {
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
                hidePersonalBanners();
                ignore = false;
            }
        });

        phoneEditTxt.addTextChangedListener(new TextWatcher() {
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
                hidePersonalBanners();
                ignore = false;
            }
        });

        NatIDEditTxt.addTextChangedListener(new TextWatcher() {
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
                hidePersonalBanners();
                ignore = false;
            }
        });

        EmailEditTxt.addTextChangedListener(new TextWatcher() {
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
                hidePersonalBanners();
                ignore = false;
            }
        });

        NewPassEditTxt.addTextChangedListener(new TextWatcher() {
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
                hidePasswordBanners();
                ignore = false;
            }
        });

        CNewPassEditTxt.addTextChangedListener(new TextWatcher() {
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
                hidePasswordBanners();
                ignore = false;
            }
        });


    }

    private void hidePasswordBanners() {
        NewPassDisc.setVisibility(View.GONE);
        CNewPassDisc.setVisibility(View.GONE);
    }

    private void hidePersonalBanners() {
        fNameDisc.setVisibility(View.GONE);
        lNameDisc.setVisibility(View.GONE);
        phoneDisc.setVisibility(View.GONE);
        NatIDDisc.setVisibility(View.GONE);
        EmailDisc.setVisibility(View.GONE);
    }

    private void hidePassWordFields() {
        regLbl.setText("Personal details");
        btn_process_passwords.setVisibility(View.GONE);
        NewPassLayout.setVisibility(View.GONE);
        CNewPassLayout.setVisibility(View.GONE);
        progressBarReg.setVisibility(View.GONE);
        reg_strength_note_tt.setVisibility(View.GONE);
        reg_strength_note1.setVisibility(View.GONE);
        reg_strength_note2.setVisibility(View.GONE);
        reg_strength_note3.setVisibility(View.GONE);
        reg_strength_note4.setVisibility(View.GONE);
        reg_strength_note5.setVisibility(View.GONE);
        footer2.setVisibility(View.GONE);

        btn_process_personal.setVisibility(View.VISIBLE);
        fNameTxtLayout.setVisibility(View.VISIBLE);
        lNameLayout.setVisibility(View.VISIBLE);
        PhoneLayout.setVisibility(View.VISIBLE);
        NatIDLayout.setVisibility(View.VISIBLE);
        EmailLayout.setVisibility(View.VISIBLE);
        footer.setVisibility(View.VISIBLE);
    }

    private void hidePersonalDetailsFields() {
        regLbl.setText("Your password");
        btn_process_passwords.setVisibility(View.VISIBLE);
        NewPassLayout.setVisibility(View.VISIBLE);
        CNewPassLayout.setVisibility(View.VISIBLE);
        progressBarReg.setVisibility(View.GONE);
        reg_strength_note_tt.setVisibility(View.VISIBLE);
        reg_strength_note1.setVisibility(View.VISIBLE);
        reg_strength_note2.setVisibility(View.VISIBLE);
        reg_strength_note3.setVisibility(View.VISIBLE);
        reg_strength_note4.setVisibility(View.VISIBLE);
        reg_strength_note5.setVisibility(View.VISIBLE);
        footer2.setVisibility(View.VISIBLE);

        btn_process_personal.setVisibility(View.GONE);
        fNameTxtLayout.setVisibility(View.GONE);
        lNameLayout.setVisibility(View.GONE);
        PhoneLayout.setVisibility(View.GONE);
        NatIDLayout.setVisibility(View.GONE);
        EmailLayout.setVisibility(View.GONE);
        footer.setVisibility(View.GONE);
    }

    private void checkPersonalInput() {

        _fName = fNameEditTxt.getText().toString();
        _lName = lNameEditTxt.getText().toString();
        _pNumber = phoneEditTxt.getText().toString();
        _natID = NatIDEditTxt.getText().toString();
        _eAddress = EmailEditTxt.getText().toString();

        if (_fName.length() == 0) {

            fNameDisc.setVisibility(View.VISIBLE);
            fNameDisc.setText("Please enter your first name");

        } else if (_lName.length() == 0) {

            lNameDisc.setVisibility(View.VISIBLE);
            lNameDisc.setText("Please enter your last name");

        } else if (_pNumber.length() == 0) {

            phoneDisc.setVisibility(View.VISIBLE);
            phoneDisc.setText("Please enter your phone number");
        } else if ((_pNumber.length() > 12) || (_pNumber.length() < 10)) {

            phoneDisc.setVisibility(View.VISIBLE);
            phoneDisc.setText("Please enter a valid phone number");

        } else if (_natID.length() == 0) {

            NatIDDisc.setVisibility(View.VISIBLE);
            NatIDDisc.setText("Please enter your National ID number");

        } else if (_eAddress.length() == 0) {

            EmailDisc.setVisibility(View.VISIBLE);
            EmailDisc.setText("Please enter your email address");

        } else if (!isEmail(_eAddress)) {

            EmailDisc.setVisibility(View.VISIBLE);
            EmailDisc.setText("Type in a valid email address");
        } else {
            hidePersonalDetailsFields();
        }
    }

    private void checkPasswordInput() {

        _userPass = NewPassEditTxt.getText().toString();
        _cPass = CNewPassEditTxt.getText().toString();

        if (_userPass.length() == 0) {

            NewPassDisc.setVisibility(View.VISIBLE);
            NewPassDisc.setText("Please enter your password");
        } else if (!isPassword(_userPass)) {

            NewPassDisc.setVisibility(View.VISIBLE);
            NewPassDisc.setText("Type in a strong password");
        } else if (_cPass.length() == 0) {

            CNewPassDisc.setVisibility(View.VISIBLE);
            CNewPassDisc.setText("Please confirm your password");


        } else if (!((_cPass).equals(_userPass))) {
            NewPassDisc.setVisibility(View.VISIBLE);
            NewPassDisc.setText("Your passwords don't match");
            CNewPassDisc.setVisibility(View.VISIBLE);
            CNewPassDisc.setText("Your passwords don't match");
        } else {
            sendRegToken();
            //showDialog();
        }

    }

    private void showProgress(boolean check) {
        if (check) {
            btn_process_passwords.setVisibility(View.GONE);
            reg_strength_note_tt.setVisibility(View.GONE);
            reg_strength_note1.setVisibility(View.GONE);
            reg_strength_note2.setVisibility(View.GONE);
            reg_strength_note3.setVisibility(View.GONE);
            reg_strength_note4.setVisibility(View.GONE);
            reg_strength_note5.setVisibility(View.GONE);
            progressBarReg.setVisibility(View.VISIBLE);
            footer2.setVisibility(View.GONE);
        } else {
            btn_process_passwords.setVisibility(View.VISIBLE);
            reg_strength_note_tt.setVisibility(View.VISIBLE);
            reg_strength_note1.setVisibility(View.VISIBLE);
            reg_strength_note2.setVisibility(View.VISIBLE);
            reg_strength_note3.setVisibility(View.VISIBLE);
            reg_strength_note4.setVisibility(View.VISIBLE);
            reg_strength_note5.setVisibility(View.VISIBLE);
            progressBarReg.setVisibility(View.GONE);
            footer2.setVisibility(View.VISIBLE);
        }
    }

    public static boolean isEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public static boolean isPassword(String password) {

        String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";

        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(password);

        return m.matches();
    }

    private void showDialog() {

        new MaterialAlertDialogBuilder(this)
                .setTitle("Success")
                .setMessage("Welcome to T-Bank. You will be taken to the login page where you will sign in to start using our services")

                .setPositiveButton("OK, I got it", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent toSignIn = new Intent(SignUp.this, LoginActivity.class);
                        startActivity(toSignIn);
                    }
                })
                .setCancelable(false)
                .show();

    }

    private void sendRegToken() {
        try {
            APIInterface apiInterface;

            showProgress(true);
            _pNumber = "254" + _pNumber.substring(_pNumber.length() - 9);
            responseArray = new ArrayList<>();

            apiInterface = APIClient.getClient().create(APIInterface.class);
            Call<List<DefaultResponse>> call = apiInterface.doRegister(_fName, _lName, _eAddress, _natID, _pNumber, _userPass);


            call.enqueue(new Callback<List<DefaultResponse>>() {
                @Override
                public void onResponse(Call<List<DefaultResponse>> call, Response<List<DefaultResponse>> response) {
                    showProgress(false);
                    showDialog();
                }

                @Override
                public void onFailure(Call<List<DefaultResponse>> call, Throwable t) {
                    showProgress(false);
                    Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
                    call.cancel();
                }
            });
        } catch (Exception e) {
            showProgress(false);
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}