package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME = 3000;
    Animation splashText;
    ImageView si;
    TextView st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splashText = AnimationUtils.loadAnimation(this,R.anim.down_to_up);

        si = findViewById(R.id.splash_i);
        st = findViewById(R.id.splash_t);

        st.setAnimation(splashText);
        si.animate().rotationYBy(360f).translationYBy(350f).setDuration(1500).start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent I = new Intent(MainActivity.this,HomeActivity.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(si,"logo");
                pairs[1] = new Pair<View,String>(st,"title");
                ActivityOptions O = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    O = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                    startActivity(I,O.toBundle());
                }
                finish();
            }
        },SPLASH_TIME);
    }
}