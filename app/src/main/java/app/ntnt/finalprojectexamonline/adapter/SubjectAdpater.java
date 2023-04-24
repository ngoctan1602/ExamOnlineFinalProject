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
import app.ntnt.finalprojectexamonline.activity.TopicActivity;
import app.ntnt.finalprojectexamonline.activity.test.HomeTeacherActivity;
import app.ntnt.finalprojectexamonline.fragment.HomeFragment;
import app.ntnt.finalprojectexamonline.fragment.teacher.TeacherHomeFragment;
import app.ntnt.finalprojectexamonline.model.entites.Subject;


public class SubjectAdpater extends Adapter<SubjectAdpater.TopicViewHolder> {
    private HomeFragment context;

    //private HomeTeacherActivity homeTeacherContext;

    private TeacherHomeFragment teacherHomeFragment;
    private Boolean b;
    List<Subject> subjects;
    List<Subject> filteredList;

    public SubjectAdpater(HomeFragment context) {
        this.context = context;
        this.b=true;
    }

    //mới thêm
    public SubjectAdpater(TeacherHomeFragment teacherHomeFragment) {
        this.teacherHomeFragment = teacherHomeFragment;
        this.b=false;
    }

    public void setData(List<Subject> subjects) {

        this.subjects = subjects;
        this.filteredList = new ArrayList<>(subjects);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(b==true) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_subject, parent, false);
            return new TopicViewHolder(view);
        }
        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_subject_teacher, parent, false);
            return new TopicViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        Subject subject = filteredList.get(position);
        if (subject == null) {
            return;
        }


            holder.tvNameSubject.setText(subject.getName());
            Glide.with(teacherHomeFragment)
                    .load(subject.getImage())
                    .placeholder(R.drawable.pic6)
                    .into(holder.imageViewSubject);
           // holder.imageViewSubject.setImageResource(R.drawable.pic6);
            holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context.getContext(), TopicActivity.class);
                    Bundle bundle = new Bundle();
                    startActivity(context.getContext(), intent, bundle);

                }
            });

            if (b==false)
            {
//                holder.imgEdit.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        teacherHomeFragment.showDialogUpdate();
//                    }
//                });
//                holder.imgDelete.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        teacherHomeFragment.showDialogDelete();
//                    }
//                });
                holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(teacherHomeFragment.getContext(), TopicActivity.class);
                        Bundle bundle = new Bundle();
                        startActivity(teacherHomeFragment.getContext(), intent, bundle);
                    }
                });
            }

    }


    @Override
    public int getItemCount() {
        if (filteredList != null)
            return filteredList.size();
        return 0;
    }

    public class TopicViewHolder extends ViewHolder {

        ImageView imageViewSubject,imgEdit,imgDelete;
        TextView tvNameSubject;
        RelativeLayout relativeLayout;


        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            if(b==true)
            {
                tvNameSubject = itemView.findViewById(R.id.tv_name_subject);
                imageViewSubject = itemView.findViewById(R.id.img_subject);
                relativeLayout = itemView.findViewById(R.id.rlt_subject);
            }
            else {
                tvNameSubject = itemView.findViewById(R.id.tv_subject_teacher);
                imageViewSubject = itemView.findViewById(R.id.img_subject_teacher);
                relativeLayout = itemView.findViewById(R.id.rlt_subject_teacher);
                imgDelete= itemView.findViewById(R.id.img_delete);
                imgEdit= itemView.findViewById(R.id.img_edit);
            }

        }
    }

    public void filter(String query) {
        filteredList.clear();
        if (query.isEmpty()) {
            filteredList.addAll(subjects);
        } else {
            for (Subject item : subjects) {
                if (item.getName().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }
}
