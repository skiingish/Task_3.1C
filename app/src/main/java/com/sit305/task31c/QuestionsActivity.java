package com.sit305.task31c;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Bundle;
import java.util.ArrayList;

public class QuestionsActivity extends AppCompatActivity {

    // All the views.
    ProgressBar progressBar;
    TextView progress_TV;
    TextView question_TV;
    TextView questionTitle_TV;
    TextView option_one_TV;
    TextView option_two_TV;
    TextView option_three_TV;


    // To hold the current pos of the list of questions.
    private int currentPosition = 1;
    // Current selected question option.
    private int selectedOpt = 0;
    // The list of questions.
    private ArrayList<Question> listOfQuestions = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        // Get all the views.
        progressBar = findViewById(R.id.progressBar);
        progress_TV = findViewById(R.id.progress_TV);
        question_TV = findViewById(R.id.question_TV);
        questionTitle_TV = findViewById(R.id.questionTitle_TV);
        option_one_TV = findViewById(R.id.option_one_TV);
        option_two_TV = findViewById(R.id.option_two_TV);
        option_three_TV = findViewById(R.id.option_three_TV);

        // Get and build the list of questions.
        listOfQuestions = Constants.getQuestionsList();

        // Set the welcome message.
        TextView nameHolder_TV = findViewById(R.id.nameHolder_TV);
        nameHolder_TV.setText("Welcome " + Constants.dataList.get(0));

        // Build the questions.
        buildQuestions();
    }

    private void buildQuestions() {

        // Clear the current selection.
        clearSelectedOpts();

        // Current question.
        currentPosition = 1;

        // Hold the current question being asked.
        Question question = listOfQuestions.get(currentPosition - 1);

        // Update the progress bar.
        progressBar.setProgress(currentPosition);
        progress_TV.setText(currentPosition + "/" + progressBar.getMax());

        // Set the different question elements of the current question.
        questionTitle_TV.setText("Question Title: " + question.questionTitle);
        question_TV.setText(question.question);
        option_one_TV.setText(question.optionOne);
        option_two_TV.setText(question.optionTwo);
        option_three_TV.setText(question.optionThree);
    }

    // Used when a option is selected to show that the option was selected.
    public void onOptClick(View view) {
        // First clear all options so they look unselected.
        clearSelectedOpts();

        // Used to hold the selected TextView.
        TextView selected_TV;

        // Cast the passed view to TextView.
        try {
            selected_TV = (TextView) view;
        } catch (Exception e) {
            // Can't cast to a TextView.
            return;
        }

        // Select the required option given the passed textView.
        if (selected_TV.getId() == option_one_TV.getId()) {
            selectOpt(selected_TV, 1);
        }
        else if (selected_TV.getId() == option_two_TV.getId()) {
            selectOpt(selected_TV, 2);
        }
        else if (selected_TV.getId() == option_three_TV.getId()) {
            selectOpt(selected_TV, 3);
        }
        else {
            // This view don't exist.
        }
    }

    private void selectOpt(TextView selected_TV, int selectedOptNum) {
        // Set the selected option
        selectedOpt = selectedOptNum;

        // Create a typeface from the current one.
        Typeface tf  = selected_TV.getTypeface();

        // Set the design of the selected option.
        selected_TV.setTextColor(Color.parseColor("#363A43"));
        selected_TV.setTypeface(tf, Typeface.BOLD);
        selected_TV.setBackground(ContextCompat.getDrawable(this, R.drawable.options_selected_btn_shape_borders));
    }

    // Create a list of all the options then set them to unselected.
    private void clearSelectedOpts() {
        // Create a new list of the options.
        ArrayList<TextView> options = new ArrayList<TextView>();

        // All options to the list.
        options.add(0, option_one_TV);
        options.add(1, option_two_TV);
        options.add(2, option_three_TV);

        // For each option in the list set to the unselected look.
        for (TextView option : options) {
            option.setTextColor(Color.parseColor("#7A8089"));
            option.setBackground(ContextCompat.getDrawable(this, R.drawable.options_btn_shape_borders));
        }
    }
}