package app.ntnt.finalprojectexamonline.adapter;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.io.Serializable;
import java.util.List;

import app.ntnt.finalprojectexamonline.fragment.QuestionFragment;
import app.ntnt.finalprojectexamonline.model.entites.Answer;
import app.ntnt.finalprojectexamonline.model.entites.Question;

public class LoadQuestionAdapter extends FragmentStateAdapter {
    List<List<Answer>> answers;
    List<Question> questions;
    public LoadQuestionAdapter(@NonNull FragmentActivity fragment, List<Question> questions, List<List<Answer>> answers) {
        super(fragment);
        this.questions= questions;
        this.answers = answers;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if(questions!=null)
        {
            Question question = questions.get(position);
            List<Answer> answers1 = answers.get(position);
            QuestionFragment questionFragment= new QuestionFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("question_object",question);
            bundle.putSerializable("answers_object", (Serializable) answers1);
            questionFragment.setArguments(bundle);
            return questionFragment;
        }
        return null;
    }

    @Override
    public int getItemCount() {
        if(questions!=null)
            return answers.size();
        return 0;
    }
}
