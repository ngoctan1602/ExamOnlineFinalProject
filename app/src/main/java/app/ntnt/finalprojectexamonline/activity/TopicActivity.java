package app.ntnt.finalprojectexamonline.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.adapter.TestAdapter;
import app.ntnt.finalprojectexamonline.adapter.TopicAdapter;
import app.ntnt.finalprojectexamonline.model.entites.Topic;


public class TopicActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TopicAdapter topicAdapter;
    List<Topic> topics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_activity);

        recyclerView = findViewById(R.id.rcv_topic);
        setTopicAdapter();

    }

    private void setTopicAdapter()
    {
        topicAdapter = new TopicAdapter(this);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(this,1, GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        topicAdapter.setData(getTopicById());
        recyclerView.setAdapter(topicAdapter);
    }

    private List<Topic> getTopicById() {
        topics = new ArrayList<>();
        for(int i=0;i<=10;i++)
        {
            Topic topic = new Topic(i,"Chuyển động thẳng đều");
            topics.add(topic);
        }

        return topics;
    }
}