package com.example.vishal.json.Remote;

import com.example.vishal.json.model.APIResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IMyAPI {
    @FormUrlEncoded
    @POST("user_login_webservices.php")
    Call<APIResponse> loginUser(@Field("email") String email,@Field("password") String password);


}
