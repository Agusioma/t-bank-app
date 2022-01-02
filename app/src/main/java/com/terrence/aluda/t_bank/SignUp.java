package com.terrence.aluda.t_bank;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputLayout;
import com.terrence.aluda.t_bank.ui.login.LoginActivity;

public class SignUp extends AppCompatActivity {

    private Button btn_process_personal, btn_process_passwords, toSignInBtn, toPersonals;
    private TextInputLayout fNameTxtLayout, lNameLayout, PhoneLayout, NatIDLayout, EmailLayout, NewPassLayout, CNewPassLayout;
    private TextView regLbl, reg_strength_note_tt, reg_strength_note1;
    private TextView reg_strength_note2, reg_strength_note3, reg_strength_note4, reg_strength_note5;
    private TextView fNameDisc, lNameDisc, phoneDisc, NatIDDisc, EmailDisc, NewPassDisc, CNewPassDisc;
    private EditText fNameEditTxt, lNameEditTxt, phoneEditTxt, NatIDEditTxt, EmailEditTxt, NewPassEditTxt, CNewPassEditTxt;
    private ProgressBar progressBarReg;
    private RelativeLayout footer, footer2;
    private String _fName, _lName, _eAddress, _natID, _pNumber, _userPass;

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
                hidePersonalDetailsFields();
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
        NewPassDisc.setVisibility(View.VISIBLE);
        CNewPassDisc.setVisibility(View.VISIBLE);
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
}