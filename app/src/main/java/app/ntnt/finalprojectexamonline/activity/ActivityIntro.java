package app.ntnt.finalprojectexamonline.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import app.ntnt.finalprojectexamonline.utils.ContextUtil;
import app.ntnt.finalprojectexamonline.utils.SharedPrefManager;

public class ActivityIntro extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        ContextUtil.context = getApplicationContext();
        if (SharedPrefManager.getInstance(ContextUtil.context).isLoggedIn()){
            Intent intent = new Intent(ActivityIntro.this, HomeActivity.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(ActivityIntro.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
