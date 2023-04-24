package app.ntnt.finalprojectexamonline.activity.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.adapter.LoadQuestionAdapter;
import app.ntnt.finalprojectexamonline.model.entites.Answer;
import app.ntnt.finalprojectexamonline.model.entites.Question;

public class LoadQuestionActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private Button button;
    private List<Question> questionList;
    private TextView txtBack, txtNext, txtCurrent, txtSumQuestion;
    private TextView countdownText;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = 60000*60; // Thời gian bắt đầu đếm ngược
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_question);
        init();
        LoadQuestionAdapter viewPagerAdapter = new LoadQuestionAdapter(this,getQuestion(),getListAnswer());
        viewPager.setAdapter(viewPagerAdapter);
        txtCurrent.setText("1");
        txtSumQuestion.setText(String.valueOf(questionList.size()));
        countdownText = findViewById(R.id.tv_timmer);

        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Cập nhật thời gian đếm ngược trên TextView
                timeLeftInMillis = millisUntilFinished;
                updateCountdownText();
            }

            @Override
            public void onFinish() {
                // Thực hiện thao tác sau khi đếm ngược kết thúc
                // Ví dụ: hiển thị thông báo hoặc chuyển sang màn hình khác
            }
        }.start();
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Question question = questionList.get(position);
                txtCurrent.setText(String.valueOf(position+1));
                if(position==0)
                {
                    txtBack.setVisibility(View.GONE);
                    txtNext.setVisibility(View.VISIBLE);

                }
                else if(position==questionList.size()-1)
                {
                    txtBack.setVisibility(View.VISIBLE);
                    txtNext.setVisibility(View.GONE);

                }
                else
                {
                    txtBack.setVisibility(View.VISIBLE);
                    txtNext.setVisibility(View.VISIBLE);
                }

            }
        });



    }

    private void updateCountdownText() {
//        int minutes = (int) (timeLeftInMillis / 1000) / 60;
//        int seconds = (int) (timeLeftInMillis / 1000) % 60;
//
//        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        String timeString = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(timeLeftInMillis),
                TimeUnit.MILLISECONDS.toMinutes(timeLeftInMillis) % TimeUnit.HOURS.toMinutes(1),
                TimeUnit.MILLISECONDS.toSeconds(timeLeftInMillis) % TimeUnit.MINUTES.toSeconds(1));
        countdownText.setText(timeString);
    }

    private void init()
    {
        txtBack = findViewById(R.id.txt_back);
        txtCurrent = findViewById(R.id.txt_curent);
        txtNext= findViewById(R.id.txt_next);
        txtSumQuestion= findViewById(R.id.txt_sumquestion);
        viewPager = findViewById(R.id.view_pager);
        button = findViewById(R.id.btn_sheet);
    }

    private List<Question> getQuestion()
    {
        questionList = new ArrayList<>();
        for(int i=1;i<11;i++)
        {
            questionList.add(new Question(1L,"Câu hỏi số "+i,null,1L));
        }

        return questionList;
    }

    private List<List<Answer>> getListAnswer()
    {
        List<List<Answer>> list = new ArrayList<List<Answer>>();
        for( int i=1;i<11;i++)
        {
            List<Answer> answers = new ArrayList<>();
            answers.add(new Answer(1L,2L,"Đáp án a",0));
            answers.add(new Answer(2L,2L,"Đáp án b",0));
            answers.add(new Answer(3L,2L,"Đáp án c",0));
            answers.add(new Answer(4L,2L,"Đáp án d",1));
            list.add(answers);
        }

        return  list;

    }
}