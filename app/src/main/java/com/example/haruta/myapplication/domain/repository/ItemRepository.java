package com.example.haruta.myapplication.domain.repository;

import com.example.haruta.myapplication.data.entity.Item;
import com.example.haruta.myapplication.domain.exception.ErrorBundle;

import java.util.List;


public interface ItemRepository {

    void loadItems(ItemsCallback itemsCallback);

    void loadItem(int id, ItemCallback itemCallback);

    interface ItemsCallback {
        void onItemLoaded(List<Item> items);

        void onError(ErrorBundle errorBundle);
    }

    interface  ItemCallback {
        void onItemLoaded(Item item);

        void onError(ErrorBundle errorBundle);
    }
}
