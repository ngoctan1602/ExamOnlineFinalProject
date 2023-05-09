package app.ntnt.finalprojectexamonline.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.adapter.SubjectAdpater;
import app.ntnt.finalprojectexamonline.adapter.TestInforAdapter;
import app.ntnt.finalprojectexamonline.model.TestInfor;
import app.ntnt.finalprojectexamonline.model.entites.Subject;
import app.ntnt.finalprojectexamonline.model.response.ResponseEntity;
import app.ntnt.finalprojectexamonline.model.response.SubjectResponse;
import app.ntnt.finalprojectexamonline.services.BaseAPIService;
import app.ntnt.finalprojectexamonline.services.ISubjectService;
import app.ntnt.finalprojectexamonline.utils.AppConstrain;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
//        loadDataTest();

        return view;
    }

//    private void loadDataTest()
//    {
//        testInforAdapter = new TestInforAdapter(this);
//        GridLayoutManager gridLayoutManager= new GridLayoutManager(getContext(),1, GridLayoutManager.VERTICAL,false);
//        rcvTest.setLayoutManager(gridLayoutManager);
//        testInforAdapter.setData(getFeaturedExam());
//        rcvTest.setAdapter(testInforAdapter);
//    }

//    private List<TestInfor> getFeaturedExam() {
//        testInforList = new ArrayList<>();
//        for(int i=0;i<=10;i++)
//        {
//            TestInfor test = new TestInfor(1,"Đề quốc gia lần 1","Toán",45,"Nguyễn Văn B","29/3/2023");
//            testInforList.add(test);
//        }
//
//        return testInforList;
//    }

    private void loadDataSubject() {
        subjectAdapter = new SubjectAdpater(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        rcvSubject.setLayoutManager(gridLayoutManager);

        BaseAPIService.createService(ISubjectService.class).getAllSubject()
                .enqueue(new Callback<ResponseEntity>() {
                    @Override
                    public void onResponse(Call<ResponseEntity> call, Response<ResponseEntity> response) {
                        if (response.body()!= null){
                            if (!response.body().isError()){
                                List<Object> objects;
                                List<SubjectResponse> subjectResponses = new ArrayList<>();
                                objects = AppConstrain.objectList(response.body().getData(), SubjectResponse.class);
                                for (Object i: objects){
                                    subjectResponses.add((SubjectResponse) i);
                                }
                                subjects = new ArrayList<>();
                                for (SubjectResponse i: subjectResponses){
                                    subjects.add(new Subject(i.getSubjectId(), i.getName(), i.getImage()));
                                }
                                subjectAdapter.setData(subjects);
                                rcvSubject.setAdapter(subjectAdapter);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseEntity> call, Throwable t) {
                        Log.d("erroeee rồi", t.getMessage().toString());
                    }
                });
    }

    private void init(View view)
    {
        rcvSubject = view.findViewById(R.id.rcv_subject_home);
        rcvTest =view.findViewById(R.id.rcv_featured_exam);
    }
}