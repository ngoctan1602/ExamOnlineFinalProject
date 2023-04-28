package app.ntnt.finalprojectexamonline.services;

import app.ntnt.finalprojectexamonline.model.request.QuestionRequest;
import app.ntnt.finalprojectexamonline.model.request.RegisterRequest;
import app.ntnt.finalprojectexamonline.model.response.ResponseEntity;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface IQuestionService {
    @Multipart
    @POST("/question/add")
    Call<ResponseEntity> addQuestion(@Part("question") QuestionRequest question,
                                     @Part MultipartBody.Part image);
}
