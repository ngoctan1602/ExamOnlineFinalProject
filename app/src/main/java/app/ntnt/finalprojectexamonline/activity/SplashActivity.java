package app.ntnt.finalprojectexamonline.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.activity.teacher.HomeTeacherActivity;
import app.ntnt.finalprojectexamonline.utils.ContextUtil;
import app.ntnt.finalprojectexamonline.utils.SharedPrefManager;

public class SplashActivity extends AppCompatActivity {
    private TextView appName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        appName = findViewById(R.id.app_name);
        Typeface typeface;

        Animation anim = AnimationUtils.loadAnimation( this, R.anim.myanim);
        appName.setAnimation(anim);

        new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                ContextUtil.context = getApplicationContext();
                if (SharedPrefManager.getInstance(ContextUtil.context).isLoggedIn()) {
                    if (SharedPrefManager.getInstance(ContextUtil.context).getAuthToken().getRoles().get(0).toString().equals("ROLE_teacher")) {
                        Intent intent = new Intent(SplashActivity.this, HomeTeacherActivity.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }

                } else {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                SplashActivity.this.finish();
            }
        }.start();
    }
}