package com.example.haruta.myapplication.util;


import com.example.haruta.myapplication.BuildConfig;

public class Url {
    public static String getApiUrl() {
        if (BuildConfig.BUILD_TYPE == "debug") {
            return "http://dev.domus.jp/kubox/practice/public/";
        } else if (BuildConfig.BUILD_TYPE == "stage") {
            return "http://localhost:8000/kubox/practice/public/";
        } else {
            return "http://dev.domus.jp/kubox/practice/public/";
        }
    }
}
