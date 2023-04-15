package app.ntnt.finalprojectexamonline.adapter;

import static androidx.core.content.ContextCompat.startActivity;
import static androidx.recyclerview.widget.RecyclerView.Adapter;
import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.activity.TestInforActivity;
import app.ntnt.finalprojectexamonline.activity.TopicActivity;
import app.ntnt.finalprojectexamonline.fragment.HistoryFragment;
import app.ntnt.finalprojectexamonline.model.entites.Topic;


public class TopicAdapter extends Adapter<TopicAdapter.TopicViewHolder> {
    private TopicActivity context;
    List<Topic> topics;

    public TopicAdapter(TopicActivity context) {
        this.context = context;
    }

    public void setData(List<Topic> topics) {

        this.topics = topics;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic, parent, false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        Topic topic = topics.get(position);
        if (topic == null) {
            return;
        }

        holder.tv_name_topic.setText(topic.getName());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TestInforActivity.class);
                Bundle bundle = new Bundle();
                startActivity(context,intent,bundle);
            }
        });
    }


    @Override
    public int getItemCount() {
        if (topics != null)
            return topics.size();
        return 0;
    }

    public class TopicViewHolder extends ViewHolder {

        TextView tv_name_topic;
        RelativeLayout relativeLayout;

        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name_topic=itemView.findViewById(R.id.tv_name_topic);
            relativeLayout = itemView.findViewById(R.id.item_rlt_topic);

        }
    }
}
