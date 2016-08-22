package com.example.namanh.retrofit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.namanh.retrofit.Adapter.QuestionAdapter;
import com.example.namanh.retrofit.Model.Question_Response;
import com.example.namanh.retrofit.Presenter.MainPresentor;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public QuestionAdapter questionAdapter;
    private RecyclerView recyclerView;
    private MainPresentor mainPresentor;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresentor = new MainPresentor(this);
        recyclerView = (RecyclerView) findViewById(R.id.question_list);
        layoutManager = new LinearLayoutManager(this);
        questionAdapter = new QuestionAdapter(this, new ArrayList<Question_Response>());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(questionAdapter);
        questionAdapter.notifyDataSetChanged();
        mainPresentor.getData();
    }

}
