package com.example.haruta.myapplication.data.repository.datasource;


import android.util.Log;

import com.example.haruta.myapplication.data.api.RestClient;
import com.example.haruta.myapplication.data.entity.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiItemStore implements ItemStore {

    private RestClient mRestClient;

    public ApiItemStore() {
        mRestClient = new RestClient();
    }

    @Override
    public void getItems(final ItemsCallback callback) {
        mRestClient.getItems().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                callback.onItemsLoaded(response);
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                callback.onError(t);
                Log.e("javalog", "load fail:" + Log.getStackTraceString(t));
            }
        });
    }

    @Override
    public void getItem(int id, final ItemCallback callback) {
        mRestClient.getItem(id).enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                callback.onItemLoaded(response);
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                callback.onError(t);
                Log.e("javalog", "get item fail:" + Log.getStackTraceString(t));
            }
        });
    }
}
