package com.example.haruta.myapplication.data;

import com.example.haruta.myapplication.data.repository.ItemRepositoryImpl;
import com.example.haruta.myapplication.domain.repository.ItemRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    @Singleton
    public ItemRepository provideItemRepository() {
        return new ItemRepositoryImpl();
    }
}
