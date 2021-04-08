package com.sit305.task31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Name of the person taking the quiz.
    EditText name_ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Start the game by pressing the start button
    public void startGame(View view) {
        // Create the new intent from the questions activity
        Intent intent = new Intent(this, QuestionsActivity.class);
        // Start the questions activity
        startActivity(intent);
        // Finish the current activity I.e this one.
        finish();
    }
}