package com.example.prashant.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class quiz_two_activity extends AppCompatActivity {
    private static String LOG_TAG = quiz_two_activity.class.getSimpleName();
    static boolean tempValue = false;

    private Button optionOne;
    private Button optionTwo;
    private Button optionThree;
    private Button optionFour;
    private Button QuizTwoSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_two);

        optionOne = findViewById(R.id.radio_button_one);
        optionTwo =  findViewById(R.id.radio_button_two);
        optionThree = findViewById(R.id.radio_button_three);
        optionFour = findViewById(R.id.radio_button_four);
        QuizTwoSubmit = findViewById(R.id.quizTwoSubmit);

        //setting the title
        setTitle("Question 2.");

        //submitting the second question
        QuizTwoSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tempValue){
                    MainActivity.Marks++;
                    tempValue = false;
                    Log.d(LOG_TAG,"Right answer. Marks is now" +MainActivity.Marks);
                }else {
                    MainActivity.feedbackReport.add("Asia is the biggest continent in the world.");
                    Log.d(LOG_TAG,"Wrong answer. Marks is now" +MainActivity.Marks);
                }
                Intent intent = new Intent(quiz_two_activity.this,quiz_three_activity.class);
                startActivity(intent);
            }
        });
    }

    //tempValue is used as a flag to check the selected option is correct
    public void onRadioButtonClicked(View view) {
        if(view.getId() == R.id.radio_button_two){
            tempValue = true;
        }else{
            tempValue = false;
        }
    }
}