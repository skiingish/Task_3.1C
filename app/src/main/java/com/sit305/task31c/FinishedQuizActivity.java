package com.sit305.task31c;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;


public class FinishedQuizActivity extends AppCompatActivity {

    // The textviews needed to show the use's name and score.
    private TextView userName_TV;
    private TextView usersScore_TV;

    // Ints to hold the user's score and total number of questions.
    private int usersScore;
    private int numOfQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_finished);

        // Get the needed views
        userName_TV = findViewById(R.id.userName_TV);
        usersScore_TV = findViewById(R.id.usersScore_TV);

        // Show the congratulations message.
        userName_TV.setText("Congratulations " + Constants.dataList.get(0) + "!");

        // Create a new intent.
        Intent thisIntent = getIntent();
        // Create a bundle to get the passed extras from the last activity.
        Bundle bundle = thisIntent.getExtras();

        // As long as the bundle is not null get and set the user's score.
        if (bundle != null) {
            usersScore = (int) bundle.get("Score");
            numOfQuestions = (int) bundle.get("NumOfQuestions");
            usersScore_TV.setText(usersScore + "/" + numOfQuestions);
        }
    }

    // Clicking on the restart button goes back to main activity.
    public void restartOnClick(View view) {
        // Finish this activity therefor go back to the MainActivity.
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    // Clicking on the finish button closes the app.
    public void finishedOnClick(View view) {
        // Close the app
        finish();
        System.exit(0);
    }
}