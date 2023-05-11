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
                       "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0YW50YW50YW4zIiwiaWF0IjoxNjgzNzE1ODY0LCJleHAiOjE2OTgxMTU4NjR9.Vq6zAnUXET6bY4_jgZltKJrJILstDqlZespA7uui0QsolCWiuqwwiuyD8UlNeA43hpxu3TL21FWzaIJEYR7IPQ").build();
        return chain.proceed(request);
    }
}
