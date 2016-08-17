package com.example.mr_wind.priojectdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;

import com.example.mr_wind.priojectdemo.BaseApplication;
import com.example.mr_wind.priojectdemo.manager.MyWindowManager;

/**
 * Created by mr_wind on 2016/8/16.
 */
public class FloatService extends Service {

    //定义浮动窗口布局
    ViewGroup mFloatLayout;
    WindowManager.LayoutParams wmParams;
    //创建浮动窗口设置布局参数的对象
    WindowManager mWindowManager;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        createView();
    }

    private void createView() {
        MyWindowManager.createFloatView(BaseApplication.getInstance());
    }
}
