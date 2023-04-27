package app.ntnt.finalprojectexamonline.services;

import java.util.List;

import app.ntnt.finalprojectexamonline.model.entites.Subject;
import app.ntnt.finalprojectexamonline.model.response.ResponseEntity;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ISubjectService {
    @GET("subject")
    Call<ResponseEntity> getAllSubject();
}
