package com.sit305.task31c;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Bundle;

public class QuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        // Set the welcome message.
        TextView nameHolder_TV = findViewById(R.id.nameHolder_TV);
        nameHolder_TV.setText("Welcome " + Constants.dataList.get(0));
    }
}