package com.sit305.task31c;

// Public question class to store the question data
// An object of this class then can be added to an array of different quiz questions
public class Question {
    public static int id;
    public static String questionTitle;
    public static String question;
    public static String optionOne;
    public static String optionTwo;
    public static String optionThree;
    public static int correctAnswer;

    // Ctor to create a question with it's required values.
    public Question(int id, String questionTitle, String question, String optionOne, String optionTwo, String optionThree, int correctAnswer) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.question = question;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.correctAnswer = correctAnswer;
    }
}
