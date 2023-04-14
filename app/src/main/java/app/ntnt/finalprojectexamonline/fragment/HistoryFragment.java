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
import app.ntnt.finalprojectexamonline.adapter.TestAdapter;
import app.ntnt.finalprojectexamonline.model.Test;


public class HistoryFragment extends Fragment {
    RecyclerView recyclerView;
    TestAdapter testAdapter;
    List<Test> tests;

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_history, container, false);
        recyclerView = view.findViewById(R.id.rcv_exam_complete);
        loadDataTest();
        return view;
    }

    private void loadDataTest()
    {
        testAdapter = new TestAdapter(this);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(getContext(),1, GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        testAdapter.setData(getFeaturedExam());
        recyclerView.setAdapter(testAdapter);
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
}