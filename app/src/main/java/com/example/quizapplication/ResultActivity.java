package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    Bundle ex2;
    TextView t1, t2, t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ex2 = getIntent().getExtras();

        t1 = findViewById(R.id.rname);
        t1.setText(ex2.getString("Name"));

        t2 = findViewById(R.id.fscore);
        t2.setText(ex2.getInt("Score")+"/10");

        t3 = findViewById(R.id.enrollNo);
        t3.setText(t3.getText()+ex2.getString("Enroll"));
    }

    public void reQuiz(View v){
        Intent i = new Intent(ResultActivity.this,HomeActivity.class);
        startActivity(i);
        finish();
    }
}