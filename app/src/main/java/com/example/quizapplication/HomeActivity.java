package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class HomeActivity extends AppCompatActivity {

    ImageView hi;
    TextView ht,gr;
    TextInputEditText name,enr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        hi = findViewById(R.id.home_i);
        ht = findViewById(R.id.home_t);
        gr = findViewById(R.id.greet);
        name = findViewById(R.id.uname);
        enr = findViewById(R.id.uenr);
    }

    public void startQuiz(View v){

        String uname = name.getText().toString();
        String uenr = enr.getText().toString();

        if(!uname.isEmpty() && !uenr.isEmpty()){
            if(uenr.length() < 10) {
                enr.setError("Should be of 10 digits");
            }
            else{
                Intent I = new Intent(HomeActivity.this,QAActivity.class);
                I.putExtra("Name",uname);
                I.putExtra("Enroll",uenr);
                Pair[] pairs = new Pair[4];
                pairs[0] = new Pair<View,String>(hi,"logo");
                pairs[1] = new Pair<View,String>(ht,"title");
                pairs[2] = new Pair<View,String>(gr,"toUName2");
                pairs[3] = new Pair<View,String>(name,"toUName");
                ActivityOptions O = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    O = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this,pairs);
                }
                startActivity(I,O.toBundle());
                finish();
            }
        }
        else{
            if(uname.isEmpty())
                name.setError("Required");
            if(uenr.isEmpty())
                enr.setError("Required");
        }

    }
}