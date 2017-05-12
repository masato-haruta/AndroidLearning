package com.example.haruta.myapplication.presentation.view.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.haruta.myapplication.R;
import com.example.haruta.myapplication.data.api.RestClient;
import com.example.haruta.myapplication.data.entity.BooleanResult;
import com.example.haruta.myapplication.util.ListViewUtil;
import com.example.haruta.myapplication.util.PreferencesUtil;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.login_edittext_id)
    EditText mLoginId;

    @BindView(R.id.login_edittext_pass)
    EditText mLoginPassword;

    @BindView(R.id.login_button_login)
    Button mLoginButton;

    @BindString(R.string.loginSuccess)
    String mLoginSuccess;

    @BindString(R.string.loginFail)
    String mLoginFail;

    private ListViewUtil mListViewUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        PreferencesUtil.init(getSharedPreferences(PreferencesUtil.PREF_KEY, Activity.MODE_PRIVATE));

        mListViewUtil = new ListViewUtil(this);
        mListViewUtil.autoLoginIfNeeded();
    }

    @OnClick(R.id.login_button_login)
    public void login() {
        // ログイン処理を実行
        new RestClient().auth(mLoginPassword.getText().toString().trim()).enqueue(new Callback<BooleanResult>() {
            @Override
            public void onResponse(Call<BooleanResult> call, Response<BooleanResult> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, mLoginSuccess, Toast.LENGTH_LONG).show();

                    mListViewUtil.save(mLoginId);
                    mListViewUtil.launchListViewActivity();
                } else {
                    Toast.makeText(MainActivity.this, mLoginFail, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<BooleanResult> call, Throwable t) {
                Log.e("javalog", "authorize fail:" + Log.getStackTraceString(t));
            }
        });
    }
}
