package com.example.namanh.retrofit.Model.rest_api;

import com.example.namanh.retrofit.Model.Question_Response;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by NamAnh on 15/08/2016.
 */
public interface ApiInterface {
    @GET("list_question?count=0")
    Call<ResponseBody> get_Question();
}
