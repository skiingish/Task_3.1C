package com.sit305.task31c;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
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
    Button submit_next_BTN;

    // To hold the current pos of the list of questions.
    private int currentPosition = 1;
    // Current selected question option.
    private int selectedOpt = 0;
    // The list of questions.
    private ArrayList<Question> listOfQuestions = null;
    // Hold the user's score.
    private int currentScore;
    // Logic of if the answers have been shown.
    private boolean answersShown;
    // Logic of if a answer has been submitted.
    private boolean answerSubmitted;


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
        submit_next_BTN = findViewById(R.id.submit_next_BTN);

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
        // If a answer has already been submitted, it can't be changed.
        if (answerSubmitted) {
            return;
        }

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

    public void onSubmitBTNClick(View view) {
        // If the answers have been show, move to the next question if more exist.
        if (answersShown) {
            // If the current question num is the same as the size of list finish the quiz.
            if (currentPosition == listOfQuestions.size())
            {
                // Finish the quiz.
                // Intent to finish page.
            }
            else{
                // Move to next question.
                currentPosition++;
                // Build the new questions.
                buildQuestions();
                // Reset the submitted answer logic
                answerSubmitted = false;
                // Reset the button text.
                submit_next_BTN.setText("Submit");
                // Answers shown back to false
                answersShown = false;
            }
        }
        else {
            // Answer submitted therefor a new one can't be selected and submitted.
            answerSubmitted = true;

            // Get the current on screen question.
            Question question = listOfQuestions.get(currentPosition - 1);

            // Correct answer.
            if (selectedOpt == question.correctAnswer)
            {
                // Add to the user's score
                currentScore++;
            }
            else {
                // Incorrect Answer (color the selected answer red)
                changeOptDesign(selectedOpt, R.drawable.incorrect_option_btn_shape_borders);
            }

            // Show the correct answer in green regardless if selected or not.
            changeOptDesign(question.correctAnswer, R.drawable.correct_option_btn_shape_borders);

            // Answers have been shown.
            answersShown = true;

            // If it's the last question show finish.
            if (currentPosition == listOfQuestions.size()) {
                // Finish Button.
                submit_next_BTN.setText("Finish"); // TODO Task sheet says this should just be next when on the last question.
            }
            else {
                // Show the next question text.
                submit_next_BTN.setText("Next");
            }
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

        // Clear the current selected option.
        selectedOpt = 0;

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

    private void changeOptDesign(int optionIndex, int drawableInt) {
        switch (optionIndex) {
            case 1:
                option_one_TV.setBackgroundResource(drawableInt);
                break;
            case 2:
                option_two_TV.setBackgroundResource(drawableInt);
                break;
            case 3:
                option_three_TV.setBackgroundResource(drawableInt);
                break;

        }
    }
}