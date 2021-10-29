package com.terrence.aluda.t_bank.retrofit;

import com.terrence.aluda.t_bank.login.LoginTest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

public interface APIInterface {

    @GET("/customer/254702277060")
    Call<List<LoginTest>> doGetListResources();

   /* @POST("/api/users")
    Call<User> createUser(@Body User user);

    @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);*/
}
