package com.example.mr_wind.priojectdemo;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import com.mounacheikhna.decor.DecorContextWrapper;
import com.mounacheikhna.decorators.Decorators;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * 基准activity<br/>
 * Created by mr_wind on 2016/7/21.
 */
public class BaseActivity extends SwipeBackActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindow();
    }

    private void initWindow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//状态栏半透明
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);//虚拟键背景透明
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(DecorContextWrapper.wrap(newBase).with(Decorators.getAll()));

    }
}