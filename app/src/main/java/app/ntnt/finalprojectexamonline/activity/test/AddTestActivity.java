package app.ntnt.finalprojectexamonline.activity.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.adapter.MultiCheckboxSpinnerAdapter;
import app.ntnt.finalprojectexamonline.adapter.OnSpinnerCheckboxSelectedListener;
import app.ntnt.finalprojectexamonline.adapter.QuestionAdapter;
import app.ntnt.finalprojectexamonline.adapter.SpinnerAdapter;
import app.ntnt.finalprojectexamonline.fragment.DialogFragmentTest;
import app.ntnt.finalprojectexamonline.model.entites.Question;
import app.ntnt.finalprojectexamonline.model.entites.Subject;
import app.ntnt.finalprojectexamonline.model.entites.Topic;

public class AddTestActivity extends AppCompatActivity {
    Spinner spinnerSubject,spinnerTopic;
    QuestionAdapter questionAdapter;
    List<Question> questions;
    RecyclerView recyclerView;
    Button btnAddTest;

    ImageView imageViewCountQuestion;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_test);

        imageViewCountQuestion = findViewById(R.id.img_countQues);
        spinnerTopic = findViewById(R.id.spinnerTopic);
        btnAddTest = findViewById(R.id.btn_add_test);

        // Tạo popup window
        PopupWindow popupWindow = new PopupWindow(getApplicationContext());
        TextView popupTextView = new TextView(getApplicationContext());
       // popupTextView.setBackgroundResource(R.drawable.popup_background);
        popupTextView.setPadding(10, 10, 10, 10);
        popupTextView.setTextColor(Color.WHITE);
        popupWindow.setContentView(popupTextView);

        // Bắt sự kiện OnTouchListener cho TextView
        imageViewCountQuestion.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View v, MotionEvent event) {

                return false;
            }
        });
        imageViewCountQuestion.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Hiển thị popup window tại vị trí của sự kiện
                        popupWindow.showAtLocation(imageViewCountQuestion, Gravity.NO_GRAVITY,
                                (int) event.getRawX(), (int) event.getRawY() + 30);
                        // Cập nhật nội dung cho popup window
                        popupTextView.setText("Khi số câu hỏi được chọn bên dưới nhỏ hơn số lượng câu hỏi được điền ở đây" +
                                " sẽ tiến hành chọn ngẫu nhiên các câu hỏi không trùng bên dưới để tạo thành đề thi hoàn chỉnh"
                        );
                        break;
                    case MotionEvent.ACTION_UP:
                        // Ẩn popup window khi thả chuột
                        popupWindow.dismiss();
                        break;

                }
                return true;
            }
        });


        ArrayList<Topic> topics = new ArrayList<>();
        topics.add(new Topic(1L,"Chuyển động thẳng đều",null,1));
        topics.add(new Topic(1L,"Chuyển động nhanh dần đều",null,1));
        topics.add(new Topic(1L,"Chuyển động chậm dần đều",null,1));
        topics.add(new Topic(1L,"Chuyển động thẳng đều đều đều đều",null,1));
        SpinnerAdapter adapter = new SpinnerAdapter(this,topics);
        spinnerTopic.setAdapter(adapter);

//        ArrayAdapter<Topic> adapter2 =
//                new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, topics);
//        spinnerTopic.setAdapter(adapter2);


//        boolean[] selected = new boolean[topics.size()];
//        List<Topic> selectedItems = new ArrayList<>();
//        MultiCheckboxSpinnerAdapter multiCheckboxSpinnerAdapter = new MultiCheckboxSpinnerAdapter(this,topics);
//
//        spinnerTopic.setAdapter(multiCheckboxSpinnerAdapter);
//        btnAddTest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               // multiCheckboxSpinnerAdapter.notifyDataSetChanged();
//                multiCheckboxSpinnerAdapter.printSelectedItems();
//
//            }
//        });

    }

    private void setQuestionAdapter()
    {
        questionAdapter = new QuestionAdapter(this);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(this,1, GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        //questionAdapter.setData(getQuestionById());
        recyclerView.setAdapter(questionAdapter);
    }

    private List<Question> getQuestionById() {
        questions = new ArrayList<>();
        for(int i=0;i<=10;i++)
        {
            Question question = new Question(1L,"Chuyển động thẳng đều","null",1L);
            questions.add(question);
        }

        return questions;
    }


}