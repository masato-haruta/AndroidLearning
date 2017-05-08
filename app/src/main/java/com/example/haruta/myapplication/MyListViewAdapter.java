package com.example.haruta.myapplication;

import com.example.haruta.myapplication.model.Item;
import com.example.haruta.myapplication.util.ListViewUtil;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyListViewAdapter extends BaseAdapter {

    private Context mContext;

    private List<Item> mItems;

    private ListViewUtil mListViewUtil;

    public MyListViewAdapter(ListViewUtil listViewUtil) {
        mItems = listViewUtil.getItems();
        mContext = listViewUtil.getContext();
        mListViewUtil = listViewUtil;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Item getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final ViewHolder holder;

        // convertViewは使い回しされている可能性があるのでnullの時だけ新しく作る
        if (null == convertView) {
            convertView = View.inflate(mContext, R.layout.activity_listview_row, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mBody.setText(getItem(position).getBody());

        holder.mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(mContext)
                        .setTitle(R.string.deleteDialogTitle)
                        .setMessage(R.string.deleteDialogBody)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mListViewUtil.deleteItem(getItem(position));
                            }
                        })
                        .setNegativeButton("cancel", null)
                        .create()
                        .show();
            }
        });

        holder.mDate.setText(getItem(position).getCreated_at());

        holder.mRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListViewUtil.launchEditItemActivity(getItem(position).getId(), getItem(position).getBody());
            }
        });

        return convertView;
    }

    static class ViewHolder {

        @BindView(R.id.listview_text_body)
        TextView mBody;

        @BindView(R.id.listview_button_delete)
        Button mDeleteButton;

        @BindView(R.id.listview_text_date)
        TextView mDate;

        @BindView(R.id.listview_row_select)
        RelativeLayout mRow;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}