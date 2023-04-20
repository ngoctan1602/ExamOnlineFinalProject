package app.ntnt.finalprojectexamonline.services;


import java.lang.reflect.Modifier;
import java.util.Map;

import app.ntnt.finalprojectexamonline.model.request.LoginRequest;
import app.ntnt.finalprojectexamonline.model.request.Register;
import app.ntnt.finalprojectexamonline.model.request.RegisterRequest;
import app.ntnt.finalprojectexamonline.model.response.AuthResponse;
import app.ntnt.finalprojectexamonline.model.response.RespRegister;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface IAuthService {
    @POST("auth/login")
    Call<AuthResponse> login (@Body LoginRequest loginRequest);


    @Multipart
    @POST("auth/register")
    Call<RespRegister> register(@Part("user") RegisterRequest userRequest,
                                @Part MultipartBody.Part avatar);

}
