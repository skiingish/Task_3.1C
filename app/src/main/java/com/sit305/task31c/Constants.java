package com.sit305.task31c;

import java.util.ArrayList;

// Public interface to store the data of this quiz app to be access anywhere
public interface Constants {

    // The list of different questions
    ArrayList<Question> questionsList = new ArrayList<Question>();

    // Public static method to build and return the list of quiz questions
    static ArrayList<Question> getQuestionsList() {


        // Create question 1 from a question object
        Question question1 = new Question(
                0, "@values/questions.xml:3",
                "Question it's self?",
                "Answer1", "Answer2",
                "Answer3", 1);

        // Add question 1 to the list of questions
        questionsList.add(question1);

        // Return the list of questions after being build.
        return questionsList;
    }
}
