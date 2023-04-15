package app.ntnt.finalprojectexamonline.activity;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {


    private ActivityLoginBinding binding;
    private Button btnLogin;
    private EditText edtUsername,edtPassword;
    private TextView tvSignup;

    ProgressBar progressBar;

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
                progressBar.setVisibility(View.VISIBLE);
                //Lấy thông tin từ người dùng nhập
                String username = binding.edtUsername.getText().toString();
                String password = binding.edtPassword.getText().toString();
                LoginRequest loginRequest = new LoginRequest(username, password);
                BaseAPIService.createService(ILoginService.class).login(loginRequest)
                        .enqueue(new Callback<AuthResponse>() {
                            @Override
                            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                                Log.d("true", response.message().toString());
                                Log.d("token", response.body().getToken());
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                if(username.equals("tan") && password.equals("123"))
                {
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(intent);

                }
                else
                {
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(LoginActivity.this, "Đăng nhập thất bại", Toast.LENGTH_LONG).show();
                }

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