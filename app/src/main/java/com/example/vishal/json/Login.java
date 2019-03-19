package com.example.vishal.json;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.vishal.json.Remote.IMyAPI;
import com.example.vishal.json.model.APIResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
EditText email,password;
Button login;
TextView txt_register;
    IMyAPI mService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);

       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               authenticateUser(email.getText().toString(),password.getText().toString());
               
           }

           private void authenticateUser(String email, String password) {

               mService.loginUser(email,password).enqueue(new Callback<APIResponse>() {
                   @Override
                   public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
APIResponse result=response.body();

                   }

                   @Override
                   public void onFailure(Call<APIResponse> call, Throwable t) {
                Toast.makeText(Login.this,t.getMessage(),Toast.LENGTH_LONG).show();
                   }
               });

           }
       });
    }
}
