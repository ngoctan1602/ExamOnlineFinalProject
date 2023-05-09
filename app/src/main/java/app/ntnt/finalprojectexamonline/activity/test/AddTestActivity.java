package app.ntnt.finalprojectexamonline.activity.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.adapter.QuestionAdapter;
import app.ntnt.finalprojectexamonline.fragment.DialogFragmentTest;
import app.ntnt.finalprojectexamonline.model.entites.Question;
import app.ntnt.finalprojectexamonline.model.entites.Subject;
import app.ntnt.finalprojectexamonline.model.entites.Topic;

public class AddTestActivity extends AppCompatActivity {
    Spinner spinnerSubject,spinnerTopic;
    QuestionAdapter questionAdapter;
    List<Question> questions;
    RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_test_teacher);


        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject(1L,"Toán",null));
        subjects.add(new Subject(1L,"Lý",null));
        subjects.add(new Subject(1L,"Hóa",null));
        subjects.add(new Subject(1L,"Địa",null));

        List<Topic> topics = new ArrayList<>();
        topics.add(new Topic(1L,"Chuyển động thẳng đều",null,1));
        topics.add(new Topic(1L,"Chuyển động nhanh dần đều",null,1));
        topics.add(new Topic(1L,"Chuyển động chậm dần đều",null,1));
        topics.add(new Topic(1L,"Chuyển động thẳng đều đều đều đều",null,1));
        spinnerSubject = findViewById(R.id.spinner2);
        spinnerTopic= findViewById(R.id.spinner3);
        recyclerView = findViewById(R.id.rcv_list_ques);


       // imageViewEdit.setVisibility(View.GONE);

        ArrayAdapter<Subject> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, subjects);

        ArrayAdapter<Topic> adapter2 =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, topics);
        spinnerTopic.setAdapter(adapter2);
        spinnerSubject.setAdapter(adapter);
        setQuestionAdapter();

//        DialogFragmentTest dialog = new DialogFragmentTest();
//        dialog.show(getSupportFragmentManager(), "MyDialogFragment");


    }

    private void setQuestionAdapter()
    {
        questionAdapter = new QuestionAdapter(this);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(this,1, GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        //questionAdapter.setData(getQuestionById());
        recyclerView.setAdapter(questionAdapter);
    }

    private List<Question> getQuestionById() {
        questions = new ArrayList<>();
        for(int i=0;i<=10;i++)
        {
            Question question = new Question(1L,"Chuyển động thẳng đều","null",1L);
            questions.add(question);
        }

        return questions;
    }
}