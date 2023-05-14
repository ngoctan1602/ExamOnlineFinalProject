package app.ntnt.finalprojectexamonline.activity.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.adapter.AnswerAdapter;
import app.ntnt.finalprojectexamonline.model.entites.Answer;
import app.ntnt.finalprojectexamonline.model.response.AnswerResponse;
import app.ntnt.finalprojectexamonline.model.response.QuestionResponse;

public class AnswerActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AnswerAdapter answerAdapter;
    List<Answer> answers;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        recyclerView= findViewById(R.id.rcv_answer);
        Bundle bundle = getIntent().getExtras();

        List<AnswerResponse> answerResponse= bundle.getParcelableArrayList("question");


        setQuestionAdapter();



    }

    private void setQuestionAdapter()
    {
        answerAdapter = new AnswerAdapter(this);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(this,1, GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
//        answerAdapter.setData(getQuestionById());
        recyclerView.setAdapter(answerAdapter);
    }

    private List<Answer> getQuestionById() {
        answers = new ArrayList<>();
        for(int i=0;i<=2;i++)
        {
            Answer answer = new Answer(1L,1L,"câu này sai nè",0);
            answers.add(answer);
        }
        Answer answer = new Answer(1L,1L,"câu này đúng nè",1);
        answers.add(answer);
        return answers;
    }
}