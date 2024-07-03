package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class QAActivity extends AppCompatActivity {

    Bundle ex;
    TextView un;
    ImageView i1;
    TextView t1;
    String pName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qaactivity);

        ex = getIntent().getExtras();
        un = findViewById(R.id.UName);
        pName = ex.getString("Name");
        un.setText(pName+",");

        i1 = findViewById(R.id.imageView2);
        t1 = findViewById(R.id.textView2);
    }

    public void changeName(View v){
        Intent i = new Intent(QAActivity.this,HomeActivity.class);
        startActivity(i);
        finish();
    }

    public void startMainQuiz(View v){
        Intent I = new Intent(QAActivity.this,MainQAActivity.class);
        I.putExtra("Name",pName);
        I.putExtra("Enroll",ex.getString("Enroll"));
        Pair[] pairs = new Pair[2];
        pairs[0] = new Pair<View,String>(i1,"logo");
        pairs[1] = new Pair<View,String>(t1,"title");
        ActivityOptions O = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            O = ActivityOptions.makeSceneTransitionAnimation(QAActivity.this,pairs);
            startActivity(I,O.toBundle());
        }
        finish();
    }

}