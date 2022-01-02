package com.terrence.aluda.t_bank.retrofit;

import com.terrence.aluda.t_bank.netrequests.AccountStatements;
import com.terrence.aluda.t_bank.netrequests.DefaultResponse;
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

    @GET("/viewstatements/")
    Call<ArrayList<AccountStatements>> getStatements(@Query("user_id") String user_id);

    @GET("/statPreview/")
    Call<ArrayList<AccountStatements>> getStatPreview(@Query("user_id") String user_id);

    @GET("/totalsavings/")
    Call<List<TotalSavings>> getTotalSavings(@Query("user_id") String user_id);

    @GET("/updatedetails/")
    Call<List<LoginTest>> doUpdate(@Query("_fName") String _fName, @Query("_lName") String _lName, @Query("_eAddress") String _eAddress, @Query("_natID") String _natID, @Query("_pNumber") String _pNumber);

    @GET("/register_user/")
    Call<List<DefaultResponse>> doRegister(@Query("_fName") String _fName, @Query("_lName") String _lName, @Query("_eAddress") String _eAddress, @Query("_natID") String _natID, @Query("_pNumber") String _pNumber, @Query("_userPass") String _userPass);

    @GET("/updatepassword/")
    Call<List<DefaultResponse>> changePassword(@Query("_natID") String _natID, @Query("_password") String _password);
   /* @POST("/api/users")
    Call<User> createUser(@Body User user);

    @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);*/
}
