package com.example.namanh.retrofit.Model.rest_api;


import com.example.namanh.retrofit.Presenter.FetchDataCallBack;
import com.example.namanh.retrofit.Presenter.FetchDataInterface;


import org.json.JSONArray;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by NamAnh on 15/08/2016.
 */
public class ApiClient implements FetchDataInterface{
    public static ApiClient instance;
    public static ApiClient getInstance(){
        if (instance==null){
            return new ApiClient();
        } else {
            return instance;
        }
    }
    private Retrofit retrofit;
    private ApiInterface apiInterface;
    public ApiClient(){
        retrofit = new Retrofit.Builder().baseUrl("http://app.pixa.vn/app_caudo/api/").build();
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
                    callBack.onFetchFaile(e);
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBack.onFetchFaile(new Exception(t));
            }
        });
    }

}
