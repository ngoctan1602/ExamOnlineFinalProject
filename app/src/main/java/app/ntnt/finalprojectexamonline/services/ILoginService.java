package app.ntnt.finalprojectexamonline.services;

import android.util.Log;

import com.google.gson.JsonObject;

import java.util.Map;

import app.ntnt.finalprojectexamonline.model.request.LoginRequest;
import app.ntnt.finalprojectexamonline.model.request.RegisterRequest;
import app.ntnt.finalprojectexamonline.model.response.AuthResponse;
import app.ntnt.finalprojectexamonline.model.response.RespRegister;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ILoginService {
    @POST("auth/login")
    Call<AuthResponse> login (@Body LoginRequest loginRequest);
    @FormUrlEncoded
    @POST("auth/register")
    Call<RespRegister> register(@FieldMap Map<String,String> params);

//    @Multipart
//    @POST("auth/register")
//    Call<RespRegister> register(
//            @Part MultipartBody.Part object
//    );
}
