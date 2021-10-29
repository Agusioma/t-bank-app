package com.terrence.aluda.t_bank.ui.login;

import android.app.ProgressDialog;
import android.util.Log;
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
    APIInterface apiInterface;
    TextView testDisplay;
     List<LoginTest> testArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        testDisplay = (TextView) findViewById(R.id.text_depo2);
        Gson gson = new Gson();
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setMessage("Testing");
        progressDialog.show();
        testArray= new ArrayList<>();
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Toast.makeText(getApplicationContext(), "skrr", Toast.LENGTH_SHORT).show();
        Call<List<LoginTest>> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<List<LoginTest>>() {
                         @Override
                         public void onResponse(Call<List<LoginTest>> call, Response<List<LoginTest>> response) {

                             progressDialog.dismiss();
                             Log.d("TAG",response.code()+"");

                             String displayResponse = "";
                             testArray = response.body();
                             String testdisplayToken = testArray.get(0).getFirstname();
                             Toast.makeText(getApplicationContext(), testdisplayToken, Toast.LENGTH_SHORT).show();

                             /*Type collectionType = new TypeToken<Collection<LoginTest>>(){}.getType();
                             Collection<LoginTest> enums = gson.fromJson(resource.natID, collectionType);*/

                             /*String text = resource.natID;
                             String total = resource.firstname;*/

                             //displayResponse += "National ID "+text+"Firstname"+total;
                            // Toast.makeText(getApplicationContext(), displayResponse, Toast.LENGTH_SHORT).show();
                            //testDisplay.setText((CharSequence) enums);
                         }
                         @Override
                         public void onFailure(Call<List<LoginTest>> call, Throwable t) {

                             progressDialog.dismiss();
                             Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
                             testDisplay.setText(t.toString());
                             call.cancel();
                         }
        });
    }


    /**
     GET List Resources
     **/
}