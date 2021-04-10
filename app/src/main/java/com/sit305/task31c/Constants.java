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


        // Create question 1 from a question object
        Question question1 = new Question(
                0, "Question 1- (1)",
                "Question it's self?",
                "Answer1", "Answer2",
                "Answer3", 1);

        // Add question 1 to the list of questions
        questionsList.add(question1);

        // Create question 2 from a question object
        Question question2 = new Question(
                1, "Question 2- (3)",
                "Question it's self?",
                "Answer1", "Answer2",
                "Answer3", 3);

        // Add question 1 to the list of questions
        questionsList.add(question2);

        // Create question 3 from a question object
        Question question3 = new Question(
                2, "Question 3- (2)",
                "Question it's self?",
                "Answer1", "Answer2",
                "Answer3", 3);

        // Add question 1 to the list of questions
        questionsList.add(question3);

        // Create question 4 from a question object
        Question question4 = new Question(
                3, "Question 4 - (2)",
                "Question it's self?",
                "Answer1", "Answer2",
                "Answer3", 3);

        // Add question 1 to the list of questions
        questionsList.add(question4);

        // Create question 3 from a question object
        Question question5 = new Question(
                4, "Question 5- (2)",
                "Question it's self?",
                "Answer1", "Answer2",
                "Answer3", 3);

        // Add question 1 to the list of questions
        questionsList.add(question5);

        // Return the list of questions after being build.
        return questionsList;
    }

    // Add the username to string data list.
    static void updateUsername(String usernameInput) {
        dataList.add(usernameInput);
    }
}
