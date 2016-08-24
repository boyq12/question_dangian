package com.example.namanh.retrofit.Api;


import org.json.JSONArray;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ApiClient implements FetchDataInterface{
    public static ApiClient instance;
    public static ApiClient getInstance(){
        if (instance==null){
            return new ApiClient();
        } else {
            return instance;
        }
    }
    private ApiInterface apiInterface;
    public ApiClient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://app.pixa.vn/app_caudo/api/").build();
        apiInterface = retrofit.create(ApiInterface.class);
    }
    @Override
    public void fetchQuestion(final FetchDataCallBack callBack){
        Call<ResponseBody> api = apiInterface.get_Question();
        api.enqueue(new Callback<ResponseBody>(){
            @Override
            public void onResponse(Call<ResponseBody>call, Response<ResponseBody> res){
                try {
                    JSONObject jsonObject = new JSONObject(res.body().string());
                    JSONArray jsonArray = jsonObject.getJSONArray("items");
                    callBack.onFetchSuccess(jsonArray);
                }
                catch (Exception e){
                    callBack.onFetchFail(e);
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBack.onFetchFail(new Exception(t));
            }
        });
    }

}
