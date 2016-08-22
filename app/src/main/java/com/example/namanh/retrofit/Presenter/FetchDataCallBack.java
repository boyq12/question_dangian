package com.example.namanh.retrofit.Presenter;

import org.json.JSONArray;

/**
 * Created by NamAnh on 15/08/2016.
 */
public interface FetchDataCallBack {
    void onFetchSuccess(JSONArray jsonArray);
    void onFetchFaile(Exception e);


}
