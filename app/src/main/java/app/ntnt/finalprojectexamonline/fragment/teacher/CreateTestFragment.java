package app.ntnt.finalprojectexamonline.fragment.teacher;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import app.ntnt.finalprojectexamonline.adapter.SpinnerAdapter;
import app.ntnt.finalprojectexamonline.adapter.TestAdapter;
import app.ntnt.finalprojectexamonline.model.entites.Test;
import app.ntnt.finalprojectexamonline.model.entites.Topic;
import app.ntnt.finalprojectexamonline.model.response.ResponseEntity;
import app.ntnt.finalprojectexamonline.model.response.SubjectResponse;
import app.ntnt.finalprojectexamonline.model.response.TestResponse;
import app.ntnt.finalprojectexamonline.model.response.TopicResponse;
import app.ntnt.finalprojectexamonline.services.BaseAPIService;
import app.ntnt.finalprojectexamonline.services.ISubjectService;
import app.ntnt.finalprojectexamonline.services.ITestService;
import app.ntnt.finalprojectexamonline.services.ITopicService;
import app.ntnt.finalprojectexamonline.utils.AppConstrain;
import app.ntnt.finalprojectexamonline.utils.SharedPrefManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CreateTestFragment extends Fragment {
    RecyclerView recyclerView;
    TestAdapter testAdapter;
    LinearLayout addTest;
    SearchView search_test;
    List<Test> tests;
    ArrayList<Topic> topics;
    List<Object> obList= new ArrayList<>();
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
        return view;
    }


    private void init(View view)
    {
        addTest = view.findViewById(R.id.llt_addTest);
    }


}