package app.ntnt.finalprojectexamonline.services;

import java.util.Map;

import app.ntnt.finalprojectexamonline.model.response.ResponseEntity;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

public interface IUserService {
    @POST("updateAvatar")
    @Multipart
    Call<String> updateAvatar(@Part MultipartBody.Part avatar);

    @GET("profile")
    Call<ResponseEntity> getProfile();
}
