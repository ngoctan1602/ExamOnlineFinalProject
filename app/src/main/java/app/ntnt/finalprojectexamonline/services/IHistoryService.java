package app.ntnt.finalprojectexamonline.services;

import app.ntnt.finalprojectexamonline.model.request.HistoryRequest;
import app.ntnt.finalprojectexamonline.model.request.TestRequest;
import app.ntnt.finalprojectexamonline.model.response.ResponseEntity;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IHistoryService {

    @POST("history/finishTest")
    Call<ResponseEntity> finishTest(@Body HistoryRequest testId);
}
