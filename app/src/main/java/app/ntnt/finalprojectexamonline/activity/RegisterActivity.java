package app.ntnt.finalprojectexamonline.activity;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.databinding.ActivityRegisterBinding;
import app.ntnt.finalprojectexamonline.fragment.UploadImageFragment;
import app.ntnt.finalprojectexamonline.model.request.RegisterRequest;
import app.ntnt.finalprojectexamonline.model.response.RespRegister;
import app.ntnt.finalprojectexamonline.services.BaseAPIService;

import app.ntnt.finalprojectexamonline.services.IAuthService;
import app.ntnt.finalprojectexamonline.utils.AppConstrain;
import app.ntnt.finalprojectexamonline.utils.RealPathUtil;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements UploadImageFragment.OnImageUploadedListener {
    private ActivityRegisterBinding binding;
    private Uri mUri;
    UploadImageFragment uploadImageFragment;
    private void initFragMent(){
       uploadImageFragment = UploadImageFragment.getInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.uploadImage, uploadImageFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onImageUploaded(Uri uri) {
        mUri = uri;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initFragMent();

        binding.txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()){
                    //Gọi API đăng kí
                    createAccount();
                }
            }
        });
    }

    private boolean validate(){
        if (binding.edtEmail.getText()== null)
        {
            binding.edtEmail.setError("Vui lòng nhập thông tin");
            return false;
        }
        if (binding.edtFirstName.getText()== null)
        {
            binding.edtFirstName.setError("Vui lòng nhập thông tin");
            return false;
        }
        if (binding.edtLastName.getText()== null)
        {
            binding.edtLastName.setError("Vui lòng nhập thông tin");
            return false;
        }
        if (binding.edtPhoneNumber.getText()== null)
        {
            binding.edtPhoneNumber.setError("Vui lòng nhập thông tin");
            return false;
        }
        if (binding.edtUsernameSignup.getText()== null)
        {
            binding.edtUsernameSignup.setError("Vui lòng nhập thông tin");
            return false;
        }
        if (binding.edtPasswordSignup.getText() == null)
        {
            binding.edtPasswordSignup.setError("Vui lòng nhập thông tin");
            return false;
        }
        else{
            return true;
        }
    }

    private RegisterRequest getInputData(){
        RegisterRequest userRegister = new RegisterRequest();
        userRegister.setGender(binding.radioGroup.toString());
        userRegister.setFirstName(binding.edtFirstName.getText().toString());
        userRegister.setLastName(binding.edtLastName.getText().toString());
        userRegister.setEmail(binding.edtEmail.getText().toString());
        userRegister.setPhoneNumber(binding.edtPhoneNumber.getText().toString());
        userRegister.setUsername(binding.edtUsernameSignup.getText().toString());
        userRegister.setPassword(binding.edtPasswordSignup.getText().toString());
        return userRegister;
    }

    public void createAccount()
    {
        MultipartBody.Part avatar = AppConstrain.toPart(this, mUri);
        RegisterRequest userRegister = getInputData();
        BaseAPIService.createService(IAuthService.class).register(userRegister, avatar).enqueue(new Callback<RespRegister>() {
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
//                Intent intent = new Intent(RegisterActivity.this,TestInforActivity.class);
//                startActivity(intent);
            }
        });
    }

}