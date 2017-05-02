package com.example.haruta.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListViewActivity extends AppCompatActivity {

    private ListView mListView;

    private MyAdapter mAdapter;

    @BindView(R.id.listview_button_add)
    Button mAddListButton;

    @NonNull
    @BindView(R.id.listview_edittext_title)
    EditText mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ButterKnife.bind(this);

        mListView = (ListView) findViewById(R.id.my_listView);

        mAdapter = new MyAdapter(
                this,
                android.R.layout.activity_list_item
        );

        mListView.setAdapter(mAdapter);
    }

    @OnClick(R.id.listview_button_add)
    public void addList() {
        mAdapter.add(mTitle.getText().toString());
    }

    // カスタムAdapter
    static class MyAdapter extends ArrayAdapter<String> {

        private Context mContext;

        private String mText;

        public MyAdapter(Context context, int resourceId) {
            super(context, resourceId);
            mContext = context;
        }

        @Override
        public View getView(final int position, View convertView, final ViewGroup parent) {
            final ViewHolder holder;
            mText = getItem(position);

            // convertViewは使い回しされている可能性があるのでnullの時だけ新しく作る
            if (null == convertView) {
                convertView = View.inflate(mContext, R.layout.activity_listview_row, null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.mBody.setText(mText);

            holder.mDeleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ListView listView = (ListView) parent;
                    String selectedItem = (String) listView.getItemAtPosition(position);
                    remove(selectedItem);
                }
            });

            holder.mDate.setText(getDateText());

            return convertView;
        }

        // 現在時刻を返す
        private String getDateText() {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            return simpleDateFormat.format(date);
        }

        static class ViewHolder {
            @BindView(R.id.listview_text_body)
            TextView mBody;

            @BindView(R.id.listview_button_delete)
            Button mDeleteButton;

            @BindView(R.id.listview_text_date)
            TextView mDate;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
}
