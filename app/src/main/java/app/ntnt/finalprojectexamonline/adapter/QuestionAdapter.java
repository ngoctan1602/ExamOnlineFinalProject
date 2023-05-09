package app.ntnt.finalprojectexamonline.adapter;

import static androidx.core.content.ContextCompat.startActivity;
import static androidx.recyclerview.widget.RecyclerView.Adapter;
import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.activity.TestInforActivity;
import app.ntnt.finalprojectexamonline.activity.TopicActivity;
import app.ntnt.finalprojectexamonline.activity.test.AddTestActivity;
import app.ntnt.finalprojectexamonline.activity.test.AnswerActivity;
import app.ntnt.finalprojectexamonline.activity.test.QuestionActivity;
import app.ntnt.finalprojectexamonline.model.entites.Question;
import app.ntnt.finalprojectexamonline.model.entites.Topic;
import app.ntnt.finalprojectexamonline.model.response.QuestionResponse;


public class QuestionAdapter extends Adapter<QuestionAdapter.TopicViewHolder> {
    private AddTestActivity context;
    QuestionActivity contextQues;
    List<QuestionResponse> questions;
    List<QuestionResponse> filteredList;
    boolean b;

    public QuestionAdapter(QuestionActivity contextQues) {
        this.contextQues = contextQues;
        this.b=true;
    }

    public QuestionAdapter(AddTestActivity context) {
        this.context = context;
        this.b=false;
    }

    public void setData(List<QuestionResponse> questions) {

        this.questions = questions;
        this.filteredList = new ArrayList<>(questions);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question_teacher, parent, false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        QuestionResponse question = filteredList.get(position);
        if (question == null) {
            return;
        }
        holder.tvIdQuestion.setText(String.valueOf(question.getQuestionId()));
        holder.tvNameQuestion.setText(question.getQuestion());
        if(b==false)
        {
            holder.imgEdit.setVisibility(View.GONE);
        }

//        holder.tvNameTopic.setText(question.getName());
//        holder.imageViewTopic.setImageResource(R.drawable.pic6);
        Glide.with(contextQues).load(question.getImage()).into(holder.imgQuestion);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b==false)
                {
                    Intent intent = new Intent(context, AnswerActivity.class);
                    Bundle bundle = new Bundle();
                    startActivity(context,intent,bundle);
                }

            }
        });
//
//        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                context.showDialogUpdate();
//            }
//        });
//        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                context.showDialogDelete();
//            }
//        });
    }


    @Override
    public int getItemCount() {
        if (filteredList != null)
            return filteredList.size();
        return 0;
    }

    public class TopicViewHolder extends ViewHolder {

        ImageView imgQuestion,imgEdit,imgDelete;
        TextView tvIdQuestion,tvNameQuestion;
        RelativeLayout relativeLayout;

        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);

            imgQuestion= itemView.findViewById(R.id.img_question_teacher);
            tvNameQuestion = itemView.findViewById(R.id.tv_name_question);
            tvIdQuestion = itemView.findViewById(R.id.tv_id_question);
            relativeLayout = itemView.findViewById(R.id.rlt_question_teacher);
            imgEdit= itemView.findViewById(R.id.img_edit_topic);

        }
    }

    public void filter(String query) {
        filteredList.clear();
        if (query.isEmpty()) {
            filteredList.addAll(questions);
        } else {
            for (QuestionResponse item : questions) {
                if (item.getQuestion().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }
}
