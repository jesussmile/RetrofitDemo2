package com.example.pannam.retrofitdemo2.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.pannam.retrofitdemo2.R;
import com.example.pannam.retrofitdemo2.adapter.FlowerAdapter;
import com.example.pannam.retrofitdemo2.controller.RestManager;
import com.example.pannam.retrofitdemo2.helper.Constants;
import com.example.pannam.retrofitdemo2.model.Flower;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements FlowerAdapter.FlowerClickListener{

    private RecyclerView mRecyclerView;
    private RestManager mManager;
    private FlowerAdapter mFlowerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configViews();
        mManager = new RestManager();
        Call<List<Flower>> listCall = mManager.getFlowerService().getAllFlowers();
        listCall.enqueue(new Callback<List<Flower>>() {
            @Override
            public void onResponse(Call<List<Flower>> call, Response<List<Flower>> response) {


                if (response.isSuccess()) {
                    List<Flower> flowerList = response.body();

                    for (int i = 0; i < flowerList.size(); i++) {
                        Flower flower = flowerList.get(i);
                        mFlowerAdapter.addFlower(flower);
                    }

                } else {
                    int sc = response.code();
                    switch (sc) {

                    }
                }


            }

            @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),
                        Toast.LENGTH_LONG).show();
                Log.e("Retrofit", "No connection " + t.getMessage());
            }
        });

        //stop service
       // listCall.cancel();
    }

    private void configViews() {

        mRecyclerView = (RecyclerView)this.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,false));
        mFlowerAdapter = new FlowerAdapter(this);


        mRecyclerView.setAdapter(mFlowerAdapter);

    }


    @Override
    public void onClick(int position) {

        Flower selectedFlower = mFlowerAdapter.getSelectedFlower(position);
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(Constants.REFERENCE.FLOWER,selectedFlower);
        startActivity(intent);
    }
}



