package com.terrence.aluda.t_bank;

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
import com.terrence.aluda.t_bank.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private String firstname, email, lastname, natID, userPassword, regDate;

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

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.navigation_News:
                        selectedFragment = ItemoneFragment.newInstance();
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.content, selectedFragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                        return true;

                    case R.id.navigation_profile:
                        selectedFragment = ItemtwoFragment.newInstance();
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.content, selectedFragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                        return true;

                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content, selectedFragment);
                transaction.commit();
                return true;
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            firstname = extras.getString("firstname");
            lastname = extras.getString("lastname");
            natID = extras.getString("natID");
            userPassword = extras.getString("userPassword");
            regDate = extras.getString("regDate");
            email = extras.getString("email");

        }

        Bundle homeBundle = new Bundle();

        homeBundle.putString("firstname", firstname);
        homeBundle.putString("lastname", lastname);
        homeBundle.putString("natID", natID);
        homeBundle.putString("userPassword", userPassword);
        homeBundle.putString("regDate", regDate);

        HomeFragment homeFrag = new HomeFragment();
        homeFrag.setArguments(homeBundle);
    }

}