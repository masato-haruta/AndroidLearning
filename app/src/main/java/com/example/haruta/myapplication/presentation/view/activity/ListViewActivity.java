package com.example.haruta.myapplication.presentation.view.activity;

import com.example.haruta.myapplication.R;
import com.example.haruta.myapplication.util.ListViewUtil;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ListViewActivity extends AppCompatActivity {

    @BindView(R.id.listview_button_add)
    Button mAddItemButton;

    @BindView(R.id.listview_edittext_title)
    EditText mTitle;

    @BindView(R.id.listview_button_logout)
    Button mLogoutButton;

    @BindView(R.id.listview_text_loginid)
    TextView mLoginId;

    private ListViewUtil mListViewUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ButterKnife.bind(this);

        mListViewUtil = new ListViewUtil(
                this,
                (ListView) findViewById(R.id.my_listView),
                (SwipeRefreshLayout) findViewById(R.id.refresh),
                (LinearLayout) findViewById(R.id.emptyView));

        mListViewUtil.logoutIfNeeded();

        mListViewUtil.loadItems();
        mListViewUtil.setLoginId(mLoginId);
    }

    @OnClick(R.id.listview_button_add)
    public void addItem() {
        mListViewUtil.registerItem(mTitle);
    }

    @OnClick(R.id.listview_button_logout)
    public void logout() {
        mListViewUtil.logout();
    }
}
