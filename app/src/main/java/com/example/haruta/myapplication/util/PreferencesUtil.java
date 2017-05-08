package com.example.haruta.myapplication.util;

import android.content.SharedPreferences;

public class PreferencesUtil {
    public static final String PREF_KEY = "MyApplication";

    private static  final String LoginIdKey = "LoginIdKey";

    private static  final String IsAuthorizedKey = "IsAuthorizeddKey";

    private static SharedPreferences sPreferences;

    public static void init(SharedPreferences sharedPreferences) {
        sPreferences = sharedPreferences;
    }

    public static SharedPreferences getsSharedPreferences() {
        return sPreferences;
    }

    public static void saveLoginId(String loginId) {
        sPreferences.edit().putString(LoginIdKey, loginId).apply();
    }

    public static String getLoginId() {
        return sPreferences.getString(LoginIdKey, "");
    }

    public static void saveIsAuthorized(boolean isAuthorized) {
        sPreferences.edit().putBoolean(IsAuthorizedKey, isAuthorized).apply();
    }

    public static boolean getIsAuthorized() {
        return sPreferences.getBoolean(IsAuthorizedKey, false);
    }
}
