package app.ntnt.finalprojectexamonline.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import app.ntnt.finalprojectexamonline.R;

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