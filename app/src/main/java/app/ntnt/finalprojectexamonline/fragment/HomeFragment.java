package app.ntnt.finalprojectexamonline.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.adapter.SubjectAdpater;
import app.ntnt.finalprojectexamonline.adapter.TestInforAdapter;
import app.ntnt.finalprojectexamonline.model.entites.Subject;
import app.ntnt.finalprojectexamonline.model.TestInfor;


public class HomeFragment extends Fragment {
    SubjectAdpater subjectAdapter;
    TestInforAdapter testInforAdapter;
    RecyclerView rcvSubject;
    RecyclerView rcvTest;
    List<Subject> subjects;
    List<TestInfor> testInforList;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
       // Ánh xạ view
        init(view);
        //Load dữ liệu cho rcv Môn học
        loadDataSubject();
        loadDataTest();

        return view;
    }

    private void loadDataTest()
    {
        testInforAdapter = new TestInforAdapter(this);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(getContext(),1, GridLayoutManager.VERTICAL,false);
        rcvTest.setLayoutManager(gridLayoutManager);
        testInforAdapter.setData(getFeaturedExam());
        rcvTest.setAdapter(testInforAdapter);
    }

    private List<TestInfor> getFeaturedExam() {
        testInforList = new ArrayList<>();
        for(int i=0;i<=10;i++)
        {
            TestInfor test = new TestInfor(1,"Đề quốc gia lần 1","Toán",45,"Nguyễn Văn B","29/3/2023");
            testInforList.add(test);
        }

        return testInforList;
    }

    private void loadDataSubject() {
        subjectAdapter = new SubjectAdpater(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        rcvSubject.setLayoutManager(gridLayoutManager);
        subjectAdapter.setData(getAllSubject());
        rcvSubject.setAdapter(subjectAdapter);
    }

    private List<Subject> getAllSubject() {
        subjects = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Subject subject = new Subject(i, "Toán", "https://images.pexels.com/photos/14819864/pexels-photo-14819864.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
            subjects.add(subject);
        }
        return subjects;
    }
    private void init(View view)
    {
        rcvSubject = view.findViewById(R.id.rcv_subject_home);
        rcvTest =view.findViewById(R.id.rcv_featured_exam);
    }
}