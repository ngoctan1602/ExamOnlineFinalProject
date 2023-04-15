package app.ntnt.finalprojectexamonline.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.model.RespRegister;
import app.ntnt.finalprojectexamonline.service.LoginService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    RadioButton rdbMale,rdbFemale;
    EditText edtUsername,edtPassword,edtEmail;
    Button buttonSignIn;
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

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
        LoginService.loginService.createUser("tantantan","NTNTngoctan16@","ngoctannn@gmail.com",
                "0923092309","Nguyễn Thái Ngọc", "Tân").enqueue(new Callback<RespRegister>() {
            @Override
            public void onResponse(Call<RespRegister> call, Response<RespRegister> response) {
                String message = response.message().toString();
                Intent intent = new Intent(RegisterActivity.this,HomeActivity.class);

                Toast.makeText(RegisterActivity.this, "Đăng ký thành công", Toast.LENGTH_LONG).show();
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<RespRegister> call, Throwable t) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);

                Toast.makeText(RegisterActivity.this, "Đăng ký thất bại", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }

    private void init()
    {
        rdbMale = findViewById(R.id.radio_male);
        rdbFemale = findViewById(R.id.rdn_female);
        tvLogin = findViewById(R.id.txtLogin);
        edtUsername = findViewById(R.id.edt_username_signup);
        edtPassword = findViewById(R.id.edt_password_signup);
        edtEmail = findViewById(R.id.edt_email);
        buttonSignIn = findViewById(R.id.btn_signup);

    }
}