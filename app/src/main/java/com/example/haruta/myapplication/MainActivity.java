package com.example.haruta.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.haruta.myapplication.util.AuthUtil;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.login_button_login)
    public void login() {
        // ログイン処理を実行
        if (AuthUtil.isAuthorized(mLoginId.getText().toString().trim(),
                mLoginPassword.getText().toString().trim())) {
            Toast.makeText(MainActivity.this, mLoginSuccess, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ListViewActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, mLoginFail, Toast.LENGTH_LONG).show();
        }
    }
}
