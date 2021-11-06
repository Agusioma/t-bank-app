package com.terrence.aluda.t_bank.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.terrence.aluda.t_bank.MainActivity;
import com.terrence.aluda.t_bank.models.home.HomeModel;
import com.terrence.aluda.t_bank.netrequests.TotalSavings;
import com.terrence.aluda.t_bank.retrofit.APIClient;
import com.terrence.aluda.t_bank.retrofit.APIInterface;
import com.terrence.aluda.t_bank.ui.home.HomeFragment;
import com.terrence.aluda.t_bank.ui.login.LoginActivity;
import org.jetbrains.annotations.NotNull;

import com.terrence.aluda.t_bank.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private HomeFragment context;
    private ArrayList<HomeModel> courseModelArrayList;
    private SharedPreferences sharedPreferences;
    List<TotalSavings> totalsArray;
    private String currencyPattern = "###,###,###.##";
    DecimalFormat dF = new DecimalFormat(currencyPattern);
    private String totals, totalSavings, firstName, lastName, test;

    public HomeAdapter(HomeFragment context, ArrayList<HomeModel> courseModelArrayList) {
        this.context = context;
        this.courseModelArrayList = courseModelArrayList;
        sharedPreferences = context.getActivity().getSharedPreferences("MyTax", 0);
    }

    @NonNull
    @NotNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_cards, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull HomeAdapter.ViewHolder holder, int position) {
        HomeModel model = courseModelArrayList.get(position);
        APIInterface apiInterface;
        totalsArray = new ArrayList<>();

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<List<TotalSavings>> call = apiInterface.getTotalSavings();

        call.enqueue(new Callback<List<TotalSavings>>() {
            @Override
            public void onResponse(Call<List<TotalSavings>> call, Response<List<TotalSavings>> response) {
                totalsArray = response.body();
                totals = totalsArray.get(0).getTotals();
                firstName = sharedPreferences.getString("Name", "defaultValue");
                lastName = sharedPreferences.getString("Last", "defaultValue");

                holder.nameLbl.setText(firstName + " " + lastName);
                holder.totalsLbl.setText(totals);
                String total = dF.format(Double.parseDouble(totals));
                holder.savingsLbl.setText(total);
                holder.loanLimitLbl.setText(total);
            }

            @Override
            public void onFailure(Call<List<TotalSavings>> call, Throwable t) {
                Toast.makeText(context.getActivity(), t.toString(), Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });


    }

    @Override
    public int getItemCount() {
        return courseModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView courseNameTV, savingsLbl, totalsLbl, nameLbl, loanLimitLbl;
        private CardView cvt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseNameTV = itemView.findViewById(R.id.text_name);
            cvt = itemView.findViewById(R.id.our_card);
            savingsLbl = itemView.findViewById(R.id.userSavings);
            totalsLbl = itemView.findViewById(R.id.totalsLbl);
            nameLbl = itemView.findViewById(R.id.nameLbl);
            loanLimitLbl = itemView.findViewById(R.id.loanLimitLbl);
        }
    }

    /*private void retrieveTotals() {
        APIInterface apiInterface;
        final ProgressDialog progressDialog = new ProgressDialog(context.getActivity());
        progressDialog.setMessage("Testing");
        progressDialog.show();
        totalsArray = new ArrayList<>();

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<List<TotalSavings>> call = apiInterface.getTotalSavings();

        call.enqueue(new Callback<List<TotalSavings>>() {
            @Override
            public void onResponse(Call<List<TotalSavings>> call, Response<List<TotalSavings>> response) {
                progressDialog.dismiss();
                totalsArray = response.body();
                totals = totalsArray.get(0).getTotals();

                Toast.makeText(context.getActivity(), totals, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<TotalSavings>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(context.getActivity(), t.toString(), Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });
    }*/

}
