package com.example.haruta.myapplication.util;

import com.example.haruta.myapplication.MyListViewAdapter;
import com.example.haruta.myapplication.api.RestClient;
import com.example.haruta.myapplication.model.BooleanResult;
import com.example.haruta.myapplication.model.Item;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import lombok.Getter;
import lombok.experimental.Accessors;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListViewUtil implements SwipeRefreshLayout.OnRefreshListener {

    @Getter
    @Accessors(prefix = {"m"})
    private Context mContext;

    @Getter
    @Accessors(prefix = {"m"})
    private List<Item> mItems;

    private MyListViewAdapter mAdapter;

    private ListView mListView;

    private RestClient mRestClient;

    private SwipeRefreshLayout mSwipeRefreshLayout;

    public ListViewUtil(Context context, ListView listView, SwipeRefreshLayout swipeRefreshLayout) {
        mContext = context;
        mListView = listView;
        mRestClient = new RestClient();
        mSwipeRefreshLayout = swipeRefreshLayout;
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    public void loadItems() {
        mRestClient.getItems().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.isSuccessful()) {
                    mItems = response.body();
                    mAdapter = new MyListViewAdapter(ListViewUtil.this);
                    mListView.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                mSwipeRefreshLayout.setRefreshing(false);
                Log.e("javalog", "load fail:" + Log.getStackTraceString(t));
            }
        });
    }

    public void registerItem(final EditText editText) {
        mRestClient.postItem(editText.getText().toString()).enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                loadItems();
                editText.setText("");
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                Log.e("javalog", "register fail:" + Log.getStackTraceString(t));
            }
        });

    }

    public void deleteItem(final Item selectedItem) {
        mRestClient.deleteItem(selectedItem.getId()).enqueue(
                new Callback<BooleanResult>() {
                    @Override
                    public void onResponse(Call<BooleanResult> call,
                            Response<BooleanResult> response) {
                        mItems.remove(selectedItem);
                        mAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<BooleanResult> call, Throwable t) {
                        Log.e("javalog", "delete fail:" + Log.getStackTraceString(t));
                    }
                });

    }

    public void getItem(int id) {
        mRestClient.getItem(id).enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                Log.d("javalog", "hoge-->" + response.body());
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                Log.e("javalog", "get item fail:" + Log.getStackTraceString(t));
            }
        });
    }

    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setRefreshing(true);
        loadItems();
    }
}
