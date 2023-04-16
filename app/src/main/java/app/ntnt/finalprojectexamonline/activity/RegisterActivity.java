package app.ntnt.finalprojectexamonline.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.databinding.ActivityLoginBinding;
import app.ntnt.finalprojectexamonline.databinding.ActivityRegisterBinding;
import app.ntnt.finalprojectexamonline.model.request.RegisterRequest;
import app.ntnt.finalprojectexamonline.model.response.RespRegister;
import app.ntnt.finalprojectexamonline.service.LoginService;
import app.ntnt.finalprojectexamonline.services.BaseAPIService;

import app.ntnt.finalprojectexamonline.services.IAuthService;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private RadioButton rdnChecked;
    private EditText edtUsername,edtPassword,edtEmail;
    private RadioGroup radioGroup;
    private Button buttonSignIn;
    private TextView tvLogin;
    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();


        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Gọi API đăng kí
                createAccount();
            }
        });
    }

    public void createAccount()
    {
        RegisterRequest registerRequest = new RegisterRequest("hoa211111","NTNTngoctan16@","hoa211111@gmail.com","0932340293",
                "Nguyen Thi","Hoa");
//        RegisterRequest registerRequest = getInput();
//        RequestBody descriptionBody =
//                RequestBody.create(MediaType.parse("multipart/form-data"), String.valueOf(registerRequest));

        String request = new Gson().toJson(registerRequest);
        Map<String,String> params = new HashMap<String, String>();
        params.put("data", request);

//
//        Gson gson = new Gson();
//        String json = gson.toJson(registerRequest);
//        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
//        MultipartBody.Part objectPart = MultipartBody.Part.createFormData("object", "object.json", requestBody);
        BaseAPIService.createService(IAuthService.class).register(params).enqueue(new Callback<RespRegister>() {
            @Override
            public void onResponse(Call<RespRegister> call, Response<RespRegister> response) {
                String message = response.message().toString();
                Toast.makeText(RegisterActivity.this, message.toString(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<RespRegister> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Đăng ký thất bại", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(RegisterActivity.this,TestInforActivity.class);
                startActivity(intent);
            }
        });

//        RegisterRequest registerRequest = new RegisterRequest("hoa2111","NTNTngoctan16@","hoa2111@gmail.com","0931140493",
//                "Nguyen Thi","Hoa");

//        LoginService.loginService.createUser(registerRequest.getUsername(),registerRequest.getPassword(),registerRequest.getEmail(),
//                registerRequest.getPhoneNumber(),registerRequest.getFirstName(), registerRequest.getLastName()).enqueue(new Callback<RespRegister>() {
//            @Override
//            public void onResponse(Call<RespRegister> call, Response<RespRegister> response) {
//                String message = response.message().toString();
//                Intent intent = new Intent(RegisterActivity.this,HomeActivity.class);
//
//                Toast.makeText(RegisterActivity.this, "Đăng ký thành công", Toast.LENGTH_LONG).show();
//                startActivity(intent);
//
//            }
//
//            @Override
//            public void onFailure(Call<RespRegister> call, Throwable t) {
//                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
//
//                Toast.makeText(RegisterActivity.this, "Đăng ký thất bại", Toast.LENGTH_LONG).show();
//                startActivity(intent);
//            }
//        });
    }

    private void init()
    {

        tvLogin = binding.txtLogin;
        buttonSignIn = binding.btnSignup;
        String username = binding.edtUsernameSignup.getText().toString();
        String password = binding.edtPasswordSignup.getText().toString();

    }
    private RegisterRequest getInput()
    {
        String username = binding.edtUsernameSignup.getText().toString();
        String password = binding.edtPasswordSignup.getText().toString();
        String phoneNumber = binding.edtPhoneNumber.getText().toString();
        String firstName = binding.edtFirstName.getText().toString();
        String lastName = binding.edtLastName.getText().toString();
        String email = binding.edtEmail.getText().toString();
        return new RegisterRequest(username,password,email,phoneNumber,firstName,lastName);
    }
}