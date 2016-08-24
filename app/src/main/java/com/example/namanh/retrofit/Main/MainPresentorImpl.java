package com.example.namanh.retrofit.Main;

import android.content.Context;

import com.example.namanh.retrofit.Api.ApiClient;
import com.example.namanh.retrofit.Api.FetchDataCallBack;


import org.json.JSONArray;


public class MainPresentorImpl implements MainPresentor {
    Context context;
    ApiClient apiClient;
    MainView mainView;
    public MainPresentorImpl (Context context, MainView mainView){
        this.context=context;
        this.mainView = mainView;
        apiClient = ApiClient.getInstance();
    }
    @Override
    public void onShowClick() {
        apiClient.fetchQuestion(new FetchDataCallBack() {
            @Override
            public void onFetchSuccess(JSONArray jsonArray) {
                    mainView.setQuestion(jsonArray);
            }
            @Override
            public void onFetchFail(Exception e) {
                e.printStackTrace();
            }
        });
    }
}