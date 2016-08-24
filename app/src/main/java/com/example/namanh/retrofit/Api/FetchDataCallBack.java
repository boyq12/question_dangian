package com.example.namanh.retrofit.Api;

import org.json.JSONArray;

public interface FetchDataCallBack {
    void onFetchSuccess(JSONArray jsonArray);
    void onFetchFail(Exception e);


}
