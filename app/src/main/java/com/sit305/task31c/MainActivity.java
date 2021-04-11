package com.sit305.task31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Name of the person taking the quiz.
    EditText name_ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the username field.
        name_ET = findViewById(R.id.user_name_field);

        // Check to see if a username already exists, if so set it as the editText.
        if (Constants.dataList.size() > 0 ) {
            name_ET.setText(Constants.dataList.get(0));
        }
    }

    // Start the game by pressing the start button.
    public void startGame(View view) {
        // Get and set (or update) the quiz taker's user name value.
        try {
            Constants.updateUsername(name_ET.getText().toString());
        } catch (Exception e) {
            // Error converting to a string. (Show a error message).
            Toast.makeText(this, "Error inputting user name - " + e.toString(), Toast.LENGTH_LONG).show();
        }

        // Create the new intent from the questions activity
        Intent intent = new Intent(this, QuestionsActivity.class);
        // Send the user's username.
        intent.putExtra("username", name_ET.getText().toString());
        // Start the questions activity
        startActivity(intent);
        // Finish the current activity I.e this one.
        finish();
    }
}