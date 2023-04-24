package app.ntnt.finalprojectexamonline.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.adapter.AnswerAdapter;
import app.ntnt.finalprojectexamonline.model.entites.Answer;
import app.ntnt.finalprojectexamonline.model.entites.Question;

public class QuestionFragment extends Fragment {
    private View view;
    private TextView textView;

    private RecyclerView recyclerView;
    private AnswerAdapter answerAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_question, container, false);
        textView= view.findViewById(R.id.txt_ques);
        recyclerView = view.findViewById(R.id.rcv_anwser);


        answerAdapter = new AnswerAdapter(getContext());
        GridLayoutManager gridLayoutManager= new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);

        List<Answer> list = new ArrayList<Answer>();
        Bundle bundle = getArguments();
        if(bundle !=null)
        {
            Question question = (Question) bundle.getSerializable("question_object");
            list = (List<Answer>) bundle.getSerializable("answers_object");
            if(question!=null)
            {
                textView.setText(question.getName());
            }
        }
        answerAdapter.setData(list);
        recyclerView.setAdapter(answerAdapter);
        return view;
    }
}
