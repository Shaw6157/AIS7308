package com.ais.demosqlitequiz;

public class CompleteQuestion {
    private int questionID;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int correctAnswer;

    private String quizName;

    public CompleteQuestion(int pQuestionID, String pQuestion, String pOption1, String pOption2, String pOption3, String pOption4, int pCorrectAnswer, String pQuizName) {
        this.questionID = pQuestionID;
        question = pQuestion;
        option1 = pOption1;
        option2 = pOption2;
        option3 = pOption3;
        option4 = pOption4;
        correctAnswer = pCorrectAnswer;
        quizName = pQuizName;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int pQuestionID) {
        questionID = pQuestionID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String pQuestion) {
        question = pQuestion;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String pOption1) {
        option1 = pOption1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String pOption2) {
        option2 = pOption2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String pOption3) {
        option3 = pOption3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String pOption4) {
        option4 = pOption4;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int pCorrectAnswer) {
        correctAnswer = pCorrectAnswer;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String pQuizName) {
        quizName = pQuizName;
    }
}
