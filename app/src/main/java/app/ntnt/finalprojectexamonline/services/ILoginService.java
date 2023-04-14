package app.ntnt.finalprojectexamonline.services;

import android.util.Log;

import com.google.gson.JsonObject;

import app.ntnt.finalprojectexamonline.model.request.LoginRequest;
import app.ntnt.finalprojectexamonline.model.response.AuthResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ILoginService {
    @POST("auth/login")
    Call<AuthResponse> login (@Body LoginRequest loginRequest);

}
