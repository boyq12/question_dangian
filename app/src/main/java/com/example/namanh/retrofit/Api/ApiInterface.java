package com.example.namanh.retrofit.Api;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("list_question?count=0")
    Call<ResponseBody> get_Question();
}
