package app.ntnt.finalprojectexamonline.services;

import app.ntnt.finalprojectexamonline.model.request.LoginRequest;
import app.ntnt.finalprojectexamonline.model.response.AuthResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IAuthService {
    @POST("auth/login")
    Call<AuthResponse> login (@Body LoginRequest loginRequest);

}
