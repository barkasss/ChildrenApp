package com.brks.childrenapp.Answers;

import android.view.View;


import androidx.recyclerview.widget.RecyclerView;

public class SingleAnswer {


    private String[] answers;
    private String question;


    public SingleAnswer(String question, String[] answers) {

        this.answers = answers;
        this.question = question;
    }


    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String[] answers) {
        this.answers = answers;
    }

}

