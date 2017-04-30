package com.example.haruta.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ListViewActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        String[] members = {
                "osumi",
                "kamezawa",
                "haruta",
                "kubo",
                "kakimoto",
                "fumy",
                "leon"
        };

        mListView = (ListView) findViewById(R.id.my_listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                members
        );

        mListView.setAdapter(adapter);
    }
}
