package app.ntnt.finalprojectexamonline.services;

import androidx.annotation.NonNull;

import java.io.IOException;

import app.ntnt.finalprojectexamonline.model.response.AuthResponse;
import app.ntnt.finalprojectexamonline.utils.ContextUtil;
import app.ntnt.finalprojectexamonline.utils.SharedPrefManager;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestInterceptor implements Interceptor {
    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
//        if (SharedPrefManager.getInstance(ContextUtil.context).isLoggedIn()) {
//            AuthResponse authResponse = SharedPrefManager.getInstance(ContextUtil.context).getAuthToken();
//            if (authResponse != null){
//                request = request.newBuilder().addHeader(
//                        "Authorization",
//                        "Bearer "+
//                                authResponse.getToken()).build();
//            }
//        }
        request = request.newBuilder().addHeader(
                "Authorization",
                "Bearer "+
                       "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0YW50YW50YW4zIiwiaWF0IjoxNjgzMzc5MDk0LCJleHAiOjE2OTc3NzkwOTR9.yfDxSjRbFz9AHEOW_git3vSIETn5SmiGsJogjZ5LRVxh-qVe04SXrTnLj6UH0pIrDhLnaXO34ZNaVZo9_Or6uA").build();
        return chain.proceed(request);
    }
}
