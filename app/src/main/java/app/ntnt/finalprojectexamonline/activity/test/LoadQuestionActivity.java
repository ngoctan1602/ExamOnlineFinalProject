package app.ntnt.finalprojectexamonline.activity.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
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
import app.ntnt.finalprojectexamonline.model.response.AnswerResponse;
import app.ntnt.finalprojectexamonline.model.response.QuestionResponse;
import app.ntnt.finalprojectexamonline.model.response.ResponseEntity;
import app.ntnt.finalprojectexamonline.model.response.TestResponse;
import app.ntnt.finalprojectexamonline.services.BaseAPIService;
import app.ntnt.finalprojectexamonline.services.ITestService;
import app.ntnt.finalprojectexamonline.utils.AppConstrain;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadQuestionActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private Button button;
    List<QuestionResponse> questionResponses = new ArrayList<>();
    private int size = 10;
    private TextView txtBack, txtNext, txtCurrent, txtSumQuestion;
    private TextView countdownText;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = 60000 * 60; // Thời gian bắt đầu đếm ngược

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_question);
        init();

        Bundle bundle = getIntent().getExtras();
        Long testId = (Long) bundle.getLong("testId");

        loadDataQuestion(testId);


        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
//                Question question = questionList.get(position);
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
                        Log.d("TAG", "onFinish: hết giờ");
                    }
                }.start();

                txtCurrent.setText(String.valueOf(position + 1));
                txtSumQuestion.setText(String.valueOf(size));
                if (position == 0) {
                    txtBack.setVisibility(View.GONE);
                    txtNext.setVisibility(View.VISIBLE);
                    txtNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });

                } else if (position == size - 1) {
                    txtBack.setVisibility(View.VISIBLE);
                    txtNext.setVisibility(View.GONE);

                } else {
                    txtBack.setVisibility(View.VISIBLE);
                    txtNext.setVisibility(View.VISIBLE);
                }
                txtBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                    }
                });
                txtNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    }
                });

            }
        });


    }

    private void loadDataQuestion(Long testId) {
        BaseAPIService.createService(ITestService.class).getTestById(testId).enqueue(new Callback<ResponseEntity>() {
            @Override
            public void onResponse(Call<ResponseEntity> call, Response<ResponseEntity> response) {
                Log.d("TAG", "onResponse: succees");
                if (response.body().isError() == false) {
                    Object objects;
                    objects = AppConstrain.toObject(response.body().getData(), TestResponse.class);
                    TestResponse testResponse = (TestResponse) objects;

                    questionResponses = testResponse.getQuestions();
                    List<List<AnswerResponse>> answerResponses = new ArrayList<>();
                    for (QuestionResponse questionResponse : questionResponses) {
                        answerResponses.add(questionResponse.getAnswers());
                    }
                    size = questionResponses.size();
                    timeLeftInMillis = testResponse.getTime() * 60000;
                    LoadQuestionAdapter viewPagerAdapter = new LoadQuestionAdapter(LoadQuestionActivity.this, questionResponses, answerResponses);
                    viewPager.setAdapter(viewPagerAdapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseEntity> call, Throwable t) {
                Log.d("TAG", "onResponse: failed");
            }
        });
    }

    private void updateCountdownText() {

        String timeString = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(timeLeftInMillis),
                TimeUnit.MILLISECONDS.toMinutes(timeLeftInMillis) % TimeUnit.HOURS.toMinutes(1),
                TimeUnit.MILLISECONDS.toSeconds(timeLeftInMillis) % TimeUnit.MINUTES.toSeconds(1));
        countdownText.setText(timeString);
    }

    private void init() {
        countdownText = findViewById(R.id.tv_timmer);
        txtBack = findViewById(R.id.txt_back);
        txtCurrent = findViewById(R.id.txt_curent);
        txtNext = findViewById(R.id.txt_next);
        txtSumQuestion = findViewById(R.id.txt_sumquestion);
        viewPager = findViewById(R.id.view_pager);
        button = findViewById(R.id.btn_sheet);
    }



}