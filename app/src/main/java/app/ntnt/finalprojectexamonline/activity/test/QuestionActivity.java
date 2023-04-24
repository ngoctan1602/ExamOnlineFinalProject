package app.ntnt.finalprojectexamonline.activity.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.adapter.QuestionAdapter;
import app.ntnt.finalprojectexamonline.adapter.TopicAdapter;
import app.ntnt.finalprojectexamonline.model.entites.Question;
import app.ntnt.finalprojectexamonline.model.entites.Topic;

public class QuestionActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    QuestionAdapter questionAdapter;
    List<Question> questions;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_teacher);

        recyclerView = findViewById(R.id.rcv_question);
        setQuestionAdapter();


    }

    private void setQuestionAdapter()
    {
        questionAdapter = new QuestionAdapter(this);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(this,1, GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        questionAdapter.setData(getQuestionById());
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