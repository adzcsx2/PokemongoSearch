package com.hoyn.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by Hoyn on 2016/7/23.
 */
public class BaseApplication extends Application {
    private static Context context;

    public static Context getContextObject() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
