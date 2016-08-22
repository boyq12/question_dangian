package com.example.namanh.retrofit.Model;

/**
 * Created by NamAnh on 15/08/2016.
 */
public class Question {
    private String id;
    private String question;
    private String answerplan;
    private String answerfull;
    private String hint;
    private String done;

    public Question() {
    }

    public Question(String id, String question, String answerplan,
                         String answerfull, String hint, String done) {
        super();
        this.id = id;
        this.question = question;
        this.answerplan = answerplan;
        this.answerfull = answerfull;
        this.hint = hint;
        this.done = done;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerplan() {
        return answerplan;
    }

    public void setAnswerplan(String answerplan) {
        this.answerplan = answerplan;
    }

    public String getAnswerfull() {
        return answerfull;
    }

    public void setAnswerfull(String answerfull) {
        this.answerfull = answerfull;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }
}
