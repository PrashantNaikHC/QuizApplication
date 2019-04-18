package com.example.prashant.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class quiz_three_activity extends AppCompatActivity {

    static boolean tempValue1 = false;
    static boolean tempValue2 = false;
    private static String LOG_TAG = quiz_three_activity.class.getSimpleName();

    private CheckBox optionOne, optionTwo, optionThree, optionFour;
    private Button QuizThreeSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_three);

        optionOne = (CheckBox) findViewById(R.id.check_box_one);
        optionTwo = (CheckBox) findViewById(R.id.check_box_two);
        optionThree = (CheckBox) findViewById(R.id.check_box_three);
        optionFour = (CheckBox) findViewById(R.id.check_box_four);

        //setting the title
        setTitle("Question 3.");

        //submitting the third question
        QuizThreeSubmit = (Button) findViewById(R.id.quizThreeSubmit);
        QuizThreeSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tempValue1==true &&tempValue2==true){
                    MainActivity.Marks++;
                    tempValue1 = false;
                    tempValue2 = false;
                    Log.d(LOG_TAG,"Right answer. Marks is now" +MainActivity.Marks);
                }else {
                    MainActivity.feedbackReport.add("Audi and Nissan are the Automobile manufacturers.");
                    Log.d(LOG_TAG,"Wrong answer. Marks is now" +MainActivity.Marks);
                }
                Intent intent = new Intent(quiz_three_activity.this,quiz_four_activity.class);
                startActivity(intent);
            }
        });
    }

    public void onCheckboxClicked (View view) {
        switch(view.getId()) {
            case R.id.check_box_one:
                tempValue1 = true;
                Log.d(LOG_TAG,"Checked Box one" );
                break;
            case R.id.check_box_two:
                tempValue1 = false;
                Log.d(LOG_TAG,"Checked Box two" );
                break;
            case R.id.check_box_three:
                tempValue2 = true;
                Log.d(LOG_TAG,"Checked Box three" );
                break;
            case R.id.check_box_four:
                tempValue2 = false;
                Log.d(LOG_TAG,"Checked Box four" );
                break;
        }
    }
}
