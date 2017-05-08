package com.example.haruta.myapplication;

import com.example.haruta.myapplication.util.ListViewUtil;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ListViewActivity extends AppCompatActivity {

    @BindView(R.id.listview_button_add)
    Button mAddItemButton;

    @BindView(R.id.listview_edittext_title)
    EditText mTitle;

    private ListViewUtil mListViewUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ButterKnife.bind(this);

        mListViewUtil = new ListViewUtil(
                this,
                (ListView) findViewById(R.id.my_listView),
                (SwipeRefreshLayout) findViewById(R.id.refresh));
        mListViewUtil.loadItems();
    }

    @OnClick(R.id.listview_button_add)
    public void addItem() {
        mListViewUtil.registerItem(mTitle);
    }
}
