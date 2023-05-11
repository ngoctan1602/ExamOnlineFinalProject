package app.ntnt.finalprojectexamonline.adapter;

import static androidx.recyclerview.widget.RecyclerView.Adapter;
import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.activity.test.AnswerActivity;
import app.ntnt.finalprojectexamonline.activity.test.QuestionActivity;
import app.ntnt.finalprojectexamonline.fragment.QuestionFragment;
import app.ntnt.finalprojectexamonline.model.entites.Answer;
import app.ntnt.finalprojectexamonline.model.entites.Question;
import app.ntnt.finalprojectexamonline.model.response.AnswerResponse;


public class AnswerAdapter extends Adapter<AnswerAdapter.TopicViewHolder> {


    Context context;
    List<AnswerResponse> answers;
    List<AnswerResponse> filteredList;
    private int lastCheckPosition=-1;

    private int selectedAnswerPosition = -1;

    public int getSelectedAnswerPosition() {
        return selectedAnswerPosition;
    }

    public void setSelectedAnswerPosition(int selectedAnswerPosition) {
        this.selectedAnswerPosition = selectedAnswerPosition;
    }

    public AnswerAdapter(Context context) {
        this.context = context;

    }

    public void setData(List<AnswerResponse> answers) {

        this.answers = answers;
        this.filteredList = new ArrayList<>(answers);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anwser, parent, false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, @SuppressLint("RecyclerView") int position) {
        AnswerResponse answer = filteredList.get(position);
        if (answer == null) {
            return;
        }
        //holder.tvIdAnswer.setText(String.valueOf(answer.getId()));
        holder.tvNameAnswer.setText(answer.getContent());
//        if(position == lastCheckPosition)
//        {
//            holder.relativeLayout.setBackgroundResource(R.color.yellow);
//        }
//        else {
//            holder.relativeLayout.setBackgroundResource(R.color.teal_200);
//        }

        if (position == selectedAnswerPosition) {
            holder.relativeLayout.setBackgroundResource(R.color.yellow);
        } else {
            holder.relativeLayout.setBackgroundResource(R.color.teal_200);
        }

        // Set click listener for item
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedAnswerPosition = position;
                notifyDataSetChanged();
            }
        });

//        if(answer.getStatus()==0)
//        {
//            holder.relativeLayout.setBackgroundResource(R.color.red);
//        }
//        else {
//            holder.relativeLayout.setBackgroundResource(R.color.teal_200);
//        }
//        holder.tvNameTopic.setText(question.getName());
//        holder.imageViewTopic.setImageResource(R.drawable.pic6);
//        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, TestInforActivity.class);
//                Bundle bundle = new Bundle();
//                startActivity(context,intent,bundle);
//            }
//        });
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

//        ImageView imgAnswer,imgEdit,imgDelete;
        TextView tvNameAnswer;//,tvIdAnswer;
        RelativeLayout relativeLayout;

        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);

//            imgAnswer= itemView.findViewById(R.id.img_answer_teacher);
//            tvIdAnswer = itemView.findViewById(R.id.tv_id_answer);
            tvNameAnswer = itemView.findViewById(R.id.tv_answer_content);
            relativeLayout= itemView.findViewById(R.id.rlt_load_answer);

//            relativeLayout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int copy = lastCheckPosition;
//                    lastCheckPosition= getAdapterPosition();
//                    notifyItemChanged(copy);
//                    notifyItemChanged(lastCheckPosition);
//
//                }
//            });

        }
    }

    public void filter(String query) {
        filteredList.clear();
        if (query.isEmpty()) {
            filteredList.addAll(answers);
        } else {
            for (AnswerResponse item : answers) {
                if (item.getContent().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }
}
