package com.example.haruta.myapplication.api;

import com.example.haruta.myapplication.model.BooleanResult;
import com.example.haruta.myapplication.model.Item;
import com.example.haruta.myapplication.util.Url;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private ApiService mApiService;

    public RestClient() {

        mApiService = new Retrofit.Builder()
                .baseUrl(Url.getApiUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getHttpClientBuilder()
                        .build()).build().create(ApiService.class);
    }

    public Retrofit.Builder getServiceBuilder() {
        return new Retrofit.Builder()
                .baseUrl(Url.getApiUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getHttpClientBuilder().build());
    }


    public OkHttpClient.Builder getHttpClientBuilder() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        Request original = chain.request();

                        Request.Builder builder = original.newBuilder();
                        builder.method(original.method(), original.body());
                        Request request = builder.build();

                        return chain.proceed(request);
                    }
                });
        return httpClientBuilder;
    }

    public Call<BooleanResult> auth(String password) {
        return mApiService.authorize(password);
    }

    public Call<BooleanResult> deleteItems() {
        return mApiService.deleteItems();
    }

    public Call<List<Item>> getItems() {
        return mApiService.getItems();
    }

    public Call<Item> postItem(String body) {
        return mApiService.registerItem(body);
    }

    public Call<Item> updateItem(int id, String body) {
        return mApiService.updateItem(id, body);
    }

    public Call<BooleanResult> deleteItem(int id) {
        return mApiService.deleteItem(id);
    }

    public Call<Item> getItem(int id) {
        return mApiService.getItem(id);
    }
}
