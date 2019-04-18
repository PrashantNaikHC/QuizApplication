package com.example.prashant.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class quiz_one_activity extends AppCompatActivity {
    private static String LOG_TAG = MainActivity.class.getSimpleName();
    static boolean tempValue = false;
    private Button QuizOneSubmit;
    private RadioButton optionOne, optionTwo, optionThree, optionFour;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_one);

        optionOne = findViewById(R.id.radio_button_one);
        optionTwo = findViewById(R.id.radio_button_two);
        optionThree = findViewById(R.id.radio_button_three);
        optionFour = findViewById(R.id.radio_button_four);
        QuizOneSubmit = findViewById(R.id.quizOneSubmit);

        //setting the title of the activity
        setTitle("Question 1.");

        //submitting the first question
        QuizOneSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tempValue) {
                    MainActivity.Marks++;
                    tempValue = false;
                    Log.d(LOG_TAG, "Right answer. Marks is now" + MainActivity.Marks);
                } else {
                    Log.d(LOG_TAG, "Wrong answer. Marks is now" + MainActivity.Marks);
                    MainActivity.feedbackReport.add("Moon is the natural satellite of Earth.");
                }
                Intent intent = new Intent(quiz_one_activity.this, quiz_two_activity.class);
                startActivity(intent);
            }
        });
    }

    //tempValue is used as a flag to check the selected option is correct
    public void onRadioButtonClicked(View view) {
        if (view.getId() == R.id.radio_button_one) {
            tempValue = true;
        } else {
            tempValue = false;
        }
    }
}
