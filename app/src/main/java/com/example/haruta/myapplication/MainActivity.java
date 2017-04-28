package com.example.haruta.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private String mTestText = "hoge";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // ログレベルによって出し分け(vervose, info, warnは割愛)

        // 変数をデバッグとしてログ表示する
        Log.d("javalog", mTestText + "という文字が入っています。");

        try {
            int dividerResult = 1 / 0;
        } catch (ArithmeticException exception) {
            // 致命的な問題としてログ出力する
            Log.e("javalog", "ゼロ割例外：" + exception.getMessage());
        }
    }
}
