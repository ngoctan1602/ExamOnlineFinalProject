package app.ntnt.finalprojectexamonline.activity.teacher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.fragment.UploadImageFragment;
import app.ntnt.finalprojectexamonline.model.request.AnswerRequest;
import app.ntnt.finalprojectexamonline.model.request.QuestionRequest;
import app.ntnt.finalprojectexamonline.model.response.RespRegister;
import app.ntnt.finalprojectexamonline.model.response.ResponseEntity;
import app.ntnt.finalprojectexamonline.services.BaseAPIService;
import app.ntnt.finalprojectexamonline.services.IQuestionService;
import app.ntnt.finalprojectexamonline.services.ISubjectService;
import app.ntnt.finalprojectexamonline.services.ITopicService;
import app.ntnt.finalprojectexamonline.utils.AppConstrain;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddTopicActivity extends AppCompatActivity implements UploadImageFragment.OnImageUploadedListener{
    Button btnOk, btnCancel;
    UploadImageFragment uploadImageFragment;
    EditText editText;
    TextView textView;
    Uri mUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_add_subject);

        btnOk = findViewById(R.id.dialog_btn_Ok);
        btnCancel = findViewById(R.id.dialog_btn_Cancel);
        editText =findViewById(R.id.editTextTextPersonName);
        textView = findViewById(R.id.tv_dialog_text);

        editText.setHint("Thêm chủ đề");
        textView.setText("Thêm chủ đề");


        Bundle bundle = getIntent().getExtras();
        long subjectId = bundle.getLong("subjectId");

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTopic(subjectId);
            }
        });

        initFragMent();

    }
    private void addTopic(long subjectId)
    {
//        RequestBody subjectIdRes = RequestBody.create(MediaType.parse("multipart/form-data"), String.valueOf(subjectId));
//        RequestBody name = RequestBody.create(MediaType.parse("multipart/form-data"), editText.getText().toString());
        MultipartBody.Part img = AppConstrain.toPart(this, mUri);
        Log.d("TAG", "onResponse: "+img);

        List<AnswerRequest> answerRequestList = new ArrayList<>();
        AnswerRequest answerRequest = new AnswerRequest("Câu này đúng",true);
        AnswerRequest answerRequest1 = new AnswerRequest("Câu này sai",false);
        answerRequestList.add(answerRequest);
        answerRequestList.add(answerRequest1);
        QuestionRequest questionRequest = new QuestionRequest("Câu hỏi nè",13L,answerRequestList);
//        Log.d("TAG", "addTopic: ");

        BaseAPIService.createService(IQuestionService.class).addQuestion(questionRequest,img).enqueue(new Callback<ResponseEntity>() {
            @Override
            public void onResponse(Call<ResponseEntity> call, Response<ResponseEntity> response) {
                boolean b = response.body().isError();
                Log.d("TAG", "onResponse: "+b);
            }

            @Override
            public void onFailure(Call<ResponseEntity> call, Throwable t) {
                Log.d("TAG", "onResponse: failed");
            }
        });

    }
    private void initFragMent() {
        uploadImageFragment = UploadImageFragment.getInstance();
        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.img_dialog_addImage, uploadImageFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onImageUploaded(Uri uri) {
        mUri = uri;
    }
}