package com.example.namanh.retrofit.Main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.namanh.retrofit.Model.Question_Response;
import com.example.namanh.retrofit.Question.QuestionAdapter;
import com.example.namanh.retrofit.R;

import org.json.JSONArray;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainView{

    private MainPresentor mainPresentor;
    public QuestionAdapter questionAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnShow = (Button) findViewById(R.id.btn_show);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.question_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        questionAdapter = new QuestionAdapter(this, new ArrayList<Question_Response>());
        recyclerView.setAdapter(questionAdapter);
        mainPresentor = new MainPresentorImpl(MainActivity.this,this);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresentor.onShowClick();
            }
        });
    }
    @Override
    public void setQuestion(JSONArray jsonArray) {
        questionAdapter.addQuestion(jsonArray);
        questionAdapter.notifyDataSetChanged();
    }
}
