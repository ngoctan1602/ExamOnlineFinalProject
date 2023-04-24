package app.ntnt.finalprojectexamonline.fragment.teacher;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.activity.test.HomeTeacherActivity;
import app.ntnt.finalprojectexamonline.adapter.SubjectAdpater;
import app.ntnt.finalprojectexamonline.adapter.TestInforAdapter;
import app.ntnt.finalprojectexamonline.model.TestInfor;
import app.ntnt.finalprojectexamonline.model.entites.Subject;
import app.ntnt.finalprojectexamonline.services.BaseAPIService;
import app.ntnt.finalprojectexamonline.services.ISubjectService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TeacherHomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private SubjectAdpater subjectAdpater;
    private SearchView searchView;
    private List<Subject> subjects;

    private ImageView imageViewAdd;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home_teacher, container, false);
       // Ánh xạ view
        init(view);
        loadData();
        return view;
    }

    private void loadData() {
        subjectAdpater = new SubjectAdpater(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

        subjects = new ArrayList<>();
        for(int i=1;i<10;i++)
        {
            subjects.add(new Subject(1L,"Toán",null));
        }
        subjectAdpater.setData(subjects);
        recyclerView.setAdapter(subjectAdpater);

    }

    private void init(View view)
    {
        recyclerView = view.findViewById(R.id.rcv_subject_home_teacher);
        searchView = view.findViewById(R.id.search_subject);
        imageViewAdd = view.findViewById(R.id.img_addSubject);
    }
}