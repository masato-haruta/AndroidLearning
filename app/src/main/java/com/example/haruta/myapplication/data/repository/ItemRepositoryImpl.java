package com.example.haruta.myapplication.data.repository;


import com.example.haruta.myapplication.data.repository.datasource.ItemStore;
import com.example.haruta.myapplication.data.repository.datasource.ItemStoreFactory;
import com.example.haruta.myapplication.domain.repository.ItemRepository;

import javax.inject.Inject;

public class ItemRepositoryImpl implements ItemRepository {

    private ItemStoreFactory mItemStoreFactory;

    @Inject
    public ItemRepositoryImpl(ItemStoreFactory itemStoreFactory) {
        mItemStoreFactory = itemStoreFactory;
    }

    @Override
    public void loadItems(ItemsCallback itemsCallback) {
        final ItemStore itemStore = mItemStoreFactory.createItemStore();
        itemStore.getItems(itemsCallback);
    }

    @Override
    public void loadItem(int id, ItemCallback itemCallback) {}
}
