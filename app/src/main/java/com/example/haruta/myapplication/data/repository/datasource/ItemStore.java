package com.example.haruta.myapplication.data.repository.datasource;

import com.example.haruta.myapplication.data.entity.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public interface ItemStore {

    public void getItems(ItemsCallback itemsCallback);

    public void getItem(int id, ItemCallback itemCallback);

    interface ItemsCallback {
        void onItemsLoaded(Response<List<Item>> items);

        void onError(Throwable exception);
    }

    interface ItemCallback {
        void onItemLoaded(Response<Item> items);

        void onError(Throwable exception);
    }
}
