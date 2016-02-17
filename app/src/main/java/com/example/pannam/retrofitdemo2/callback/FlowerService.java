package com.example.pannam.retrofitdemo2.callback;

import com.example.pannam.retrofitdemo2.model.Flower;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pannam on 2/17/2016.
 */
public interface FlowerService {

    @GET("/feeds/flowers.json")
    Call<List<Flower>> getAllFlowers();

}
