package com.example.haruta.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.haruta.myapplication.util.AuthUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 各Viewオブジェクトを初期化
        final EditText loginId = (EditText) findViewById(R.id.login_edittext_id);
        final EditText loginPassword = (EditText) findViewById(R.id.login_edittext_pass);
        Button loginButton = (Button) findViewById(R.id.login_button_login);

        // ボタンが押された時の挙動
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ログイン処理を実行
                if (AuthUtil.isAuthorized(loginId.getText().toString().trim(), loginPassword.getText().toString().trim())) {
                    Toast.makeText(MainActivity.this, "認証成功", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "認証失敗", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
