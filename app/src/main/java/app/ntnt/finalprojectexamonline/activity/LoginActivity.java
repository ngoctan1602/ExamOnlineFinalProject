package app.ntnt.finalprojectexamonline.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import app.ntnt.finalprojectexamonline.R;


public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText edtUsername,edtPassword;
    TextView tvSignup;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Ánh xạ
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


            }
        });
    }

    private void init()
    {
        btnLogin = findViewById(R.id.btn_login);
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        tvSignup = findViewById(R.id.txtSignUp);
        progressBar = findViewById(R.id.prb_login);
    }
}