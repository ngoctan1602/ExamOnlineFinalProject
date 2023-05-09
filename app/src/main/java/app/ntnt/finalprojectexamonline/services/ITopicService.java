package app.ntnt.finalprojectexamonline.services;

import app.ntnt.finalprojectexamonline.model.response.RespRegister;
import app.ntnt.finalprojectexamonline.model.response.TopicResponse;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ITopicService {
    @GET("topic")
    Call<TopicResponse> getTopicBySubjectId(@Query("subjectId") long subjectId);

    @Multipart
    @POST("topic/add")
    Call<RespRegister> addTopic(
            @Part("subjectId") RequestBody subjectId,
            @Part("name") RequestBody name,
            @Part MultipartBody.Part image
    );

}
