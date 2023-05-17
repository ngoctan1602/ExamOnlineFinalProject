package app.ntnt.finalprojectexamonline.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.Glide;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.activity.teacher.HomeTeacherActivity;
import app.ntnt.finalprojectexamonline.fragment.UploadImageFragment;
import app.ntnt.finalprojectexamonline.model.response.ResponseEntity;
import app.ntnt.finalprojectexamonline.services.BaseAPIService;
import app.ntnt.finalprojectexamonline.services.IUserService;
import app.ntnt.finalprojectexamonline.utils.AppConstrain;
import app.ntnt.finalprojectexamonline.utils.SharedPrefManager;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateAvatar extends AppCompatActivity implements UploadImageFragment.OnImageUploadedListener{

    UploadImageFragment uploadImageFragment;
    Button btnUpdate;
    Uri mUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_avatar);
        btnUpdate= findViewById(R.id.btn_update_avt);


        initFragMent();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
    }

    private void update()
    {
        MultipartBody.Part avatar = AppConstrain.toPart(this, mUri);
        Log.d("TAG", "onResponse: "+mUri.toString());

        BaseAPIService.createService(IUserService.class).updateAvatar(avatar).enqueue(new Callback<ResponseEntity>() {
            @Override
            public void onResponse(Call<ResponseEntity> call, Response<ResponseEntity> response) {
                Log.d("TAG", "onResponse: thành công");
                if(SharedPrefManager.getInstance(UpdateAvatar.this).getAuthToken().getRoles().equals("Role_student"))
                {
                    startActivity(new Intent(UpdateAvatar.this,HomeActivity.class));
                }
                else {
                    startActivity(new Intent(UpdateAvatar.this, HomeTeacherActivity.class));
                }

            }

            @Override
            public void onFailure(Call<ResponseEntity> call, Throwable t) {
                Log.d("TAG", "onResponse: thất bại");
            }
        });
    }

    private void initFragMent() {
        uploadImageFragment = UploadImageFragment.getInstance();
        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.img_update_avatar, uploadImageFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onImageUploaded(Uri uri) {
        mUri = uri;
    }
}