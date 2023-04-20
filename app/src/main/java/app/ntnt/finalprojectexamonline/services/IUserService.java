package app.ntnt.finalprojectexamonline.services;

import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface IUserService {
    @POST("updateAvatar")
    @Multipart
    Call<String> updateAvatar(@Part MultipartBody.Part avatar);
}
