package app.ntnt.finalprojectexamonline.adapter;

import static androidx.recyclerview.widget.RecyclerView.Adapter;
import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.activity.TestInforActivity;
import app.ntnt.finalprojectexamonline.fragment.HistoryFragment;
import app.ntnt.finalprojectexamonline.fragment.HomeFragment;
import app.ntnt.finalprojectexamonline.model.TestInfor;


public class TestInforAdapter extends Adapter<TestInforAdapter.TopicViewHolder> {
    private HomeFragment context;
    private TestInforActivity testInforActivity;
    List<TestInfor> testInforList;

    public TestInforAdapter(HomeFragment context) {
        this.context = context;
    }

    public TestInforAdapter(TestInforActivity testInforActivity) {
        this.testInforActivity = testInforActivity;
    }

    public void setData(List<TestInfor> testInforList) {

        this.testInforList = testInforList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test, parent, false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        TestInfor test = testInforList.get(position);
        if (test == null) {
            return;
        }
        holder.tvName.setText(test.getName());
        holder.tvNameAuthor.setText(test.getNameAuthor());
        holder.tvDateCreated.setText(test.getDateCreated());
        holder.tvTime.setText(String.valueOf(test.getTime()));
        holder.tvNameSubject.setText(test.getNameSubject());
    }


    @Override
    public int getItemCount() {
        if (testInforList != null)
            return testInforList.size();
        return 0;
    }

    public class TopicViewHolder extends ViewHolder {

         TextView tvName,tvTime,tvNameSubject,tvNameAuthor,tvDateCreated;
         //ProgressBar progressBar;

        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_nameExam_test);
            tvTime = itemView.findViewById(R.id.tv_time_test);
            tvNameSubject = itemView.findViewById(R.id.tv_nameSubject_test);
            tvNameAuthor = itemView.findViewById(R.id.tv_author);
            tvDateCreated = itemView.findViewById(R.id.tv_datecreated);


        }
    }
}
