package app.ntnt.finalprojectexamonline.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.adapter.TopicAdapter;
import app.ntnt.finalprojectexamonline.model.entites.Topic;


public class TopicActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TopicAdapter topicAdapter;
    List<Topic> topics;
    SearchView searchView;
    ImageView imageView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_activity);

        recyclerView = findViewById(R.id.rcv_topic);
        setTopicAdapter();
//        searchView = (SearchView) findViewById(R.id.search_topic);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                topicAdapter.filter(newText);
//                return true;
//            }
//        });

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
            Topic topic = new Topic(1L,"Chuyển động thẳng đều","null",1);
            topics.add(topic);
        }

       return topics;
    }


    public void showDialogUpdate() {
        Dialog dialog = new Dialog(TopicActivity.this);
        dialog.setContentView(R.layout.dialog_update_subject);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);
        Button btnOk = dialog.findViewById(R.id.dialog_btn_Ok) ;
        Button btnCancel = dialog.findViewById(R.id.dialog_btn_Cancel);


//        imageView = dialog.findViewById(R.id.img_dialog_imgSubject);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                CheckPermission();
//            }
//        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Gọi API update môn học
            }
        });
        dialog.show();
    }


    public void showDialogDelete() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Bạn có muốn xóa hay không?");
        builder.setCancelable(false);

        builder.setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Xử lý khi người dùng chọn xác nhận
            }
        });

        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Xử lý khi người dùng chọn hủy
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}