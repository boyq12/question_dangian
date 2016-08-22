package com.example.namanh.retrofit.Presenter;

import android.content.Context;

import com.example.namanh.retrofit.MainActivity;
import com.example.namanh.retrofit.Model.rest_api.ApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by NamAnh on 15/08/2016.
 */
public class MainPresentor extends BasePresenter {
    ApiClient apiClient;
    public MainPresentor(Context context){
        super(context);
        apiClient = ApiClient.getInstance();
    }
    public void getData(){
        apiClient.fetchQuestion(new FetchDataCallBack() {
            @Override
            public void onFetchSuccess(JSONArray jsonArray) {
                try {
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    jsonArray = jsonObject.getJSONArray("items");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                getParent().questionAdapter.addQuestion(jsonArray);
            }

            @Override
            public void onFetchFaile(Exception e) {
                e.printStackTrace();
            }
        });

    }
    private MainActivity getParent(){
        return (MainActivity) this.context;
    }
}