package com.example.mr_wind.priojectdemo;

import android.app.Application;

/**
 * Created by mr_wind on 2016/8/16.
 */
public class BaseApplication extends Application {
    private static BaseApplication instance;

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
