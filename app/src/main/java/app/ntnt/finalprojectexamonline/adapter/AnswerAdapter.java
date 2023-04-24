package app.ntnt.finalprojectexamonline.adapter;

import static androidx.recyclerview.widget.RecyclerView.Adapter;
import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

import android.content.Context;
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


public class AnswerAdapter extends Adapter<AnswerAdapter.TopicViewHolder> {


    Context context;
    List<Answer> answers;
    List<Answer> filteredList;
    private int lastCheckPosition=-1;



    public AnswerAdapter(Context context) {
        this.context = context;

    }

    public void setData(List<Answer> answers) {

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
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        Answer answer = filteredList.get(position);
        if (answer == null) {
            return;
        }
        //holder.tvIdAnswer.setText(String.valueOf(answer.getId()));
        holder.tvNameAnswer.setText(answer.getName());
        if(position == lastCheckPosition)
        {
            holder.relativeLayout.setBackgroundResource(R.color.yellow);
        }
        else {
            holder.relativeLayout.setBackgroundResource(R.color.teal_200);
        }

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

            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int copy = lastCheckPosition;
                    lastCheckPosition= getAdapterPosition();
                    notifyItemChanged(copy);
                    notifyItemChanged(lastCheckPosition);
                }
            });

        }
    }

    public void filter(String query) {
        filteredList.clear();
        if (query.isEmpty()) {
            filteredList.addAll(answers);
        } else {
            for (Answer item : answers) {
                if (item.getName().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }
}
