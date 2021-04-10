package com.sit305.task31c;

import java.util.ArrayList;
import java.util.List;

// Public interface to store the data of this quiz app to be access anywhere
public interface Constants {

    // The list of different questions
    ArrayList<Question> questionsList = new ArrayList<Question>();

    // Will be used to store a list of data strings
    List<String> dataList = new ArrayList<String>();

    // Public static method to build and return the list of quiz questions
    static ArrayList<Question> getQuestionsList() {

        // If the question list has already been built clear it before rebuild.
        if (questionsList.size() > 0) {
            questionsList.clear();
        }

        // Create question 1 from a question object
        Question question1 = new Question(
                0, "Question 1 - Views",
                "Which of these views allows a user to input text?",
                "TextView", "EditText",
                "Toolbar", 2);

        // Create question 2 from a question object
        Question question2 = new Question(
                1, "Question 2 - Views",
                "How would you reference a view by it's ID? (in this example the view ID is: viewName)",
                "findViewById(R.id.viewName)", "findId(id.viewName)",
                "viewName.find(id)", 1);

        // Create question 3 from a question object
        Question question3 = new Question(
                2, "Question 3 - Activity Lifecycle",
                "Which callback method runs for the whole lifecycle of an activity?",
                "onStart()", "onLaunch()",
                "onCreate()", 3);

        // Create question 4 from a question object
        Question question4 = new Question(
                3, "Question 4 - Intent",
                "Question it's self?",
                "Answer1", "Answer2",
                "Answer3", 3);

        // Create question 5 from a question object
        Question question5 = new Question(
                4, "Question 5- (2)",
                "Question it's self?",
                "Answer1", "Answer2",
                "Answer3", 3);

        // Add questions to the list of questions.
        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);

        // Return the list of questions after being built.
        return questionsList;
    }

    // Add the username to string data list.
    static void updateUsername(String usernameInput) {
        // If the datalist has already been created clear first.
        if (dataList.size() > 0) {
            dataList.clear();
        }
        // Add the Username
        dataList.add(usernameInput);
    }
}
