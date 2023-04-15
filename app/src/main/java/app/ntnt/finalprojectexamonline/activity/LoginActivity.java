package app.ntnt.finalprojectexamonline.activity;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.databinding.ActivityLoginBinding;
import app.ntnt.finalprojectexamonline.model.request.LoginRequest;
import app.ntnt.finalprojectexamonline.model.response.AuthResponse;
import app.ntnt.finalprojectexamonline.services.BaseAPIService;
import app.ntnt.finalprojectexamonline.services.ILoginService;
import app.ntnt.finalprojectexamonline.utils.SharedPrefManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private Button btnLogin;
    private EditText edtUsername,edtPassword;
    private TextView tvSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        binding =ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        //Ánh xạ
        init();
        //Chuyển trang đăng kí
        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        //Xét sự kiện login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Lấy thông tin từ người dùng nhập
                String username = binding.edtUsername.getText().toString();
                String password = binding.edtPassword.getText().toString();
                LoginRequest loginRequest = new LoginRequest(username, password);
                String params = new Gson().toJson(loginRequest);
                JsonParser parser = new JsonParser();
                BaseAPIService.createService(ILoginService.class).login(loginRequest)
                        .enqueue(new Callback<AuthResponse>() {
                            @Override
                            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                                Log.d("true", response.message().toString());
                                Log.d("token", response.body().getToken());
                                SharedPrefManager.getInstance(getApplicationContext()).saveAuthToken(response.body());
                                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                                startActivity(intent);
                            }

                            @Override
                            public void onFailure(Call<AuthResponse> call, Throwable t) {
                                Log.d("error", t.getMessage().toString());
                            }
                        });
            }
        });
    }

    private void init()
    {
        btnLogin = binding.btnLogin;
        tvSignup = binding.txtSignUp;
    }
}