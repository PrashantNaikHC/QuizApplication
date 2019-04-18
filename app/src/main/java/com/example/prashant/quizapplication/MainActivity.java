package com.example.prashant.quizapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public  class MainActivity extends AppCompatActivity {

    private static String LOG_TAG = MainActivity.class.getSimpleName();

    //variable to store the total marks
    public static int Marks;
    public static ArrayList<String> feedbackReport;

    private Button enterQuiz;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterQuiz = findViewById(R.id.Enter_quiz_bt);

        feedbackReport = new ArrayList<String>();

        //starting the quiz
        enterQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,quiz_one_activity.class);
                startActivity(intent);
            }
        });
    }
}
