package com.example.quizapplication;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainQAActivity extends AppCompatActivity {

    TextView ques, quein;
    Bundle ex1;
    Button nextQ;
    LinearLayout optionsContainer;
    String ans;
    List<QM> l;
    private int count = 0;
    private int position = 0;
    private int qCounter = 1;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_qaactivity);

        ex1 = getIntent().getExtras();
        ques = findViewById(R.id.q);
        quein = findViewById(R.id.qin);
        nextQ = findViewById(R.id.nextBt);
        optionsContainer = findViewById(R.id.optionsC);

        l = new ArrayList<>();
        l.add(new QM("Which attribute is used to set the text color of TextView?","android:textColor","android:text","android:margin","None","android:text"));
        l.add(new QM("Which are the pre-defined constants of Toast class?","Length_Short, Length_Long","LENGTH_SHORT, LENGTH_LONG","lengthlong, lengthshort","LONG,SHORT","LENGTH_SHORT, LENGTH_LONG"));
        l.add(new QM("Android Is Developed By - ","Apple","Google","Microsoft","Android Inc","Android Inc"));
        l.add(new QM("Which Programming Language Is Used For Android Application Development?","Java","Kotlin","Both A & B","Javascript","Both A & B"));
        l.add(new QM("Android Beam is based on _______ technology?","Bluetooth","Wi-Fi","GCM","NFC","NFC"));
        l.add(new QM("When did Open Handset Alliance announce?","2007","2006","2010","2008","2007"));
        l.add(new QM("What does DVM stand for ","Java Virtual Machine","Device Virtual Machine","Device Virtual Machine","Dalvik Virtual Machine","Dalvik Virtual Machine"));
        l.add(new QM("One of application component, that manages application's background services is called","Activities","Broadcast Receivers","Services","Content Providers","Services"));
        l.add(new QM("A type of service provided by android that shows messages and alerts to user is","Content Providers","View System","Notification Manager","Activity Manager","Notification Manager"));
        l.add(new QM("Which progress bar can be used to represent the progress when when you do not know how long an operation will take?","Determinate Progress Bar","Indeterminate Progress Bar","None of the above","Both A & B","Indeterminate Progress Bar"));
        l.add(new QM("___________ can be used when presenting users with a group of selectable options that are not mutually exclusive.","Radio Button","Toggle Button","CheckBox","Image Button","CheckBox"));
        l.add(new QM("The android component that shows the part of an activity on the screen is called ","Intent","Fragment","View","Manifest","Fragment"));
        l.add(new QM("A drop-down list that allows users to select one value from a set is...","List","Spinner","DropdownList","Choice","List"));
        l.add(new QM("What Activity method you use to retrieve a reference to an android view by using the id attribute of a resource XML?","findViewByReference(int id)","findViewById(int id)","retrieveResourceById(int id)","findViewById(String id)","findViewById(int id)"));
        l.add(new QM("Which configuration file holds the permission to use the internet?","Layout File","Java Source File","Manifest File","Property File","Manifest File"));
        l.add(new QM("Which of the following is not an Android component (i.e. a point from which the system can enter your application)?","Service","Activity","Layout","Content Provider","Layout"));
        l.add(new QM("Which of the following is/are the subclasses in Android?","ActionBar Activity","Launcher Activity","Tab Activity","All of the above","All of the above"));
        l.add(new QM("The layout or design of an android application is saved in",".dex file",".java file",".xml file",".text file",".xml file"));
        l.add(new QM("For specialized layout elements, the palette element used is","Custom","Textfields","Containers","Widgets","Custom"));
        l.add(new QM("What is the context in android?","It is an interface to store global information about an application","It is used to create new components.","Android has two contexts, those are getContext and getApplicationContext","All of the above","All of the above"));
        l.add(new QM("While developing Android Application, developers can test their Apps on","Emulator included in Android SDK","Physical Android Phone","Third Party Emulators","All of the above","All of the above"));

        Collections.shuffle(l);

        play(ques,0,l.get(position).getQ());

        for (int i=0; i<4; i++){
            int I = i;
            optionsContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clearSelection();
                    nextQ.setEnabled(true);
                    nextQ.setAlpha(1);
                    optionsContainer.getChildAt(I).setBackgroundResource(R.drawable.bordered_selected_button);
                    ans = (String)((Button)optionsContainer.getChildAt(I)).getText();
                }
            });
        }

        nextQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(ans);
                count = 0;
                if (position < 9) {
                    if(position == 8){
                        nextQ.setText("End Quiz");
                        qCounter++;
                        position++;
                        play(ques, 0, l.get(position).getQ());
                    }
                    else {
                        qCounter++;
                        position++;
                        play(ques, 0, l.get(position).getQ());
                    }
                }
                else{
                    Intent RA = new Intent(MainQAActivity.this,ResultActivity.class);
                    RA.putExtra("Name",ex1.getString("Name"));
                    RA.putExtra("Score",score);
                    RA.putExtra("Enroll",ex1.getString("Enroll"));
                    startActivity(RA);
                    finish();
                }
            }
        });
    }

    public void clearSelection(){
        for (int i=0; i<4; i++){
            optionsContainer.getChildAt(i).setBackgroundResource(R.drawable.bordered_button);
        }
    }

    public void checkAnswer(String curAns){
        if (l.get(position).getCtA() == curAns){
            Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
            score++;
        }
        else
            Toast.makeText(this, "You are wrong, Correct answer is\n"+ l.get(position).getCtA(), Toast.LENGTH_SHORT).show();
    }

    public void play(final View v,final int val,final  String d){
        v.animate().alpha(val).setDuration(200).setStartDelay(70).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                nextQ.setEnabled(false);
                if(val == 0 && count < 4) {
                    String option = " ";
                    if(count == 0){
                        option = l.get(position).getOptA();
                    }
                    if(count == 1){
                        option = l.get(position).getOptB();
                    }
                    if(count == 2){
                        option = l.get(position).getOptC();
                    }
                    if(count == 3){
                        option = l.get(position).getOptD();
                    }
                    play(optionsContainer.getChildAt(count), 0,option);
                    count++;

                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ((TextView)v).setText(d);
                if(val == 0){
                    play(v,1,d);
                }
                quein.setText(qCounter+"/10");
                nextQ.setAlpha(0.5f);
                clearSelection();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}