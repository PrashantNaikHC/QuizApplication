package com.example.prashant.quizapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Final_activity extends AppCompatActivity {

    private TextView totalMarks, report;
    private Button returnToMain;
    private RatingBar ratingBar;

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Cannot go back. Please re-take the quiz.", Toast.LENGTH_SHORT).show();
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        totalMarks =  findViewById(R.id.total_marks);
        returnToMain =  findViewById(R.id.return_to_main);
        ratingBar =  findViewById(R.id.ratingBar);
        report = findViewById(R.id.report);

        //setting the title
        setTitle("Result");

        //rating bar for the rating
        ratingBar.setRating(MainActivity.Marks);
        totalMarks.setText(Integer.toString(MainActivity.Marks)+"/4");
        Toast.makeText(this, "Score is "+MainActivity.Marks, Toast.LENGTH_SHORT).show();

        //showing the remarks
        for (String string : MainActivity.feedbackReport){
            report.append(string + "\n\n");
        }

        //to retake the quiz
        returnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.Marks = 0;
                MainActivity.feedbackReport.clear();
                Intent intent = new Intent(Final_activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
