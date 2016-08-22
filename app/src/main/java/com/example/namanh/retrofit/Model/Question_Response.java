package com.example.namanh.retrofit.Model;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by NamAnh on 15/08/2016.
 */
public class Question_Response {
    @SerializedName("id")
    private String id;
    @SerializedName("question")
    private String question;
    @SerializedName("answer")
    private String answer;

    public Question_Response(String id, String question, String answer){
        super();
        this.id = id;
        this.question = question;
        this.answer = answer;
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
    public String getAnswer(){return answer;}
    public void setAnswer(String answer){this.answer = answer;}
    public static ArrayList<Question_Response> addQuestion(JSONArray jsonArray){
        ArrayList<Question_Response> arrayList= new ArrayList<>();
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                      arrayList.add(Question_Response.getMovie(jsonArray.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
    public static Question_Response getMovie(JSONObject obj) {
        try {
            return new Question_Response(obj.getString("id"), obj.getString("question"), obj.getString("answerplan"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
