package com.terrence.aluda.t_bank.retrofit;

import com.terrence.aluda.t_bank.netrequests.AccountStatements;
import com.terrence.aluda.t_bank.netrequests.LoginTest;
import com.terrence.aluda.t_bank.netrequests.TotalSavings;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.ArrayList;
import java.util.List;

public interface APIInterface {
    @GET("/customer/")
    Call<List<LoginTest>> doAuthenticate(@Query("user_phone") String user_phone, @Query("user_token") String user_token);

    @GET("/viewstatements/37378962")
    Call<ArrayList<AccountStatements>> getStatements(/*@Query("user_phone") String user_phone*/);
    @GET("/statPreview/37378962")
    Call<ArrayList<AccountStatements>> getStatPreview(/*@Query("user_phone") String user_phone*/);
    @GET("/totalsavings/37378962")
    Call<List<TotalSavings>> getTotalSavings(/*@Query("user_phone") String user_phone*/);
   /* @POST("/api/users")
    Call<User> createUser(@Body User user);

    @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);*/
}
