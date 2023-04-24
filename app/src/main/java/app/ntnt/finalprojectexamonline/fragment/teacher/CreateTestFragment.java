package app.ntnt.finalprojectexamonline.fragment.teacher;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.activity.test.AddTestActivity;
import app.ntnt.finalprojectexamonline.adapter.TestAdapter;
import app.ntnt.finalprojectexamonline.model.entites.Test;


public class CreateTestFragment extends Fragment {
    RecyclerView recyclerView;
    TestAdapter testAdapter;
    LinearLayout randomTest,addTest;
    SearchView search_test;
    List<Test> tests;

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_create_teacher, container, false);
        init(view);
        addTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddTestActivity.class);
                startActivity(intent);
            }
        });
//        recyclerView = view.findViewById(R.id.rcv_exam_complete);
//        loadDataTest();
        return view;
    }

    private void loadDataTest()
    {
//        testAdapter = new TestAdapter(this);
//        GridLayoutManager gridLayoutManager= new GridLayoutManager(getContext(),1, GridLayoutManager.VERTICAL,false);
//        recyclerView.setLayoutManager(gridLayoutManager);
//        testAdapter.setData(getFeaturedExam());
//        recyclerView.setAdapter(testAdapter);
    }

    private List<Test> getFeaturedExam() {
        tests = new ArrayList<>();
        for(int i=0;i<=10;i++)
        {
            Test test = new Test(1,"Đề quốc gia",8,"Toán",45,1);
            tests.add(test);
        }

        return tests;
    }

    private void init(View view)
    {
        search_test = view.findViewById(R.id.search_test);
        recyclerView = view.findViewById(R.id.rcv_test_created);
        randomTest = view.findViewById(R.id.llt_randomtest);
        addTest = view.findViewById(R.id.llt_addTest);
    }
}