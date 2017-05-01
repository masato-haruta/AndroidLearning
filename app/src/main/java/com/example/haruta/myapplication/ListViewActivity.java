package com.example.haruta.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ListViewActivity extends AppCompatActivity {

    private ListView mListView;

    private ArrayAdapter<String> mAdapter;

    @BindView(R.id.listview_button_add)
    Button mAddListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ButterKnife.bind(this);

        mListView = (ListView) findViewById(R.id.my_listView);

        mAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1
        );

        mListView.setAdapter(mAdapter);
    }

    @OnClick(R.id.listview_button_add)
    public void addList() {
        mAdapter.add(getDateText());
    }

    // 現在時刻を返す
    private String getDateText() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
