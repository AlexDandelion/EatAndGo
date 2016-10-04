package com.dandelion.eatandgo;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class EatAndGoApp extends Application {

    private static EatAndGoApp sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static EatAndGoApp getInstance() {
        return sInstance;
    }

    public boolean isAuthorized() {
        return getSharedPreferences(Constants.USER_PREFERENCE, Context.MODE_PRIVATE)
                .getBoolean(Constants.USER_IS_AUTHORIZED, true);
    }

    public void setIsAuthorized(boolean isAuthorized) {
        SharedPreferences.Editor editor = getSharedPreferences(Constants.USER_PREFERENCE,
                Context.MODE_PRIVATE).edit();
        editor.putBoolean(Constants.USER_IS_AUTHORIZED, isAuthorized);
        editor.commit();
    }
}
