package com.terrence.aluda.t_bank.retrofit;

import com.terrence.aluda.t_bank.netrequests.LoginTest;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface APIInterface {
    @GET("/customer/")
    Call<List<LoginTest>> doAuthenticate(@Query("user_phone") String user_phone, @Query("user_token") String user_token);

   /* @POST("/api/users")
    Call<User> createUser(@Body User user);

    @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);*/
}
