package com.example.haruta.myapplication.data.api;


import com.example.haruta.myapplication.data.entity.BooleanResult;
import com.example.haruta.myapplication.data.entity.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {

    // 認証結果取得
    @GET("auth/{password}")
    Call<BooleanResult> authorize(@Path("password") String password);

    // 全アイテム取得
    @GET("items")
    Call<List<Item>> getItems();

    // アイテム取得
    @GET("item/{id}")
    Call<Item> getItem(@Path("id") int id);

    // アイテム登録
    @FormUrlEncoded
    @POST("item")
    Call<Item> registerItem(@Field("body") String body);

    // アイテム更新
    @FormUrlEncoded
    @PUT("item")
    Call<Item> updateItem(@Field("id") int id, @Field("body") String body);

    // アイテム削除
    @DELETE("item/{id}")
    Call<BooleanResult> deleteItem(@Path("id") int id);

    // 全アイテム削除
    @DELETE("items")
    Call<BooleanResult> deleteItems();
}
