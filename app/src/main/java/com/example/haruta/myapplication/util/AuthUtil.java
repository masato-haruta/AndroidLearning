package com.example.haruta.myapplication.util;

public class AuthUtil {

    // 認証結果を返す
    public static boolean isAuthorized(String id, String pass) {
        return id.equals("hoge") && pass.equals("1234");
    }
}