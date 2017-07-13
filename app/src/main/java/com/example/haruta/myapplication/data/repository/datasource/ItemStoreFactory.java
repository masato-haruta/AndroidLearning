package com.example.haruta.myapplication.data.repository.datasource;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ItemStoreFactory {

    @Inject
    public ItemStoreFactory() {}

    public ItemStore create() {
        return createItemStore();
    }

    public ItemStore createItemStore() {
        return new ApiItemStore();
    }
}
