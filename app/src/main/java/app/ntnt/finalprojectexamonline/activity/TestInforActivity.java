package app.ntnt.finalprojectexamonline.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.adapter.TestInforAdapter;
import app.ntnt.finalprojectexamonline.adapter.TopicAdapter;
import app.ntnt.finalprojectexamonline.model.TestInfor;


public class TestInforActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TestInforAdapter testInforAdapter;
    List<TestInfor> testInfors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_infor);

        recyclerView = findViewById(R.id.rcv_test);
        loadDataTest();
    }

    private void loadDataTest()
    {
        testInforAdapter = new TestInforAdapter(this);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(this,1, GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        testInforAdapter.setData(getFeaturedExam());
        recyclerView.setAdapter(testInforAdapter);
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