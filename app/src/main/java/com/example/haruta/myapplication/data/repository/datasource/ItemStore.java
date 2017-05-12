package com.example.haruta.myapplication.data.repository.datasource;

import com.example.haruta.myapplication.data.entity.Item;

import java.util.List;

import retrofit2.Call;

public interface ItemStore {

    public void getItems(ItemsCallback itemsCallback);

    public void getItem(int id, ItemCallback itemCallback);

    interface ItemsCallback {
        void onItemsLoaded(Call<List<Item>> items);

        void onError(Exception exception);
    }

    interface ItemCallback {
        void onItemLoaded(Call<Item> items);

        void onError(Exception exception);
    }
}
