package com.example.prashant.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class quiz_four_activity extends AppCompatActivity {
    private static String LOG_TAG = quiz_four_activity.class.getSimpleName();
    private Button QuizfourSubmit;
    private EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quiz_four);

        QuizfourSubmit =  findViewById(R.id.quizFourSubmit);
        editText = (EditText) findViewById(R.id.edit_text);

        //setting the title
        setTitle("Question 4.");

        //submitting the question
        QuizfourSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //getting the string from the edittext
                String enteredString = editText.getText().toString();

                if(TextUtils.equals(enteredString,"Tesla") || TextUtils.equals(enteredString,"tesla") || TextUtils.equals(enteredString,"TESLA")){
                    MainActivity.Marks++;
                    Log.e(LOG_TAG,"Right answer. Marks is now" +MainActivity.Marks);
                    if(MainActivity.Marks == 4){
                        MainActivity.feedbackReport.add("Perfect Scorer!");
                    }
                }
                else {
                    MainActivity.feedbackReport.add("it is not"+" \""+enteredString + "\"."+ "Tesla is the car manufacturer which also happens to be the last name of scientist \"Nicola tesla\"");
                    Log.e(LOG_TAG,"wrong answer. Marks is now" +MainActivity.Marks);
                }
                Intent intent = new Intent(quiz_four_activity.this,Final_activity.class);
                startActivity(intent);
            }
        });

    }
}
