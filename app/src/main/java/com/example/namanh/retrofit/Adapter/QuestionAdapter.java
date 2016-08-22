package com.example.namanh.retrofit.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.namanh.retrofit.Model.Question_Response;
import com.example.namanh.retrofit.R;

import org.json.JSONArray;


import java.util.ArrayList;

/**
 * Created by NamAnh on 15/08/2016.
 */
public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>{
    public Context context;
    public ArrayList<Question_Response> arrayList;
    public LayoutInflater layoutInflater;

    public QuestionAdapter(Context context, ArrayList<Question_Response> arrayList){
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public QuestionAdapter.QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = layoutInflater.inflate(R.layout.question_item, null);
        QuestionViewHolder item = new QuestionViewHolder(view);
        return item;
    }

    @Override
    public void onBindViewHolder(QuestionViewHolder holder, int position) {
        final Question_Response question_response = this.arrayList.get(position);
        holder.question_id.setText(question_response.getId());
        holder.question_data.setText(question_response.getQuestion());
        holder.question_answer.setText(question_response.getAnswer());
    }

    @Override
    public int getItemCount() {
        return this.arrayList.size();
    }
    public void addQuestion(JSONArray jsonArray){
        ArrayList<Question_Response> arrayList = Question_Response.addQuestion(jsonArray);
        addQuestion(arrayList);
    }
    public void addQuestion(ArrayList<Question_Response> arrayList){
        this.arrayList.clear();
        this.arrayList.addAll(arrayList);
        notifyDataSetChanged();
    }
    public static class QuestionViewHolder extends RecyclerView.ViewHolder{
        public TextView question_id;
        public TextView question_data;
        public TextView question_answer;
        public QuestionViewHolder(View v){
            super(v);
            question_id = (TextView) v.findViewById(R.id.question_id);
            question_data = (TextView) v.findViewById(R.id.question_data);
            question_answer = (TextView) v.findViewById(R.id.question_answer);
        }
    }

}
