package com.example.haruta.myapplication.presentation.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.haruta.myapplication.R;
import com.example.haruta.myapplication.util.ListViewUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditListItemActivity extends AppCompatActivity {

    @BindView(R.id.edititem_edittext_title)
    EditText mTitle;

    @BindView(R.id.edititem_button_update)
    Button mUpdateButton;

    private int mId;

    private ListViewUtil mListViewUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        mListViewUtil = new ListViewUtil(this);

        Bundle extra = getIntent().getExtras();
        mTitle.setText(extra.getString(ListViewUtil.EDIT_TITLE));
        mId = extra.getInt(ListViewUtil.ID);
    }

    @OnClick(R.id.edititem_button_update)
    public void updateItem() {
        mListViewUtil.updateItem(mId, mTitle.getText().toString());
    }
}
