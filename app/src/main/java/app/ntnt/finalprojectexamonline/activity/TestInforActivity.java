package app.ntnt.finalprojectexamonline.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.adapter.TestInforAdapter;
import app.ntnt.finalprojectexamonline.adapter.TopicAdapter;
import app.ntnt.finalprojectexamonline.model.TestInfor;
import app.ntnt.finalprojectexamonline.model.response.QuestionResponse;
import app.ntnt.finalprojectexamonline.model.response.ResponseEntity;
import app.ntnt.finalprojectexamonline.model.response.TestResponse;
import app.ntnt.finalprojectexamonline.services.BaseAPIService;
import app.ntnt.finalprojectexamonline.services.ITestService;
import app.ntnt.finalprojectexamonline.utils.AppConstrain;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TestInforActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TestInforAdapter testInforAdapter;
    List<TestInfor> testInfors;
    TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_infor);
        textView = findViewById(R.id.tv_name_test_of_topic);

        Bundle bundle = getIntent().getExtras();
        Long topicId = (Long) bundle.getSerializable("topicId");
        String nameTopic = (String)bundle.getSerializable("nameTopic");
        textView.setText("Danh sách chủ đề môn "+nameTopic);

        recyclerView = findViewById(R.id.rcv_test);
        loadDataTest(topicId);
    }

    private void loadDataTest(Long topicId)
    {
        testInforAdapter = new TestInforAdapter(this);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(this,1, GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
//        testInforAdapter.setData(getFeaturedExam());
//        recyclerView.setAdapter(testInforAdapter);


        BaseAPIService.createService(ITestService.class).getTestInTopic(topicId,0,100).enqueue(new Callback<ResponseEntity>() {
            @Override
            public void onResponse(Call<ResponseEntity> call, Response<ResponseEntity> response) {
                Log.d("TAG", "onResponse: sucess");

                List<Object> objects;
                objects = AppConstrain.objectList(response.body().getData(), TestResponse.class);
                List<TestResponse> testResponses = new ArrayList<>();
                for (Object i: objects){
                    testResponses.add((TestResponse) i);
                }
                testInforAdapter.setData(testResponses);
                recyclerView.setAdapter(testInforAdapter);
            }

            @Override
            public void onFailure(Call<ResponseEntity> call, Throwable t) {
                Log.d("TAG", "onResponse: failed");
            }
        });
    }

    private List<TestInfor> getFeaturedExam() {
        testInfors = new ArrayList<>();
        for(int i=0;i<=10;i++)
        {
            TestInfor test = new TestInfor(1,"Đề quốc gia lần 1","Toán",45,"Nguyễn Văn B","29/3/2023");
            testInfors.add(test);
        }

        return testInfors;
    }
}