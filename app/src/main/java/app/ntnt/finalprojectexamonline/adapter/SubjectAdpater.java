package app.ntnt.finalprojectexamonline.adapter;

import static androidx.core.content.ContextCompat.startActivity;
import static androidx.recyclerview.widget.RecyclerView.Adapter;
import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

import android.content.Context;
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

import java.util.List;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.activity.HomeActivity;
import app.ntnt.finalprojectexamonline.activity.TopicActivity;
import app.ntnt.finalprojectexamonline.fragment.HomeFragment;
import app.ntnt.finalprojectexamonline.model.Subject;


public class SubjectAdpater extends Adapter<SubjectAdpater.TopicViewHolder> {
    private HomeFragment context;
    List<Subject> subjects;

    public SubjectAdpater(HomeFragment context) {
        this.context = context;
    }

    public void setData(List<Subject> subjects) {

        this.subjects = subjects;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_subject, parent, false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        Subject subject = subjects.get(position);
        if (subject == null) {
            return;
        }
        holder.tvNameSubject.setText(subject.getName());
//        Glide.with(context).load(subject.getImage()).into(holder.imageViewSubject);
        holder.imageViewSubject.setImageResource(R.drawable.pic6);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getContext(), TopicActivity.class);
                Bundle bundle = new Bundle();
                startActivity(context.getContext(),intent,bundle);

            }
        });
    }


    @Override
    public int getItemCount() {
        if (subjects != null)
            return subjects.size();
        return 0;
    }

    public class TopicViewHolder extends ViewHolder {

        ImageView imageViewSubject;
        TextView tvNameSubject;
        RelativeLayout relativeLayout;

        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNameSubject = itemView.findViewById(R.id.tv_name_subject);
            imageViewSubject = itemView.findViewById(R.id.img_subject);
            relativeLayout = itemView.findViewById(R.id.rlt_subject);

        }
    }
}
