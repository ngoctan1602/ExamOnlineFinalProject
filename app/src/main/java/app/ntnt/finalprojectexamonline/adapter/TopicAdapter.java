package app.ntnt.finalprojectexamonline.adapter;

import static androidx.recyclerview.widget.RecyclerView.Adapter;
import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.fragment.HistoryFragment;
import app.ntnt.finalprojectexamonline.model.Test;


public class TopicAdapter extends Adapter<TopicAdapter.TopicViewHolder> {
    private HistoryFragment context;
    List<Test> tests;

    public TopicAdapter(HistoryFragment context) {
        this.context = context;
    }

    public void setData(List<Test> tests) {

        this.tests = tests;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        Test test = tests.get(position);
        if (test == null) {
            return;
        }
        int percent = test.getScore()*10;
        holder.tvName.setText(test.getName());
        holder.tvTime.setText(String.valueOf(test.getTime()));
        holder.tvTimes.setText(String.valueOf(test.getTimes()));
        holder.tvPercent.setText(String.valueOf(percent));
        holder.tvDateComplete.setText(String.valueOf(test.getTime()));
        holder.nameSubject.setText(test.getNameSubject());
        holder.progressBar.setProgress(percent);
    }


    @Override
    public int getItemCount() {
        if (tests != null)
            return tests.size();
        return 0;
    }

    public class TopicViewHolder extends ViewHolder {

        TextView tvName,tvTime,tvTimes,tvPercent,tvDateComplete,nameSubject;
        ProgressBar progressBar;

        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tv_nameExam);
            tvTime=itemView.findViewById(R.id.tv_time);
            tvTimes=itemView.findViewById(R.id.txt_times);
            tvPercent=itemView.findViewById(R.id.txt_percent);
            tvDateComplete=itemView.findViewById(R.id.txt_date_complete);
            nameSubject=itemView.findViewById(R.id.tv_time_exam);
            progressBar = itemView.findViewById(R.id.pbr_complete);

        }
    }
}
