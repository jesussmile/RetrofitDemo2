package com.example.pannam.retrofitdemo2.controller;

import com.example.pannam.retrofitdemo2.callback.FlowerService;
import com.example.pannam.retrofitdemo2.helper.Constants;
import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pannam on 2/17/2016.
 */
public class RestManager {


    private FlowerService mFlowerService;

public FlowerService getFlowerService(){
    if(mFlowerService == null){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.HTTP.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();




        mFlowerService = retrofit.create(FlowerService.class);
    }
    return mFlowerService;
}












}
