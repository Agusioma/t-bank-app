package com.terrence.aluda.t_bank;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.terrence.aluda.t_bank.netrequests.AccountStatements;
import com.terrence.aluda.t_bank.netrequests.LoginTest;
import com.terrence.aluda.t_bank.netrequests.TotalSavings;
import com.terrence.aluda.t_bank.retrofit.APIClient;
import com.terrence.aluda.t_bank.retrofit.APIInterface;
import com.terrence.aluda.t_bank.ui.home.HomeFragment;
import com.terrence.aluda.t_bank.ui.login.LoginActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String firstname, email, lastname, natID, userPassword, regDate,statCheck, totals;
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_transaction, R.id.navigation_borrow, R.id.navigation_more)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        sharedpreferences = getSharedPreferences("MyTax" ,0);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            firstname = extras.getString("firstname");
            lastname = extras.getString("lastname");
            natID = extras.getString("natID");
            userPassword = extras.getString("userPassword");
            regDate = extras.getString("regDate");
            email = extras.getString("email");

        }

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("Name", firstname);
        editor.putString("Last", lastname);
        editor.putString("NatID", natID);
        editor.commit();

    }
        public String getData(){
            SharedPreferences sharedPreferences = getSharedPreferences("MyTax", 0);
            String setting = sharedPreferences.getString("Name", "defaultValue");
            return setting;
        }

}